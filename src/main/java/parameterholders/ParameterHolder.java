package parameterholders;

import parameterholders.abstraction.*;

public class ParameterHolder implements ParameterHolderInterface {
    private DataContainerParametersInterface dataContainerParametersInterface;
    private DataProviderParametersInterface dataProviderParametersInterface;
    private MergerParametersInterface mergerParametersInterface;
    private TypeCheckerParametersInterface typeCheckerParametersInterface;
    private UserInterfaceParametersInterface userInterfaceParametersInterface;

    @Override
    public DataContainerParametersInterface getDataContainerParametersInterface() {
        return dataContainerParametersInterface;
    }

    @Override
    public void setDataContainerParameters(DataContainerParametersInterface dataContainerParametersInterface) {
        this.dataContainerParametersInterface = dataContainerParametersInterface;
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
    public void setUserInterfaceParameters(UserInterfaceParameters userInterfaceParametersInterface) {
        this.userInterfaceParametersInterface = userInterfaceParametersInterface;
    }
}
