package common;

import java.util.*;
/**
 * Created by xingyun on 15/7/24.
 */
public class Utility<E> {

    public void printCollection(Collection<E> collection) {
        for (E i: collection) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void printListCollection(Collection<List<E>> collections) {
        for(Collection<E> collection : collections) {
            printCollection(collection);
        }
        System.out.println();
    }

}
