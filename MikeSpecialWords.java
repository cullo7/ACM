import java.util.Scanner;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        int size = in.nextInt();
        String kill = in.nextLine();//empty line is passed as input for some reason
        for(int i = 0 ; i < size; i++){
            String word = in.nextLine();
            String answer = "YES";
            ArrayList<Character> first  = new ArrayList<>();
            ArrayList<Character> second  = new ArrayList<>();
            for(int k = 0; k < word.length()/2; k++){
                first.add(word.charAt(k));
                second.add(word.charAt(word.length()-1-k));
            }
            for(int k = 0; k < word.length()/2; k++){
                if(first.contains(second.get(k))){
                    first.remove(second.get(k));
                }
            }
            if(first.size() != 0){
                answer = "NO";
            }
            System.out.println(answer);
            first.clear();
            second.clear();
        }
    }
}