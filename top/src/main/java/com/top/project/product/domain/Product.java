package com.top.project.product.domain;

import com.top.framework.web.domain.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: guWei
 * @Description:
 * @Date: Created in 15:54 2019/12/4
 */
@Data
public class Product extends BaseEntity {


    /**
     * 商品编号
     */
    private String productId;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品图片路径
     */
    private String productImg;
    /**
     * 商品描述
     */
    private String description;
    /**
     * 商品价格
     */
    private BigDecimal price;
    /**
     * 库存数量
     */
    private Integer amount;
    /**
     * 商品状态
     * 1-待审核；2-审核不通过；3-审核通过并上架；4-下架
     */
    private String status;
    /**
     * 已售数量
     */
    private Integer sellAmount;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新者
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 备注
     */
    private String remark;


}
