package com.example.accessingdatarest.domain;

import com.example.accessingdatarest.domain.Enumerators.MapperType;

import javax.persistence.*;
import java.util.List;

@Entity
public class Mapper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ElementCollection
    private List<String> key;
    private String value;
    private MapperType type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getKey() {
        return key;
    }

    public void setKey(List<String> key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public MapperType getType() {
        return type;
    }

    public void setType(MapperType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Mapper{" +
                "id=" + id +
                ", key=" + key +
                ", value='" + value + '\'' +
                ", type=" + type +
                '}';
    }
}