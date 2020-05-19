import { Component, OnInit } from '@angular/core';
import { Merchant } from '../Merchant';

@Component({
  selector: 'app-update-merchant',
  templateUrl: './update-merchant.component.html',
  styleUrls: ['./update-merchant.component.css']
})
export class UpdateMerchantComponent implements OnInit {

  merchant:Merchant= new Merchant();
  constructor() { }

  ngOnInit(): void {
  }
 update(){
   
 }
}
