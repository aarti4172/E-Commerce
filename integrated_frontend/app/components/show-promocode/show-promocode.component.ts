import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show-promocode',
  templateUrl: './show-promocode.component.html',
  styleUrls: ['./show-promocode.component.css']
})
export class ShowPromocodeComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }
  back()
  {
    
    this.router.navigate(['admin']);
    }

}
