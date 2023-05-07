public class Euler {
    public static int ausrechnen(int range){
        int res = 0;
        for(int i = 1; i < range; i++){
            if(i % 3 == 0 || i % 5 == 0){
                res += i;
            }
        }
        return res;
    }
}
