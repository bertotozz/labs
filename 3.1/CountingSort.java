import java.util.List;

public class CountingSort implements Sorting<Integer> {

  private static final int MAX_VALUE = 127;

  @Override
  public void sort(List<Integer> nums) {
    int[] counts = new int[MAX_VALUE + 1];
    for (int num : nums) {
      counts[num]++;
    }
    int index = 0;
    for (int value = 0; value <= MAX_VALUE; value++) {
      for (int k = 0; k < counts[value]; k++) {
        nums.set(index, value);
        index++;
      }
    }
  }
}
