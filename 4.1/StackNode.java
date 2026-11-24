public class StackNode {

  final int value;
  final int min;
  final StackNode next;

  StackNode(int value, int min, StackNode next) {
    this.value = value;
    this.min = min;
    this.next = next;
  }
}
