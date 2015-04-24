


/**
 * @constructor
 *
 * @param {!*=} opt_value
 */
var List = function(opt_value) {

  /**
   * @type {*}
   */
  this.head = opt_value !== undefined ? opt_value : null;

  /**
   * @type {?List}
   */
  this.tail = null;
};


/**
 * @param {...*} var_args
 * @return {!List}
 */
List.build = function(var_args) {
  var cursor = List.EMPTY;
  for (var i = arguments.length - 1, l = 0; i >= l; i -= 1) {
    var list = new List(arguments[i]);
    cursor = list.setTail(cursor);
  }
  return cursor;
};


/**
 * @type {!List}
 */
List.EMPTY = new List();


/**
 * @param {number=} opt_accum
 * @return {number}
 */
List.prototype.size = function(opt_accum) {
  var accum = opt_accum || 0;
  if (this.isLast()) {
    return this.isEmpty() ? accum : accum + 1;
  } else {
    return this.tail.size(accum + 1);
  }
};


/**
 * @return {boolean}
 */
List.prototype.isEmpty = function() {
  return this.head === null;
};


/**
 * @return {boolean}
 */
List.prototype.isLast = function() {
  return this.tail === null || this.tail.isEmpty();
};


/**
 * @param {List} list
 * @return {boolean}
 */
List.prototype.equals = function(list) {
  if (list !== null) {
    var oneListEmpty = list.isEmpty() ^ this.isEmpty();
    var oneListFinished = list.isLast() ^ this.isLast();

    if (!oneListEmpty && !oneListFinished) {
      if (list.head === this.head) {
        if (list.isLast() && this.isLast) {
          return true;
        } else {
          return this.tail.equals(list.tail);
        }
      }
    }
  }

  return false;
};


/**
 * @param {!function(!*): *} mapFunction
 * @return {!List}
 */
List.prototype.map = function(mapFunction) {
  var mapped = [];
  this.forEach(function(elem) {
    var value = mapFunction(elem);
    if (value !== null) {
      mapped.push(value);
    }
  });

  return List.build.apply(null, mapped);
};


/**
 * @param {!function(!*)} forFunction
 */
List.prototype.forEach = function(forFunction) {
  if (!this.isEmpty()) {
    forFunction(this.head);
    if (!this.isLast()) {
      this.tail.forEach(forFunction);
    }
  }
};


/**
 * @param {!function(!*): boolean} filterFunction
 * @return {!List}
 */
List.prototype.filter = function(filterFunction) {
  return this.map(function(elem) {
    return filterFunction(elem) ? elem : null;
  });
};


/**
 * @param {!List} list
 * @return {!List}
 */
List.prototype.setTail = function(list) {
  if (this.isEmpty()) {
    return list;
  } else {
    this.tail = list;
    return this;
  }
};


/**
 * @param {!*} value
 * @return {!List}
 */
List.prototype.setTailValue = function(value) {
  return this.setTail(new List(value));
};
