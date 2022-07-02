import java.util.PriorityQueue;

public class test {

    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        heap.add(1);
        heap.add(2);
        heap.add(10);
        heap.add(3);
        while(heap.size() > 0) {
            System.out.println(heap.poll());
        }
    }
}
