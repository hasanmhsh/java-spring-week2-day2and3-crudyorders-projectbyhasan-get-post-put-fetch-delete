package com.lambdaschool.crudyorders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
@JsonIgnoreProperties(value = {"hasvalueforopeningamt","hasvalueforoutstandingamt","hasvalueforpaymentamt","hasvalueforreceiveamt"})
public class Customer {
    @Transient
    public boolean hasvalueforopeningamt = false;
    @Transient
    public boolean hasvalueforoutstandingamt = false;
    @Transient
    public boolean hasvalueforpaymentamt = false;
    @Transient
    public boolean hasvalueforreceiveamt = false;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long custcode;

    private String custcity;
    private String custcountry;

    @Column(unique = false , nullable = false)
    private String custname;

    private String grade;

    private double openingamt;
    private double outstandingamt;
    private double paymentamt;

    private String phone;

    private double receiveamt;

    private String workingarea;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agentcode",
            nullable = false)
    @JsonIgnoreProperties({"customerlist", "hibernateLazyInitializer"})
    private Agent agent;

    @OneToMany(mappedBy = "customer",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("customer")
    private List<Customer> orderlist = new ArrayList<>();


    public Customer(){
    }

    public Customer(String custcity, String custcountry, String custname, String grade, double openingamt, double outstandingamt, double paymentamt, String phone, double receiveamt, String workingarea, Agent agent) {
        this.custcity = custcity;
        this.custcountry = custcountry;
        this.custname = custname;
        this.grade = grade;
        this.openingamt = openingamt;
        this.outstandingamt = outstandingamt;
        this.paymentamt = paymentamt;
        this.phone = phone;
        this.receiveamt = receiveamt;
        this.workingarea = workingarea;
        this.agent = agent;
    }

    public long getCustcode() {
        return custcode;
    }

    public void setCustcode(long custcode) {
        this.custcode = custcode;
    }

    public String getCustcity() {
        return custcity;
    }

    public void setCustcity(String custcity) {
        this.custcity = custcity;
    }

    public String getCustcountry() {
        return custcountry;
    }

    public void setCustcountry(String custcountry) {
        this.custcountry = custcountry;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getOpeningamt() {
        return openingamt;
    }

    public void setOpeningamt(double openingamt) {
        hasvalueforopeningamt=true;
        this.openingamt = openingamt;
    }

    public double getOutstandingamt() {
        return outstandingamt;
    }

    public void setOutstandingamt(double outstandingamt) {
        hasvalueforoutstandingamt = true;
        this.outstandingamt = outstandingamt;
    }

    public double getPaymentamt() {
        return paymentamt;
    }

    public void setPaymentamt(double paymentamt) {
        hasvalueforpaymentamt = true;
        this.paymentamt = paymentamt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getReceiveamt() {
        return receiveamt;
    }

    public void setReceiveamt(double receiveamt) {
        hasvalueforreceiveamt = true;
        this.receiveamt = receiveamt;
    }

    public String getWorkingarea() {
        return workingarea;
    }

    public void setWorkingarea(String workingarea) {
        this.workingarea = workingarea;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public List<Customer> getOrderlist() {
        return orderlist;
    }

    public void setOrderlist(List<Customer> orderlist) {
        this.orderlist = orderlist;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "hasvalueforopeningamt=" + hasvalueforopeningamt +
                ", hasvalueforoutstandingamt=" + hasvalueforoutstandingamt +
                ", hasvalueforpaymentamt=" + hasvalueforpaymentamt +
                ", hasvalueforreceiveamt=" + hasvalueforreceiveamt +
                ", custcode=" + custcode +
                ", custcity='" + custcity + '\'' +
                ", custcountry='" + custcountry + '\'' +
                ", custname='" + custname + '\'' +
                ", grade='" + grade + '\'' +
                ", openingamt=" + openingamt +
                ", outstandingamt=" + outstandingamt +
                ", paymentamt=" + paymentamt +
                ", phone='" + phone + '\'' +
                ", receiveamt=" + receiveamt +
                ", workingarea='" + workingarea + '\'' +
                ", agentcode=" + agent.getAgentCode() +
                ", agentname=" + agent.getAgentName() +
                ", orderlist=" + orderlist +
                '}';
    }
}
