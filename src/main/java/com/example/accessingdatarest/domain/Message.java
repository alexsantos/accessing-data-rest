package com.example.accessingdatarest.domain;

import javax.persistence.*;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String code;
    private String event;

    public Message(String code, String event) {
        this.code = code;
        this.event = event;
    }

    public Message() {
    }

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

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", event='" + event + '\'' +
                '}';
    }
}