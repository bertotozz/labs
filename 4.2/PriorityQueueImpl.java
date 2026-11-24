import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriorityQueueImpl implements PriorityQueue<Integer> {

  private final List<HeapEntry> heap = new ArrayList<>();
  private final Map<Long, Integer> positions = new HashMap<>();
  private long operationCount = 0;

  @Override
  public void enqueue(Integer value) {
    operationCount++;
    heap.add(new HeapEntry(operationCount, value));
    positions.put(operationCount, heap.size() - 1);
    siftUp(heap.size() - 1);
  }

  @Override
  public Integer dequeueMax() {
    if (heap.isEmpty()) {
      return null;
    }
    HeapEntry max = heap.get(0);
    swap(0, heap.size() - 1);
    heap.remove(heap.size() - 1);
    positions.remove(max.operation);
    siftDown(0);
    return max.value;
  }

  @Override
  public void increment(long operation, Integer addition) {
    Integer index = positions.get(operation);
    if (index == null) {
      return;
    }
    heap.get(index).value += addition;
    siftUp(index);
    siftDown(index);
  }

  public boolean isEmpty() {
    return heap.isEmpty();
  }

  public long getMaxOperation() {
    return heap.get(0).operation;
  }

  private void siftUp(int index) {
    while (index > 0) {
      int parent = (index - 1) / 2;
      if (heap.get(parent).value >= heap.get(index).value) {
        return;
      }
      swap(parent, index);
      index = parent;
    }
  }

  private void siftDown(int index) {
    while (true) {
      int largest = index;
      int left = 2 * index + 1;
      int right = 2 * index + 2;
      if (left < heap.size() && heap.get(left).value > heap.get(largest).value) {
        largest = left;
      }
      if (right < heap.size() && heap.get(right).value > heap.get(largest).value) {
        largest = right;
      }
      if (largest == index) {
        return;
      }
      swap(index, largest);
      index = largest;
    }
  }

  private void swap(int first, int second) {
    HeapEntry temp = heap.get(first);
    heap.set(first, heap.get(second));
    heap.set(second, temp);
    positions.put(heap.get(first).operation, first);
    positions.put(heap.get(second).operation, second);
  }
}
