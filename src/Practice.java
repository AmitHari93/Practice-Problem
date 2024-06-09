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

    public static void main(String[] args){
//        patternDiamond(3);
//        halfDiamond(5);
//        pattern_1(7);
//        pattern_2(5);
//        pattern_3(4);
        pattern_4(4);
    }
}
