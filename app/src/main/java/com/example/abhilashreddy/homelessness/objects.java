package com.example.abhilashreddy.homelessness;

/**
 * Created by ABHILASH REDDY on 10/22/2016.
 */
public class objects {
    public String address;
    public String age;
    public String daddress;
    public double dlat;
    public double dlongi;
    public String firstname;
    public double hlat;
    public double hlongi;
    public String lastname;
    public String lookingfor;
    public String nameofdonar;
    public String note;
    public Long phone;
    public String reasonforhelp;
    public String resources;

    public objects() {
    }

    public objects(String address, String age, String daddress, double dlat, double dlongi, String firstname, double hlat, double hlongi, String lastname, String lookingfor, String nameofdonar, String note, Long phone, String reasonforhelp, String resources) {
        this.address = address;
        this.age = age;
        this.daddress = daddress;
        this.dlat = dlat;
        this.dlongi = dlongi;
        this.firstname = firstname;
        this.hlat = hlat;
        this.hlongi = hlongi;
        this.lastname = lastname;
        this.lookingfor = lookingfor;
        this.nameofdonar = nameofdonar;
        this.note = note;
        this.phone = phone;
        this.reasonforhelp = reasonforhelp;
        this.resources = resources;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDaddress() {
        return daddress;
    }

    public void setDaddress(String daddress) {
        this.daddress = daddress;
    }

    public double getDlat() {
        return dlat;
    }

    public void setDlat(double dlat) {
        this.dlat = dlat;
    }

    public double getDlongi() {
        return dlongi;
    }

    public void setDlongi(double dlongi) {
        this.dlongi = dlongi;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public double getHlat() {
        return hlat;
    }

    public void setHlat(double hlat) {
        this.hlat = hlat;
    }

    public double getHlongi() {
        return hlongi;
    }

    public void setHlongi(double hlongi) {
        this.hlongi = hlongi;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLookingfor() {
        return lookingfor;
    }

    public void setLookingfor(String lookingfor) {
        this.lookingfor = lookingfor;
    }

    public String getNameofdonar() {
        return nameofdonar;
    }

    public void setNameofdonar(String nameofdonar) {
        this.nameofdonar = nameofdonar;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getReasonforhelp() {
        return reasonforhelp;
    }

    public void setReasonforhelp(String reasonforhelp) {
        this.reasonforhelp = reasonforhelp;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }
}
