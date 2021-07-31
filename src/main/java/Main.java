import modifiers.Searcher;
import database.DataProvider;
import parameterholders.abstraction.ParameterHolderInterface;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ParameterHolderInterface parameterHolderInterface = new ParameterHolderInitializer().getParameterHolder();
        DataProvider dataProvider = new DataProvider(parameterHolderInterface.getDataProviderParameters());
        dataProvider.initialize();
        new UserInterface(parameterHolderInterface.getUserInterfaceParameters(), new Searcher(dataProvider.getDataContainer())).run();
    }
}
