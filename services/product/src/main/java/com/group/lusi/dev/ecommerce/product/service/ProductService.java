package com.group.lusi.dev.ecommerce.product.service;

import com.group.lusi.dev.ecommerce.product.dto.ProductPurchaseRequest;
import com.group.lusi.dev.ecommerce.product.dto.ProductPurchaseResponse;
import com.group.lusi.dev.ecommerce.product.dto.ProductRequest;
import com.group.lusi.dev.ecommerce.product.dto.ProductResponse;
import com.group.lusi.dev.ecommerce.product.exception.ProductPurchaseException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductService {
    Integer createProduct(
            ProductRequest request
    );

    ProductResponse findById(Integer id);

    List<ProductResponse> findAll();

    @Transactional(rollbackFor = ProductPurchaseException.class)
    List<ProductPurchaseResponse> purchaseProducts(
            List<ProductPurchaseRequest> request
    );
}
