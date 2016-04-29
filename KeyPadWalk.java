import java.util.Scanner;
import java.math.BigInteger;

public class KeyPadWalk {

    public static int possibilities = 1;
    
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        int size = in.nextInt();
        BigInteger TL = new BigInteger("1");//start at the top left corner
        BigInteger TM = new BigInteger("0");
        BigInteger TR = new BigInteger("0");
        BigInteger ML = new BigInteger("0");
        BigInteger MM = new BigInteger("0");
        BigInteger MR = new BigInteger("0");
        BigInteger BL = new BigInteger("0");
        BigInteger BM = new BigInteger("0");
        BigInteger BR = new BigInteger("0");
        BigInteger BB = new BigInteger("0");
        for(int i = 0 ; i < size-1; i++){
            //set the current values so you can use them to add to other node values without changing them
            BigInteger tempTL = TL;
            BigInteger tempTM = TM;
            BigInteger tempTR = TR;
            BigInteger tempML = ML;
            BigInteger tempMM = MM;
            BigInteger tempMR = MR;
            BigInteger tempBL = BL;
            BigInteger tempBM = BM;
            BigInteger tempBR = BR;
            BigInteger tempBB = BB;
            
            //adding top left to its connecting nodes
            TM = TM.add(tempTL);
            ML = ML.add(tempTL);
            
            //adding top middle to its connecting nodes
            TL = TL.add(tempTM);
            MM = MM.add(tempTM);
            TR = TR.add(tempTM);
            
            //adding top right to its connecting nodes
            TM = TM.add(tempTR);
            MR = MR.add(tempTR);
            
            //adding middle left to its connecting nodes
            TL = TL.add(tempML);
            MM = MM.add(tempML);
            BL = BL.add(tempML);
            
            //adding middle middle to its connecting nodes
            TM = TM.add(tempMM);
            ML = ML.add(tempMM);
            MR = MR.add(tempMM);
            BM = BM.add(tempMM);
            
            //adding middle right to its connecting nodes
            TR = TR.add(tempMR);
            MM = MM.add(tempMR);
            BR = BR.add(tempMR);
            
            //adding bottom left to its connecting nodes
            ML = ML.add(tempBL);
            BM = BM.add(tempBL);
            
            //adding bottom middle to its connecting nodes
            BL = BL.add(tempBM);
            MM = MM.add(tempBM);
            BR = BR.add(tempBM);
            BB = BB.add(tempBM);
            
            //adding bottom right to its connecting nodes
            MR = MR.add(tempBR);
            BM = BM.add(tempBR);
            
            //adding bottom bottom to its connecting nodes
            BM = BM.add(tempBB);
            
            //subtract each temp (original) key value from the current one
            //ones that were 0 will not be substract at all - as they now hold the value
            //ones with value will lose exactly what they equal as they should because
            //the values has oscillated back to empty nodes
            TL = TL.subtract(tempTL);
            TM = TM.subtract(tempTM);
            TR = TR.subtract(tempTR);
            ML = ML.subtract(tempML);
            MM = MM.subtract(tempMM);
            MR = MR.subtract(tempMR);
            BL = BL.subtract(tempBL);
            BM = BM.subtract(tempBM);
            BR = BR.subtract(tempBR);
            BB = BB.subtract(tempBB);
        }
        BigInteger total = new BigInteger("0");
        //add all the current possible solutions up
        total = total.add(TM);
        total = total.add(TL);
        total = total.add(TR);         
        total = total.add(ML);
        total = total.add(MM);
        total = total.add(MR);
        total = total.add(BL);
        total = total.add(BM);
        total = total.add(BR);
        total = total.add(BB);
        String eq = (int)Math.pow(10,9) + 7 +"";
        total = total.mod(new BigInteger(eq));
        System.out.println(total.intValue());
    }
}
