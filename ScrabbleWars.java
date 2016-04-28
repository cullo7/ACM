import java.util.Scanner;
import java.util.ArrayList;

public class ScrabbleWars {

    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        ArrayList<Integer> melScores = new ArrayList<>();
        ArrayList<Integer> jesScores = new ArrayList<>();
        int jOverall = 0;
        int mOverall = 0;
        String winnerThread = "";
        boolean notOver = true;
        while(in.hasNext()){
            String [] moves = (in.nextLine()).split(" "); 
            String mel = moves[0];
            String jes = moves[1];
            int melScore = 0;
            int jesScore = 0;
            ArrayList<Character> compare = new ArrayList<>();
            for(int i = 0; i < mel.length(); i++){
                melScore+=getVal(mel.charAt(i));
                compare.add(mel.charAt(i));
            }
            for(int i = 0; i < jes.length(); i++){
                if(compare.contains(jes.charAt(i))){
                    melScore-=getVal(jes.charAt(i));
                    compare.remove((Object)jes.charAt(i));
                }
                else{
                    jesScore+=getVal(jes.charAt(i));
                }
            }
            compare.clear();
            melScores.add(melScore);
            jesScores.add(jesScore);
            jOverall+=jesScore;
            mOverall+=melScore;
            if(jOverall >= 100 && mOverall >= 100 && notOver){
                winnerThread = "Cheater caught in round "+melScores.size()+"!";
                notOver = false;
            }
            else if(jOverall >= 100 && notOver){
                winnerThread = "Jesse wins during round "+melScores.size()+", "+jOverall+"-"+mOverall+"!";
                notOver = false;
            }
            else if(mOverall >= 100 && notOver){
                winnerThread = "Uncle Mel wins during round "+melScores.size()+", "+mOverall+"-"+jOverall+"!";
                notOver = false;
            }
        }
        if(winnerThread.length() == 0){
            winnerThread = "No winner!";
        }
        for(int i = 1; i <= melScores.size(); i++){
            System.out.println("Round "+i+": "+melScores.get(i-1)+" "+jesScores.get(i-1));
        }
        System.out.println(winnerThread);
    }
    
    public static int getVal(char c){
                if(c == 'E' ||c ==  'A' || c == 'I' || c == 'O' || c == 'N' || c == 'R' || c == 'T' || c == 'L' || c == 'S' || c == 'U'){
                    return 1;
                }
                if(c == 'D' || c == 'G'){
                    return 2;
                }
                if(c == 'B' || c == 'C' || c == 'M' || c == 'P'){
                    return 3;
                }
                if(c == 'F' || c == 'H' || c == 'V' || c == 'W' || c == 'Y'){
                    return 4;
                }
                if(c == 'K'){
                    return 5;
                }
                if(c == 'J' || c == 'X'){
                    return 8;
                }
                if(c == 'Q' || c == 'Z'){
                    return 10;
                }
                return 0;
            }
}