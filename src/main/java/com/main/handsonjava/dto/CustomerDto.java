package com.main.handsonjava.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomerDto {

    private int customerId;

    @NotEmpty(message = "Customer Name is required")
    @Size(min = 5, max = 30, message = "The length of the customer name should be between 5 and 30")
    private String customerName;

    @NotEmpty(message = "Customer Email is required")
    @Email(message = "Customer Email is not valid")
    private String customerEmail;

    @NotEmpty(message = "Customer Address is required")
    private String customerAddress;

    @NotEmpty(message = "Customer Phone is required")
    private String customerPhone;

    @NotEmpty(message = "Customer City is required")
    private String customerCity;

    @NotEmpty(message = "Customer State is required")
    private String customerState;

    @NotEmpty(message = "Customer Zipcode is required")
    private String customerZipcode;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerState() {
        return customerState;
    }

    public void setCustomerState(String customerState) {
        this.customerState = customerState;
    }

    public String getCustomerZipcode() {
        return customerZipcode;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerCity='" + customerCity + '\'' +
                ", customerState='" + customerState + '\'' +
                ", customerZipcode='" + customerZipcode + '\'' +
                '}';
    }

    public void setCustomerZipcode(String customerZipcode) {
        this.customerZipcode = customerZipcode;
    }
}
