import database.DataProvider;
import parameterholders.abstraction.ParameterHolderInterface;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ParameterHolderInterface parameterHolder = new ParameterHolderInitializer().getParameterHolder();
        DataProvider dataProvider = new DataProvider(parameterHolder.getDataProviderParameters());
        dataProvider.initialize();
        UserInterface userInterface = new UserInterface(parameterHolder.getUserInterfaceParameters());
        userInterface.run();
    }
}