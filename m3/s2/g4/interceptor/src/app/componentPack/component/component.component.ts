import { Component } from '@angular/core';
import { Interface } from '../../models/interface';
import { ServiceService } from '../../servicePack/service.service';

@Component({
  selector: 'app-component',
  templateUrl: './component.component.html',
  styleUrl: './component.component.scss',
})
export class ComponentComponent {
  ArrayFoto: Interface[] = [];
  constructor(private fotoSvc: ServiceService) {}

  ngOnInit() {
    this.fotoSvc.getAllFoto();
    //.Subscribe((p) => {
    //this.ArrayFoto;
  } //);
}
//}
