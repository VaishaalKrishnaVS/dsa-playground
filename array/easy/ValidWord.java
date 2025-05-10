package array.easy;

import util.IBaseClass;
//leetCode 3136
public class ValidWord implements IBaseClass {
    public static final String word = "UuE6";

    public static void main(String[] args) {
        var cls = new ValidWord();
        cls.bruteForce();
    }
    @Override
    public void bruteForce() {
        int n = 0;
        boolean isDigitOrAlpha = true;
        int v = 0;
        int c = 0;
        String vo = "aAeEiIoOuU";
        for(char ch: word.toCharArray()){
            n++;
            if(!Character.isLetter(ch) && !Character.isDigit(ch)) {
                isDigitOrAlpha = false;
                break;
            }

            if (    !Character.isDigit(ch)) {
                if(vo.indexOf(ch)==-1)c++;
                else v++;
            }
        }
        System.out.println(c > 0 && v > 0 && n > 3 && isDigitOrAlpha);
    }

    @Override
    public void better() {

    }

    @Override
    public void optimal() {

    }
}
