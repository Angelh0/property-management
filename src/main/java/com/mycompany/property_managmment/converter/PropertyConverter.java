package com.mycompany.property_managmment.converter;

import com.mycompany.property_managmment.dto.PropertyDTO;
import com.mycompany.property_managmment.entity.PropertyEntity;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyConverter {

    public PropertyEntity convertDTOtoEntity (PropertyDTO propertyDTO) {
        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setTittle(propertyDTO.getTittle());
        propertyEntity.setAddress(propertyDTO.getAddress());
        propertyEntity.setOwnerName(propertyDTO.getOwnerName());
        propertyEntity.setOwnerEmail(propertyDTO.getOwnerEmail());
        propertyEntity.setDescription(propertyDTO.getDescription());
        propertyEntity.setPrice(propertyDTO.getPrice());

        return propertyEntity;
    }

    public PropertyDTO convertEntitytoDTO(PropertyEntity propertyEntity) {
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setId(propertyEntity.getId());
        propertyDTO.setTittle(propertyEntity.getTittle());
        propertyDTO.setAddress(propertyEntity.getAddress());
        propertyDTO.setOwnerName(propertyEntity.getOwnerName());
        propertyDTO.setOwnerEmail(propertyEntity.getOwnerEmail());
        propertyDTO.setDescription(propertyEntity.getDescription());
        propertyDTO.setPrice(propertyEntity.getPrice());

        return propertyDTO;
    }
}
