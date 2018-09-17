package com.capgemini.serviciosya.beans.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.Size;

@NamedQueries ({

        @NamedQuery(

                name  = "ClientFindByPhone",
                query = "from Provider p where p.phone = :phone"
        )
})
@Entity (name = "Client")
@Table (name = "client")

public class ClientEntity {

    //Map the field (Database tables) and properties (Java classes)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private int id;
    @Column(name = "name", length = 48, nullable = false)
    private String name;

    @Column(name = "lastName", length = 48, nullable = false)
    private String lastName;

    @Column(name = "phone", length = 48, nullable = false, unique = true)
    private String phone;

    @Column(name = "dni", nullable = false, unique = true)
    private Integer dni;

    @Size(min = 15, max = 100)
    @Email
    @Column(name = "email", length = 128, nullable = false, unique = true)
    private String email;

    @Column(name = "address", length = 128, nullable = false)
    private String address;


    @Size(max = 16)
    @CreditCardNumber
    @Column(name = "creditcard_number", nullable = true, unique = false)
    private int creditcard_number;


    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityEntity city;


    public ClientEntity() {

        super();
    }

    public ClientEntity(int id, String name, String lastName, String phone, Integer dni, String email, String address, Integer creditcard_number, CityEntity city) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.dni = dni;
        this.email = email;
        this.address = address;
        this.creditcard_number = creditcard_number;
        this.city = city;
    }


    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }

    public Integer getCreditcard_number() {
        return creditcard_number;
    }

    public void setCreditcard_number(Integer creditcard_number) {
        this.creditcard_number = creditcard_number;
    }

    @Override
    public String toString() {

        return this.name;
    }

}
