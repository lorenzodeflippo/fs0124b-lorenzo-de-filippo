import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private authSvc: AuthService) {}

  isLoggedIn(): boolean {
    return false;
  }
}
