import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonFeedback } from 'src/app/models/CommonFeedback';

@Component({
  selector: 'app-common-feedback',
  templateUrl: './common-feedback.component.html',
  styleUrls: ['./common-feedback.component.css']
})
export class CommonFeedbackComponent implements OnInit {

  feedbacks:CommonFeedback[];
  constructor(private router:Router) { }

  ngOnInit() {
  }
  back()
  {
      this.router.navigate(['admin']);
  }
}
