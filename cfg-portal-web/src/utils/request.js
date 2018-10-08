import axios from 'axios'
import router from '../router/index'
import {
  tokenKey,
  getToken
} from './common'

const axiosCli = axios.create({
  baseURL: process.env.BASE_API, // api的base_url
  timeout: 60000, // 请求超时时间
  //withCredentials: true // 跨域使用凭证
})

axiosCli.interceptors.request.use(function (config) {
  if (getToken()) {
    // 让每个请求携带自定义token
    config.headers[tokenKey] = getToken() 
  }
  return config;
}, function (error) {
  return Promise.reject(error);
});

axiosCli.interceptors.response.use(function (response) {
  return response;
}, function (error) {
  if (error.response && error.response.status == 401) {
    router.replace({
      name: 'login'
    })
  }
  return Promise.reject(error);
});

export default axiosCli
