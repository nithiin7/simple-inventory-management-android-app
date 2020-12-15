package com.nithin.mrp.entities;

import java.util.Comparator;

public class Model{
    String pname, pmodel, price, qty, manufacturer, warranty;

    public Model(String pname, String pmodel, String price, String qty, String manufacturer, String warranty) {
        this.pname = pname;
        this.pmodel = pmodel;
        this.price = price;
        this.qty = qty;
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

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
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

    public static Comparator<Model> ascPname = new Comparator<Model>() {
        @Override
        public int compare(Model m1, Model m2) {
            return m1.getPname().compareTo(m2.getPname());
        }
    };

    public static Comparator<Model> descPname = new Comparator<Model>() {
        @Override
        public int compare(Model m1, Model m2) {
            return m2.getPrice().compareTo(m1.getPname());
        }
    };

    public static Comparator<Model> ascPrice = new Comparator<Model>() {
        @Override
        public int compare(Model m1, Model m2) {
            return m1.getPrice().compareTo(m2.getPrice());
        }
    };

    public static Comparator<Model> descPrice = new Comparator<Model>() {
        @Override
        public int compare(Model m1, Model m2) {
            return m2.getPrice().compareTo(m1.getPrice());
        }
    };
}
