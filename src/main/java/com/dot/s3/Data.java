package com.dot.s3;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.opencsv.bean.CsvBindByName;

@Entity
@JsonInclude(Include.NON_EMPTY)
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int dataId;

    @CsvBindByName
    private String uniqueID;

    @CsvBindByName
    private String name;

    @CsvBindByName
    private String value;


    public int getDataId() {
        return dataId;
    }

    public void setDataId(int studentId) {
        this.dataId = studentId;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String firstName) {
        this.uniqueID = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String middleName) {
        this.name = middleName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String lastName) {
        this.value = lastName;
    }

}


