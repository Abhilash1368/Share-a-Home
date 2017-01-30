package com.example.abhilashreddy.homelessness;

/**
 * Created by ABHILASH REDDY on 10/22/2016.
 */
public class donarslist {
    public String daddress;
    public String dcategory;
    public String ddescription;
    public Long dphone;
    public String dresource;
    public String fname;
    public String lname;
    public Double dlat;public  Double dlongi;

    public donarslist() {
    }

    public donarslist(String daddress, String dcategory, String ddescription, Long dphone, String dresource, String fname, String lname, Double dlat, Double dlongi) {
        this.daddress = daddress;
        this.dcategory = dcategory;
        this.ddescription = ddescription;
        this.dphone = dphone;
        this.dresource = dresource;
        this.fname = fname;
        this.lname = lname;
        this.dlat = dlat;
        this.dlongi = dlongi;
    }

    public String getDaddress() {
        return daddress;
    }

    public void setDaddress(String daddress) {
        this.daddress = daddress;
    }

    public String getDcategory() {
        return dcategory;
    }

    public void setDcategory(String dcategory) {
        this.dcategory = dcategory;
    }

    public String getDdescription() {
        return ddescription;
    }

    public void setDdescription(String ddescription) {
        this.ddescription = ddescription;
    }

    public Long getDphone() {
        return dphone;
    }

    public void setDphone(Long dphone) {
        this.dphone = dphone;
    }

    public String getDresource() {
        return dresource;
    }

    public void setDresource(String dresource) {
        this.dresource = dresource;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Double getDlat() {
        return dlat;
    }

    public void setDlat(Double dlat) {
        this.dlat = dlat;
    }

    public Double getDlongi() {
        return dlongi;
    }

    public void setDlongi(Double dlongi) {
        this.dlongi = dlongi;
    }
}
