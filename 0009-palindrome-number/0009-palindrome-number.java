class Solution {
    public boolean isPalindrome(int x) {
      if(x<0){
        return false;
      }
      int fin=x;
      int n=0;
      while(x>0){
        int pal=x%10;
        x = x/10;
        n=n*10+pal;
      }
      if(n==fin){ return true;}
        else return false;
    }
}