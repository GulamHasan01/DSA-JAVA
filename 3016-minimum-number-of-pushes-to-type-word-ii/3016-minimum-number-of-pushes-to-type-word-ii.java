class Solution {
    public int minimumPushes(String word) {
       HashMap<Character,Integer>map=new HashMap<>();

        for(int i=0;i<word.length();i++){
           map.put(word.charAt(i),map.getOrDefault(word.charAt(i),0)+1);
        }
               Map<Character, Integer> sortedMap = map.entrySet()
    .stream()
    .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
    .collect(Collectors.toMap(
        Map.Entry::getKey, 
        Map.Entry::getValue, 
        (oldValue, newValue) -> oldValue, 
        LinkedHashMap::new
    ));
        int count=0;
        if(sortedMap.size()<9){
            for(int i:sortedMap.values()){
                count+=i;
            }
        }else if(sortedMap.size()>8 && sortedMap.size()<17){
            int c=0;
               for(int i:sortedMap.values()){
                if(c>=8){
                    count=count+i*2;
                    c++;
                }else{
                count+=i;
                c++;
                }
            }
        }else if(sortedMap.size()>16 && sortedMap.size()<25){
            int c=0;
               for(int i:sortedMap.values()){
                if(c>=16){
                  count+=i*3;
                }else if(c>=8 && c<17){
                    count=count+i*2;
                    c++;
                }else{
                count+=i;
                c++;
                }
            }
        }else if(sortedMap.size()>24){
            int c=0;
               for(int i:sortedMap.values()){
                if(c>=24){
                  count+=i*4;
                  c++;
                }else if(c>=16 && c<25){
                  count+=i*3;
                  c++;
                }else if(c>=8 && c<17){
                    count=count+i*2;
                    c++;
                }else{
                count+=i;
                c++;
                }
            }
        }
        return count;
    }
    
}