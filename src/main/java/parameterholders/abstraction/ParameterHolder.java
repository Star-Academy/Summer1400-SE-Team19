package parameterholders.abstraction;

import parameterholders.*;

public interface ParameterHolder {
    DataContainerParameters getDataContainerParametersInterface();

    void setDataContainerParameters(DataContainerParameters dataContainerParametersInterface);

    DataProviderParameters getDataProviderParameters();

    void setDataProviderParameters(DataProviderParameters dataProviderParametersInterface);

    MergerParameters getMergerParameters();

    void setMergerParameters(MergerParameters mergerParametersInterface);

    TypeCheckerParameters getTypeCheckerParameters();

    void setTypeCheckerParameters(TypeCheckerParameters typeCheckerParametersInterface);

    UserParametersHolder getUserInterfaceParameters();

    void setUserInterfaceParameters(UserParametersHolder userInterfaceParametersInterface);
}
