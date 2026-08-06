class Solution {
    public int findCenter(int[][] edges) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int[] i:edges){
            map.put(i[0],map.getOrDefault(i[0],0)+1);
            map.put(i[1],map.getOrDefault(i[1],0)+1);
        }
        for(int key:map.keySet()){
            if(map.get(key)>1) return key;
        }
        return -1;
    }
}