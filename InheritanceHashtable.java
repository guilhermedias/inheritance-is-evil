import java.util.Map;
import java.util.HashMap;
import java.util.Hashtable;

public class InheritanceHashtable<K, V> extends Hashtable<K, V> {
  private int counter;

  public InheritanceHashtable() {
    super();
    counter = 0;
  }

  @Override
    public V put(K key, V value) {
      counter++;
      return super.put(key, value);
    }

  @Override
    public void putAll(Map<? extends K, ? extends V> t) {
      counter += t.size();
      super.putAll(t);
    }

  public int getCount() {
    return counter;
  }

  public static void main(String [] args) {
    HashMap<String, Integer> hashMap = new HashMap<>();
    hashMap.put("A", 1);
    hashMap.put("B", 2);

    InheritanceHashtable<String, Integer> instrumentedHashtable = new InheritanceHashtable<String, Integer>();
    instrumentedHashtable.putAll(hashMap);
    instrumentedHashtable.put("C", 3);
    instrumentedHashtable.put("D", 4);

    System.out.println(instrumentedHashtable.getCount());
  }
}
