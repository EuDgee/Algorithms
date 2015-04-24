

describe('List', function() {
  it('Basic structure', function() {
    var list = new List('a').setTailValue('b');

    expect(list.head).to.be.equal('a');
    expect(list.tail.head).to.be.equal('b');
    expect(list.tail.isLast()).to.be.true;
  });

  it('Fabric helper', function() {
    var list = List.build('a', 'b', 'c', 'd', 'e');
    expect(list.head).to.be.equal('a');
    expect(list.tail.head).to.be.equal('b');
    expect(list.tail.tail.head).to.be.equal('c');
    expect(list.tail.tail.tail.head).to.be.equal('d');
    expect(list.tail.tail.tail.tail.head).to.be.equal('e');
    expect(list.tail.tail.tail.tail.isLast()).to.be.true;
  });

  it('Size', function() {
    var list1 = List.build(0);
    expect(list1.size()).to.be.equal(1);

    var list5 = List.build(1, 2, 3, 4, 5);
    expect(list5.size()).to.be.equal(5);

    var listQ = new List('');
    expect(listQ.size()).to.be.equal(1);

    var list0 = List.build();
    expect(list0.size()).to.be.equal(0);

    expect(list0.setTailValue('').size()).to.be.equal(1);
  });

  it('Equals', function() {
    var list1 = List.build(0, 1, 2, 3, 4, 5);
    var list2 = List.build(0, 1, 2, 3, 4, 5);
    var list3 = List.build(0, 1, 2, 3, 4);
    var list4 = List.build(0, 1, 2, 3, 4, 5, 6);
    var list5 = List.build(0, 2, 1, 3, 5, 4);

    expect(list1.equals(list2)).to.be.true;
    expect(list2.equals(list1)).to.be.true;

    expect(list1.equals(list3)).to.be.false;
    expect(list1.equals(list4)).to.be.false;
    expect(list1.equals(list5)).to.be.false;

    expect(list2.equals(list4)).to.be.false;
    expect(list4.equals(list2)).to.be.false;
  });

  it('Map list', function() {
    var list = List.build(0, 1, 2, 3, 4);

    var listPlus = List.build(1, 2, 3, 4, 5);
    var mapped = list.map(function(elem) {
      return elem + 1;
    });
    expect(mapped.equals(listPlus)).to.be.true;

    var listWo3 = List.build(1, 2, 3, 5);
    var mappedWithNull = list.map(function(elem) {
      return elem === 3 ? null : elem + 1;
    });
    expect(mappedWithNull.equals(listWo3)).to.be.true;
  });

  it('Filter list', function() {
    var list = List.build(0, 1, 2, 3, 4, 5);

    var listBelow3 = List.build(0, 1, 2);
    var listFiltered3 = list.filter(function(elem) {
      return elem < 3;
    });
    expect(listFiltered3.equals(listBelow3)).to.be.true;

    var listEmpty = new List(null);
    var filteredEmpty = list.filter(function(elem) {
      return false;
    });
    expect(filteredEmpty.equals(listEmpty)).to.be.true;
  });

  it('Traverse list/forEach', function() {
    var list = List.build(0, 1, 2);
    var array = [];
    list.forEach(function(elem) {
      array.push(elem);
    });

    expect(array).to.be.deep.equal([0, 1, 2]);
  });
});
