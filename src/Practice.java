import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice {

    public static void patternDiamond(Integer n){

        for(int i = 1; i <=n; i++){
            for(int s = n-i; s > 0; s--){
                System.out.print(" ");
            }
            for(int j = 0; j < (2*i -1); j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int k=n; k>=1;k--){
            for(int s = 0; s < n -k; s++){
                System.out.print(" ");
            }
            for(int j = (2* k -1); j>=1; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void halfDiamond(int n){
        for(int i=1; i<=2*n-1; i++){
            if(i<=n) {
                for (int j = 0; j < i; j++) {
                    System.out.print("*");
                }
            } else{
                for(int k = 1; k<= 2*n-i; k++){
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    public static void pattern_1(int n){
        for(int i=1; i<=n; i++){
            if(i%2==1){
                for(int j=1; j<=i; j++){
                    System.out.print(j%2);
                    System.out.print(" ");
                }
            } else{
                for(int j=0; j<=i-1; j++){
                    System.out.print(j%2);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void pattern_2(int n){
        int count = 0;
        for(int i=1; i<=n; i++){
            for(int j=0; j<i; j++){
                count++;
                System.out.print(count);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void pattern_3(int n){
        for(int i=1; i<=n; i++){
            for(int j=1;j<=i; j++){
                System.out.print(j);
            }
            for(int s=0; s<2*(n-i); s++){
                System.out.print(" ");

            }
            for(int k=i; k>0; k--){
                System.out.print(k);

            }
            System.out.println();

        }
    }

    public static void pattern_4(int n){
        for(int i=0; i<n; i++){
            for(char c='A'; c <='A'+i; c++){
                System.out.print(c);
            }
            System.out.println();
        }


    }

    public static void pattern_5(int n){
        for(int i=n; i > 0; i--){
            for(char c = 'A'; c <'A'+i; c++){
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void pattern_6(int n){
        char c = 'A';
        for(int i=1; i<= n; i++){
            for(int j=0; j<i; j++){
                System.out.print(c);
            }
            c++;
            System.out.println();
        }
    }

    public static void pattern_7(int n){
        for(int i=0; i<n; i++){
            for(int s=n-i; s > 0; s--){
                System.out.print(" ");
            }
            char c = 'A';
            for(int j=0; j<=i; j++){
                System.out.print(c);
                c++;
            }
            c--;
            for(char k=0; k<i; k++){
                c--;
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void pattern_8(int n){
//        char c = 'A';
//        for(int i=0; i<n; i++){
//            c++;
//        }
//        c--;
//        for(int j =0; j<n; j++){
//            char p = c;
//            for(char k = 0; k<=j ; k++){
//                System.out.print(p);
//                p++;
//            }
//            c--;
//            System.out.println();
//        }
        for(int i=0; i<n; i++){
            for(char c = (char)('A'+ n-1-i); c <= (char)(int)'A'+n-1; c++){
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void prefix_sum(int[] array){
        int sum = 0;
        int ans = -1;
        int prefix_sum = 0;
        for (int k : array) {
            sum += k;
        }
        for (int j=0; j< array.length; j++) {
            sum  = sum - array[j];
            if(sum == prefix_sum) ans = j;
            prefix_sum += array[j];
        }
        if(ans != -1) System.out.println(ans);
        else System.out.println("No");
    }

    public static void main(String[] args){
//        patternDiamond(3);
//        halfDiamond(5);
//        pattern_8(4);
        int[] array = {10,7,2,1,5,4,10};
//        for (int j : array) {
//            System.out.println(j);
//        }
        prefix_sum(array);
    }
}
