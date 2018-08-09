var tokenKey = "token"

function cacheToken(tokenValue){
    localStorage.setItem(tokenKey,tokenValue);
}

function getToken(){
    localStorage.getItem(tokenKey);
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
	  }
    return Promise.reject(error);
  });