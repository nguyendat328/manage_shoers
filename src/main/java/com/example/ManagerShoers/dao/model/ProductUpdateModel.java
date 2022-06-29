package com.example.ManagerShoers.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductUpdateModel {

    private Integer id;

    private String name;

    private Integer typeId;

    private Integer brandId;

    private String size;

    private String color;

    private String imgUrl;

    private String status;
}
