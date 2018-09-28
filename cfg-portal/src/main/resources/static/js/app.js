var tokenKey = "token"

function cacheToken(tokenValue){
    localStorage.setItem(tokenKey,tokenValue);
}

function getToken(){
    localStorage.getItem(tokenKey);
}

function getUrlKey(name) {
    return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.href) || [, ""])[1].replace(/\+/g, '%20')) || null
}

axios.interceptors.request.use(function (config) {
	config.headers["req-source"] = "axios"
    return config;
  }, function (error) {
    return Promise.reject(error);
  });

axios.interceptors.response.use(function (response) {
    return response;
  }, function (error) {
	  if(error.response.status == 401){
		  window.location.href = "/page/login.html"
      }else{
          alert('未知异常')
      }
    return Promise.reject(error);
  });