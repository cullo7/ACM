import java.util.ArrayList;
import java.util.Scanner;

public class ScavengerHunt {
	
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		double curX = in.nextDouble();
		double curY = in.nextDouble();
		int size = in.nextInt();
		ArrayList<Double> x = new ArrayList<>();
		ArrayList<Double> y = new ArrayList<>();
		for(int i = 0; i < size; i++){
			x.add(in.nextDouble());
			y.add(in.nextDouble());
		}
		double totalDistance = 0;
		for(int k = 0; k < size; k++){
			double min = 2;
			int index = 0;
			for(int i = 0; i < x.size(); i ++){
				double dist = calculateDistance(curX, curY, x.get(i), y.get(i));
				if(dist < min){
					min = dist;
					index = i;
				}
			}
			totalDistance+=min;
			curX = x.remove(index);
			curY = y.remove(index);
		}
		System.out.println(String.format("%.5f", totalDistance));
	}
	
	public static double calculateDistance(double startX, double startY, double endX, double endY){
		return Math.sqrt(Math.pow(Math.abs(endX-startX), 2) + Math.pow(Math.abs(endY-startY), 2));
	}
}