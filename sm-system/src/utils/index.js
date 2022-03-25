export function isStringEmpty(string) {
  return string === undefined || string === null || string.trim().length === 0;
}

export function isArrayEmpty(array) {
  return array === undefined || array === null || array.length === 0;
}
