import { Component, OnInit } from '@angular/core';
import { CustomerPhoneDto } from '../model/customer-phone-dto';
import { CustomerPageResponse } from '../model/customer-page-dto';
import { CustomerService } from '../service/customer.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  filters: string[] = ['', 'country'];
  filter = this.filters[0];
  filterCountry = false;
  countryMap = new Map<string, string>();
  countries: string[] = [];
  country: string = '';
  pageNumber = 1;
  size = 5;
  phonePrefix: any = '';

  customerPhoneDtos: CustomerPhoneDto[] = [];

  customerPageResponse: CustomerPageResponse

  constructor(private customerService: CustomerService) {

    this.countryMap.set('Cameroon', '(237)');
    this.countryMap.set('Ethiopia', '(251)');
    this.countryMap.set('Morocco', '(212)');
    this.countryMap.set('Mozambique', '(258)');
    this.countryMap.set('Uganda', '(256)');
    this.countries = Array.from(this.countryMap.keys());
    this.customerPageResponse = new CustomerPageResponse();
    this.getCustomer(this.pageNumber);
  }

  ngOnInit(): void {
  }


  selectFilter(filter: string) {
    this.filterCountry = false;
    this.filter = filter;
    this.pageNumber=1;
    console.log('selected filter ....... ' + this.filter);


    if (this.filter === 'country') {
      this.filterCountry = true;
      this.country = this.countries[0];
      this.phonePrefix = this.countryMap.get(this.country);
      this.getCustomer(this.pageNumber);
    } else {
      this.phonePrefix = ''
      this.getCustomer(this.pageNumber);
    }
  }

  selectCountry(country: string) {
    this.country = country;
    this.pageNumber=1;
    console.log('selected country ....... ' + this.country);
    this.phonePrefix = this.countryMap.get(this.country);
    this.getCustomer(this.pageNumber);
  }


  getCustomer(page:number) {

    page = this.pageNumber - 1;
    this.customerService.getCustomers(page, this.size, this.phonePrefix).subscribe(
      (response: any) => {
        this.customerPageResponse = response;
        this.customerPhoneDtos=this.customerPageResponse.customerPhoneDtos ;
      },
      error => {
        console.log(error);
      }
    );

  }
}
