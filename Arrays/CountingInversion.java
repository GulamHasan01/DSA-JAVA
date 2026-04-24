package Arrays;

import java.util.ArrayList;
import java.util.List;

public class CountingInversion {
    public static void main(String[] args) {
        List<Integer> list= new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(1);
        list.add(2);
        System.out.println(countInversions(list));
    }
    public static long countInversions(List<Integer> arr) {
        // Write your code here
        boolean isSorted= java.util.stream.IntStream.range(0, arr.size()-1).allMatch(i->arr.get(i)>=arr.get(i+1));
        if(isSorted){
            return 0;
        }
        int count=0;
        for (int i = 0; i < arr.size(); i++) {
            int j = i + 1;

            while (j < arr.size()) {
                if (arr.get(i) > arr.get(j)) {
                    int temp = arr.get(i);
                    arr.add(i, arr.get(j));
                    arr.add(j, temp);
                    count++;
                }
                j++;
            }
        }
        return count;
    }

}
