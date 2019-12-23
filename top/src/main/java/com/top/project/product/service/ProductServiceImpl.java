package com.top.project.product.service;

import com.top.common.constant.Constants;
import com.top.common.constant.ProductConstans;
import com.top.common.constant.UserConstants;
import com.top.common.exception.file.InvalidExtensionException;
import com.top.common.utils.StringUtils;
import com.top.common.utils.file.FileUploadUtils;
import com.top.common.utils.file.MimeTypeUtils;
import com.top.framework.config.TopConfig;
import com.top.project.product.domain.Product;
import com.top.project.product.mapper.ProductMapper;
import com.top.project.system.domain.SysConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public int insertProduct(Product product, MultipartFile[] files) throws Exception {
        product.setProductImg(getImgPath(files));
        return productMapper.insertProduct(product);
    }

    private String getImgPath(MultipartFile[] files) throws IOException, InvalidExtensionException {
        if (StringUtils.isNotEmpty(files)) {
            StringBuffer sb = new StringBuffer();
            for (MultipartFile file : files) {
                String upload = FileUploadUtils.upload(TopConfig.getUploadPath(), file, MimeTypeUtils.IMAGE_EXTENSION);
                sb.append(upload).append(";");
            }
            return sb.substring(0, sb.length() - 1);
        }
        return "";
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
    public int updateProduct(Product product, MultipartFile[] files) throws Exception {
        product.setProductImg(getImgPath(files));
        return productMapper.updateProduct(product);
    }

    @Override
    public int deleteProductByIds(String[] ids) {
        return productMapper.deleteProductByIds(ids);
    }
}
