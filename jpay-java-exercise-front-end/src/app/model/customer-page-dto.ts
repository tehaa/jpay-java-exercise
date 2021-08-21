import { CustomerPhoneDto } from "./customer-phone-dto";
import { PageDto } from "./page-dto";


export class CustomerPageResponse extends PageDto {
    customerPhoneDtos :CustomerPhoneDto[];

    constructor(){
        super();
        this.customerPhoneDtos={} as any;
    }
  
}