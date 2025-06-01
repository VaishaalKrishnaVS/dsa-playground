package neetcode.twopointer;

import util.IBaseClassV2;

public class ValidPalindrome implements IBaseClassV2<Boolean, String> {
    public static void main(String[] args) {
        var cls =  new ValidPalindrome();
        System.out.println(cls.optimal("A man, a plan, a canal: Panama"));
    }
    @Override
    public Boolean intution(String s) {
        String str = s.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String rStr = new StringBuilder(str).reverse().toString();
        return str.equals(rStr);
    }

    @Override
    public Boolean optimal(String s) {
        int i=0,j=s.length()-1;
        while (i<=j){
          char chi = s.charAt(i);
          if(!Character.isLetterOrDigit(chi)){
              i++;
              continue;
          }
          char chj = s.charAt(j);
          if (!Character.isLetterOrDigit(chj)){
              j--;
              continue;
          }
          if(Character.toLowerCase(chi)!=Character.toLowerCase(chj)) return false;
          i++;
          j--;
        }
        return true;
    }
}
