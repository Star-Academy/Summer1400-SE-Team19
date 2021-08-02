package parameterholders;

import parameterholders.abstraction.*;

public class ParameterHolder implements ParameterHolderInterface {
    private DataContainerParameters dataContainerParametersInterface;
    private DataProviderParameters dataProviderParametersInterface;
    private MergerParameters mergerParametersInterface;
    private TypeCheckerParameters typeCheckerParametersInterface;
    private UserInterfaceParameters userInterfaceParametersInterface;

    @Override
    public DataContainerParameters getDataContainerParametersInterface() {
        return dataContainerParametersInterface;
    }

    @Override
    public void setDataContainerParameters(DataContainerParameters dataContainerParametersInterface) {
        this.dataContainerParametersInterface = dataContainerParametersInterface;
    }

    @Override
    public DataProviderParameters getDataProviderParameters() {
        return dataProviderParametersInterface;
    }

    @Override
    public void setDataProviderParameters(DataProviderParameters dataProviderParametersInterface) {
        this.dataProviderParametersInterface = dataProviderParametersInterface;
    }

    @Override
    public MergerParameters getMergerParameters() {
        return mergerParametersInterface;
    }

    @Override
    public void setMergerParameters(MergerParameters mergerParametersInterface) {
        this.mergerParametersInterface = mergerParametersInterface;
    }

    @Override
    public TypeCheckerParameters getTypeCheckerParameters() {
        return typeCheckerParametersInterface;
    }

    @Override
    public void setTypeCheckerParameters(TypeCheckerParameters typeCheckerParametersInterface) {
        this.typeCheckerParametersInterface = typeCheckerParametersInterface;
    }

    @Override
    public UserInterfaceParameters getUserInterfaceParameters() {
        return userInterfaceParametersInterface;
    }

    @Override
    public void setUserInterfaceParameters(UserInterfaceParameters userInterfaceParametersInterface) {
        this.userInterfaceParametersInterface = userInterfaceParametersInterface;
    }
}
