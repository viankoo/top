package com.top.project.product.service;

import com.top.common.constant.Constants;
import com.top.common.constant.ProductConstans;
import com.top.common.constant.UserConstants;
import com.top.common.utils.StringUtils;
import com.top.project.product.domain.Product;
import com.top.project.product.mapper.ProductMapper;
import com.top.project.system.domain.SysConfig;
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
        return productMapper.selectProductList(product);
    }

    @Override
    public String checkProductNameUnique(Product product) {
        String productId = StringUtils.isEmpty(product.getProductId()) ? "-1L" : product.getProductId();
        Product result = productMapper.checkProductNameUnique(product.getProductName());
        if (StringUtils.isNotNull(result) && !result.getProductId().equals(productId)) {
            return Constants.NOT_UNIQUE;
        }
        return Constants.UNIQUE;
    }

    @Override
    public int insertProduct(Product product) {
        return productMapper.insertProduct(product);
    }

    @Override
    public int checkProduct(Product product) {
        return productMapper.updateProduct(product);
    }

    @Override
    public int onOffSellProduct(Product product) {
        return productMapper.updateProduct(product);
    }

    @Override
    public Product selectProductById(String id) {
        return productMapper.selectProductById(id);
    }

    @Override
    public int updateProduct(Product product) {
        return productMapper.updateProduct(product);
    }

    @Override
    public int deleteProductByIds(String[] ids) {
        return productMapper.deleteProductByIds(ids);
    }
}
