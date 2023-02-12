
public class SetDoublyLinkedList<T> implements SetInterface<T> {

  static class Node<T> {
    T data;
    Node<T> next;
    Node<T> prev;

    public Node() {
      data = null;
      next = null;
      prev = null;
    }
  }

  Node<T> head;
  int numberOfElements;

  public SetDoublyLinkedList() {
    head = null;
    numberOfElements = 0;
  }

  private Node<T> getNode(T anEntry) {
    Node<T> nodePos = new Node<>();
    Node<T> tmp = head;

    while (tmp != null) {
      if (tmp.data == anEntry) {
        nodePos = tmp;
        break;
      }
      tmp = tmp.next;
    }

    return nodePos;
  }

  @Override
  public void add(T newEntry) {
    Node<T> newNode = new Node<>();
    newNode.data = newEntry;
    newNode.next = null;

    Node<T> tmp = head;

    if (head == null) {
      newNode.prev = null;
      head = newNode;
      numberOfElements++;
      return;
    }

    if (contains(newEntry)) return;

    while (tmp.next != null) {
      tmp = tmp.next;
    }

    tmp.next = newNode;
    newNode.prev = tmp;
    numberOfElements++;
  }

  @Override
  public void remove(T anEntry) {
    Node<T> delNode = getNode(anEntry);

    if (head == delNode) {
      head = delNode.next;
    }

    if (delNode.next != null) {
      delNode.next.prev = delNode.prev;
    }

    if (delNode.prev != null) {
      delNode.prev.next = delNode.next;
    }

    numberOfElements--;
    return;
  }

  @Override
  public boolean contains(T anEntry) {
    Node<T> tmp = head;

    while (tmp != null) {
      if (tmp.data == anEntry) return true;
      tmp = tmp.next;
    }
    return false;
  }

  @SuppressWarnings("unchecked")
  @Override
  public T[] toArray() {
    T[] arr = (T[]) new Object[numberOfElements];
    Node<T> tmp = head;

    for (int i = 0; i < arr.length; i++) {
      arr[i] = tmp.data;
      tmp = tmp.next;
    }

    return arr;
  }

  @Override
  public void clear() {
    head = null;
    numberOfElements = 0;
  }

  @Override
  public int getSize() {
    return numberOfElements;
  }

  @Override
  public boolean isEmpty() {
    return numberOfElements == 0;
  }

  public static void main(String[] args) {
    SetDoublyLinkedList<Integer> set = new SetDoublyLinkedList<>();

    System.out.println("set empty or not: " + set.isEmpty());

    set.add(1);
    set.add(1);
    set.add(2);
    set.add(3);

    System.out.println("set empty or not: " + set.isEmpty());
    System.out.println("number of elements: " + set.getSize());

    set.remove(3);

    System.out.println("number of elements: " + set.getSize());
    System.out.println("contains 3: " + set.contains(3));
    System.out.println("contains 1: " + set.contains(1));

    System.out.print("elements in set: ");
    for (Object element : set.toArray()) {
      System.out.print(element + " ");
    }
    System.out.println();
    set.clear();
    System.out.print("elements in set: ");
    for (Object element : set.toArray()) {
      System.out.print(element + " ");
    }
    System.out.println();

    set.add(1);
    set.add(2);
    set.add(3);
    set.add(4);
    set.add(5);

    SetDoublyLinkedList<Integer> set2 = new SetDoublyLinkedList<>();

    set2.add(1);
    set2.add(6);
    set2.add(10);

    System.out.print("union between set A and B: ");
    for (Object element : SetUtil.union(set, set2).toArray()) {
      System.out.print(element.toString() + " ");
    }
    System.out.println();
    System.out.print("intersect between set A and B: ");
    for (Object element : SetUtil.intersect(set, set2).toArray()) {
      System.out.print(element.toString() + " ");
    }
    System.out.println();
    System.out.print("difference between set A and B: ");
    for (Object element : SetUtil.difference(set, set2).toArray()) {
      System.out.print(element.toString() + " ");
    }

  }
}
