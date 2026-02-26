import java.math.BigInteger;

class Solution {
    public int numSteps(String s) {
        BigInteger val = new BigInteger(s, 2);
        int count = 0;

        while (!val.equals(BigInteger.ONE)) {
            if (val.testBit(0)) { // odd number check
                val = val.add(BigInteger.ONE);
            } else {
                val = val.shiftRight(1); // divide by 2
            }
            count++;
        }

        return count;
    }
}
