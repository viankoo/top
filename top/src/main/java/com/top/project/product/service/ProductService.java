package com.top.project.product.service;

import com.top.project.product.domain.Product;

import java.util.List;

/**
 * @Author: guWei
 * @Description:
 * @Date: Created in 18:54 2019/12/4
 */
public interface ProductService {

    /**
     * 条件查询商品列表
     * @param product
     * @return
     */
    List<Product> selectProductList(Product product);
}
