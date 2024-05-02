package com.pingou.msuseradress.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    private Long id;
    private String postal_code;
    private String user_id;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;

    private double latitude;
    private double longitude;
    private String city;
    private String state;
}
