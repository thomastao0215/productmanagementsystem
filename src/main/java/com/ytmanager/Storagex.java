package com.ytmanager;

import org.hibernate.mapping.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by jiachen215 on 2017/6/9.
 */
@Entity
public class Storagex {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sotrage_id;
    private Integer product_id;
    private Integer product_quantity;
    private Date instore_date;
    private Date oustore_date;
    private Set statue;

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getManufacture_id() {
        return sotrage_id;
    }

    public Integer getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(Integer product_quantity) {
        this.product_quantity = product_quantity;
    }

    public Date getInstore_date() {
        return instore_date;
    }

    public void setInstore_date(Date instore_date) {
        this.instore_date = instore_date;
    }

    public Set getStatue() {
        return statue;
    }

    public void setStatue(Set statue) {
        this.statue = statue;
    }

    public Date getOustore_date() {
        return oustore_date;
    }

    public void setOustore_date(Date oustore_date) {
        this.oustore_date = oustore_date;
    }
}
