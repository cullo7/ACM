import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        int size = in.nextInt();
        for(int i = 0 ; i < size; i++){
            double diameter = in.nextDouble();
            double revolutions = in.nextDouble();
            double time = in.nextDouble();
            time = time/3600;
            double c = Math.PI * (diameter/63360);
            double distance = c * revolutions;
            double mph = distance/time;
            System.out.printf(i+1+" %.2f %.2f",distance, mph);
            System.out.println();
        }        
    }
}