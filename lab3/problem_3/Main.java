package lab3.problem_3;

public class Main {

    interface MyCollection<T> {
        void add(T element);
        void remove(T element);
        boolean contains(T element);
        int size();
        boolean isEmpty();
        void clear();
    }

    static class MyList implements MyCollection<String> {
        private String[] data = new String[100];
        private int count = 0;

        @Override
        public void add(String element) {
            data[count++] = element;
        }

        @Override
        public void remove(String element) {
            for (int i = 0; i < count; i++) {
                if (data[i].equals(element)) {
                    data[i] = data[--count];
                    return;
                }
            }
        }

        @Override
        public boolean contains(String element) {
            for (int i = 0; i < count; i++) {
                if (data[i].equals(element)) return true;
            }
            return false;
        }

        @Override
        public int size() { return count; }

        @Override
        public boolean isEmpty() { return count == 0; }

        @Override
        public void clear() { count = 0; }
    }

    static class MySet implements MyCollection<String> {
        private String[] data = new String[100];
        private int count = 0;

        @Override
        public void add(String element) {
            if (!contains(element)) {
                data[count++] = element;
            }
        }

        @Override
        public void remove(String element) {
            for (int i = 0; i < count; i++) {
                if (data[i].equals(element)) {
                    data[i] = data[--count];
                    return;
                }
            }
        }

        @Override
        public boolean contains(String element) {
            for (int i = 0; i < count; i++) {
                if (data[i].equals(element)) return true;
            }
            return false;
        }

        @Override
        public int size() { return count; }

        @Override
        public boolean isEmpty() { return count == 0; }

        @Override
        public void clear() { count = 0; }
    }

    public static void main(String[] args) {

        System.out.println("=== MyList ===");
        MyList list = new MyList();
        list.add("apple");
        list.add("banana");
        list.add("apple");   
        System.out.println("Size: " + list.size());
        System.out.println("Contains apple: " + list.contains("apple"));
        System.out.println("After remove size: " + list.size());

        System.out.println("=== MySet ===");
        MySet set = new MySet();
        set.add("apple");
        set.add("banana");
        set.add("apple");
        System.out.println("Size: " + set.size());
        System.out.println("Is empty: " + set.isEmpty());
        set.clear();
        System.out.println("After clear size: " + set.size());
    }
}
