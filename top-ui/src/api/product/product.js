import request from '@/utils/request'

// 查询参数列表
export function listProduct(query) {
  return request({
    url: '/bus/product/list',
    method: 'get',
    params: query
  })
}

// 查询参数详细
export function getProduct(productId) {
  return request({
    url: '/bus/product/' + productId,
    method: 'get'
  })
}

// // 根据参数键名查询参数值
// export function getConfigKey(configKey) {
//   return request({
//     url: '/bus/product/configKey/' + configKey,
//     method: 'get'
//   })
// }

// 新增参数配置
export function addProduct(data) {
  return request({
    url: '/bus/product',
    method: 'post',
    data: data
  })
}

// 修改参数配置
export function updateProduct(data) {
  return request({
    url: '/bus/product',
    method: 'put',
    data: data
  })
}

// 删除参数配置
export function delProduct(productId) {
  return request({
    url: '/bus/product/' + productId,
    method: 'delete'
  })
}

// 导出参数
export function exportProduct(query) {
  return request({
    url: '/bus/product/export',
    method: 'get',
    params: query
  })
}