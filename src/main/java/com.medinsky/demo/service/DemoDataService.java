package com.medinsky.demo.service;

import com.medinsky.demo.entity.DemoData;
import com.medinsky.demo.repository.DemoDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Aleksandr on 31.01.2015.
 */
@Service
public class DemoDataService {

    @Autowired
    private DemoDataRepository demoDataRepository;

    public void save(DemoData data){
        demoDataRepository.save(data);
    }

    public DemoData findOne(String id){
        return demoDataRepository.findOne(id);
    }

    public Iterable<DemoData> findAll(){
        return demoDataRepository.findAll();
    }

    public void delete(String id){
        demoDataRepository.delete(id);
    }
}
