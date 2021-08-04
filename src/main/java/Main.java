import database.DataProvider;
import parameterholders.ParameterHolder;

public class Main {
    public static void main(String[] args) {
        ParameterHolder parameterHolderInterface = new ParameterHolderInitializer().getParameterHolder();
        DataProvider dataProvider = new DataProvider(parameterHolderInterface.getDataProviderParameters());
        dataProvider.initialize();
        UserInterface userInterface = new UserInterface(parameterHolderInterface.getUserInterfaceParameters());
        userInterface.run();
    }
}
