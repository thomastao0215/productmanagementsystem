package com.ytmanager;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by jiachen215 on 2017/6/9.
 */


@RestController
@RequestMapping(path="/api/manufacture")
public class ManufactureController {
    @Autowired
    private ManufactureRepository manufactureRepository;
    // 增加or修改
    @GetMapping(path="/modify")
    public @ResponseBody
    String addNewUser(@RequestParam String product_name ,
                      @RequestParam String unit,
                      @RequestParam Integer product_id,
                      @RequestParam Double qty,
                      @RequestParam String cury,
                      @RequestParam java.sql.Date sdate,
                      @RequestParam java.sql.Date edate
                      ){
        Manufacture m = new Manufacture();
        m.setProduct_id(product_id);
        m.setProduct_name(product_name);
        m.setManufacture_qty(qty);
        m.setManufacture_unit(unit);
        m.setManufacture_currency(cury);
        m.setStart_date(sdate);
        m.setEnd_date(edate);

        manufactureRepository.save(m);
        return "Saved";
    }
    //查询所有
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Manufacture> getAllManufacture(){
        return manufactureRepository.findAll();
    }
    //根据id查询
    @RequestMapping(path="/query")
    public @ResponseBody Manufacture querryManufacutre(@RequestParam Long mid) {
        Manufacture selectManufacutre = manufactureRepository.findOne(mid);
        return selectManufacutre;
    }
    //根据id删除
    @RequestMapping(path="/delete")
    public @ResponseBody String deleteManufacutre(@RequestParam Long mid) {
        manufactureRepository.delete(mid);
        return "Sucess";
    }


}