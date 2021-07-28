package parameterholders;

public class ParameterHolder {
    private DataContainerParameters dataContainerParameters;
    private DataProviderParameters dataProviderParameters;
    private MergerParameters mergerParameters;
    private TypeCheckerParameters typeCheckerParameters;
    private UserInterfaceParameters userInterfaceParameters;

    public DataContainerParameters getDataContainerParameters() {
        return dataContainerParameters;
    }

    public void setDataContainerParameters(DataContainerParameters dataContainerParameters) {
        this.dataContainerParameters = dataContainerParameters;
    }

    public DataProviderParameters getDataProviderParameters() {
        return dataProviderParameters;
    }

    public void setDataProviderParameters(DataProviderParameters dataProviderParameters) {
        this.dataProviderParameters = dataProviderParameters;
    }

    public MergerParameters getMergerParameters() {
        return mergerParameters;
    }

    public void setMergerParameters(MergerParameters mergerParameters) {
        this.mergerParameters = mergerParameters;
    }

    public TypeCheckerParameters getTypeCheckerParameters() {
        return typeCheckerParameters;
    }

    public void setTypeCheckerParameters(TypeCheckerParameters typeCheckerParameters) {
        this.typeCheckerParameters = typeCheckerParameters;
    }

    public UserInterfaceParameters getUserInterfaceParameters() {
        return userInterfaceParameters;
    }

    public void setUserInterfaceParameters(UserInterfaceParameters userInterfaceParameters) {
        this.userInterfaceParameters = userInterfaceParameters;
    }
}
