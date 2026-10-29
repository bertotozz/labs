import java.util.List;

public class MergeSort implements Sorting<Integer> {

  @Override
  public void sort(List<Integer> nums) {
    slice(nums, 0, nums.size() - 1);
  }

  private void slice(List<Integer> nums, int start, int end) {
    if (start >= end) {
      return;
    }
    int middle = (start + end) / 2;
    slice(nums, start, middle);
    slice(nums, middle + 1, end);
    merge(nums, start, middle, end);
  }

  private void merge(List<Integer> nums, int start, int middle, int end) {
  }
}
