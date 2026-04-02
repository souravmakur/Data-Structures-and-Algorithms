public class printOneTon {
    public static void Ntimes(int n , int count) {
        if(count > n){
            return;
        }
        System.out.println(count);
        count ++;
        Ntimes(n , count);
    }
    public static void main (String args []) {
        Ntimes(5 , 1);
    }
}
