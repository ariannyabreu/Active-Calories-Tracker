/*
	Arianny Abreu Gonzalez
	Program: Active Calories Tracker
	Date: 14 December 2023
	Description: Active Calories Tracker. This class represents an exercise session in the program.
	It holds the details of a single exercise session, including the date of the session,
    a list of exercises performed during the session, and the total calories burned.
*/

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Class to represent an exercise session.
public class ExerciseSession
{
    private LocalDate date;
    private List<CardioExercise> exercises;
    private double userWeight; // Add the userWeight field

    // Constructor for the ExerciseSession class.
    public ExerciseSession(double userWeight)
    {
        this.date = LocalDate.now(); // Sets the session date to the current date.
        this.userWeight = userWeight;
        this.exercises = new ArrayList<>(); // Initializes an empty list for storing exercises.
    }

    // Adds a cardio exercise to the exercise session. Adds a CardioExercise object to the exercises list.
    public void addExercise(CardioExercise exercise)
    {
        exercises.add(exercise); // Adds an exercise to the session
    }

    /* Calculates the total calories burned in the session.
       This method iterates over each CardioExercise in exercises the session,
       it calculates calories burned using each exercise's specific calorie calculation logic.
    */
    public double getTotalCaloriesBurned()
    {
        double totalCalories = 0;

        for (CardioExercise exercise : exercises)
        {
            // Directly call calculateCaloriesBurned on each CardioExercise object.
            // Calculates and sums up the calories burned for each exercise
            totalCalories += exercise.calculateCaloriesBurned(userWeight);
        }
        return totalCalories;
    }

    // Retrieves a formatted string with the details about the exercise session, including the date.
    public String getSessionDetails()
    {
        // StringBuilder is more efficient than using regular string concatenation in a loop.
        StringBuilder details = new StringBuilder("Session on " + date + "\n");

        // For loop that iterates over each element in the exercises list.
        for (CardioExercise exercise : exercises)
        {
            // getExerciseDetails() method is called on the current CardioExercise object exercise.
            details.append(exercise.getExerciseDetails()).append("\n");
        }
        return details.toString();
    }
}
