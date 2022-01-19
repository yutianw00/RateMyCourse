import axios from 'axios'

// axios.defaults.baseURL = 'http://localhost:8888/admin'
// axios.defaults.timeout = 5000 // 超时时间设置
// axios.defaults.withCredentials = true // true允许跨域
// axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'

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

    // let a = 1 + 1
    // if (a === 2) {
    //   resolve('succeed.')
    // } else {
    //   // eslint-disable-next-line prefer-promise-reject-errors
    //   reject('failed.')
    // }
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
