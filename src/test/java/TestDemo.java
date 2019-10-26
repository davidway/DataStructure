import org.testng.annotations.Test;

public class TestDemo {

    int n=4;
    public int[] num=new int[n];
    public boolean[] hashSet=new boolean[n];
    public int e = 0;
    @Test
    public void testcase1() {
        hashSet = MyTool.init(n);
        generaeteP(1);
    }



    public void generaeteP(int index){
        //递归边界
        if ( index>n){
            e++;
            System.out.println(e);
        }

        //递归公式
        // 列举１位的全排列　，列举２的全排列，列举１２的全排列，列举２１的全排列
        for(int i=1 ; i<n ; i++){
            if ( hashSet[i]==false){
                num[index] = i;
                hashSet[i] = true;
                generaeteP(index+1);
                hashSet[i]=false;
            }

        }
    }


}