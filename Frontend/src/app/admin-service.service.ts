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
  product: Product;
  constructor(private http: HttpClient) { }
  //merchant
  addNewMerchant(data){
    let options = {   method: "POST",
    body: JSON.stringify(data),
    headers: { "Content-Type": "application/json" } };
                return fetch(this.baseUrl+"/newMerchant",options);

  }
   getMerchant(id){
    return this.http.get(this.baseUrl+"/AllMerchants/"+id);
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

  //Product Section
  getAllProducts(): Observable<Object>{
    return this.http.get<Product[]>(`${this.baseUrl}/getAllProducts`);
  }

  addProduct(product: Object): Observable<Object>{
    return this.http.post<number>(`${this.baseUrl}/addProduct`, product);
  }

  removeProduct(productId: number): Observable<Object>{
    return this.http.delete<boolean>(`${this.baseUrl}/deleteProduct/${productId}`);
  }

  update(product: Object): Observable<Object>{
    return this.http.put<boolean>(`${this.baseUrl}/updateProduct`,product);
  }

  getProductById(productId: number): Observable<Object>{
    return this.http.get<Product>(`${this.baseUrl}/getProductById/${productId}`);
  }

  updateCategoryByCategory(productCategory: String, updatedCategory: String):Observable<Object>{
    return this.http.put<boolean>(`${this.baseUrl}/updateByCategory?productCategory=${productCategory}&updatedCategory=${updatedCategory}`,productCategory);
  }

  updateCategoryById(productId: number, updatedCategory: String): Observable<Object>{
    return this.http.put<boolean>(`${this.baseUrl}/updatedById?productId=${productId}&updatedCategory=${updatedCategory}`,productId);
  }
}
