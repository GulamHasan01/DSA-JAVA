package BinarySearch;

import java.util.Arrays;

public class BoatToSavePeople {
    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{3,2,2,1},3));
    }
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        int boats = 0;

        while (left <= right) {

            if (people[left] + people[right] <= limit) {
                left++;
            }

            right--;
            boats++;
        }
        return boats;
    }
}

