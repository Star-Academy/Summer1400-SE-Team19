import modifiers.Merger;
import modifiers.TypeChecker;
import database.DataContainer;
import parameterholders.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ParameterHolderInitializer {
    private final ParameterHolder parameterHolder;

    public ParameterHolderInitializer() {
        parameterHolder = new ParameterHolder();
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
        parameterHolder.setUserInterfaceParameters(new UserInterfaceParameters());
        parameterHolder.getUserInterfaceParameters().setTypeChecker(new TypeChecker(parameterHolder.getTypeCheckerParameters()));
        parameterHolder.getUserInterfaceParameters().setMerger(new Merger());
        parameterHolder.getUserInterfaceParameters().setScanner(new Scanner(System.in));
    }

    private void initializeTypeCheckerParameters() {
        parameterHolder.setTypeCheckerParameters(new TypeCheckerParameters());
        parameterHolder.getTypeCheckerParameters().setWordsInObject(new ArrayList<>());
    }

    private void initializeMergerParameters() {
        parameterHolder.setMergerParameters(new MergerParameters());
        parameterHolder.getMergerParameters().setHashSet(new HashSet<>());
    }

    private void initializeDataProviderParameters() {
        parameterHolder.setDataProviderParameters(new DataProviderParameters());
        parameterHolder.getDataProviderParameters().setDataContainer(new DataContainer(parameterHolder.getDataContainerParameters()));
        parameterHolder.getDataProviderParameters().setFileDirectory(new File("resources/SampleEnglishData"));
    }

    private void initializeDataContainerParameters() {
        parameterHolder.setDataContainerParameters(new DataContainerParameters());
        parameterHolder.getDataContainerParameters().setAllData(new HashMap<>());
    }

    public ParameterHolder getParameterHolder() {
        return parameterHolder;
    }
}
