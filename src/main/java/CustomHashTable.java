import java.util.ArrayList;

/**
 * Created by Tapan on 9/3/2017.
 */
public class CustomHashTable<K, V> {

    class HashNode<K, V> {
        K key;
        V value;
        HashNode<K, V> nextNode;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int numberOfBuckets = 10;
    private ArrayList<HashNode<K, V>> buckets;

    public CustomHashTable() {
        buckets = new ArrayList<HashNode<K, V>>();
        for (int i = 0; i < numberOfBuckets; i++) {
            buckets.add(null);
        }
    }

    public void set(K key, V value) {
        int hashCode = key.hashCode();
        int bucketNumber = hashCode % numberOfBuckets;
        HashNode<K, V> firstNode = buckets.get(bucketNumber);
        if (firstNode == null) {
            createNewNode(key, value, bucketNumber, firstNode);
        } else {
            HashNode<K, V> foundNode = find(key, firstNode);
            if (foundNode == null) {
                createNewNode(key, value, bucketNumber, firstNode);
            } else {
                foundNode.value = value;
            }
        }
    }

    public V get(K key) {
        int hashCode = key.hashCode();
        int bucketNumber = hashCode % numberOfBuckets;
        HashNode<K, V> firstNode = buckets.get(bucketNumber);
        HashNode<K, V> foundNode = find(key, firstNode);
        if (foundNode != null) {
            return foundNode.value;
        }
        return null;
    }

    private void createNewNode(K key, V value, int bucketNumber, HashNode<K, V> firstNode) {
        HashNode<K, V> newHashNode = new HashNode<K, V>(key, value);
        newHashNode.nextNode = firstNode;
        buckets.set(bucketNumber, newHashNode);
    }

    private HashNode<K, V> find(K key, HashNode<K, V> input) {
        for (HashNode<K, V> currentNode = input; currentNode != null; currentNode = currentNode.nextNode) {
            if (currentNode.key.hashCode() == key.hashCode()) {
                return currentNode;
            }
        }
        return null;
    }
}
