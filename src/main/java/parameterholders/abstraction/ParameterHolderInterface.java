package parameterholders.abstraction;

import parameterholders.DataContainerParameters;
import parameterholders.UserInterfaceParameters;

public interface ParameterHolderInterface {
    DataContainerParametersInterface getDataContainerParametersInterface();

    void setDataContainerParameters(DataContainerParametersInterface dataContainerParametersInterface);

    DataProviderParametersInterface getDataProviderParameters();

    void setDataProviderParameters(DataProviderParametersInterface dataProviderParametersInterface);

    MergerParametersInterface getMergerParameters();

    void setMergerParameters(MergerParametersInterface mergerParametersInterface);

    TypeCheckerParametersInterface getTypeCheckerParameters();

    void setTypeCheckerParameters(TypeCheckerParametersInterface typeCheckerParametersInterface);

    UserInterfaceParametersInterface getUserInterfaceParameters();

    void setUserInterfaceParameters(UserInterfaceParameters userInterfaceParametersInterface);
}
