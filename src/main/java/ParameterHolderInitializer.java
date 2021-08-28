import database.DataContainer;
import modifiers.*;
import parameterholders.*;

import java.io.File;
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
        parameterHolder.getUserInterfaceParameters().
                setTypeChecker(new TypeChecker(parameterHolder.getTypeCheckerParameters()));
        parameterHolder.getUserInterfaceParameters().setScanner(new Scanner(System.in));
        parameterHolder.getUserInterfaceParameters().setPositiveWordFilter(new FilterPositiveWords());
        parameterHolder.getUserInterfaceParameters().setPositiveWordFilter(new FilterNeutralWords());
        parameterHolder.getUserInterfaceParameters().setPositiveWordFilter(new FilterNegativeWords());

        parameterHolder.getUserInterfaceParameters().setResult(new HashSet<>());
        parameterHolder.getUserInterfaceParameters().setSearcher(new DataCollector());
        parameterHolder.getUserInterfaceParameters().getSearcher().setDataContainer(
                parameterHolder.getDataProviderParameters().getDataContainer());
    }

    private void initializeTypeCheckerParameters() {
        parameterHolder.setTypeCheckerParameters(new TypeCheckerParameters());
    }

    private void initializeMergerParameters() {
        parameterHolder.setMergerParameters(new MergerParameters());
        parameterHolder.getMergerParameters().setHashSet(new HashSet<>());
    }

    private void initializeDataProviderParameters() {
        parameterHolder.setDataProviderParameters(new DataProviderParameters());
        parameterHolder.getDataProviderParameters().setDataContainer
                (new DataContainer(parameterHolder.getDataContainerParametersInterface()));
        parameterHolder.getDataProviderParameters().setFileDirectory(new File("resources/SampleEnglishData"));
    }

    private void initializeDataContainerParameters() {
        parameterHolder.setDataContainerParameters(new DataContainerParameters());
        parameterHolder.getDataContainerParametersInterface().setAllData(new HashMap<>());
    }

    public ParameterHolder getParameterHolder() {
        return parameterHolder;
    }
}
