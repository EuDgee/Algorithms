

describe('Hash Table', function() {
  it('put/get', function() {
    var hTable = new HashTable();
    hTable.put('string', 123);
    expect(hTable.get('string')).to.be.equal(123);
  });
});
