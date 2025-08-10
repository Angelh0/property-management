package com.mycompany.property_managmment.controller;

import com.mycompany.property_managmment.dto.PropertyDTO;
import com.mycompany.property_managmment.respository.PropertyRepository;
import com.mycompany.property_managmment.service.PropertyService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @Value("${pms.dummy:}")
    private String dummy;

    @Value("${spring.datasource.url:}")
    private String dbUrl;

    private final PropertyService propertyService;
    private final PropertyRepository propertyRepository;

    public PropertyController(PropertyService propertyService, PropertyRepository propertyRepository) {
        this.propertyService = propertyService;
        this.propertyRepository = propertyRepository;
    }

    @GetMapping("/hello")
    public String SayHello() {

        return "Hello ";
    }

    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO) {

        propertyDTO = propertyService.saveProperty(propertyDTO);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<PropertyDTO>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/properties")
    public ResponseEntity <List<PropertyDTO>> getAllProperties() {
       System.out.println(dummy);
       System.out.println(dbUrl);
       List<PropertyDTO> propertyList = propertyService.getAllProperties();
       ResponseEntity <List<PropertyDTO>> responseEntity = new ResponseEntity<>(propertyList, HttpStatus.OK);
       return responseEntity;
    }

    @PutMapping("/properties/{propertyId}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
        propertyDTO = propertyService.updateProperty(propertyDTO, propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return responseEntity;
    }

    @PatchMapping("/properties/update-description/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyDescription(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
        propertyDTO = propertyService.updatePropertyDescription(propertyDTO, propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return responseEntity;
    }

    @PatchMapping("/properties/update-price/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyPrice (@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
        propertyDTO = propertyService.updatePropertyPrice(propertyDTO, propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/properties/delete/{propertyId}")
    public ResponseEntity<Void> deleteProperties(@PathVariable Long propertyId) {
        propertyService.deleteProperty(propertyId);
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        return responseEntity;
    }
}