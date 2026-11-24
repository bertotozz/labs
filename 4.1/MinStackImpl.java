public class MinStackImpl implements MinStack<Integer> {

  private StackNode head;

  @Override
  public void push(Integer value) {
    int min = value;
    if (head != null && head.min < value) {
      min = head.min;
    }
    head = new StackNode(value, min, head);
  }

  @Override
  public Integer pop() {
    int value = head.value;
    head = head.next;
    return value;
  }

  @Override
  public Integer top() {
    return head.value;
  }

  @Override
  public Integer min() {
    return head.min;
  }
}
