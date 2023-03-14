package com.example.demo.domain.shop.repository;

import com.example.demo.domain.shop.entity.ImageData;
import com.example.demo.domain.shop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopRepository extends JpaRepository<Product, Long> {
    List<ImageData> findAllImagesByProductId(Long productId);
}
