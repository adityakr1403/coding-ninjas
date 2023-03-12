public class StackLL<T> {
    private Node<T> head;
    private int size;

    public StackLL() {
        head = null;
        size = 0;
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            next = null;
        }
    }

    public int getSize() {
        return size;
    }

    public T top() {
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(T element) {
        if (head == null) {
            head = new Node<>(element);
            size++;
            return;
        }
        Node<T> temp = new Node<>(element);
        temp.next = head;
        head = temp;
        size++;
    }

    public T pop() {
        if (head == null) {
            System.out.println("stack empty");
            return null;
        }
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public static void main(String[] args) {
        StackLL<Integer> stackList = new StackLL<>();
        stackList.push(98);
        stackList.push(12);
        stackList.push(70);
        stackList.push(72);
        stackList.push(14);
        int n = stackList.getSize();
        System.out.println("************   " + n + "   *****************");
        for (int i = 0; i < n; i++) {
            System.out.println(stackList.pop());
        }

    }
}
