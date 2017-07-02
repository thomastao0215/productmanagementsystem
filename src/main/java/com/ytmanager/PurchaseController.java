package com.ytmanager;

import com.sun.org.apache.regexp.internal.RE;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by jiachen215 on 2017/6/9.
 */


@RestController
@RequestMapping(path="/api/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseRepository purchaseRepository;
    // 增加or修改
    @GetMapping(path="/modify")
    public @ResponseBody
    String addNewUser(@RequestParam String material_name ,
                      @RequestParam Integer material_id,
                      @RequestParam Integer qty,
                      @RequestParam java.sql.Date ddate,
                      @RequestParam java.sql.Date pdate,
                      @RequestParam String op
    ){
        Purchase p = new Purchase();
        p.setMaterial_id(material_id);
        p.setMaterial_name(material_name);
        p.setMaterial_qty(qty);
        p.setDemand_date(ddate);
        p.setPurchase_date(pdate);
        p.setPurchase_operator(op);
        purchaseRepository.save(p);
        return "Saved";
    }
    //查询所有
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Purchase> getAllManufacture(){
        return purchaseRepository.findAll();
    }
    //根据id查询
    @RequestMapping(path="/query")
    public @ResponseBody Purchase querryPurchasefacutre(@RequestParam Long mid) {
        Purchase selectPurchase = purchaseRepository.findOne(mid);
        return selectPurchase;
    }
    //根据id删除
    @RequestMapping(path="/delete")
    public @ResponseBody String deletePurchasefacutre(@RequestParam Long mid) {
        purchaseRepository.delete(mid);
        return "Sucess";
    }


}