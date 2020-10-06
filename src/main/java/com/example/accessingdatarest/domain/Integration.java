package com.example.accessingdatarest.domain;

import javax.persistence.*;

@Entity
@Table(indexes = {@Index(name = "idx_msg_apps", columnList = "message,sending_app,receiving_app")})
public class Integration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Message message;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Player sendingApp;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Player receivingApp;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Mapper mapper;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getSendingApp() {
        return sendingApp;
    }

    public void setSendingApp(Player sendingApp) {
        this.sendingApp = sendingApp;
    }

    public Player getReceivingApp() {
        return receivingApp;
    }

    public void setReceivingApp(Player receivingApp) {
        this.receivingApp = receivingApp;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Mapper getMapper() {
        return mapper;
    }

    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public String toString() {
        return "Integration{" +
                "id=" + id +
                ", message=" + message +
                ", sendingApp=" + sendingApp +
                ", receivingApp=" + receivingApp +
                ", mapper=" + mapper +
                '}';
    }
}
