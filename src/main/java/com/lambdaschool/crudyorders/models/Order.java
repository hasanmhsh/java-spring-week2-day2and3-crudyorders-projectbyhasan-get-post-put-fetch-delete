package com.lambdaschool.crudyorders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@JsonIgnoreProperties(value = {"hasvalueforadvanceamount","hasvalueforordamount"})
public class Order {
    @Transient
    public boolean hasvalueforadvanceamount = false;
    @Transient
    public boolean hasvalueforordamount = false;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordnum;

    private double advanceamount;

    private double ordamount;

    private String orderdescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "custcode",
            nullable = false)
    @JsonIgnoreProperties({"orderlist", "hibernateLazyInitializer"})
    private Customer customer;

    @ManyToMany()
    @JoinTable(name = "orderspayments",
            joinColumns = @JoinColumn(name = "ordnum"),
            inverseJoinColumns = @JoinColumn(name = "paymentid"))
    @JsonIgnoreProperties("orderlist")
    List<Payment> paymentlist = new ArrayList<>();


    public Order(){
    }

    public Order(double advanceamount, double ordamount, String orderdescription, Customer customer) {
        this.advanceamount = advanceamount;
        this.ordamount = ordamount;
        this.orderdescription = orderdescription;
        this.customer = customer;
    }

    public long getOrdnum() {
        return ordnum;
    }

    public void setOrdnum(long ordnum) {
        this.ordnum = ordnum;
    }

    public double getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount) {
        hasvalueforadvanceamount=true;
        this.advanceamount = advanceamount;
    }

    public double getOrdamount() {
        return ordamount;
    }

    public void setOrdamount(double ordamount) {
        hasvalueforordamount = true;
        this.ordamount = ordamount;
    }

    public String getOrderdescription() {
        return orderdescription;
    }

    public void setOrderdescription(String orderdescription) {
        this.orderdescription = orderdescription;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Payment> getPaymentlist() {
        return paymentlist;
    }

    public void setPaymentlist(List<Payment> paymentlist) {
        this.paymentlist = paymentlist;
    }

    @Override
    public String toString() {
        return "Order{" +
                "hasvalueforadvanceamount=" + hasvalueforadvanceamount +
                ", hasvalueforordamount=" + hasvalueforordamount +
                ", ordnum=" + ordnum +
                ", advanceamount=" + advanceamount +
                ", ordamount=" + ordamount +
                ", orderdescription='" + orderdescription + '\'' +
                ", custcode=" + customer.getCustcode() +
                ", custname=" + customer.getCustname() +
                ", paymentlist=" + paymentlist +
                '}';
    }
}
