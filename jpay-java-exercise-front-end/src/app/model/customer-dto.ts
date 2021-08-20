export class CustomerDto {
    name: string;
    fullPhoneNumber: string;
    countryName: string;
    state: string;
    countryCode: string;
    number: string;





    constructor() {
        this.name = '';
        this.fullPhoneNumber = '';
        this.countryName = '';
        this.countryCode = '';
        this.state = '';
        this.number = '';
    }
}