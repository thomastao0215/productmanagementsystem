package com.ytmanager;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by jiachen215 on 2017/6/9.
 */
@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer purchase_id;
    private Integer material_id;
    private String material_name;
    private Integer material_qty;
    private Date demand_date;
    private Date purchase_date;
    private String purchase_operator;


    public Integer getPurchase_id() {
        return purchase_id;
    }

    public Integer getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(Integer material_id) {
        this.material_id = material_id;
    }

    public String getMaterial_name() {
        return material_name;
    }

    public void setMaterial_name(String material_name) {
        this.material_name = material_name;
    }

    public Integer getMaterial_qty() {
        return material_qty;
    }

    public void setMaterial_qty(Integer material_qty) {
        this.material_qty = material_qty;
    }

    public Date getDemand_date() {
        return demand_date;
    }

    public void setDemand_date(Date demand_date) {
        this.demand_date = demand_date;
    }

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }

    public String getPurchase_operator() {
        return purchase_operator;
    }

    public void setPurchase_operator(String purchase_operator) {
        this.purchase_operator = purchase_operator;
    }
}
