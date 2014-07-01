package com.springapp.mvc;

/**
 * Created by bildad on 27/06/14.
 */
public class Clients {

    private int cid;
    private String names;
    private String tel1;
    private String phy_address;
    private String email;
    private String city;


    public void setEmail(String email) {
        this.email = email;
    }



    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setCity(String city) {
        this.city = city;
    }





    public void setNames(String names) {
        this.names = names;
    }



    public void setPhy_address(String phy_address) {
        this.phy_address = phy_address;
    }



    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }




    public int getCid() {
        return cid;
    }

    public String getNames() {
        return names;
    }

    public String getEmail() {
        return email;
    }

    public String getPhy_address() {
        return phy_address;
    }

    public String getTel1() {
        return tel1;
    }

    public String getCity() {
        return city;
    }
}

