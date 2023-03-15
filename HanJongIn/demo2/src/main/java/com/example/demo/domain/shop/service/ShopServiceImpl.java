package com.example.demo.domain.shop.service;

import com.example.demo.domain.shop.controller.request.ShopRequest;
import com.example.demo.domain.shop.controller.response.ImageDataResponse;
import com.example.demo.domain.shop.entity.ImageData;
import com.example.demo.domain.shop.entity.Product;
import com.example.demo.domain.shop.repository.ImageDataRepository;
import com.example.demo.domain.shop.repository.ShopRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ShopServiceImpl implements ShopService{
    final private ShopRepository shopRepository;

    final private ImageDataRepository imageDataRepository;

    public ShopServiceImpl(ShopRepository shopRepository, ImageDataRepository imageDataRepository) {
        this.shopRepository = shopRepository;
        this.imageDataRepository = imageDataRepository;
    }

    public String register(ShopRequest shopRequest) throws IOException {
        Product product = new Product();
        product.setName(shopRequest.getName());
        product.setDescription(shopRequest.getDescription());
        product.setPrice(shopRequest.getPrice());

        for (MultipartFile file : shopRequest.getFileList()) {
            if (!file.isEmpty()) {
                String filePath = "productImages/" + file.getOriginalFilename();

                ImageData imageData = new ImageData();
                imageData.setImageData(filePath);
                product.addImageData(imageData);

                FileOutputStream writer = new FileOutputStream("../../../KHGPM-Frontend/JongInHan/frontend/src/assets/" + filePath);
                writer.write(file.getBytes());
                writer.close();
            }
        }

        shopRepository.save(product);

        return "Upload Success!!!";
    }

    @Override
    public List<Product> list() {
        return shopRepository.findAll(Sort.by(Sort.Direction.DESC, "productId"));
    }

    @Override
    public List<ImageDataResponse> findAllImagesByProductId(Long productId) {
        List<ImageData> imageDataList = imageDataRepository.findAllImagesByProductId(productId);
        List<ImageDataResponse> imageDataResponses = new ArrayList<>();

        for (ImageData imageData : imageDataList) {
            imageDataResponses.add(new ImageDataResponse((imageData.getImageData())));
        }

        return imageDataResponses;
//        return imageDataList;
    }
}
