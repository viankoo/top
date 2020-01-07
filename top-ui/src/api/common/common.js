import request from '@/utils/request'

//上传
export function uploadFile(data) {
  return request({
    url: '/common/upload',
    method: 'post',
    data: data
  })
}

//删除
export function deleteFile(data) {
  return request({
    url: '/common/delete',
    method: 'delete',
    data: data
  })
}

//下载
export function downloadFile(data) {
  return request({
    url: '/common/download',
    method: 'get',
    data: data
  })
}
