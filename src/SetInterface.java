
interface SetInterface<T> {

  public void add(T newEntry);

  public void remove(T anEntry);

  public boolean contains(T anEntry);

  public T[] toArray();

  public void clear();

  public int getSize();

  public boolean isEmpty();
}