package lab1;
import cse131.ArgsProcessor;

public class Nutrition {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		boolean lowCarbDiet = false;
		boolean lowFatDiet = false;
		boolean shouldEat = false;
		double carbsPercent, fatPercent, proteinPercent;

		String name = ap.nextString("Enter the name of this food: ");
		double carbs = ap.nextDouble("Enter the number of grams of carbohydrates in this food: ");
		double fat = ap.nextDouble("Enter the number of grams of fat in this food: ");
		double protein = ap.nextDouble("Enter the number of grams of protein in this food: ");
		double statedCals = ap.nextDouble("Enter the number of grams of calories stated in this food: ");
		
		double carbsCals = (double) Math.round(carbs * 4 * 10) / 10;
		double fatCals = (double) Math.round(fat * 9 * 10) / 10;
		double proteinCals = (double) Math.round(protein * 4 * 10) / 10;
		double calculatedCals = carbsCals + fatCals + proteinCals;
		
		double fiberCals = (double) Math.round((calculatedCals - statedCals) * 10) / 10;
		double fiber = fiberCals / 4;
		
		carbsPercent = (double) Math.round(carbsCals / statedCals * 1000) / 10;
		fatPercent = (double) Math.round(fatCals / statedCals * 1000) / 10;
		proteinPercent = (double) Math.round(proteinCals / statedCals * 1000) / 10;
		
		if (carbsPercent <= 25) {
			lowCarbDiet = true;
		}
		if (fatPercent <= 15) {
			lowFatDiet = true;
		}
		
		if (Math.random() > 0.5) {
			shouldEat = true;
		}
		
		System.out.println(name+" has");
		System.out.println("\t"+carbs+" grams of carbohydrates = "+carbsCals+ " Calories");
		System.out.println("\t"+fat+" grams of fat = "+fatCals+" Calories");
		System.out.println("\t"+protein+" grams of protein = "+proteinCals+" Calories");
		System.out.println("This food is said to have "+statedCals+" (available) Calories");
		System.out.println("With "+fiberCals+" unavailable Calories, this food has "+fiber+" grams of fiber\n");
		System.out.println("Approximately");
		System.out.println("\t"+carbsPercent+"% of your food is carbohydrates");
		System.out.println("\t"+fatPercent+"% of your food is fat");
		System.out.println("\t"+proteinPercent+"% of your food is protein\n");
		System.out.println("This food is acceptable for low-carb diet? "+lowCarbDiet);
		System.out.println("This food is acceptable for low-fat diet? "+lowFatDiet);
		System.out.println("By coin flip, you should eat this food? "+shouldEat);
	}

}
