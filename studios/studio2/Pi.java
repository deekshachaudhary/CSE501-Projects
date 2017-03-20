package studio2;

import cse131.ArgsProcessor;

public class Pi {

	public static void computePi() {
		
		
//		double boardDiameter = ap.nextDouble("Enter the size of the dart board");
//		double circleDiameter = ap.nextDouble("Enter the size of the circle you wanna draw");
		
		double boardDiameter = 1.0;
		double circleDiameter = 0.5;
		double boardRadius = boardDiameter / 2;
		double circleRadius = circleDiameter / 2;	 
		double ans = 0.0;
		int numCircle = 0;
		int numThrows = 1000;
		double areaBoard = Math.PI * boardRadius * boardRadius;
		double areaCircle = Math.PI * circleRadius * circleRadius;
		double circleRatioRest = 0.0;
     
		for(int i = 0; i < numThrows; i++) {
    	 
			if(Math.random() * areaCircle < ((areaBoard - areaCircle) / areaCircle)) {
				
				numCircle++;
			}
				
		}
		
		ans = (numThrows - numCircle) / (Math.pow(boardRadius, 2) - Math.pow(circleRadius, 2));
     
     System.out.println("The program shows Pi = " + ans);
  }

  public static void main(String[] args) {
	  
//	  ArgsProcessor ap = new ArgsProcessor(args);
	  
	  computePi();
  }
}