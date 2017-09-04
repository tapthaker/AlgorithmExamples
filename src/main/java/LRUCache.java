import java.util.HashMap;

public class LRUCache {

    class Node {
        int key;
        int value;
        Node previousNode = null;
        Node nextNode = null;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        void reset() {
            previousNode = null;
            nextNode = null;
        }
    }

    private int cacheSize = 10;
    private Node head = null;
    private Node tail = null;
    private HashMap<Integer, Node> hashMap = new HashMap<Integer, Node>();

    void set(int key, int value) {
        if (hashMap.containsKey(key)) {
            Node node = hashMap.get(key);
            remove(node);
            node.value = value;
            setHead(node);
        } else {
            Node node = new Node(key, value);
            setHead(node);
            if (hashMap.size() >= cacheSize) {
                hashMap.remove(tail.key);
                remove(tail);
            }
            hashMap.put(key, node);
        }
    }

    private void remove(Node node) {

        if (node == head) {
            if (node.nextNode != null) {
                node.nextNode.previousNode = null;
                head = node.nextNode;
            }
            node.reset();
            return;
        }

        if (node == tail) {
            node.previousNode.nextNode = null;
            tail = node.previousNode;
            node.reset();
            return;
        }
        if (node.previousNode != null) {
            node.previousNode.nextNode = node.nextNode;
        }
        if (node.nextNode != null) {
            node.nextNode.previousNode = node.previousNode;
        }
        node.reset();
    }

    private void setHead(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            head.previousNode = node;
            node.nextNode = head;
            head = node;
        }
    }

    Node get(int key) {
        Node node = hashMap.get(key);
        if (node == null) {
            return null;
        }
        remove(node);
        setHead(node);
        return node;
    }

    String getStringFromHEAD() {
        String string = new String();
        Node node = head;
        do {
            string = string + node.key + ":" + node.value + "=>";
            node = node.nextNode;
        } while (node != null);

        return string;
    }

    String getStringFromTAIL() {
        String string = new String();
        Node node = tail;
        do {
            string = node.key + ":" + node.value + "=>" + string;
            node = node.previousNode;
        } while (node != null);

        return string;
    }
}
