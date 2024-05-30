/*
	Arianny Abreu Gonzalez
	Program: Active Calories Tracker
	Date: 14 December 2023
	Description: Active Calories Tracker Program GUI.
	This class is responsible for creating and managing the user interface. Swing-based application that tracks the calories burned
	during different types of exercise. It allows users to input exercise details and view the total calories burned.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class ActiveCaloriesTrackerGUI extends WindowAdapter {
    // GUI components declaration.
    private JFrame frame; // Main window of the application.
    private JTextField usernameField, ageField, weightField, exerciseDurationField; // Text fields for user input.
    private JComboBox<String> exerciseTypeComboBox; // ComboBox for selecting exercise type.
    private JComboBox<String> exercisePaceComboBox; // ComboBox for selecting exercise pace.
    private JTextField sessionNoteField; // Field for entering notes about the session.
    private JButton calculateCaloriesButton; // Button for calorie calculation.
    private JTextArea resultArea; // Text area to display results.
    private User currentUser; // An object that represents the current user of the application.

    // Method to set up and display the GUI.
    public void go() {
        frame = new JFrame("Active Calories Tracker");

        // Calls methods to initialize and arrange GUI components.
        JPanel inputPanel = setupInputPanel();
        JPanel buttonPanel = setupButtonPanel();
        JScrollPane scrollPane = setupScrollPane();

        // Adds the panels to different regions of the frame.
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(scrollPane, BorderLayout.SOUTH);

        // Adjusts the frame size and makes it visible.
        frame.setSize(600, 500);
        frame.setVisible(true);
    }

    // Creates and returns a JPanel with a vertical BoxLayout, containing labeled input fields and combo boxes for user data and exercise details.
    private JPanel setupInputPanel() {
        // Panel to hold various input fields vertically.
        JPanel inputPanel = new JPanel();
        // Components added to inputPanel will be stacked top to bottom.
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

        // Adding labeled text fields and combo boxes to the panel.
        inputPanel.add(createInputFieldPanel("Username: ", usernameField = new JTextField(20)));
        inputPanel.add(createInputFieldPanel("Age: ", ageField = new JTextField(5)));
        inputPanel.add(createInputFieldPanel("Weight (kg): ", weightField = new JTextField(5)));
        inputPanel.add(createInputFieldPanel("Exercise Duration (min): ", exerciseDurationField = new JTextField(5)));
        inputPanel.add(createComboBoxPanel("Exercise Type: ", exerciseTypeComboBox = new JComboBox<>(new String[]{"Running", "Swimming", "Cycling"})));
        inputPanel.add(createComboBoxPanel("Pace: ", exercisePaceComboBox = new JComboBox<>(new String[]{"Slow", "Moderate", "Fast"})));
        sessionNoteField = new JTextField(20);
        inputPanel.add(createInputFieldPanel("Session Note: ", sessionNoteField));

        return inputPanel;
    }

    // Helper method tht creates and returns a panel with a label and text field, used for inputting user data.
    private JPanel createInputFieldPanel(String label, JTextField textField) {
        // Panel with a horizontal layout to hold a label and text field.
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(new JLabel(label)); // Adds a label for the text field.
        panel.add(textField); // Adds the text field next to the label.

        return panel;
    }

    // Creates and returns a panel with a label and combo box, used for selecting options.
    private JPanel createComboBoxPanel(String label, JComboBox<String> comboBox) {
        // Panel with a horizontal layout to hold a label and combo box.
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(new JLabel(label));  // Adds a label for the combo box.
        panel.add(comboBox); // Adds the combo box next to the label.

        return panel;
    }

    // Sets up and returns a panel with the Calculate Calories button.
    private JPanel setupButtonPanel() {
        // Panel with centered layout for the button.
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        calculateCaloriesButton = new JButton("Calculate Calories");

        // Attaches an event listener to the button for handling click events.
        calculateCaloriesButton.addActionListener(new CalculateCaloriesHandler());
        buttonPanel.add(calculateCaloriesButton);

        return buttonPanel;
    }

    // Sets up and returns a scrollable text area for displaying the results.
    private JScrollPane setupScrollPane() {
        resultArea = new JTextArea(10, 30); // Initializes the JTextArea with 10 rows and 30 columns.
        resultArea.setEditable(false); // Disables editing, making it read-only for displaying results.
        return new JScrollPane(resultArea); // Wraps the JTextArea in a JScrollPane for scroll functionality.
    }

    // Window closing event handling.
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    private void writeToFile(String text) {
        // Tries to open and write to a file, and catches any IOException that might occur.
        // true: the file is opened in append mode, new data will be added to the end of the file rather than overwriting existing data.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("CardioExerciseSessionDetails.txt", true))) {
            writer.write(text); // Writes the provided text to the file.
            writer.newLine(); // Adds a newline character after writing for formatting.
        } catch (IOException e) {
            e.printStackTrace(); // Prints the IOException to the console.
        }
    }

    // Inner class for handling the action of the Calculate Calories button.
    public class CalculateCaloriesHandler implements ActionListener {
        // This method is called when the associated action event clicking the Calculate Calories button occurs.
        public void actionPerformed(ActionEvent e) {
            try {
                // Retrieve user input from GUI fields and updates (parses) user input
                String username = usernameField.getText();
                int age = Integer.parseInt(ageField.getText()); // Takes a string and converts it to an int
                float weight = Float.parseFloat(weightField.getText()); // Takes a string and converts it to a float.

                // Checks if currentUser is null or if the username has changed.
                if (currentUser == null || !currentUser.getUsername().equals(username)) {
                    // Creates a new User object if it doesn't exist or the username has changed.
                    currentUser = new User(username, age, weight);
                }

                // Add Exercise Session based on user input.
                String selectedExercise = (String) exerciseTypeComboBox.getSelectedItem(); // Gets the selected item from exerciseTypeComboBox.
                int duration = Integer.parseInt(exerciseDurationField.getText()); // Parses the exercise duration from exerciseDurationField.
                CardioExercise exercise = null; // Initializes a CardioExercise object to null.
                String pace = (String) exercisePaceComboBox.getSelectedItem(); // Gets the selected pace from exercisePaceComboBox.

                // Determines the type of exercise selected and creates an appropriate object.
                switch (selectedExercise) {
                    case "Running":
                        exercise = new Running(duration, pace);
                        break;
                    case "Swimming":
                        exercise = new Swimming(duration, pace);
                        break;
                    case "Cycling":
                        // NEED to implement logic for Cycling****
                        break;
                }

                // Add the created exercise to the user's current session.
                //  Checks if an exercise object was created.
                if (exercise != null) {
                    ExerciseSession session = new ExerciseSession(currentUser.getWeight());
                    session.addExercise(exercise);
                    currentUser.addExerciseSession(session); // Add the session to the user

                    // Calculate calories for the latest session
                    double caloriesBurned = session.getTotalCaloriesBurned();

                    // Build the result string with session details and calories burned
                    String resultText = currentUser.getUserInfo() + "\n" +
                            "Session Details:\n" + session.getSessionDetails() +
                            "\nCalories Burned in This Session: " + caloriesBurned + "\n";

                    // Sets the result text in the result area and write to file.
                    resultArea.setText(resultText);
                    writeToFile(resultText);
                }
                // Clear all input fields after processing.
                usernameField.setText("");
                ageField.setText("");
                weightField.setText("");
                exerciseDurationField.setText("");
                sessionNoteField.setText("");
            } catch (NumberFormatException ex) {
                // Shows an error dialog if the input values are not valid numbers.
                JOptionPane.showMessageDialog(frame, "Please enter valid numbers for age, weight, and duration.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
