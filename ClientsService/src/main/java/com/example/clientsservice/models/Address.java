package com.example.clientsservice.models;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

//все поля, в таблице addresses в базе, должны быть NOT NULL
//кроме apartment

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    //
    //квартира
    private String apartment;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_address_clients"))
    private Client client;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) && Objects.equals(region, address.region) && Objects.equals(district, address.district) && Objects.equals(city, address.city) && Objects.equals(street, address.street) && Objects.equals(house, address.house) && Objects.equals(apartment, address.apartment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, region, district, city, street, house, apartment);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", apartment='" + apartment + '\'' +
                '}';
    }
}
