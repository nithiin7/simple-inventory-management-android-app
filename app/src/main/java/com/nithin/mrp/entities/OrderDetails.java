package com.nithin.mrp.entities;


public class OrderDetails {

    String pname, pmodel, price, manufacturer, warranty;

    public OrderDetails(String pname, String pmodel, String price, String manufacturer) {
        this.pname = pname;
        this.pmodel = pmodel;
        this.price = price;
        this.manufacturer = manufacturer;
        this.warranty = warranty;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPmodel() {
        return pmodel;
    }

    public void setPmodel(String pmodel) {
        this.pmodel = pmodel;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

}

