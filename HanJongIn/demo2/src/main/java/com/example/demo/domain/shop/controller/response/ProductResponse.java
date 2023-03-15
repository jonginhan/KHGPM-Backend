package com.example.demo.domain.shop.controller.response;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class ProductResponse {

    final private String name;
    final private String description;
    final private Integer price;
    final private List<String> imageDataList;
}
