import java.util.PriorityQueue;
import java.util.Random;

class ToyStore {
    private static final int[] weights = {20, 20, 60};
    private static final String[] toys = {"конструктор", "робот", "кукла"};
    private static final int[] ids = {1, 2, 3};
    private static final PriorityQueue<Toy> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        for (int i = 0; i < toys.length; i++) {
            queue.add(new Toy(ids[i], toys[i], weights[i]));
        }

        for (int i = 0; i < 10; i++) {
            Toy toy = queue.poll();
            if (toy == null) {
                break;
            }
            System.out.println(toy);
        }
    }

    private static class Toy implements Comparable<Toy> {
        private final int id;
        private final String name;
        private final int weight;

        public Toy(int id, String name, int weight) {
            this.id = id;
            this.name = name;
            this.weight = weight;
        }

        @Override
        public int compareTo(Toy o) {
            return Integer.compare(new Random().nextInt(100), weight);
        }

        @Override
        public String toString() {
            return "Toy{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }
}
