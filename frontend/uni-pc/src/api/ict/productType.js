import request from '@/utils/request'

// 查询产品类型列表
export function listProductType(query) {
  return request({
    url: '/ict/productType/list',
    method: 'get',
    params: query
  })
}

// 查询产品类型详细
export function getProductType(typeId) {
  return request({
    url: '/ict/productType/' + typeId,
    method: 'get'
  })
}

// 新增产品类型
export function addProductType(data) {
  return request({
    url: '/ict/productType',
    method: 'post',
    data: data
  })
}

// 修改产品类型
export function updateProductType(data) {
  return request({
    url: '/ict/productType',
    method: 'put',
    data: data
  })
}

// 删除产品类型
export function delProductType(typeId) {
  return request({
    url: '/ict/productType/' + typeId,
    method: 'delete'
  })
}
