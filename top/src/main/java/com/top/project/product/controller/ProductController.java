package com.top.project.product.controller;

import com.top.common.constant.UserConstants;
import com.top.common.utils.SecurityUtils;
import com.top.framework.aspectj.lang.annotation.Log;
import com.top.framework.aspectj.lang.enums.BusinessType;
import com.top.framework.web.controller.BaseController;
import com.top.framework.web.domain.AjaxResult;
import com.top.framework.web.page.TableDataInfo;
import com.top.project.product.domain.Product;
import com.top.project.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @Log(title = "商品管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody Product product) {
        if (UserConstants.NOT_UNIQUE.equals(productService.checkProductNameUnique(product))) {
            return AjaxResult.error("新增商品'" + product.getProductName() + "'失败，商品名称已存在");
        }
        product.setCreateBy(SecurityUtils.getUsername());
        return toAjax(productService.insertProduct(product));
    }

    /**
     * 根据商品编号审核商品
     */
    @Log(title = "商品管理", businessType = BusinessType.UPDATE)
    @PutMapping("/check")
    public AjaxResult check(@Validated @RequestBody Product product) {
        product.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(productService.checkProduct(product));
    }

    /**
     * 根据商品编号上下架商品
     */
    @Log(title = "商品管理", businessType = BusinessType.UPDATE)
    @PutMapping("/onOffSell")
    public AjaxResult onOffSell(@Validated @RequestBody Product product) {
        product.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(productService.onOffSellProduct(product));
    }

    /**
     * 根据商品编号获取详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable String id) {
        return AjaxResult.success(productService.selectProductById(id));
    }

    /**
     * 根据商品编号更新商品
     */
    @Log(title = "商品管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody Product product) {
        product.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(productService.updateProduct(product));
    }

    /**
     * 根据商品编号删除商品
     */
    @Log(title = "商品管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(productService.deleteProductByIds(ids));
    }

}
