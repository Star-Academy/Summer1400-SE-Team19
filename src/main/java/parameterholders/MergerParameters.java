package parameterholders;

import parameterholders.abstraction.MergerParametersInterface;

import java.util.HashSet;

public class MergerParameters implements MergerParametersInterface {
    private HashSet<Integer> hashSet;

    public HashSet<Integer> getHashSet() {
        return hashSet;
    }

    public void setHashSet(HashSet<Integer> hashSet) {
        this.hashSet = hashSet;
    }
}
