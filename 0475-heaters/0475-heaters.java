class Solution {
     public int findRadius(int[] houses, int[] heaters) { 
    //     Arrays.sort(houses); 
    //     Arrays.sort(heaters); 
        
    //     int tracker = 0; 
    //     int first = heaters[tracker++]; 
    //     int second = first; 
    //     if (tracker != heaters.length) second = heaters[tracker++]; 
        
    //     int ans = 0; 
    //     for (int i = 0; i < houses.length; i++) { 
    //         int house = houses[i]; 
            
    //         while (first != second && Math.abs(house - second) <= Math.abs(house - first)) {
    //             first = second;
    //             if (tracker != heaters.length) {
    //                 second = heaters[tracker++];
    //             } else {
    //                 break; 
    //             }
    //         }
            
    //         if (Math.abs(house - first) < Math.abs(house - second)) { 
    //             ans = Math.max(ans, Math.abs(house - first)); 
    //         } else { 
    //             ans = Math.max(ans, Math.abs(house - second)); 
    //         } 
            
    //        // System.out.println(first + " " + second + " " + ans); 
    //     } 
    //     return ans; 
    // } 

    //     Arrays.sort(houses);
    //     Arrays.sort(heaters);
    //     int tracker = 0;
    //     int first = heaters[tracker++];
    //     int second = first;
    //     if (tracker != heaters.length)
    //         second = heaters[tracker++];
    //     int ans = 0;
    //     for (int i = 0; i < houses.length; i++) {
    //         int house = houses[i];

    //         if (Math.abs(house - first) < Math.abs(house - second)) {
    //             ans = Math.max(ans, Math.abs(house - first));
    //         } else {
    //             ans = Math.max(ans, Math.abs(house - second));
    //             if (tracker != heaters.length)
    //                 first = heaters[tracker++];
    //             if (tracker != heaters.length)
    //                 second = heaters[tracker++];
    //         }
    //     }
    //     return ans;
    // }


        Arrays.sort(houses); 
        Arrays.sort(heaters); 
        
        int ans = 0; 
        int i = 0; // Pointer for heaters
        
        for (int house : houses) {
            // Advance pointer as long as the next heater is closer or equally close
            while (i < heaters.length - 1 && Math.abs(heaters[i + 1] - house) <= Math.abs(heaters[i] - house)) {
                i++;
            }
            // Maximize the radius based on the absolute closest heater found
            ans = Math.max(ans, Math.abs(heaters[i] - house));
            
            // Replicating your original print request with safely computed boundaries
            int first = heaters[i];
            int second = (i < heaters.length - 1) ? heaters[i + 1] : heaters[i];
            System.out.println(first + " " + second + " " + ans);
        } 
        return ans; 
    } 
}

