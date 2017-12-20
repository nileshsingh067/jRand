package me.xdrop.jrand.generators.collections;

import me.xdrop.jrand.generators.basics.NaturalGenerator;

import java.util.ArrayList;
import java.util.List;

public class ListRandUtils<T> {

    private final static NaturalGenerator nat = new NaturalGenerator();

    /**
     * Return a random element from the list
     * @return The random element
     */
    public static <T> T chooseOne(List<T> list) {
         int index = nat.range(list.size()).gen();
         return list.get(index);
    }

    /**
     * Return a random element from the list
     * @return The random element
     */
    public static <T> T chooseOne(T[] list) {
        int index = nat.range(list.length).gen();
        return list[index];
    }
    /**
     * Return n random elements from the list (with replacement)
     * @param n Number of elements to retrieve
     * @return A list of random elements
     */
    public List<T> chooseN(List<T> list, int n) {
        List<Integer> indices = nat.range(list.size()).genMany(n);
        List<T> result = new ArrayList<>();
        for (Integer i : indices) {
            result.add(list.get(i));
        }
        return result;
    }

    /**
     * Return n *unique* random elements from the list (without replacement)
     * @param n Number of elements to return
     * @return A list of unique random elements
     */
    public List<T> chooseNUnique(List<T> list, int n) {
        List<Integer> indices = nat.sample(n, list.size());
        List<T> result = new ArrayList<>();
        for (Integer i : indices) {
            result.add(list.get(i));
        }
        return result;
    }

    public List<T> shuffle() {
        throw new UnsupportedOperationException();
    }

    public List<T> shuffleInplace() {
        throw new UnsupportedOperationException();
    }




}