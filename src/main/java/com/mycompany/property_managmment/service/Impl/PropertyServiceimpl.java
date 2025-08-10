package com.mycompany.property_managmment.service.Impl;

import com.mycompany.property_managmment.converter.PropertyConverter;
import com.mycompany.property_managmment.dto.PropertyDTO;
import com.mycompany.property_managmment.entity.PropertyEntity;
import com.mycompany.property_managmment.respository.PropertyRepository;
import com.mycompany.property_managmment.service.PropertyService;
import org.hibernate.mapping.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceimpl implements PropertyService {

    @Value("${pms.dummy:}")
    private String dummy;

    @Value("${spring.datasource.url:}")
    private String dbUrl;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

        PropertyEntity propertyEntity = propertyConverter.convertDTOtoEntity(propertyDTO);
        propertyEntity = propertyRepository.save(propertyEntity);

        propertyDTO = propertyConverter.convertEntitytoDTO(propertyEntity);
        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {

        System.out.println("Inside service: " + dummy);
        System.out.println(dbUrl);

        List<PropertyEntity> listOfProperties = (List<PropertyEntity>) propertyRepository.findAll();
        List<PropertyDTO> propertyList = new ArrayList<PropertyDTO>();
        for (PropertyEntity propertyEntity : listOfProperties) {
            PropertyDTO dto = propertyConverter.convertEntitytoDTO(propertyEntity);
            propertyList.add(dto);
        }
        return  propertyList;
    }


    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {

        Optional<PropertyEntity> optionalEntity = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if (optionalEntity.isPresent()) {
            PropertyEntity propertyEntity = optionalEntity.get();
            propertyEntity.setTittle(propertyDTO.getTittle());
            propertyEntity.setDescription(propertyDTO.getDescription());
            propertyEntity.setOwnerEmail(propertyDTO.getOwnerEmail());
            propertyEntity.setOwnerName(propertyDTO.getOwnerName());
            propertyEntity.setPrice(propertyDTO.getPrice());
            propertyEntity.setAddress(propertyDTO.getAddress());

            dto = propertyConverter.convertEntitytoDTO(propertyEntity);

            propertyRepository.save(propertyEntity);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optionalEntity = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if (optionalEntity.isPresent()) {
            PropertyEntity propertyEntity = optionalEntity.get();
            propertyEntity.setDescription(propertyDTO.getDescription());

            dto = propertyConverter.convertEntitytoDTO(propertyEntity);
            propertyRepository.save(propertyEntity);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optionalEntity = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if (optionalEntity.isPresent()) {
            PropertyEntity propertyEntity = optionalEntity.get();
            propertyEntity.setPrice(propertyDTO.getPrice());
            dto = propertyConverter.convertEntitytoDTO(propertyEntity);
            propertyRepository.save(propertyEntity);
        }
        return dto;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }


}