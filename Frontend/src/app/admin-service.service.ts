import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable, from} from 'rxjs';
import { Merchant } from './Merchant';
import { catchError, map, tap, retry } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class AdminServiceService {

  baseUrl ='http://localhost:8080/Capstore/admin';

  constructor(private http: HttpClient) { }

  addNewMerchant(data){
    let options = {   method: "POST",
    body: JSON.stringify(data),
    headers: { "Content-Type": "application/json" } };
                return fetch(this.baseUrl+"/newMerchant",options);

  }
  
  getAllMerchantsList():Observable<any>{
    return this.http.get(this.baseUrl+"/AllMerchants");
  }

   updateMerchant(merchant){
    let options = {
      method: "POST",
      body: JSON.stringify(merchant),
      headers: new Headers({ "Content-Type": "application/json" }),
    };
    return fetch(this.baseUrl + "/updateMerchant", options);
  //return this.http.post(this.baseUrl+"/update",merchant);
  }
  deleteMerchant(merchantId:number):Observable<any>{
    console.log("In service delete"+merchantId)
     return this.http.delete(this.baseUrl+"/delete/"+merchantId);
  }
  inviteservice(email){
    return this.http.get(this.baseUrl+"/invite/"+email);
  }

}
