export var tokenKey = 'cfg-token'

export function setToken(tokenValue) {
  localStorage.setItem(tokenKey, tokenValue);
}

export function getToken() {
  return localStorage.getItem(tokenKey);
}

var setCookie = function (name, value, expires) {
  if(expires !== 0){     //当设置的时间等于0时，不设置expires属性，cookie在浏览器关闭后删除
    var date = new Date(+new Date()+expires);
    document.cookie = name + "=" + escape(value) + ";expires=" + expires;
  }else{
    document.cookie = name + "=" + escape(value);
  }
};

 //删除 cookie
var delCookie = function clearCookie(name) {
  setCookie(name, "", -1);
}

var getCookie = function (name) {
  var arr;
  var reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
  if (arr = document.cookie.match(reg))
    return unescape(arr[2]);
  else
    return null;
};

export function getUrlKey(name) {
  return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.href) || [, ""])[1].replace(/\+/g, '%20')) || null
}

export function dateFormat(date, pattern) {
  if (/(y+)/.test(pattern)) {
    pattern = pattern.replace(RegExp.$1, (date.getFullYear() + '').substr(4 - RegExp.$1.length))
  }
  let o = {
    'M+': date.getMonth() + 1,
    'd+': date.getDate(),
    'h+': date.getHours(),
    'm+': date.getMinutes(),
    's+': date.getSeconds()
  }
  for (let k in o) {
    if (new RegExp(`(${k})`).test(pattern)) {
      let str = o[k] + ''
      pattern = pattern.replace(RegExp.$1, RegExp.$1.length === 1 ? str : padLeftZero(str))
    }
  }
  return pattern
}
function padLeftZero(str) {
  return ('00' + str).substr(str.length)
}