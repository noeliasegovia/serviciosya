package com.capgemini.serviciosya.beans.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;


@Entity (name = "ServiceContract")
@Table (name = "servicecontract")

public class ServiceContractEntity {

    //Map the field (Database tables) and properties (Java classes)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,insertable = false, updatable = false)
    private  int id;

    @ManyToOne
    @JoinColumn (name = "id_client")
    private ClientEntity client;

    @ManyToOne
    @JoinColumn (name = "id_provider")
    private ProviderEntity provider;


    @Column (name = "description", length = 180, nullable = false)
    private  String description;

    @Column (name = "price", nullable = false)
    private  Integer price;

    @Range (min = 0, max = 2)
    @Column (name = "way_to_pay", nullable = false)
    private Integer waytopay;

    @Range (min = 0, max = 2)
    @Column (name = "status", nullable = false)
    private Integer status;

    public ServiceContractEntity(int id, ClientEntity client, ProviderEntity provider, String description, Integer price, Integer waytopay, Integer status) {
        this.id = id;
        this.client = client;
        this.provider = provider;
        this.description = description;
        this.price = price;
        this.waytopay = waytopay;
        this.status = status;
    }

    public ServiceContractEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public ProviderEntity getProvider() {
        return provider;
    }

    public void setProvider(ProviderEntity provider) {
        this.provider = provider;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getWaytopay() {
        return waytopay;
    }

    public void setWaytopay(Integer waytopay) {
        this.waytopay = waytopay;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}



