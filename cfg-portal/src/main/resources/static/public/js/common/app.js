var tokenKey = "token"

function cacheToken(tokenValue){
    localStorage.setItem(tokenKey,tokenValue);
}

function getToken(){
    localStorage.getItem(tokenKey);
}