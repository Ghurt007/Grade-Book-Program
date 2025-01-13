# Grade-Book-Program
This program is a Gradebook Management System that allows users to manage student data, perform grade-related calculations, and execute various commands to analyze or modify student information.

**### Features**

**1. Student Data Input**
Users can add students by entering their:

- First Name
- Last Name
- Panther ID (7 digits)
- Grade (0 to 100)

Input format:
firstName lastName PID grade

Type DONE when you finish entering student data.

**2. Commands**
After entering student data, you can execute various commands:

- min score: Displays the minimum score.
- min letter: Displays the minimum letter grade.
- max score: Displays the maximum score.
- max letter: Displays the maximum letter grade.
- letter <PID>: Displays the letter grade of a student based on their Panther ID.
- name <PID>: Displays the name of a student based on their Panther ID.
- average score: Displays the average score of all students.
- average letter: Displays the average letter grade.
- median score: Displays the median score of all students.
- median letter: Displays the median letter grade.
- tab scores: Prints a tabulated list of all students with their scores.
- tab letters: Prints a tabulated list of all students with their letter grades.
- change <PID> <newScore>: Updates the score of a student identified by their Panther ID.
- quit: Ends the program.

**3. Error Handling**
The program validates all inputs to ensure:

- First and last names contain only letters, with the first letter capitalized.
- Panther IDs are 7-digit numeric values and do not start with 0.
- Grades are numeric values between 0 and 100.

**Usage Instructions**

1. Run the program.
2. Enter student data in the required format:
firstName lastName PID grade

Example:
John Doe 1234567 80
3. Type DONE to finish entering data.
4. Use the commands listed above to interact with the gradebook.



