export var tokenKey = 'cfg-token'

export function setToken(tokenValue) {
  localStorage.setItem(tokenKey, tokenValue);
}

export function getToken() {
  return localStorage.getItem(tokenKey);
}

export function getUrlKey(name) {
  return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.href) || [, ""])[1].replace(/\+/g, '%20')) || null
}