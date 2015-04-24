


/**
 * @constructor
 *
 * @param {!Array<number>=} opt_array
 */
var Heap = function(opt_array) {

  /**
   * @type {number}
   */
  this.__currentSize = 0;

  if (opt_array) {

    /**
     * @type {!Array.<number>}
     */
    this.__array = opt_array.slice(0);
    this.__currentSize = opt_array.length;
    this.__heapify();
  } else {
    this.__array = new Array(Heap.__DEFAULT_SIZE);
  }
};


/**
 * @type {number}
 */
Heap.__DEFAULT_SIZE = 100;


/**
 * @param {number} value
 * @return {number}
 */
Heap.prototype.insert = function(value) {
  if (this.__currentSize === this.__array.length) {
    this.__doubleArray();
  }

  var index = this.__currentSize;
  this.__array[this.__currentSize] = value;
  this.__currentSize += 1;
  return this.__bubbleUp(index);
};


/**
 * @return {?number}
 */
Heap.prototype.extract = function() {
  if (this.__currentSize === 0) {
    return null;
  } else {
    var value = this.__array[0];
    this.delete(0);
    return value;
  }
};


/**
 * @param {number} index
 */
Heap.prototype.delete = function(index) {
  if (index < this.__currentSize) {
    this.__array[index] = this.__array[this.__currentSize - 1];
    this.__currentSize -= 1;
    this.__bubbleDown(index);
    delete this.__array[this.__currentSize];
  }
};


/**
 * @return {string}
 */
Heap.prototype.toString = function() {
  return 'Heap(' + this.__array.slice(0, this.__currentSize).toString() + ')';
};


/**
 * @param {number} index
 * @return {number}
 */
Heap.prototype.__bubbleUp = function(index) {
  if (index !== 0) {
    var parentIndex = Math.floor((index - 1) / 2);
    if (this.__array[index] < this.__array[parentIndex]) {
      var swapVar = this.__array[index];
      this.__array[index] = this.__array[parentIndex];
      this.__array[parentIndex] = swapVar;
      return this.__bubbleUp(parentIndex);
    }
  }

  return index;
};


/**
 * @param {number} index
 */
Heap.prototype.__bubbleDown = function(index) {
  var child = (index * 2) + 1;
  if (child < this.__currentSize) {
    if (child + 1 < this.__currentSize &&
        this.__array[child + 1] < this.__array[child]) {
      child += 1;
    }

    if (this.__array[index] > this.__array[child]) {
      var swapVar = this.__array[index];
      this.__array[index] = this.__array[child];
      this.__array[child] = swapVar;
      this.__bubbleDown(child);
    }
  }
};


/**
 */
Heap.prototype.__doubleArray = function() {
  var array = new Array(2 * this.__array.length);
  for (var i = 0, l = this.__array.length; i < l; i += 1) {
    array[i] = this.__array[i];
  }

  this.__array = array;
};


/**
 */
Heap.prototype.__heapify = function() {
  if (this.__currentSize > 1) {
    var levels = 1;
    var size = this.__currentSize;
    while (size !== 1) {
      size = size >> 1;
      levels += 1;
    }

    for (var i = levels - 1; i >= 0; i -= 1) {
      var levelSize = Math.pow(2, i);
      var levelStart = levelSize - 1;

      for (var j = levelStart; j < levelStart + levelSize; j += 1) {
        this.__bubbleDown(j);
      }
    }
  }
};
