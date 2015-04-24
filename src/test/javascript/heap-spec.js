

describe('Heap', function() {
  function checkHeap(heap, array) {
    while (array.length > 0) {
      var min = Math.min.apply(null, array);
      expect(heap.extract()).to.be.equal(min);

      var index = array.indexOf(min);
      array.splice(index, 1);
    }
  }

  function randomArray(lenth) {
    var array = new Array(lenth);
    for (var i = 0, l = lenth; i < l; i += 1) {
      array[i] = Math.round(Math.random() * 100);
    }

    return array;
  }

  it('Insert / Extract / Delete', function() {
    var heap = new Heap();
    var LENGTH = 120;
    var array = randomArray(LENGTH);
    for (var i = 0, l = LENGTH; i < l; i += 1) {
      heap.insert(array[i]);
    }

    var value = Math.round(Math.random() * 100);
    var indexD = heap.insert(value);
    heap.delete(indexD);

    checkHeap(heap, array);
  });

  it('Heapify', function() {
    var array = randomArray(1000);
    var heap = new Heap(array);

    checkHeap(heap, array);
  });

  it('Extract before insert', function() {
    var heap = new Heap();
    expect(heap.extract()).to.be.null;
  });
});
