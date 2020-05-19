import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  email;
  searchTerm:any;
  constructor() { }

  ngOnInit(): void {
  }
 invite(){
   
 }
}
