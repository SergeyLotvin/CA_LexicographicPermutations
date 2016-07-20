
package ca_lexicographicpermutations;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PermutationIterator<E extends List<? extends Comparable>> implements Iterator<E> {
    
    private E values;
    boolean firstIteration;
 
    public PermutationIterator(E values, boolean firstIteration) {
        this.values = values;
        this.firstIteration = firstIteration;
        Collections.sort((List) this.values);
    }
    public PermutationIterator(E values) {
        this(values, true);
    }
 
    @Override
    public boolean hasNext() {
        if (firstIteration) return true;
        int smallestIndex = values.size() - 2;
        while (smallestIndex >= 0 && values.get(smallestIndex).compareTo(values.get(smallestIndex + 1)) >= 0)
            --smallestIndex;
        return smallestIndex >= 0;
    }
 
    private <T> void swap(List<T> values, int i, int j) {
        T temp = values.get(i);
        values.set(i, values.get(j));
        values.set(j, temp);
    }
 
    @Override
    public E next() {
        if (firstIteration) {
            firstIteration = false;
            return values;
        }
        // find the largest index k such that a[k] < a[k + 1].
        int smallestIndex = values.size() - 2;
 
        while (smallestIndex >= 0 && values.get(smallestIndex).compareTo(values.get(smallestIndex + 1)) >= 0)
            --smallestIndex;
        // if no such index exists, the permutation is the last permutation
        if (smallestIndex < 0) return null;
        // find the largest index l such that a[k] < a[l].
        int largestIndex = values.size() - 1;
        while (largestIndex > smallestIndex && values.get(smallestIndex).compareTo(values.get(largestIndex)) >= 0) --largestIndex;
        // swap found
        swap((List)values, smallestIndex, largestIndex);
        // revert order of remaining elements
        for (int i = values.size() - 1, j = smallestIndex + 1; i > j; ++j, --i)
            swap((List)values, i, j);
        return values;
    }
 
    @Override
    public void remove() {
        throw new UnsupportedOperationException("there is no way to remove a permutation");
    }
    
}
