class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        Deque<Integer> st = new ArrayDeque<>();
        st.push(asteroids[0]);

        int i=1;

        while(i<n){
            boolean remove=false;
            while(!st.isEmpty() &&  asteroids[i]<0 && st.peek()>0){
                if(-asteroids[i]>st.peek()){
                    st.pop();
                }else if(-asteroids[i]<st.peek()){
                    remove=true;
                    break;
                }else{
                    st.pop();
                    remove=true;
                    break;
                }
            }
            if(!remove){
                st.push(asteroids[i]);
            }
            i++;
        }
        int[] ans=new int[st.size()];
        int j=st.size()-1;
        while(!st.isEmpty()){
            ans[j--]=st.pop();
        }

        return ans;

    }
}