class Solution { 
    public void duplicateZeros(int[] arr) { 
        int count = 0; 
        int k = 0;
        boolean edgeCase = false;
        
        while (k + count < arr.length) {
            if (arr[k] == 0) {
                if (k + count == arr.length - 1) {
                    edgeCase = true;
                    break;
                }
                count++;
            }
            k++;
        }
        
        int j = arr.length - 1;
        
        if (edgeCase) {
            arr[j--] = 0;
            k--;
        } else if (k + count >= arr.length) {
            k--;
        }

        while (k >= 0) { 
            if (arr[k] != 0) { 
                arr[j--] = arr[k--]; 
            } else { 
                arr[j--] = 0; 
                arr[j--] = 0; 
                k--; 
            } 
        } 
    }
}
