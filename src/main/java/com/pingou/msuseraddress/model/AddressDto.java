package com.pingou.msuseraddress.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private String id;
    private String userId;
    private String number;
    private String street;
    private boolean isDefault;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String postalCode;
    
}
