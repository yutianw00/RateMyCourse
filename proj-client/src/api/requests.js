import axios from 'axios'

axios.defaults.baseURL = 'http://localhost:8888/client'
axios.defaults.timeout = 5000 // time out setting
axios.defaults.withCredentials = true // allow kuayu
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'

export function get (url, params = {}, responseType = 'json') {
  return new Promise((resolve, reject) => {
    axios.get(url, {
      params: params,
      responseType
    }).then((resp) => {
      resolve(resp.data)
    }).catch((err) => {
      reject(err)
    })
  })
}

export function post (url, data = {}) {
  return new Promise((resolve, reject) => {
    axios.post(url, data)
      .then(response => {
        resolve(response.data)
      }, err => {
        reject(err)
      })
  })
}
