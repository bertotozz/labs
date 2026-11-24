import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RadixSort implements Sorting<BigInteger> {

  private static final int DIGITS = 20;
  private static final int BASE = 10;

  @Override
  public void sort(List<BigInteger> nums) {
    BigInteger base = BigInteger.valueOf(BASE);
    BigInteger divider = BigInteger.ONE;
    for (int position = 0; position < DIGITS; position++) {
      List<List<BigInteger>> buckets = createBuckets();
      for (BigInteger num : nums) {
        int digit = num.divide(divider).mod(base).intValue();
        buckets.get(digit).add(num);
      }
      collect(nums, buckets);
      divider = divider.multiply(base);
    }
  }

  private List<List<BigInteger>> createBuckets() {
    List<List<BigInteger>> buckets = new ArrayList<>();
    for (int digit = 0; digit < BASE; digit++) {
      buckets.add(new ArrayList<>());
    }
    return buckets;
  }

  private void collect(List<BigInteger> nums, List<List<BigInteger>> buckets) {
    int index = 0;
    for (List<BigInteger> bucket : buckets) {
      for (BigInteger num : bucket) {
        nums.set(index, num);
        index++;
      }
    }
  }
}
