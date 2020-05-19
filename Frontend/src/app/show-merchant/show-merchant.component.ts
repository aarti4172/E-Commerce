import { Component, OnInit } from '@angular/core';
import { Merchant } from '../Merchant';
import { AdminServiceService } from '../admin-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show-merchant',
  templateUrl: './show-merchant.component.html',
  styleUrls: ['./show-merchant.component.css']
})
export class ShowMerchantComponent implements OnInit {

  merchantList: Merchant[] = [];
  constructor(private service: AdminServiceService, private router: Router) { }
  id:number;
  ngOnInit(): void {
    this.service.getAllMerchantsList()
    .subscribe((result) => {
      result.merchantsList.forEach(data => {
        this.merchantList.push(data)
      });

      console.log(this.merchantList)
    }

    )
  }
addmerchant(){
 this.router.navigate(['/addMerchant'])
}
//delete(id){
 // this.router.navigate(['/update']);
 //this.service.deleteMerchant(id);

//}
delete(data: number): any {
  //this.id =  this.merchantList[data].Merchant_id;
 if (this.service.deleteMerchant(this.id).subscribe( data => {console.log(data);
 },
 error => console.log(error)

 ))
 {
   if (confirm('Are you Sure You Want To Delete')) {
     this.merchantList.splice(data, 1);
   }
 }
}

back(){
  this.router.navigate(['/']);
}

}
