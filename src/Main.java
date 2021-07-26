import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        DataProvider dataProvider = new DataProvider();
        dataProvider.initialize();
        new Searcher(dataProvider.getDataContainer()).run();
    }
}
