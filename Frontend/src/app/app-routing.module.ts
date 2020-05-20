import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AddMerchantComponent } from './add-merchant/add-merchant.component';
import { ShowMerchantComponent } from './show-merchant/show-merchant.component';
import { AdminServiceService } from './admin-service.service';
import { AdminComponent } from './admin/admin.component';
import { ThirdPartyMerchantComponent } from './third-party-merchant/third-party-merchant.component';



const routes: Routes = [
  {path:'addMerchant',component:AddMerchantComponent},
  {path:'show',component:ShowMerchantComponent},
  {path: 'admin',component:AdminComponent},
  {path:'thirdparty',component:ThirdPartyMerchantComponent},
  {path:'productList', component:ProductListComponent},
  {path:'addProduct',component:AddProductComponent},
  {path:'updateProduct',component:UpdateProductComponent},
  {path:'updateCategory',component:UpdateCategoryComponent},
  {path:'ByCategory',component:CategoryByCategoryComponent},
  {path:'ById',component:CategoryByIdComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
