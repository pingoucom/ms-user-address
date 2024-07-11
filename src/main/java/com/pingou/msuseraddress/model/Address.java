package com.pingou.msuseraddress.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private boolean isDefault;

    private String userId;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String street;
    private String postalCode;
}
