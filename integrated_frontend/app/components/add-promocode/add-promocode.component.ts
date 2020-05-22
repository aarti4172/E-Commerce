import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-promocode',
  templateUrl: './add-promocode.component.html',
  styleUrls: ['./add-promocode.component.css']
})
export class AddPromocodeComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }
  back()
  {
      this.router.navigate(['admin']);
  }
}
