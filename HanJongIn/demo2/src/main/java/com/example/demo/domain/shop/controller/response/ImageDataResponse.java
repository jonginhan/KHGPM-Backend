package com.example.demo.domain.shop.controller.response;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class ImageDataResponse {
    private String imageData;

    public ImageDataResponse(String imageData) {
        this.imageData = imageData;
    }
}
