import { Injectable } from '@angular/core';
import { Iuser } from '../modules/iuser';
import { BehaviorSubject, Observable, map, tap } from 'rxjs';
import { JwtHelperService } from '@auth0/angular-jwt';
import { HttpClient } from '@angular/common/http';
import { Ilogindata } from '../modules/ilogindata';
import { environment } from '../../environments/environment.development';
import { Router } from '@angular/router';

type AccessData = {
  accessToken: string;
  user: Iuser;
};

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  jwtHelper: JwtHelperService = new JwtHelperService();
  authSubject = new BehaviorSubject<Iuser | null>(null);
  user$ = this.authSubject.asObservable();
  isLoggedIn$ = this.user$.pipe(
    map((user) => !!user),
    tap((user) => (this.syncIsLoggedIn = user))
  );

  constructor(
    private http: HttpClient,

    private router: Router
  ) {
    this.restoreUser();
  }

  registerUrl: string = environment.registerUrl;
  loginUrl: string = environment.loginUrl;

  syncIsLoggedIn: boolean = false;

  register(newUser: Partial<Iuser>): Observable<AccessData> {
    return this.http.post<AccessData>(this.registerUrl, newUser);
  }

  login(loginData: Ilogindata): Observable<AccessData> {
    return this.http.post<AccessData>(this.loginUrl, loginData).pipe(
      tap((data) => {
        this.authSubject.next(data.user);
        localStorage.setItem('accessdata', JSON.stringify(data));
        this.autoLogout(data.accessToken);
        return;
      })
    );
  }
  logout() {
    this.authSubject.next(null);
    localStorage.removeItem('accessData');

    this.router.navigate(['/auth/login']);
  }
  autoLogout(jwt: string) {
    const expDate = this.jwtHelper.getTokenExpirationDate(jwt) as Date;
    const expMs = expDate.getTime() - new Date().getTime();

    setTimeout(() => {
      this.logout();
    }, expMs);
  }
  restoreUser() {
    const userJson = localStorage.getItem('accessData');
    if (!userJson) return;

    const accessData: AccessData = JSON.parse(userJson);
    if (this.jwtHelper.isTokenExpired(accessData.accessToken)) return;

    this.authSubject.next(accessData.user);
    this.autoLogout(accessData.accessToken);
  }
  getAccessToken(): string {
    const userJson = localStorage.getItem('accessData');
    if (!userJson) return '';

    const accessData: AccessData = JSON.parse(userJson);
    if (this.jwtHelper.isTokenExpired(accessData.accessToken)) return '';

    return accessData.accessToken;
  }
}
