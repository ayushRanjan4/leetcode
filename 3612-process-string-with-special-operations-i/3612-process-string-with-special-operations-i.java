import java.util.*;
class Solution {
    public String processStr(String s) {
        StringBuilder str=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch>='a' && ch<='z') str.append(ch);
            else if(ch=='*'){
                if(str.length()>0){
                    str.deleteCharAt(str.length()-1);
                }
             }else if(ch=='#'){
                String st=str.toString();
                str.append(st);
            }else if(ch=='%'){
                str.reverse();
            }else{
                continue;
            }
        }
        return str.length()!=0?str.toString():"";
    }
}