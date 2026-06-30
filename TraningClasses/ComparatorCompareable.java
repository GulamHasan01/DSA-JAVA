package TraningClasses;

import java.util.*;

public class ComparatorCompareable {
    public static class A implements Comparable<A>{
        Integer a;
        public A(Integer a){
            this.a=a;
        }
        @Override
        public int compareTo(A that){
        return this.a.compareTo(that.a);
        // for reverse
            //return that.a.compareTo(this.a);
        }

    }
    public static class comparator implements Comparator<A>, TraningClasses.comparator {

        @Override
        public int compare(A a ,A b){
            return  a.a.compareTo(b.a);
        }

    }
public static class mySet implements Comparator<Integer>{
        @Override
    public int compare(Integer a,Integer b){
            if (a.compareTo(b)==0) return 1;
            return a.compareTo(b);
        }
}
    public static void main(String[] args) {
       // ArrayList<A> list=new ArrayList<>(List.of(new A(1), new A(3),new A(5), new A(2)));
//        Set<Integer>set=new TreeSet<>( new mySet());
//        for (int i = 0; i < 5; i++) {
//            set.add(i);
//        }
//        set.add(0);
//        System.out.println(set);
//
        Map<Integer,List<Integer>>map=new TreeMap<>();
        map.computeIfAbsent(5,k->new ArrayList<>()).add(20);
        map.computeIfAbsent(5,k->new ArrayList<>()).add(22);
        System.out.println(map);

        Map<Integer,Integer>map1=new TreeMap<>(new comptor());
        map1.put(5,20);
        map1.put(5,22);
        System.out.println(map1);
    }
    public static class comptor implements Comparator<Integer>{


        @Override
        public int compare(Integer a, Integer b){
            return a.compareTo(b)==0?1:a.compareTo(b);
        }
    }
}
