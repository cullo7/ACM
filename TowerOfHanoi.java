import java.util.Scanner;

public class TowerOfHanoi {

    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        int size = in.nextInt();
        for(int i = 0 ; i < size; i++){
            int input = in.nextInt();
            String line = in.nextLine().trim();
            String [] letters = line.split(" ");
            System.out.println("Hanoi!");
            findHanoi(input, letters[0], letters[2], letters[1]);
        }
    }
    
    public static void findHanoi(int num, String from, String to, String with){
        if(num >=1){
            findHanoi(num-1, from, with, to);
            moveDisc(from, to);
            findHanoi(num-1, with, to, from);
        }
    }
    
    public static void moveDisc(String from, String to){
        System.out.println(from+" -> "+to);
    }
}