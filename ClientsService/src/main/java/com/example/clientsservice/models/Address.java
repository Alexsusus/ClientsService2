package com.example.clientsservice.models;

import lombok.*;

import javax.persistence.*;

//все поля, в таблице addresses в базе, должны быть NOT NULL
//кроме apartment

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
//
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //область
    @Column(nullable = false)
    private String region;

    //район
    @Column(nullable = false)
    private String district;

    //город
    @Column(nullable = false)
    private String city;

    //улица
    @Column(nullable = false)
    private String street;

    //номер дома
    @Column(nullable = false)
    private String house;

    //квартира
    private String apartment;
}
