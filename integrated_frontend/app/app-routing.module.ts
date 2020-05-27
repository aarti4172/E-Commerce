import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MerchantListComponent } from './components/merchant-list/merchant-list.component';
import { CustomerListComponent } from './components/customer-list/customer-list.component';
import { AddDiscountComponent } from './components/add-discount/add-discount.component';
import { AddPromocodeComponent } from './components/add-promocode/add-promocode.component';
import { AddMerchantComponent } from './components/add-merchant/add-merchant.component';
import { ShowPromocodeComponent } from './components/show-promocode/show-promocode.component';
import { ShowDiscountComponent } from './components/show-discount/show-discount.component';
import { AdminComponent } from './components/admin/admin.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { CommonFeedbackComponent } from './components/common-feedback/common-feedback.component';
import { AddProductComponent } from './components/add-product/add-product.component';
import { ThirdPartyMerchantComponent } from './components/third-party-merchant/third-party-merchant.component';
import { UpdateProductComponent } from './components/update-product/update-product.component';
import { UpdateCategoryComponent } from './components/update-category/update-category.component';
import { CategoryByCategoryComponent } from './components/category-by-category/category-by-category.component';
import { CategoryByIdComponent } from './components/category-by-id/category-by-id.component';


const routes: Routes = [
  {path: '', redirectTo: 'admin', pathMatch: 'full' },
  {path:'addMerchant',component:AddMerchantComponent},
 // {path:'show',component:ShowMerchantComponent},
  {path: 'addProducts',component:AddProductComponent},
  {path: 'addProducts',component:AddProductComponent},
  {path:'productList', component:ProductListComponent},
  {path:'admin',component:AdminComponent},
  {path:'addDiscount/:productID',component:AddDiscountComponent},
  {path:'addPromocode',component:AddPromocodeComponent},
  {path:'addMerchant',component:AddMerchantComponent},
  {path:'showCustomer',component:CustomerListComponent},
  {path:'showMerchant',component:MerchantListComponent},
  {path:'showPromocode',component:ShowPromocodeComponent},
  {path:'showDiscount',component:ShowDiscountComponent},
  {path:'showProduct',component:ProductListComponent},
  {path:'PendingFeedbacks',component:CommonFeedbackComponent},
  {path:'addMerchant',component:AddMerchantComponent},
  {path:'thirdparty',component:ThirdPartyMerchantComponent},
  {path:'updateProduct',component:UpdateProductComponent},
  {path:'updateCategory',component:UpdateCategoryComponent},
  {path:'ByCategory',component:CategoryByCategoryComponent},
  {path:'ById',component:CategoryByIdComponent}
  /**/

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
