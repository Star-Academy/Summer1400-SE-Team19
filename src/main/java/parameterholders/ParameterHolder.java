package parameterholders;

import parameterholders.abstraction.*;

public class ParameterHolder implements ParameterHolderInterface {
    private DataContainerParameters dataContainerParameters;
    private DataProviderParameters dataProviderParameters;
    private MergerParameters mergerParameters;
    private TypeCheckerParameters typeCheckerParameters;
    private UserInterfaceParameters userInterfaceParameters;

    @Override
    public DataContainerParameters getDataContainerParametersInterface() {
        return dataContainerParameters;
    }

    @Override
    public void setDataContainerParameters(DataContainerParameters dataContainerParametersInterface) {
        this.dataContainerParameters = dataContainerParametersInterface;
    }

    @Override
    public DataProviderParameters getDataProviderParameters() {
        return dataProviderParameters;
    }

    @Override
    public void setDataProviderParameters(DataProviderParameters dataProviderParametersInterface) {
        this.dataProviderParameters = dataProviderParametersInterface;
    }

    @Override
    public MergerParameters getMergerParameters() {
        return mergerParameters;
    }

    @Override
    public void setMergerParameters(MergerParameters mergerParametersInterface) {
        this.mergerParameters = mergerParametersInterface;
    }

    @Override
    public TypeCheckerParameters getTypeCheckerParameters() {
        return typeCheckerParameters;
    }

    @Override
    public void setTypeCheckerParameters(TypeCheckerParameters typeCheckerParametersInterface) {
        this.typeCheckerParameters = typeCheckerParametersInterface;
    }

    @Override
    public UserInterfaceParameters getUserInterfaceParameters() {
        return userInterfaceParameters;
    }

    @Override
    public void setUserInterfaceParameters(UserInterfaceParameters userInterfaceParametersInterface) {
        this.userInterfaceParameters = userInterfaceParametersInterface;
    }
}
