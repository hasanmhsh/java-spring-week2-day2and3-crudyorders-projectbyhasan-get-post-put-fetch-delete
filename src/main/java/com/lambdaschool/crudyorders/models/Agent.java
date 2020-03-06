package com.lambdaschool.crudyorders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agents")
@JsonIgnoreProperties(value = {"hasvalueforcommission"})
public class Agent {
    @Transient
    public boolean hasvalueforcommission = false;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long agentcode;

    @Column(unique = true , nullable = false)
    private String agentname;

    private double commission;
    private String country;
    private String phone;
    private String workingarea;

    @OneToMany(mappedBy = "agent",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("agent")
    private List<Customer> customerlist = new ArrayList<>();

    public Agent() {
    }

    public Agent(String agentname, double commission, String country, String phone, String workingarea) {
        this.agentname = agentname;
        this.commission = commission;
        this.country = country;
        this.phone = phone;
        this.workingarea = workingarea;
    }

    public long getAgentCode() {
        return agentcode;
    }

    public void setAgentCode(long agentCode) {
        this.agentcode = agentCode;
    }

    public String getAgentName() {
        return agentname;
    }

    public void setAgentName(String agentname) {
        this.agentname = agentname;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.hasvalueforcommission = true;
        this.commission = commission;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWorkingArea() {
        return workingarea;
    }

    public void setWorkingArea(String workingarea) {
        this.workingarea = workingarea;
    }

    public List<Customer> getCustomerlist() {
        return customerlist;
    }

    public void setCustomerArrayList(List<Customer> customerlist) {
        this.customerlist = customerlist;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "hasvalueforcommission=" + hasvalueforcommission +
                ", agentcode=" + agentcode +
                ", agentname='" + agentname + '\'' +
                ", commission=" + commission +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                ", workingarea='" + workingarea + '\'' +
                ", customerlist=" + customerlist +
                '}';
    }
}
