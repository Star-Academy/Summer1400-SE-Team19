public class Main {
    public static void main(String[] args) {
            DataInitializer.getInstance().initialize();
            Searcher.getInstance().run();
    }
}
