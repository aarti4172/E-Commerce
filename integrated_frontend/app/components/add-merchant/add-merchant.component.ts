import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/service/admin.service';
import { MerchantDetails } from 'src/app/models/MerchantDetails';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-merchant',
  templateUrl: './add-merchant.component.html',
  styleUrls: ['./add-merchant.component.css']
})
export class AddMerchantComponent implements OnInit {
 name:string;
username:string;
password;
phone_number : String;
alternate_phone_number : String;
eMail:String;
alternate_email: String;
check=false;
status: string;
rating =0;
isApproved;
role="Merchant";
isACtive=false;
securityQueston=null;
securityAnswer=null;
products=null;
user_address=null;
product_feedback=null;
coupons=null;
merchant: MerchantDetails= new MerchantDetails(name,this.username,this.password,this.eMail,this.role,this.isACtive,this.securityQueston,this.securityAnswer,this.phone_number,
  this.alternate_phone_number,this.alternate_email,this.products,this.user_address,this.product_feedback,this.coupons,this.isApproved,this.rating);

  constructor( private adminService: AdminService, private router: Router) { }

  ngOnInit(): void {

  }

  addMerchant()
  {
    console.log(this.merchant);
   this.adminService.addNewMerchant(this.merchant);
   
  
   }

   onCheckboxValueChange():any{
    this.check=!this.check
    if(this.check){
    this.status="Approved";
    alert(this.status)
    }
    else{
    this.status="Disapproved";
    alert(this.status)
    }
    this.isApproved=this.check;


  }
}
