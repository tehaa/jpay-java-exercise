import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }

  getCustomers(page: number, size: number, phonePrefix: string) {
    return this.http.get(`${environment.apiUrl}/api/customer?page=${page}&size=${size}&phonePrefix=${phonePrefix}`)

  }
}
