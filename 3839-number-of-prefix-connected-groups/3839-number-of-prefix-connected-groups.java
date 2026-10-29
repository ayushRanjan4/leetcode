class Solution {
    public int prefixConnected(String[] words, int k) {
        Map<String,Integer> map=new HashMap<>();
        int count=0;
        for(String s:words){
            if(s.length()>=k) map.put(s.substring(0,k),map.getOrDefault(s.substring(0,k),0)+1);
        }
        // for(String s:set){
        //     int c=0;
        //     for(String st:words){
        //         if(st.length()>=k && st.substring(0,k).equals(s)) c++;
        //     }
        //     if(c>1) count++;
        // }
        for(String key:map.keySet()){
            if(map.get(key)>1) count++;
        }
        return count;
    }
}