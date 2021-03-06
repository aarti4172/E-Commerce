import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Product } from '../models/Product';
@Injectable({
  providedIn: 'root'
})
export class AdminService {
  

  baseUrl="http://localhost:9090/capstore/admin";
 // baseUrlMerchant="http://localhost:9091/admin/merchant";
 // baseUrl ='http://localhost:8080/Capstore/admin';

  constructor(private http:HttpClient) { }

  //------------------------------------------------user-----------------------------------------------------------------------------------------------------------------

  getAllUser():Observable<any>
  {
    return this.http.get(`${this.baseUrl}`+"/customer/").pipe(catchError(this.handleError) );
  }
  deleteUser(Cust_ID:number)
  {
    return this.http.delete(`${this.baseUrl}/customer/${Cust_ID}`).pipe(catchError(this.handleError));
  }
 


  //------------------------------------------------Merchant----------------------------------------------------------------------------------------------
  getAllMerchant():Observable<any>
  {
    return this.http.get(`${this.baseUrl}`+"/merchant").pipe(catchError(this.handleError) );
  }
  getMerchant(id){
    return this.http.get(this.baseUrl+"/AllMerchants/"+id);
  }
  addNewMerchant(merchant) {
      let options = {   method: "POST",
    body: JSON.stringify(merchant),
    headers: { "Content-Type": "application/json" } };
                return fetch(this.baseUrl+"/newMerchant",options);
  }
  
  deleteMerchant(merchant_ID:number)
  {
    return this.http.delete(`${this.baseUrl}/merchant/${merchant_ID}`).pipe(catchError(this.handleError));
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
   inviteservice(email){
    return this.http.get(this.baseUrl+"/invite/"+email);
  }

  //------------------------------------------------Product------------------------------------------------------------------------------------------------
  
  getAllProducts():Observable<any>
  {
    return this.http.get(`${this.baseUrl}`+"/getAllProducts").pipe(catchError(this.handleError));
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

  //------------------------------------------------Promocode----------------------------------------------------------------------------------------------
  
 
 addPromocode(Coupon:Object) :Observable<Object>
    {

         return this.http.post(`${this.baseUrl}/addCoupon`,Coupon).pipe(catchError(this.handleError));
    }

  getPromocodes():Observable<any>
    {
          return this.http.get(`${this.baseUrl}/getAllCoupons`);
    }

  deletePromocode(promocodeId:number)
    {
     return this.http.delete(`${this.baseUrl}/removeCoupon/${promocodeId}`);
   }
  
  //------------------------------------------------Discount----------------------------------------------------------------------------------------------
  addDiscount( discount:number,productID:number): Observable<any> {
    
    return this.http.put(`${this.baseUrl}/addDiscount/${discount}/${productID}`,discount);
  }
  
  //------------------------------------------------CommonFeedback-----------------------------------------------------------------------
  forwardRequestToMerchant(feedbackId: number):Observable<number>{
    return this.http.get<number>(`${this.baseUrl}/forwardRequestToMerchant/${feedbackId}`);
  }


  forwardResponseToCustomer(feedbackId:number):Observable<string>{
    return this.http.get<string>(`${this.baseUrl}/forwardResponseToCustomer/${feedbackId}`);

  }

  getAllCommonFeedback(){
    return this.http.get<CommonFeedback[]>(`${this.baseUrl}/getAllCommonFeedback`);
  }
   
  //------------------------------------------------Error Handling--------------------------------------------------------
  handleError(error) {
    let errorMessage='';
    let msg='';
    if(error.error instanceof ErrorEvent)
    {
       
        errorMessage=`${error.errorMessage}`;
        console.log("Client Side");
    }
    else{

 
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
      console.log("Server SIde");

    }
    console.log(errorMessage);
    return throwError(error);
  }

}
