public class LinkedListClass {
    private static class Node<T> {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node<Integer> node1 = new Node<>(10);
        System.out.println(node1.data);
        System.out.println(node1.next);
        Node<Integer> node2 = new Node<>(12);
    }
}
