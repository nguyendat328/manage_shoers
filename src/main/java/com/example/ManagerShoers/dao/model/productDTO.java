package com.example.ManagerShoers.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class productDTO {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "brand_id")
    private Integer brandId;

    @Column(name = "size")
    private String size;

    @Column(name = "color")
    private String color;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "status")
    private String status;

}
