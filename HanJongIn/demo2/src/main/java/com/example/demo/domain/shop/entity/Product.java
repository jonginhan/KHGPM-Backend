package com.example.demo.domain.shop.entity;

import com.example.demo.domain.shop.controller.response.ImageDataResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(length = 128, nullable = false)
    private String name;

    @Column(length = 128, nullable = false)
    private String description;

    @Column
    private Integer price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<ImageData> imageDataList = new ArrayList<>();

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    public void addImageData(ImageData imageData) {
        imageData.setProduct(this);
        imageDataList.add(imageData);
    }

//    public void setImageDataList(List<String> imageDataList) {
//        this.imageDataList.clear(); // Remove any existing imageData objects
//        if (imageDataList != null) {
//            for (String imageData : imageDataList) {
//                ImageData imageDataObject = new ImageData();
//                imageDataObject.setImageData(imageData);
//                imageDataObject.setProduct(this);
//                this.imageDataList.add(imageDataObject);
//            }
//        }
//    }

}

