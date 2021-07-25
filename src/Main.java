public class Main {
    public static void main(String[] args) {
        try {
            HashmapInitializer hashmapInitializer = new HashmapInitializer();
            hashmapInitializer.initialize();
            new Searcher().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
