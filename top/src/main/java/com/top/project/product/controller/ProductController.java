package com.top.project.product.controller;

import com.top.framework.web.controller.BaseController;
import com.top.framework.web.domain.AjaxResult;
import com.top.framework.web.page.TableDataInfo;
import com.top.project.product.domain.Product;
import com.top.project.product.service.ProductService;
import com.top.project.system.domain.SysConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: guWei
 * @Description:
 * @Date: Created in 18:56 2019/12/4
 */
@RestController
@RequestMapping("/bus/product")
public class ProductController extends BaseController{

    @Autowired
    private ProductService productService;

    /**
     * 获取商品列表
     */
    @GetMapping("/list")
    public TableDataInfo list(Product product) {
        startPage();
        List<Product> list = productService.selectProductList(product);
        return getDataTable(list);
    }

    /**
     * 新增商品
     */

    /**
     * 根据商品编号审核商品
     */

    /**
     * 根据商品编号上下架商品
     */

    /**
     * 根据商品编号获取详细信息
     */

    /**
     * 根据商品编号更新商品
     */


    /**
     * 根据商品编号删除商品
     */


}
