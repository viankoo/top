####配置信息
- host: 120.27.27.183
- port: 8080
####后台用户登录
- 请求方式：POST
- URL："/login"
- 请求体：(form-data 形式)
```
"username":"", //登录账
"password":"", //密码
"code":"", //验证码
"uuid":""  //唯一标识，通过验证码返回值获得
```
####获取验证码
- 请求方式：GET
- URL："/captchaImage"
- 请求体：不带参
##商品管理
#### 添加商品
- 请求方式：POST
- URL："/bus/product"
- 请求体：(form-data 形式)
```
"productName":"", //商品名称 必填
"price":"",  //价格
"productType":'', //商品类型
"description":"", //商品描述
"detail":"", //详细信息
"amount":"",  //库存
"status":"",  //状态，1-待审核；2-审核不通过；3-审核通过并上架；4-下架
"remark":"",  //备注
"files":""  //图片
```
#### 商品分页列表
- 请求方式：GET
- URL："/bus/product/list"
- 请求体：(form-data 形式)
```
"productName":"", //商品名称
"status":"",  //状态，1-待审核；2-审核不通过；3-审核通过并上架；4-下架
"params":{ //必填
    "pageNum":1,
    "pageSize":5
}
```
#### 获取商品详情
- 请求方式：GET
- URL："/bus/product/{id}"
- 请求体：无
#### 更新商品
- 请求方式：PUT
- URL："/bus/product/list"
- 请求体：(form-data 形式)
```
"productId":"", //商品编号 必填
"productName":"", //商品名称 必填
"price":"",  //价格
"amount":"",  //库存
"status":"",  //状态，1-待审核；2-审核不通过；3-审核通过并上架；4-下架
"remark":"",  //备注
"files":""  //图片
```
#### 批量删除商品
- 请求方式：DELETE
- URL："/bus/product/{ids}"  ids:为商品id数组
- 请求体：无