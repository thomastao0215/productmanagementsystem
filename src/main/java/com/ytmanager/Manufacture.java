package com.ytmanager;

/**
 * Created by jiachen215 on 2017/6/9.
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Manufacture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer manufacture_id;
    private Integer product_id;
    private String product_name;
    private Double manufacture_qty;//生产数量
    private String manufacture_currency; //生产金额
    private String manufacture_unit;//生产单位
    private Date start_date;
    private Date end_date;
    private Double period;
    private Integer material_id;
    private Integer material_qty;


    public Integer getManufacture_id() {
        return manufacture_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public Double getManufacture_qty() {
        return manufacture_qty;
    }

    public String getManufacture_currency() {
        return manufacture_currency;
    }

    public String getManufacture_unit() {
        return manufacture_unit;
    }

    public Date getStart_date() {
        return start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public Double getPeriod() {
        return period;
    }

    public Integer getMaterial_id() {
        return material_id;
    }

    public Integer getMaterial_qty() {
        return material_qty;
    }

    public void setManufacture_id(Integer manufacture_id) {
        this.manufacture_id = manufacture_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setManufacture_qty(Double manufacture_qty) {
        this.manufacture_qty = manufacture_qty;
    }

    public void setManufacture_currency(String manufacture_currency) {
        this.manufacture_currency = manufacture_currency;
    }

    public void setManufacture_unit(String manufacture_unit) {
        this.manufacture_unit = manufacture_unit;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public void setPeriod(Double period) {
        this.period = period;
    }

    public void setMaterial_id(Integer material_id) {
        this.material_id = material_id;
    }

    public void setMaterial_qty(Integer material_qty) {
        this.material_qty = material_qty;
    }
}