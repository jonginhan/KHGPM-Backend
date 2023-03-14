package com.example.demo.domain.shop.service;

import com.example.demo.domain.shop.controller.request.ShopRequest;
import com.example.demo.domain.shop.controller.response.ImageDataResponse;
import com.example.demo.domain.shop.entity.Product;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface ShopService {
    String register(ShopRequest shopRequest) throws IOException;

    List<Product> list();

    List<ImageDataResponse> findAllImagesByProductId(Long productId);
}
