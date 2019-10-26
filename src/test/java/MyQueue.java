import org.testng.annotations.Test;

public class MyQueue {

        int n=8;
        int count=0;
        boolean[] hashSet= new boolean[n];
        int[] array = new int[n];
        @Test
        public void testSixQueue(){
            hashSet = MyTool.init(n);
                sixQueue(1);
        }

    private void sixQueue(int index) {
            if ( index==n){
                boolean flag=true;
                for ( int i=0 ; i<n ; i++){
                    for (int j=0 ; j<n ; j++){
                        if ( Math.abs(i-j)==Math.abs(array[i]-array[j])){
                            flag = false;
                        }
                    }
                }
                if ( flag){
                    count++;
                    return ;
                }
            }

            for ( int i=0 ; i<n ; i++){
                if ( hashSet[i]==false){
                    array[index] =i;
                    hashSet[i] = true;
                    sixQueue(index+1);
                    hashSet[i] = false;
                }
            }
    }
}