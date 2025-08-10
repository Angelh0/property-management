package com.mycompany.property_managmment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyDTO {

    private Long id;
    private String tittle;
    private String description;
    private String ownerName;
    private String ownerEmail;
    private Double price;
    private String address;
}
