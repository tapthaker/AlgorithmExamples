/**
 * Created by Tapan on 9/2/2017.
 */

public class LinkedListSum {

    class Node {
        int value;
        Node nextNode;

        public Node(int value, Node nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }

        void print() {
            Node n = this;
            while (n != null) {
                System.out.print(n.value + "=>");
                n = n.nextNode;
            }
            System.out.println();
        }

    }

    private LinkedListSum.Node convert(int [] array) {
        LinkedListSum.Node linkedNode = new LinkedListSum.Node(array[0], null);
        LinkedListSum.Node originalNode = linkedNode;
        for (int i = 1; i< array.length; i++) {
            linkedNode.nextNode = new LinkedListSum.Node(array[i], null);
            linkedNode = linkedNode.nextNode;
        }
        return originalNode;
    }

    Node calculateSum(int [] arr1, int [] arr2) {
        return calculateSum(convert(arr1), convert(arr2));
    }

    private Node calculateSum(Node list1, Node list2) {
        if (list1.nextNode!= null && list2.nextNode != null) {
            Node node = calculateSum(list1.nextNode, list2.nextNode);
            int extra = modifyAndGetExtra(node);
            return new Node(list1.value + list2.value + extra, node);
        } else {
            Node node = new Node(list1.value + list2.value, null);
            int extra = modifyAndGetExtra(node);
            if (extra != 0) {
                return new Node(extra, node);

            }
            return node;
        }
    }

    private int modifyAndGetExtra(Node node) {
        int tempValue = node.value;
        int extra = 0;
        if (tempValue >= 10) {
             node.value = tempValue % 10;
             extra = tempValue / 10;
        }
        return extra;
    }
}
