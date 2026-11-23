import java.util.List;

public class CountingSort implements Sorting<Integer> {

  private static final int MAX_VALUE = 127;

  @Override
  public void sort(List<Integer> nums) {
    int[] counts = new int[MAX_VALUE + 1];
    for (int num : nums) {
      counts[num]++;
    }
  }
}
