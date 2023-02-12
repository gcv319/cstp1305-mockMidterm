
public class SetCircularLinkedList<T> implements SetInterface<T> {

  static class Node<T> {
    T data;
    Node<T> next;

    public Node() {
      data = null;
      next = null;
    }
  }

  Node<T> head;
  int numberOfElements;

  public SetCircularLinkedList() {
    head = null;
    numberOfElements = 0;
  }

  @Override
  public void add(T newEntry) {
    Node<T> newNode = new Node<>();
    newNode.data = newEntry;

    if (head == null) {
      head = newNode;
      head.next = head;
      numberOfElements++;
      return;
    }

    Node<T> tmp = head;

    while (tmp.next != head) {
      tmp = tmp.next;
    }

    if (!contains(newEntry)) {
      tmp.next = newNode;
      tmp.next.next = head;
      numberOfElements++;
    }
  }

  @Override
  public void remove(T anEntry) {
    if (head.data == anEntry && head.next == head) {
      head = null;
      numberOfElements--;
    }

    Node<T> tmp = head;

    while (tmp.next != head) {
      if (tmp.next.data == anEntry) {
        tmp.next = tmp.next.next;
        numberOfElements--;
        return;
      }
      tmp = tmp.next;
    }

  }

  @Override
  public boolean contains(T anEntry) {
    if (head.data == anEntry)
      return true;

    Node<T> tmp = head;

    while (tmp.next != head) {
      if (tmp.next.data == anEntry)
        return true;
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
    numberOfElements = 0;
    head = null;
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
    SetCircularLinkedList<Integer> set = new SetCircularLinkedList<>();

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

    SetCircularLinkedList<Integer> set2 = new SetCircularLinkedList<>();

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
