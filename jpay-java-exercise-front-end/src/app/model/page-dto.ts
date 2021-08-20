import { CustomerDto } from "./customer-dto";

export class PageDto {
    pageNumber: number;
    pageSize: number;
    totalNumberOfElements: number;

    constructor(){
        this.pageNumber=0;
        this.pageSize=0;
        this.totalNumberOfElements=0;
    }
}