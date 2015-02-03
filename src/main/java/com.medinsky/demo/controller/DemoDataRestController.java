package com.medinsky.demo.controller;

import com.google.gson.Gson;
import com.medinsky.demo.entity.DemoData;
import com.medinsky.demo.service.DemoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo-data")
public class DemoDataRestController {

    @Autowired
    private DemoDataService service;

    @Autowired Gson gson;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    String showAll(){
        Iterable<DemoData> rows = service.findAll();
        return gson.toJson(rows);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable("id") String id){
        service.delete(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    void add(@RequestBody String object){
        DemoData data = gson.fromJson(object, DemoData.class);
        service.save(data);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    void update(@RequestBody String object){
        DemoData data = gson.fromJson(object, DemoData.class);
        service.save(data);
    }

}