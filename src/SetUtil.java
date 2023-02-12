public class SetUtil {
  static <T> SetInterface union(SetInterface<T> A, SetInterface<T> B) {
    SetInterface<T> tmp = new SetArrays<>();
    T[] aArray = A.toArray();
    T[] bArray = B.toArray();

    for (int i = 0; i < aArray.length; i++) {
      tmp.add(aArray[i]);
    }

    for (int i = 0; i < bArray.length; i++) {
      if (!tmp.contains(bArray[i]))
        tmp.add(bArray[i]);
    }

    return tmp;
  }

  static <T> SetInterface intersect(SetInterface<T> A, SetInterface<T> B) {
    SetInterface<T> tmp = new SetArrays<>();
    T[] aArray = A.toArray();
    T[] bArray = B.toArray();

    if (aArray.length > bArray.length) {
      for (int i = 0; i < bArray.length; i++) {
        if (A.contains(bArray[i]))
          tmp.add(bArray[i]);
      }
    } else {
      for (int i = 0; i < aArray.length; i++) {
        if (B.contains(aArray[i]))
          tmp.add(aArray[i]);
      }
    }

    return tmp;
  }

  static <T> SetInterface difference(SetInterface<T> A, SetInterface<T> B) {
    SetInterface<T> tmp = new SetArrays<>();
    T[] aArray = A.toArray();

    for (int i = 0; i < aArray.length; i++) {
      if (!B.contains(aArray[i]))
        tmp.add(aArray[i]);
    }

    return tmp;
  }


}
