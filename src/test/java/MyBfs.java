import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MyBfs {
    class Node {
        int x;
        int y;
        int step;
        public Node (int x,int y, int step){
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
     Node num = new Node(2,2,0);

    int n = 8;
    int count = 0;
    boolean[] hashSet = new boolean[n];
    int[] array = new int[n];
    int[] X = {0, 0, 1, -1};//判断是否月结
    int[] Y = {1, -1, 0, 0};


    char[][]  xarea= {{'-','-','-','-','-'},{'-','*','*','*','-'},{'-','-','S','*','-'},{'-','*','*','*','T'},{'-','-','-','-','*'}};
    boolean posVisit[][] = new boolean[xarea.length][xarea[0].length];

    /**
     * 0 1 1 0,0,0,1
     * 0 0 1 0 0 0 0
     * 0 0 0 0 1 0 0
     * 0 0 0 1 1 1 0
     * 1 1 1 0 1 0 0
     * 1 1 1 1 0 0 0
     */


    @Test
    public void testBfs() {

        for (int i = 0; i < posVisit.length; i++) {
            for (int j = 0; j < posVisit[i].length; j++) {
                posVisit[i][j] = false;
            }
        }

                int s = bfs(2, 2);
        System.out.println(s);

    }

    private int bfs(int x, int y) {
        Node man = new Node(x,y,0);
        boolean first = true;
        Node T = new Node ( 3,4,0);
        Queue<Node> e = new LinkedList<>();
        e.add(man);
        posVisit[x][y]=true;

        while ( e.size()>0){
             num =e.poll();
            if ( num.x == T.x && num.y== T.y){
                return num.step;
            }
            for ( int i=0 ;i<4 ; i++){
                int tempX = num.x+X[i];
                int tempY = num.y+Y[i];
                
                if ( canVisit(tempX,tempY)){
                    num.step= num.step+1;
                    num = new Node(tempX,tempY,num.step);
                    if (first){
                        System.out.format("(%d,%d)",tempX,tempY);
                        first=false;
                    }else{
                        System.out.format("->(%d,%d)",tempX,tempY);

                    }
                    posVisit[tempX][tempY]=true;
                    e.add(num);

                }
            }
            System.out.println();
        }
        return -1;
    }

    private boolean canVisit(int tempX, int tempY) {
        if ( tempX<0 || tempY<0 || tempX >= xarea.length || tempY >=xarea[0].length){
                return false;
        }
        if ( xarea[tempX][tempY]=='*' || posVisit[tempX][tempY]==true){
            return false;
        }
        return true;
    }


}