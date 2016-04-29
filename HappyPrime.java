import java.util.Scanner;

public class HappyPrime {

    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        int size = in.nextInt();
        for(int i = 0 ; i < size; i++){
            String answer = "NO";
            int number = in.nextInt();
            int candidate = in.nextInt();
            int d = 0;
            int fin = candidate;
            while(candidate != 1 && d < 100){
                String numString = candidate+"";
                int total = 0;
                candidate = 0;
                for(int k = 0; k < numString.length(); k++){
                    candidate+=Math.pow(Integer.parseInt(numString.substring(k, k+1)), 2);
                }
                d++;
            }
            if(candidate == 1 && isPrime(fin)){
                answer = "YES";
            }
            System.out.println(number+" "+fin+" "+answer);
        }        
    }
    
    public static boolean isPrime(int num){
        boolean prime = true;
        for(int i = num-1; i > 1; i--){
            if(num%i ==0){
                prime = false;
            }
        }
        if(num > 1){
            return prime;
        }
        return false;
    }
}