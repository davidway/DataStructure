import org.testng.annotations.Test;

public class MyDfs {

    int n=5;
    int V=8;


    int[] array = {0,3,5,1,2,2};
    int[] valueArray = {0,4,5,2,1,3};
    int maxSum=0;
    @Test
    public void testSixQueue(){

            Dfs(0,0,0);
            System.out.println(maxSum);
    }

    private void Dfs(int index, int sum, int vSum) {
        //递归边界
        if ( index==n){
            if ( sum<=V && vSum>=maxSum){
                maxSum = vSum;
            }
            return ;
        }
        Dfs(index+1,sum,vSum);
        if ( sum+array[index+1] <=V){
            Dfs(index+1,sum+array[index+1],vSum+valueArray[index+1]);
        }
    }

    private void sixQueue(int index) {

    }
}

class InputData{

}