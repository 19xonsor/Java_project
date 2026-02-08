import java.util.Scanner;

public class MealPlanner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Program constants
        final int FEMALE_CALORIES = 2000;
        final int MALE_CALORIES = 2500;

        final double BREAKFAST_COST = 5.0;
        final int BREAKFAST_CAL = 400;

        final double LUNCH_COST = 8.0;
        final int LUNCH_CAL = 700;

        final double DINNER_COST = 10.0;
        final int DINNER_CAL = 900;

        // User input
        System.out.print("Enter your daily meal budget: ");
        double budget = input.nextDouble();

        System.out.print("Select gender (M/F): ");
        char gender = input.next().charAt(0);

        int recommendedCalories;
        if (gender == 'M' || gender == 'm') {
            recommendedCalories = MALE_CALORIES;
        } else {
            recommendedCalories = FEMALE_CALORIES;
        }

        // Meal selection
        System.out.println("Choose a meal:");
        System.out.println("1. Breakfast");
        System.out.println("2. Lunch");
        System.out.println("3. Dinner");
        System.out.print("Enter choice: ");
        int choice = input.nextInt();

        double mealCost = 0;
        int mealCalories = 0;

        if (choice == 1) {
            mealCost = BREAKFAST_COST;
            mealCalories = BREAKFAST_CAL;
        } else if (choice == 2) {
            mealCost = LUNCH_COST;
            mealCalories = LUNCH_CAL;
        } else if (choice == 3) {
            mealCost = DINNER_COST;
            mealCalories = DINNER_CAL;
        }

        double remainingBudget = budget - mealCost;

        // Output
        System.out.println("Meal cost: $" + mealCost);
        System.out.println("Calories consumed: " + mealCalories);
        System.out.println("Remaining budget: $" + remainingBudget);

        int caloriesLeft = recommendedCalories - mealCalories;

        if (caloriesLeft > 0) {
            System.out.println("You still need " + caloriesLeft + " calories today.");
        } else {
            int excess = Math.abs(caloriesLeft);
            double miles = excess / 100.0;
            System.out.println("You exceeded your goal by " + excess + " calories.");
            System.out.println("You should jog about " + miles + " miles.");
        }

        input.close();
    }
}
