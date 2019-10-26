public class MyTool {

    public static boolean[] init(int n) {
        boolean[] hashSet = new boolean[n];
        for ( int i=1 ; i< n ; i++){
            hashSet[i] = false;
        }
        return hashSet;
    }
}
