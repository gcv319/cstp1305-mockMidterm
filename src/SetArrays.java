
public class SetArrays<T> implements SetInterface<T> {
  T[] arr;
  int numberOfElements;
  int MAX_SIZE;

  @SuppressWarnings("unchecked")
  public SetArrays() {
    numberOfElements = 0;
    MAX_SIZE = 1;
    arr = (T[]) new Object[MAX_SIZE];
  }

  @SuppressWarnings("unchecked")
  private void grow() {
    T[] tmp = arr;
    MAX_SIZE *= 2;
    arr = (T[]) new Object[MAX_SIZE];

    for (int i = 0; i < tmp.length; i++) {
      arr[i] = tmp[i];
    }
  }

  @Override
  public void add(T newEntry) {
    if (numberOfElements / MAX_SIZE >= 0.8 && !contains(newEntry)) {
      grow();
      arr[numberOfElements++] = newEntry;
    } else if (!contains(newEntry)) {
      arr[numberOfElements++] = newEntry;
    }
  }

  @Override
  public void remove(T anEntry) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == anEntry) {
        for (int j = i; j < arr.length; j++) {
          if (j + 1 < arr.length) {
            arr[j] = arr[j + 1];
          }
        }
        numberOfElements--;
      }
    }
  }

  @Override
  public boolean contains(T anEntry) {
    for (T element : arr) {
      if (element == anEntry)
        return true;
    }
    return false;
  }

  @SuppressWarnings("unchecked")
  @Override
  public T[] toArray() {
    T[] tmp = (T[]) new Object[numberOfElements];

    for (int i = 0; i < tmp.length; i++) {
      tmp[i] = arr[i];
    }

    return tmp;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void clear() {
    numberOfElements = 0;
    MAX_SIZE = 1;
    arr = (T[]) new Object[MAX_SIZE];
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
    SetArrays<Integer> set = new SetArrays<>();

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
   
    SetArrays<Integer> set2 = new SetArrays<>();

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
    for (Object element: SetUtil.difference(set, set2).toArray()) {
      System.out.print(element.toString() + " ");
    }

  }

}
