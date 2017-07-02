package com.ytmanager;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by jiachen215 on 2017/6/9.
 */


@RestController
@RequestMapping(path="/api/material")
public class MaterialController {
    @Autowired
    private MaterialRepository materialRepository;
    // 增加or修改
    @GetMapping(path="/modify")
    public @ResponseBody
    String addNewUser(@RequestParam Integer material_id,
                      @RequestParam String material_name ,
                      @RequestParam Integer qty,
                      @RequestParam java.sql.Date indate,
                      @RequestParam java.sql.Date outdate
    ){
        Material m = new Material();
        m.setMaterial_id(material_id);
        m.setMaterial_name(material_name);
        m.setMaterial_qty(qty);
        m.setMaterial_indate(indate);
        m.setMaterial_outdate(outdate);


        materialRepository.save(m);
        return "Saved";
    }
    //查询所有
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Material> getAllMaterial(){
        return materialRepository.findAll();
    }
    //根据id查询
    @RequestMapping(path="/query")
    public @ResponseBody Material querryMaterial(@RequestParam Long mid) {
        Material selectMaterial = materialRepository.findOne(mid);
        return selectMaterial;
    }
    //根据id删除
    @RequestMapping(path="/delete")
    public @ResponseBody String deleteMaterial(@RequestParam Long mid) {
        materialRepository.delete(mid);
        return "Sucess";
    }


}