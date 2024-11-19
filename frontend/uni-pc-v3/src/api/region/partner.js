import request from '@/utils/request'

// 查询合作商管理列表
export function listPartner(query) {
  return request({
    url: '/region/partner/list',
    method: 'get',
    params: query
  })
}

// 查询合作商管理详细
export function getPartner(id) {
  return request({
    url: '/region/partner/' + id,
    method: 'get'
  })
}

// 新增合作商管理
export function addPartner(data) {
  return request({
    url: '/region/partner',
    method: 'post',
    data: data
  })
}

// 修改合作商管理
export function updatePartner(data) {
  return request({
    url: '/region/partner',
    method: 'put',
    data: data
  })
}

// 删除合作商管理
export function delPartner(id) {
  return request({
    url: '/region/partner/' + id,
    method: 'delete'
  })
}


// 删除合作商管理
export function resetPartnerPwd(id) {
  return request({
    url: '/region/partner/resetPwd/' + id,
    method: 'put'
  })
}