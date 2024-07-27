import request from '@/utils/request'

// 查询课程列表
export function listCourseinfo(query) {
  return request({
    url: '/courseinfo/courseinfo/list',
    method: 'get',
    params: query
  })
}

// 查询课程详细
export function getCourseinfo(id) {
  return request({
    url: '/courseinfo/courseinfo/' + id,
    method: 'get'
  })
}

// 新增课程
export function addCourseinfo(data) {
  return request({
    url: '/courseinfo/courseinfo',
    method: 'post',
    data: data
  })
}

// 修改课程
export function updateCourseinfo(data) {
  return request({
    url: '/courseinfo/courseinfo',
    method: 'put',
    data: data
  })
}

// 删除课程
export function delCourseinfo(id) {
  return request({
    url: '/courseinfo/courseinfo/' + id,
    method: 'delete'
  })
}
