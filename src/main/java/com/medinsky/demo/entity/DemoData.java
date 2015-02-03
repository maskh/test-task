package com.medinsky.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Aleksandr on 31.01.2015.
 */
@Entity
@Table(name = "demo")
public class DemoData implements Serializable {

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 45)
    private String id;

    @Column(name = "ch", nullable = true, insertable = true, updatable = true, length = 1)
    private String ch;

    @Column(name = "varch", nullable = true, insertable = true, updatable = true, length = 45)
    private String varch;

    @Column(name = "dt", nullable = true, insertable = true, updatable = true)
    private Date dt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public String getVarch() {
        return varch;
    }

    public void setVarch(String varch) {
        this.varch = varch;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DemoData demoData = (DemoData) o;

        if (ch != null ? !ch.equals(demoData.ch) : demoData.ch != null) return false;
        if (dt != null ? !dt.equals(demoData.dt) : demoData.dt != null) return false;
        if (id != null ? !id.equals(demoData.id) : demoData.id != null) return false;
        if (varch != null ? !varch.equals(demoData.varch) : demoData.varch != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (ch != null ? ch.hashCode() : 0);
        result = 31 * result + (varch != null ? varch.hashCode() : 0);
        result = 31 * result + (dt != null ? dt.hashCode() : 0);
        return result;
    }
}
