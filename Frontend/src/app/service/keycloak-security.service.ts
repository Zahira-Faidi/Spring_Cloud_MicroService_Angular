import { Injectable } from '@angular/core';
import {KeycloakInstance} from "keycloak-js";
declare var Keycloak: any;

@Injectable({
  providedIn: 'root'
})
export class KeycloakSecurityService {

  public kc: KeycloakInstance | undefined ;
  constructor() { }
  async init(){
    console.log("security Initialisation..");
    this.kc=new Keycloak({
      url: "http://localhost:1000/",
      realm:"Gestion_Factures",
      clientId: "factures_app",
    });
    await this.kc?.init({
      onLoad:'login-required'
    });
    console.log(this.kc?.token);
  }
}
