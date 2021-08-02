package customizedassertions;

import java.util.HashSet;

public class CollectionsComparator {
    public boolean areHashSetsEqual(HashSet<Integer> hashSet1, HashSet<Integer> hashSet2) {
        if (hashSet1.size() != hashSet2.size())
            return false;
        for (Integer integer : hashSet1) {
            if (!hashSet2.contains(integer))
                return false;
        }
        return true;
    }
}
