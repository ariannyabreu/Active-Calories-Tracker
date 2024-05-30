/*
	Arianny Abreu Gonzalez
	Program: Active Calories Tracker
	Date: 14 December 2023
	Description: Active Calories Tracker. This class represents an user. It stores the user's basic information
	and provides methods to interact with exercise sessions.
*/
import java.util.ArrayList;
import java.util.List;

public class User
{
    // Private fields to store user info.
    private String username;
    private int age;
    private float userWeight; // in kilograms.
    private List<ExerciseSession> sessions; // List to store user's exercise sessions.

    // Constructor for creating a new User.
    // Initializes a new user with the provided information.
    public User(String username, int age, float userWeight)
    {
        this.username = username;
        this.age = age;
        this.userWeight = userWeight;
        this.sessions = new ArrayList<>(); // To initialize the list of sessions.
    }

    // Adds a new exercise session to this user's session list.
    public void addExerciseSession(ExerciseSession session)
    {
        this.sessions.add(session); // Adds the session to the user's session list
    }

    // Adds a new exercise session with an additional note to this user's session list when note is provided.
    public void addExerciseSession(ExerciseSession session, String note)
    {
        this.sessions.add(session);
        System.out.println("Note for session: " + note); // JUST TO TEST and demonstrate method overload.
    }

    // Returns a formatted read only string containing the user's basic information.
    public String getUserInfo()
    {
        return "Username: " + username + ", Age: " + age + ", Weight: " + userWeight + " Kg";
    }

    // Method to retrieve the username (read only) of the user.
    public String getUsername()
    {
        return this.username;
    }

    // Retrieves the weight (read only) of the user.
    public float getWeight()
    {
        return userWeight;
    }
}
