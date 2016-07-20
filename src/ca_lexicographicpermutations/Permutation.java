
package ca_lexicographicpermutations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


 public class Permutation<T extends Comparable<T>> implements Iterable<List<T>> {
 private List<T> values;
 
    public Permutation(List<T> values) {
        this.values = values;
        Collections.sort(this.values);
    }
 
    @Override
    public Iterator<List<T>> iterator() {
        return new PermutationIterator<List<T>>(new ArrayList<T>(values));
    }   
}
