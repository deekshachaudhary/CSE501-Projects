package lab1;

import cse131.ArgsProcessor;

public class Nutrition {

	public double singleDigitPrecision(double number) {
		
		double integerPart = (int) number;							//50.0, 45.0		
		double floatingPart = number - integerPart;					//0.92, 0.16
		floatingPart = floatingPart * 10; 
		double roundedFloatingPart = Math.round(floatingPart);		//9, 2, 3		
		double finalFloatingPart = roundedFloatingPart / 10;		//0.9, 0.2, 0.3
		
		return integerPart + finalFloatingPart;

	}

	
	public static void main(String[] args) {

		ArgsProcessor ap = new ArgsProcessor(args);
		Nutrition obj = new Nutrition();
		String name = ap.nextString("Enter the name of this food");
		
		double carbs = ap.nextDouble("Enter the number of grams of carbohydrates in this food");
		double fat = ap.nextDouble("Enter the number of grams of fat in this food");
		double protein = ap.nextDouble("Enter the number of grams of protein in this food");
		double statedCals = ap.nextDouble("Enter the number of Calories stated on this food's label");
		
		//calories per gram of carbs, fat, protein
		double carbsCalsPerGram = 4;
		double fatCalsPerGram = 9;
		double proteinCalsPerGram = 4;
		
		//calories = grams * calsPerGram
		double carbsCals = obj.singleDigitPrecision(carbs * carbsCalsPerGram);
		double fatCals = obj.singleDigitPrecision(fat * fatCalsPerGram); 		
		double proteinCals = obj.singleDigitPrecision(protein * proteinCalsPerGram); 	
		
		double addedCals = carbsCals + fatCals + proteinCals;
		double unavailableCals = obj.singleDigitPrecision(addedCals - statedCals);
		
		// number of grams in dietaryFiber = cals / calsPerGram
		double gramsOfDietaryFiber = unavailableCals / carbsCalsPerGram;
				
		//making the percentage single precision
		double carbsPercent = obj.singleDigitPrecision(carbsCals / statedCals * 100);
		double fatPercent = obj.singleDigitPrecision(fatCals / statedCals * 100);
		double proteinPercent = obj.singleDigitPrecision(proteinCals / statedCals * 100);		

		boolean lowCarb = false;
		boolean lowFat = false;
		boolean heads = false;
				
		if (carbsPercent <= 25) {
			
			lowCarb = true;
		}
		
		if (fatPercent <= 15) {
			lowFat = true;
		}
		
		if (Math.random() < 0.5) {
			heads = true;
		}
		
		
		System.out.println(name+ " has\n"
							+carbs+ " grams of carbohydrates = " +carbsCals+ " Calories\n"
							+fat+ " grams of fat = " +fatCals+ " Calories\n"
							+protein+ " grams of protein = " +proteinCals+ " Calories\n\n"
							
							+ "This food is said to have " +statedCals+ " (available) Calories.\n"
							+ "With " +unavailableCals+ " unavailable Calories, this food has " +gramsOfDietaryFiber+ " grams of Fiber\n\n"
							
							+ "Approximately\n"
							+carbsPercent+ "% of your food is Carbohydrates\n"
							+fatPercent+ "% of your food is Fat\n"
							+proteinPercent+ "% of your food is Protein\n\n"
							
							+"This food is acceptable for a low-carb diet?  " +lowCarb+ "\n"
							+"This food is acceptable for a low-fat diet?  " +lowFat+ "\n"
							+"By coin flip, you should eat this food?  " +heads);

		}
		
	}
