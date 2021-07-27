import controller.ParameterHolderInitializer;
import controller.modifiers.Searcher;
import model.database.DataProvider;
import model.parameterholders.ParameterHolder;
import view.UserInterface;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ParameterHolder parameterHolder = new ParameterHolderInitializer().getParameterHolder();
        DataProvider dataProvider = new DataProvider(parameterHolder.getDataProviderParameters());
        dataProvider.initialize();
        new UserInterface(parameterHolder.getUserInterfaceParameters(), new Searcher(dataProvider.getDataContainer())).run();
    }

}
