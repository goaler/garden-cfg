var tokenKey = 'token'

function cacheToken(tokenValue) {
  localStorage.setItem(tokenKey, tokenValue);
}

function getToken() {
  localStorage.getItem(tokenKey);
}

function getUrlKey(name) {
  return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.href) || [, ""])[1].replace(/\+/g, '%20')) || null
}


import axios from 'axios'
import router from '../router/index'

const axiosCli = axios.create({
  baseURL: process.env.BASE_API, // api的base_url
  timeout: 60000, // 请求超时时间
  withCredentials: true // 跨域使用凭证
})

axiosCli.interceptors.request.use(function (config) {
  // config.headers['req-source'] = "axios"
  return config;
}, function (error) {
  return Promise.reject(error);
});

axiosCli.interceptors.response.use(function (response) {
  
  return response;
}, function (error) {
  if (error.response && error.response.status == 401) {
    router.replace({
      name: 'Login',
      param: {redirect: router.currentRoute.fullPath}
    })

  }
  return Promise.reject(error);
});

export default axiosCli
