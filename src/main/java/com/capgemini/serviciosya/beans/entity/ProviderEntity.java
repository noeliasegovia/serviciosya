package com.capgemini.serviciosya.beans.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.Size;

@NamedQueries ({

        @NamedQuery(

                name  = "ProviderFindByPhone",
                query = "from Provider p where p.phone = :phone"
        )
})
@Entity
@Table (name = "provider")

public class ProviderEntity {

    //Map the field (Database tables) and properties (Java classes)
    @Id
    @Column(name="id")
    @SequenceGenerator(sequenceName = "SQ_PROVIDER", name = "SQ_PROVIDER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PROVIDER")

    private  int id;

    private String name;

    private String lastName;

    private String phone;

    private Integer dni;

    private String email;

    private String address;

    private Integer status;

    private CityEntity city;

    private Set<OccupationEntity> occupations = new HashSet<> ();


//    public ProviderEntity () {
//
//        super ();
//    }
//
//    public ProviderEntity(int id, String name, String lastName, String phone, Integer dni, String email, String address, Integer status, CityEntity city, Set<OccupationEntity> occupations) {
//        this.id = id;
//        this.name = name;
//        this.lastName = lastName;
//        this.phone = phone;
//        this.dni = dni;
//        this.email = email;
//        this.address = address;
//        this.status = status;
//        this.city = city;
//        this.occupations = occupations;
//    }

    public int getId () {

        return id;
    }

    public void setId (int id) {

        this.id = id;
    }

    public String getName () {

        return name;
    }

    public void setName (String name) {

        this.name = name;
    }

    public Set<OccupationEntity> getOccupations() {

        return occupations;
    }

    public void setOccupations(Set<OccupationEntity> occupations) {

        this.occupations = occupations;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }

    @Override
    public String toString () {

        return "id="+id+",name="+name+",lastname="+lastName+", phone="+phone+",dni="+dni+",email="+email+",address="+address+",status="+status+",city="+city+",occupations="+occupations;
    }

}
