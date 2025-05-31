package neetcode.arrayandhashing;

import util.IBaseClassV2;

import java.util.HashSet;

public class ValidSudoku implements IBaseClassV2<Boolean, char[][]> {
    @Override
    public Boolean intution(char[][] param) {
        var set = new HashSet<String>();
        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                char ch = param[r][c];
                if(ch !='.')
                    if(!set.add(ch+"r"+r) || !set.add(ch+"c"+c) || !set.add(ch+"b"+(r/3)+(c/3))) return false;
            }
        }
        return true;
    }

    @Override
    public Boolean optimal(char[][] param) {
        HashSet[] rarr = new HashSet[9];
        HashSet[] carr = new HashSet[9];
        HashSet[] barr = new HashSet[9];
        for(int i=0;i<9;i++){
            rarr[i]= new HashSet<Character>();
            carr[i]= new HashSet<Character>();
            barr[i]= new HashSet<Character>();
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char ch = param[i][j];
                if(ch=='.') continue;
                if(!rarr[i].add(ch)) return false;
                if(!carr[j].add(ch)) return false;
                if(!barr[i*3+(j/3)].add(ch)) return false;
            }
        }
        return true;
    }
}
