package com.cisco.prj.entity;

import com.cisco.prj.annotation.Column;
import com.cisco.prj.annotation.Table;

@Table(name="EMP")
public class Employee {
    String email;
    String firstName;

    public Employee() {
    }

    public Employee(String email, String firstName) {
        this.email = email;
        this.firstName = firstName;
    }

    @Column(name = "EMP_EMAIL")
    public String getEmail() {
        return email;
    }

    @Column(name = "FIRST_NAME", type = "VARCHAR(50)")
    public String getFirstName() {
        return firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
