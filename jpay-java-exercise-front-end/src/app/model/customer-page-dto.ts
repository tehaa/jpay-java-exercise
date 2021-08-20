import { CustomerDto } from "./customer-dto";
import { PageDto } from "./page-dto";


export class CustomerPageResponse extends PageDto {
    customerDtos :CustomerDto[];

    constructor(){
        super();
        this.customerDtos={} as any;
    }
  
}