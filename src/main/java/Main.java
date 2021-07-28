import modifiers.Searcher;
import database.DataProvider;
import parameterholders.ParameterHolder;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ParameterHolder parameterHolder = new ParameterHolderInitializer().getParameterHolder();
        DataProvider dataProvider = new DataProvider(parameterHolder.getDataProviderParameters());
        dataProvider.initialize();
        new UserInterface(parameterHolder.getUserInterfaceParameters(), new Searcher(dataProvider.getDataContainer())).run();
    }
}
