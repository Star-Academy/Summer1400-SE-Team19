package parameterholders;

public class ParameterHolder implements ParameterHolderInterface {
    private DataContainerParameters dataContainerParameters;
    private DataProviderParametersInterface dataProviderParametersInterface;
    private MergerParametersInterface mergerParametersInterface;
    private TypeCheckerParametersInterface typeCheckerParametersInterface;
    private UserInterfaceParametersInterface userInterfaceParametersInterface;

    @Override
    public DataContainerParameters getDataContainerParameters() {
        return dataContainerParameters;
    }

    @Override
    public void setDataContainerParameters(DataContainerParameters dataContainerParameters) {
        this.dataContainerParameters = dataContainerParameters;
    }

    @Override
    public DataProviderParametersInterface getDataProviderParameters() {
        return dataProviderParametersInterface;
    }

    @Override
    public void setDataProviderParameters(DataProviderParametersInterface dataProviderParametersInterface) {
        this.dataProviderParametersInterface = dataProviderParametersInterface;
    }

    @Override
    public MergerParametersInterface getMergerParameters() {
        return mergerParametersInterface;
    }

    @Override
    public void setMergerParameters(MergerParametersInterface mergerParametersInterface) {
        this.mergerParametersInterface = mergerParametersInterface;
    }

    @Override
    public TypeCheckerParametersInterface getTypeCheckerParameters() {
        return typeCheckerParametersInterface;
    }

    @Override
    public void setTypeCheckerParameters(TypeCheckerParametersInterface typeCheckerParametersInterface) {
        this.typeCheckerParametersInterface = typeCheckerParametersInterface;
    }

    @Override
    public UserInterfaceParametersInterface getUserInterfaceParameters() {
        return userInterfaceParametersInterface;
    }

    @Override
    public void setUserInterfaceParameters(UserInterfaceParametersInterface userInterfaceParametersInterface) {
        this.userInterfaceParametersInterface = userInterfaceParametersInterface;
    }
}
