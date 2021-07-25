public class Main {
    public static void main(String[] args) {
        try {
            DataInitializer.getInstance().initialize();
            new Searcher().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
