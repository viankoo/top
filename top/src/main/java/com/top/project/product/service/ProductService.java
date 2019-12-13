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

    /**
     * 校验商品名称是否重复
     * @param product
     * @return
     */
    String checkProductNameUnique(Product product);

    /**
     * 新增商品
     * @param product
     * @return
     */
    int insertProduct(Product product);

    /**
     * 根据商品编号审核商品
     * @param product
     * @return
     */
    int checkProduct(Product product);

    /**
     * 根据商品编号上下架商品
     * @param product
     * @return
     */
    int onOffSellProduct(Product product);

    /**
     * 根据商品编号获取详细信息
     * @param id
     * @return
     */
    Product selectProductById(String id);

    /**
     * 根据商品编号更新商品
     * @param product
     * @return
     */
    int updateProduct(Product product);

    /**
     * 根据商品编号删除商品
     * @param ids
     * @return
     */
    int deleteProductByIds(String[] ids);
}
