package com.jiangbo.weixin_demo.controller;

import com.jiangbo.weixin_demo.entity.TbArea;
import com.jiangbo.weixin_demo.service.sys.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AreaController {

    @Autowired
    private AreaService areaService;

//    @GetMapping("/getarealist")
//    public List<TbArea> getAreaList() throws Exception{
//
//        return areaService.areasList();
//    }
//
//    @PutMapping("/updatearea")
//    public int updateArea(@RequestBody TbArea tbArea) throws Exception{
//
//        return areaService.updateArea(tbArea);
//    }
//
//    @PostMapping("/addarea")
//    public int addArea(@RequestBody TbArea tbArea) throws Exception{
//
//        return areaService.insertArea(tbArea);
//    }
//
//    @DeleteMapping("/deletearea/{id}")
//    public int getAreaList(@PathVariable("id") Integer id) throws Exception{
//
//        return areaService.deleteArea(id);
//    }


    @GetMapping("/getarealist")
    public Map<String, Object> getAreaList() throws Exception{

        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<TbArea> list = areaService.areasList();
        modelMap.put("areaList", list);

        return modelMap;
    }

    @GetMapping("/getareabyid")
    public Map<String, Object> getAreaById(@RequestParam Integer id) throws Exception{

        Map<String, Object> modelMap = new HashMap<String, Object>();
        TbArea tbArea = areaService.getAreaById(id);
        modelMap.put("area", tbArea);

        return modelMap;
    }

    @PostMapping("/addarea")
    public Map<String, Object> addArea(@RequestBody TbArea tbArea) throws Exception{

        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", areaService.insertArea(tbArea));

        return modelMap;
    }

    @PutMapping("/updatearea")
    public Map<String, Object> updateArea(@RequestBody TbArea tbArea) throws Exception{

        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", areaService.updateArea(tbArea));

        return modelMap;
    }

    @GetMapping("/deletearea")
    public  Map<String, Object> getAreaList(@RequestParam("id") Integer id) throws Exception{

        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", areaService.deleteArea(id));

        return modelMap;
    }
}
