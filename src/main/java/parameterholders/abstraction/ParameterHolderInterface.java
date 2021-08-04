package parameterholders.abstraction;

import parameterholders.*;

public interface ParameterHolderInterface {
    DataContainerParameters getDataContainerParametersInterface();

    void setDataContainerParameters(DataContainerParameters dataContainerParametersInterface);

    DataProviderParameters getDataProviderParameters();

    void setDataProviderParameters(DataProviderParameters dataProviderParametersInterface);

    MergerParameters getMergerParameters();

    void setMergerParameters(MergerParameters mergerParametersInterface);

    TypeCheckerParameters getTypeCheckerParameters();

    void setTypeCheckerParameters(TypeCheckerParameters typeCheckerParametersInterface);

    UserInterfaceParameters getUserInterfaceParameters();

    void setUserInterfaceParameters(UserInterfaceParameters userInterfaceParametersInterface);

}
