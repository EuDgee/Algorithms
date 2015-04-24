


/**
 * @constructor
 *
 * @param {number=} opt_size
 */
var HashTable = function(opt_size) {
  this.__size = opt_size || HashTable.DEFAULT_SIZE;

  /**
   * @type {!Array}
   */
  this.__table = new Array(this.__size);
};


/**
 * @type {number}
 */
HashTable.DEFAULT_SIZE = 1000;


/**
 * @param {string} key
 * @param {*} value
 */
HashTable.prototype.put = function(key, value) {
  var index = this.__calculateHash(key);
  this.__table[index] = value;
};


/**
 * @param {string} key
 * @return {*}
 */
HashTable.prototype.get = function(key) {
  return this.__table[this.__calculateHash(key)];
};


/**
 * @param {string} key
 * @return {number}
 */
HashTable.prototype.__calculateHash = function(key) {
  var hash = 0;
  if (key.length === 0) {
    return hash;
  }

  for (var i = 0, l = this.length; i < l; i++) {
    var char = key.charCodeAt(i);
    hash = hash * 31 + char;
    hash |= 0;
  }

  return hash % this.__size;
};
