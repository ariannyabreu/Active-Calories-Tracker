/*
	Arianny Abreu Gonzalez
	Program: Active Calories Tracker
	Date: 14 December 2023
	Description: Active Calories Tracker. This is an abstract class representing a generic cardio exercise.
	This class serves as a base (superclass) for specific types of cardio. It is designed to be extended, not instantiated.
	It defines common properties and methods to all cardio exercises.
*/

// Base class for different types of cardio exercises.
abstract class CardioExercise
{
    // Protected access, so that they can be accessed within CardioExercise subclasses.
    protected String type;  // Type of the cardio
    protected int duration; // Duration of exercise in minutes

    // Constructor for the CardioExercise class.
    // Initializes a new instance of a cardio exercise with the specified type and duration.
    public CardioExercise(String type, int duration)
    {
        this.type = type; // Assigns the type of the cardio exercise.
        this.duration = duration; // Assigns the duration fo the cardio.
    }

    // Abstract method to be implemented in derived classes to calculate calories.
    public abstract double calculateCaloriesBurned(double userWeight);

    // Abstract method to be overridden in derived classes to get details of the exercise, depending on its type.
    public abstract String getExerciseDetails();
}
