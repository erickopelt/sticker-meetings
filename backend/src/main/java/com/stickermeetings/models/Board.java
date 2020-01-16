package com.stickermeetings.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Board extends PanacheEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @javax.persistence.Column(name = "uuid", unique = true)
    public String uuid;

    public String name;

    @CreationTimestamp
    @javax.persistence.Column(name = "create_Date")
    public Date createDate;

    @OneToMany(targetEntity = Column.class)
    public List<Column> columns;

    public static Board findByName(String name) {
        return find("name", name).firstResult();
    }

    public static Board findByUuid(String uuid) {
        return find("uuid", uuid).firstResult();
    }
}
