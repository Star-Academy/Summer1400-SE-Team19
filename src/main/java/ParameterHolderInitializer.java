import database.FileReader;
import modifiers.Filter;
import modifiers.TypeChecker;
import database.DataContainer;
import parameterholders.*;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ParameterHolderInitializer {
    private final ParameterHolderInterface parameterHolderInterface;

    public ParameterHolderInitializer() {
        parameterHolderInterface = new ParameterHolder();
        initializeParameters();
    }

    private void initializeParameters() {
        initializeDataContainerParameters();
        initializeDataProviderParameters();
        initializeMergerParameters();
        initializeTypeCheckerParameters();
        initializeUserInterfaceParameters();
    }

    private void initializeUserInterfaceParameters() {
        parameterHolderInterface.setUserInterfaceParameters(new UserInterfaceParameters());
        parameterHolderInterface.getUserInterfaceParameters().setTypeChecker(new TypeChecker(parameterHolderInterface.getTypeCheckerParameters()));
        parameterHolderInterface.getUserInterfaceParameters().setScanner(new Scanner(System.in));
        parameterHolderInterface.getUserInterfaceParameters().setFilter(new Filter());
        parameterHolderInterface.getUserInterfaceParameters().setResult(new HashSet<>());
    }

    private void initializeTypeCheckerParameters() {
        parameterHolderInterface.setTypeCheckerParameters(new TypeCheckerParameters());
        parameterHolderInterface.getTypeCheckerParameters().setWordsInObject(new ArrayList<>());
    }

    private void initializeMergerParameters() {
        parameterHolderInterface.setMergerParameters(new MergerParameters());
        parameterHolderInterface.getMergerParameters().setHashSet(new HashSet<>());
    }

    private void initializeDataProviderParameters() {
        parameterHolderInterface.setDataProviderParameters(new DataProviderParameters());
        parameterHolderInterface.getDataProviderParameters().setDataContainer(new DataContainer(parameterHolderInterface.getDataContainerParameters()));
        parameterHolderInterface.getDataProviderParameters().setFileDirectory(new File("resources/SampleEnglishData"));
        parameterHolderInterface.getDataProviderParameters().setReader(new FileReader(parameterHolderInterface.getDataProviderParameters().getDataContainer()));
    }

    private void initializeDataContainerParameters() {
        parameterHolderInterface.setDataContainerParameters(new DataContainerParameters());
        parameterHolderInterface.getDataContainerParameters().setAllData(new HashMap<>());
    }

    public ParameterHolderInterface getParameterHolder() {
        return parameterHolderInterface;
    }
}
