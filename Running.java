/*
	Arianny Abreu Gonzalez
	Program: Active Calories Tracker
	Date: 14 December 2023
	Description: Active Calories Tracker. This class represents a specific type of cardio exercise: Running.
	It extends the abstract class CardioExercise.
	It calculates calories burned using the Metabolic Equivalent of Task (MET).
*/

// Derived class from CardioExercise for Running.
class Running extends CardioExercise
{
    // MET (Metabolic Equivalent of Task) values for different running paces.
    private final double RUNNING_MET_SLOW = 6.0;
    private final double RUNNING_MET_MODERATE = 8.0;
    private final double RUNNING_MET_FAST = 10.0;
    private String pace;


    // Constructor for the Running class.
    public Running(int duration, String pace)
    {
        super("Running", duration);  // Call to the father class constructor with the type "Running" and given duration.
        this.pace = pace; // Default pace is moderate.
    }

    // Provides specific details about the running exercise. It returns a formatted String.
    @Override
    public String getExerciseDetails()
    {
        return "Running for "  + pace + " pace for " + duration + " minutes";
    }

    // Calculates the calories burned during running based on the user's weight and running pace.
    @Override
    public double calculateCaloriesBurned(double userWeight)
    {
        double metValue;
        switch (this.pace)
        {
            case "Slow":
                metValue = RUNNING_MET_SLOW;
                break;
            case "Fast":
                metValue = RUNNING_MET_FAST;
                break;
            default: // Assuming "moderate" as default
                metValue = RUNNING_MET_MODERATE;
                break;
        }

        double durationInHours = duration / 60.0; // Converts the duration in minutes to hours.
        double caloriesBurned = metValue * userWeight * durationInHours; // Calculate total calories burned in running exercise.
        return caloriesBurned; // Return the calculated calories burned value.
    }
}
