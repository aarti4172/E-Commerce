import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddMerchantComponent } from './add-merchant/add-merchant.component';
import { ShowMerchantComponent } from './show-merchant/show-merchant.component';
import {HttpClientModule} from '@angular/common/http';
import { UpdateMerchantComponent } from './update-merchant/update-merchant.component';
import { ThirdPartyMerchantComponent } from './third-party-merchant/third-party-merchant.component';
import { AdminComponent } from './admin/admin.component';
@NgModule({
  declarations: [
    AppComponent,
    AddMerchantComponent,
    ShowMerchantComponent,
    UpdateMerchantComponent,
    ThirdPartyMerchantComponent,
    AdminComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
