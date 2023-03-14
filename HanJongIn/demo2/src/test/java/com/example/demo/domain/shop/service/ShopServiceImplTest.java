package com.example.demo.domain.shop.service;

import com.example.demo.domain.shop.repository.ShopRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShopServiceImplTest {

    @Autowired
    ShopRepository shopRepository;
    @Test
    void register() {
    }

    @Test
    void list() {
    }

    @Test
    @Transactional
    void findAllImagesByProductId() {
        System.out.println(shopRepository.findById(28L));

    }
}