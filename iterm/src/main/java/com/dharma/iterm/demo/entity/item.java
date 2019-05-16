package com.dharma.iterm.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "item")
public class item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String item_name;
    @Column
    private Integer count;
    @Column
    private String comment;
    @Column
    private String name;

    public item() {
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public item(String item_name, Integer count, String comment, String name) {
        this.item_name = item_name;
        this.count = count;
        this.comment = comment;
        this.name=name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItem_Name() {
        return item_name;
    }

    public void setItem_Name(String item_name) {
        this.item_name = item_name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
