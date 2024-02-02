import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit {

  cosutomers : any;
  constructor(private http:HttpClient , private  router : Router) { }

  ngOnInit(): void {
    this.http.get("http://localhost:8888/CUSTOMER-SERVICE/customers")
      .subscribe({
        next : (data)=>{
          this.cosutomers=data;
        },
        error : (err)=>{}
      });
  }
  getBill(c: any) {
    this.router.navigateByUrl("/bill/"+c.id)
  }

}
