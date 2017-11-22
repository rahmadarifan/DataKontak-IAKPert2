package com.example.android.datakontak;

/**
 * Created by Ifan on 11/18/2017.
 */

public class People {

    String name, phoneNumber;

    public People() {
    }

    public People(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
