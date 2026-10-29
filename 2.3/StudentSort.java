import java.util.List;

public class StudentSort implements Sorting<Student> {

  @Override
  public void sort(List<Student> students) {
    quickSortByName(students, 0, students.size() - 1);
  }

  private void quickSortByName(List<Student> students, int start, int end) {
    if (start >= end) {
      return;
    }
    String pivot = students.get((start + end) / 2).getName();
    int left = start;
    int right = end;
    while (left <= right) {
      while (students.get(left).getName().compareTo(pivot) < 0) {
        left++;
      }
      while (students.get(right).getName().compareTo(pivot) > 0) {
        right--;
      }
      if (left <= right) {
        swap(students, left, right);
        left++;
        right--;
      }
    }
    quickSortByName(students, start, right);
    quickSortByName(students, left, end);
  }

  private void swap(List<Student> students, int first, int second) {
    Student temp = students.get(first);
    students.set(first, students.get(second));
    students.set(second, temp);
  }
}
