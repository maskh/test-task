package com.medinsky.demo.repository;

import com.medinsky.demo.entity.DemoData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Aleksandr on 31.01.2015.
 */
@Repository
public interface DemoDataRepository extends CrudRepository<DemoData, String> {
}
