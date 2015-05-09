
import edu.eudgee.algorithms.bits.InsertBits

InsertBits.binLength(0)
InsertBits.binLength(4)
InsertBits.binLength(-3)

InsertBits.get1s(3).toBinaryString

var mask = -1
mask.toBinaryString
mask = mask ^ InsertBits.get1s(4)
mask.toBinaryString
mask = mask | InsertBits.get1s(2)
mask.toBinaryString

1023.toBinaryString
8.toBinaryString
InsertBits.insert(1023, 8, 5).toBinaryString
