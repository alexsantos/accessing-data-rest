package com.example.accessingdatarest.domain;

import com.example.accessingdatarest.domain.Enumerators.Gender;

import javax.persistence.*;
import java.util.List;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String code;
    private String display;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", display='" + display + '\'' +
                '}';
    }
}