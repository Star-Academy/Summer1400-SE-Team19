package parameterholders;

import parameterholders.abstraction.MergerParametersHolder;

import java.util.HashSet;

public class MergerParameters implements MergerParametersHolder {
    private HashSet<Integer> hashSet;

    @Override
    public HashSet<Integer> getHashSet() {
        return hashSet;
    }

    @Override
    public void setHashSet(HashSet<Integer> hashSet) {
        this.hashSet = hashSet;
    }
}
