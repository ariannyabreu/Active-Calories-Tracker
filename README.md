# Active Calories Tracker

**Arianny Abreu Gonzalez**

## Overview

The Active Calories Tracker is a Swing-based GUI application that calculates and tracks the calories burned during different types of exercise. It allows users to input exercise details and view the total calories burned. This project was created as part of a course project to learn and apply Java Swing for building graphical user interfaces.

## Features

- **User Input:** Users can enter their details such as username, age, weight, and exercise duration.
- **Exercise Types:** Supports different types of cardio exercises like running and swimming.
- **Exercise Pace:** Users can select the pace of their exercise (slow, moderate, fast).
- **Session Notes:** Allows users to add notes about their exercise sessions.
- **Calorie Calculation:** Calculates and displays the calories burned based on user inputs and exercise details.
- **Session Details:** Displays detailed information about each exercise session.
- **File Logging:** Logs session details to a file for future reference.

## Installation

1. **Clone the repository:**
    ```sh
    git clone https://github.com/ariannyabreu/Active-Calories-Tracker.git
    ```
2. **Navigate to the project directory:**
    ```sh
    cd Active-Calories-Tracker
    ```
3. **Open the project in IntelliJ IDEA or any other Java IDE.**

## Usage

1. **Run the `ActiveCaloriesTrackerGUI` class.**
2. **Input the required user details in the text fields.**
3. **Select the exercise type and pace from the combo boxes.**
4. **Enter the duration of the exercise in minutes.**
5. **Click on the "Calculate Calories" button to view the calories burned.**
6. **Optionally, add notes about the session in the provided field.**
7. **Session details and calories burned will be displayed in the result area and logged to a file.**

## Code Structure

- **ActiveCaloriesTrackerGUI:** Main class responsible for creating and managing the user interface.
- **CardioExercise:** Abstract base class for different types of cardio exercises.
  - **Running:** Derived class representing running exercise with calorie calculation logic.
  - **Swimming:** Derived class representing swimming exercise with calorie calculation logic.
- **ExerciseSession:** Class representing a session of exercises with methods to add exercises and calculate total calories burned.
- **User:** Class representing a user with methods to manage user information and exercise sessions.

## Screenshots

![Screenshot](https://github.com/ariannyabreu/Active-Calories-Tracker/blob/main/screenshot.521.jpg)

![Screenshot](https://github.com/ariannyabreu/Active-Calories-Tracker/blob/main/screenshot.522.jpg)

![Screenshot](https://github.com/ariannyabreu/Active-Calories-Tracker/blob/main/screenshot.523.jpg)

