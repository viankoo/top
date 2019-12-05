package com.top.project.product.service;

import com.top.project.product.domain.Product;
import com.top.project.product.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: guWei
 * @Description:
 * @Date: Created in 18:54 2019/12/4
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> selectProductList(Product product) {

        return null;
    }
}
