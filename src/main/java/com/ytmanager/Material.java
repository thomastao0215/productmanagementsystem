package com.ytmanager;

/**
 * Created by jiachen215 on 2017/6/9.
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Set;

@Entity
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer material_id;
    private String material_name;
    private String material_spec;
    private String material_type;
    private String material_usage;
    private String material_remark;
    private Integer material_qty;
    private Date material_indate;
    private Date material_outdate;
    private String material_statue;

    public void setMaterial_id(Integer material_id) {
        this.material_id = material_id;
    }

    public Date getMaterial_indate() {

        return material_indate;
    }

    public void setMaterial_indate(Date material_indate) {
        this.material_indate = material_indate;
    }

    public Date getMaterial_outdate() {
        return material_outdate;
    }

    public void setMaterial_outdate(Date material_outdate) {
        this.material_outdate = material_outdate;
    }

    public String getMaterial_statue() {
        return material_statue;
    }

    public void setMaterial_statue(String material_statue) {
        this.material_statue = material_statue;
    }

    public Integer getMaterial_id() {
        return material_id;
    }

    public String getMaterial_name() {
        return material_name;
    }

    public String getMaterial_spec() {
        return material_spec;
    }

    public String getMaterial_type() {
        return material_type;
    }

    public String getMaterial_usage() {
        return material_usage;
    }

    public String getMaterial_remark() {
        return material_remark;
    }

    public void setMaterial_name(String material_name) {
        this.material_name = material_name;
    }

    public void setMaterial_spec(String material_spec) {
        this.material_spec = material_spec;
    }

    public void setMaterial_remark(String material_remark) {
        this.material_remark = material_remark;
    }

    public void setMaterial_type(String material_type) {
        this.material_type = material_type;
    }

    public void setMaterial_usage(String material_usage) {
        this.material_usage = material_usage;
    }
    public Integer getMaterial_qty() {
        return material_qty;
    }

    public void setMaterial_qty(Integer material_qty) {
        this.material_qty = material_qty;
    }
}