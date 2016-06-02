package com.example.framgia.hrm_10.Model;

/**
 * Created by framgia on 02/06/2016.
 */
public class Staff {
    int id;
    String name;
    String place_of_birth;
    String birthday;
    String phone;
    String position_in_company;
    String status;
    public Staff(){

    }
    public Staff(int id,String name,String place_of_birth,
                   String birthday,String phone,
                   String position_in_company,String status){
        this.id=id;
        this.name=name;
        this.place_of_birth=place_of_birth;
        this.birthday=birthday;
        this.phone=phone;
        this.position_in_company=position_in_company;
        this.status=status;

    }
    public Staff(String name,String place_of_birth,
                   String birthday,String phone,
                   String position_in_company,String status){
        this.name=name;
        this.place_of_birth=place_of_birth;
        this.birthday=birthday;
        this.phone=phone;
        this.position_in_company=position_in_company;
        this.status=status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPlace_of_birth(String place_of_birth) {
        this.place_of_birth = place_of_birth;
    }

    public String getPlace_of_birth() {
        return place_of_birth;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPosition_in_company(String position_in_company) {
        this.position_in_company = position_in_company;
    }

    public String getPosition_in_company() {
        return position_in_company;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
