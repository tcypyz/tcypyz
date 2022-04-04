import Cookies from 'js-cookie';

const TokenKey = 'Admin-Token';

export function getCookieToken() {
  return Cookies.get(TokenKey);
}

export function setCookieToken(token) {
  return Cookies.set(TokenKey, token);
}

export function removeCookieToken() {
  return Cookies.remove(TokenKey);
}
