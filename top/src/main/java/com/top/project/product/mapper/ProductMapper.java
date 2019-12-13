package com.top.project.product.mapper;

import com.top.project.product.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: guWei
 * @Description:
 * @Date: Created in 18:54 2019/12/4
 */
@Repository
public interface ProductMapper {

    /** 查询商品列表
     * @param product
     * @return
     */
    List<Product> selectProductList(Product product);

    /**
     * 根据productName查询商品
     * @param productName
     * @return
     */
    Product checkProductNameUnique(String productName);

    /**
     * 新增商品
     * @param product
     * @return
     */
    int insertProduct(Product product);

    /**
     * 更新商品
     * @param product
     * @return
     */
    int updateProduct(Product product);

    /**
     * 根据id查询商品
     * @param id
     * @return
     */
    Product selectProductById(String id);

    /**
     * 批量删除商品
     * @param ids
     * @return
     */
    int deleteProductByIds(String[] ids);
}
