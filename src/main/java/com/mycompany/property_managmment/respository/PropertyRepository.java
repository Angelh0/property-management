package com.mycompany.property_managmment.respository;

import com.mycompany.property_managmment.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<PropertyEntity, Long> {

}
