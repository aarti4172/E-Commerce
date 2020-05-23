import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  searchTerm:any;
  constructor() { }
email;
  ngOnInit(): void {
  }
invite()
{
 this.adminService.inviteservice(this.email);
}
}
