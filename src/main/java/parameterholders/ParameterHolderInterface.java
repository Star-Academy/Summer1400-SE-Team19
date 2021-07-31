package parameterholders;

public interface ParameterHolderInterface {
    DataContainerParameters getDataContainerParameters();

    void setDataContainerParameters(DataContainerParameters dataContainerParameters);

    DataProviderParametersInterface getDataProviderParameters();

    void setDataProviderParameters(DataProviderParametersInterface dataProviderParametersInterface);

    MergerParametersInterface getMergerParameters();

    void setMergerParameters(MergerParametersInterface mergerParametersInterface);

    TypeCheckerParametersInterface getTypeCheckerParameters();

    void setTypeCheckerParameters(TypeCheckerParametersInterface typeCheckerParametersInterface);

    UserInterfaceParametersInterface getUserInterfaceParameters();

    void setUserInterfaceParameters(UserInterfaceParametersInterface userInterfaceParametersInterface);
}
