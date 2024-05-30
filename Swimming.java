/*
	Arianny Abreu Gonzalez
	Program: Active Calories Tracker
	Date: 14 December 2023
	Description: Active Calories Tracker. This class represents a specific type of cardio exercise: Swimming.
	It extends the abstract class CardioExercise.
	It calculates calories burned using the Metabolic Equivalent of Task (MET).
*/

class Swimming extends CardioExercise
{
    // MET values for different swimming paces.
    private final double SWIMMING_MET_SLOW = 5.0;
    private final double SWIMMING_MET_MODERATE = 7.0;
    private final double SWIMMING_MET_FAST = 9.0;
    private String pace;

    // Constructor for the Swimming class.
    public Swimming(int duration, String pace)
    {
        super("Swimming", duration);
        this.pace = pace; // Set swimming pace.
    }

    // Provides specific details about the swimming exercise.
    @Override
    public String getExerciseDetails()
    {
        return "Swimming at " + pace + " pace for " + duration + " minutes";
    }

    // Calculates the calories burned during swimming based on the user's weight and swimming pace.
    @Override
    public double calculateCaloriesBurned(double userWeight)
    {
        double metValue;
        switch (this.pace)
        {
            case "Slow":
                metValue = SWIMMING_MET_SLOW;
                break;
            case "Fast":
                metValue = SWIMMING_MET_FAST;
                break;
            default: // Assuming "Moderate" as default.
                metValue = SWIMMING_MET_MODERATE;
                break;
        }

        double durationInHours = duration / 60.0;
        double caloriesBurned = metValue * userWeight * durationInHours; // Calculate total calories burned in swimming exercise.
        return caloriesBurned; // Return the calculated calories burned value.
    }
}
