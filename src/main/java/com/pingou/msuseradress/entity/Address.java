package com.pingou.msuseradress.entity;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private boolean isDefault;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String postalCode;
    private double latitude;
    private double longitude;
    private String city;
    private String state;
}