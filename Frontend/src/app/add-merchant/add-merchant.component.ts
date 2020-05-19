import { Component, OnInit } from '@angular/core';
import { AdminServiceService } from '../admin-service.service';
import { Merchant } from '../Merchant';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-merchant',
  templateUrl: './add-merchant.component.html',
  styleUrls: ['./add-merchant.component.css']
})
export class AddMerchantComponent implements OnInit {

 merchant:Merchant= new Merchant();
  Merchant_id:number;
  Name:string;
  //Username:string;
  PhoneNo : String;
  Alternate_phone_no : String;
  Alternate_email: String;
  check=false;
  status: string;
  Rating:number;
  isApproved;

  constructor( private adminService: AdminServiceService, private router: Router) { }

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
