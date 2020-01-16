package com.stickermeetings.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Column extends PanacheEntity implements Serializable {
    private static final long serialVersionUID = 4465654880461635668L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @javax.persistence.Column(name = "uuid", unique = true)
    public String uuid;
    public String name;
    public int order;
    @OneToMany(targetEntity = Sticker.class)
    public List<Sticker> stickers;

    public static Column findByUuid(String uuid) {
        return find("uuid", uuid).firstResult();
    }
}
