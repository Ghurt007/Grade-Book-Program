
    package main;
    import util.Grade;
    import util.Gradebook;
    import util.Student;

    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {


            Scanner sc;
            sc = new Scanner(System.in);
            Gradebook myGradebook = new Gradebook();

            System.out.println("Welcome to my grade book!\n" +
                    "Please enter the information of the first student using the following format:\n" +
                    "“firstName lastName PID grade”.\n" +
                    "Press Enter when you are done.");


            boolean mistake;
            while (true) {

                String line = sc.nextLine();
                if (line.equals("DONE"))
                    break;// end of input handling phase
                String[] tokens = line.split(" ");
                if (tokens.length != 4) {
                    //complain about not having the correct format
                    System.out.println("Try Again");
                    continue;//try again
                }

                String firstName = tokens[0];
                String lastName = tokens[1];
                String pIdString = tokens[2];
                String scoreString = tokens[3];
                mistake = false;
                for (int i = 0; i < firstName.length(); i++) {        // makes sure only alphabetical letters are included
                    if (!Character.isLetter(firstName.charAt(i)))
                        mistake = true;

                    if (mistake) {          // if mistake try again
                        //complain about not having the correct format
                        continue;//try again
                    }
                }


                String letter = String.valueOf(firstName.charAt(0));        // makes sure the first letter of the last name is capitalized
                if (!letter.matches("[A-Z]+")) {
                    mistake = true;

                    if (mistake) {      //if mistake try again
                        //complain about not having the correct format
                        System.out.println("Try Again");
                        continue;//try again
                    }
                }


                for (int y = 0; y < lastName.length(); y++) {        // makes sure only alphabetical letters are included
                    if (!Character.isLetter(lastName.charAt(y)))
                        mistake = true;
                    if (mistake) {                  // if mistake then try again
                        //complain about not having the correct format
                        continue;//try again
                    }
                }



                int counter = 0;                    // Finds how many "." chars there are in the given input
                char dot = '.';
                for (int i = 0; i < lastName.length(); i++) {
                    if (lastName.charAt(i) == dot) {
                        counter++;
                    }
                }

                if (counter > 1) {              // if there are more than
                    System.out.println("Invalid input");
                    continue;
                }



                String letter2 = String.valueOf(lastName.charAt(0));  // makes sure the first letter of the last name is capitalized
                if (!letter2.matches("[A-Z]+")) {
                    mistake = true;
                    if (mistake) {                  // if mistake then try again
                        //complain about not having the correct format
                        System.out.println("Try Again");
                        continue;//try again
                    }
                }


                if (pIdString.length() != 7) {                          //makes sure the length of the pantherID string is = 7
                    //complain about not having the correct format
                    System.out.println("Try Again");
                    continue;//try again

                }

                if ((Character.toString(pIdString.charAt(0))).equals("0")) {               // makes sure that the first character of the pID is !0
                    //complain about not having the correct format
                    System.out.println("Try Again");
                    continue;//try again
                }


                mistake = false;
                for (int i = 0; i < pIdString.length(); i++) {                      // this makes sure that the string is composed only of numerical digits
                    if (!Character.isDigit(pIdString.charAt(i)))
                        mistake = true;
                    if (mistake) {
                        //complain about not having the correct format
                        //  System.out.println("Try Again");
                        continue;//try again

                    }
                }
                int score = Integer.valueOf(scoreString);                               // makes sure the score have a value between 0 and 100
                if (score < 0 || score > 100) {
                    //complain about not having the correct format
                    System.out.println("Try Again");
                    continue;//try again
                }

                // do more error checking, if all is fine create new student and add it to gradebook
                myGradebook.addStudent(firstName, lastName, pIdString, scoreString);


                System.out.println("Please enter the information of the next student using the same format.\n" +            //request input
                        "If there is no more students, please enter the keyword “DONE”.\n" +                // continues after the user inputs "DONE"
                        "Press Enter when you are done.");


            }

            System.out.println("Please Enter a Command");                       // asks for a command
            while (true) {
                Scanner sc2 = new Scanner(System.in);       // new scanner
                String commandInput = sc2.nextLine();       //String variable that takes value of scanner input
                String[] tokens = commandInput.split(" ");      //string array "tokens" split by each white space

                if (commandInput.equals("min score")) {             //begin if min score command is given
                    double minScore = myGradebook.getListOfStudents().get(0).getGrade().getScore();     //variable is created in order to find the lowest score
                    for (Student min : myGradebook.getListOfStudents()) {            // enhanced for loop
                        if (min.getGrade().getScore() > minScore) {                 // checks which is lesser
                            minScore = min.getGrade().getScore();                // if it is lesser than the value held by the variable, the variable takes in that value
                        }
                    }
                    System.out.println(minScore);                       //print min
                    System.out.println("Please enter a new command");
                    continue;
                }


                if (commandInput.equals("min letter")) {                                        //if this command is given the lowest letter grade is found
                    double findMinLetter = myGradebook.getListOfStudents().get(0).getGrade().getScore();         //variable is created in order to find the lowest letter grade
                    for (Student min : myGradebook.getListOfStudents()) {                                   // enhanced for loop
                        if (min.getGrade().getScore() < findMinLetter) {                                    // checks which is lesser
                            findMinLetter = min.getGrade().getScore();                                      // if it is lesser than the value held by the variable, the variable takes in that value
                        }
                    }
                    Grade minGrade = new Grade(findMinLetter);
                    System.out.println(minGrade.getLetterGrade());                  //print min
                    System.out.println("Please enter a new command");
                    continue;
                }


                if (commandInput.equals("max score")) {                                             // if this command is given the highest score is found
                    double maxScore = myGradebook.getListOfStudents().get(0).getGrade().getScore();      //variable is created in order to find the highest score
                    for (Student max : myGradebook.getListOfStudents()) {                                // enhanced for loop
                        if (max.getGrade().getScore() > maxScore) {                                         // checks which is greater
                            maxScore = max.getGrade().getScore();                                      // if it is greater than the value held by the variable, the variable takes in that value
                        }
                    }
                    System.out.println(maxScore);                                   // print max
                    System.out.println("Please enter a new command");
                    continue;
                }

                if (commandInput.equals("max letter")) {                //if this command is given the highest letter grade is found
                    double findMaxLetter = myGradebook.getListOfStudents().get(0).getGrade().getScore();        //variable is created in order to find the highest letter grade
                    for (Student max : myGradebook.getListOfStudents()) {                               // enhanced for loop
                        if (max.getGrade().getScore() > findMaxLetter) {                                // checks which is greater
                            findMaxLetter = max.getGrade().getScore();                                  // if it is greater than the value held ny the variable, the variable takes in that value
                        }
                    }
                    Grade maxGrade = new Grade(findMaxLetter);
                    System.out.println(maxGrade.getLetterGrade());                  // prints max
                    System.out.println("Please enter a new command");
                    continue;
                }

                if (tokens[0].equals("letter")) {                               //if this command is given a letter grade is found based on pID
                    for (Student letter : myGradebook.getListOfStudents())           //enhanced for loop
                        if (Integer.valueOf(tokens[1]).equals(letter.getPid())) {       //if pID matched
                            Grade x = new Grade(letter.getPid());           //create variable that holds letter based on id
                            System.out.println(x.getLetterGrade());         // print the info
                        }
                    System.out.println("Please enter a new command");
                        continue;

                }
                if (tokens[0].equals("name")) {                                 //if this command is given a name will be found based on pID
                    for (Student name : myGradebook.getListOfStudents())            //enhanced for loop
                        if (Integer.valueOf(tokens[1]).equals(name.getPid())) {         // if the pID matches
                            System.out.print(name.getFirstName() + " ");                // print first name
                            System.out.print(name.getLastName() + " ");                 //print last name
                            System.out.println();                                       //print line
                        }
                    System.out.println("Please enter a new command");
                        continue;

                }

                if (commandInput.equals("average score")) {                   //if this command is given the program calcs average score
                    System.out.println(myGradebook.calculateAvg());             //calculate average and print it
                    System.out.println("Please enter a new command");// ask for a new command
                    continue;
                }

                if (commandInput.equals("average letter")) {          //if this command is given the program finds the average letter grade
                    Grade averageLetter = new Grade(myGradebook.calculateAvg());        // create new variable of grade type called averageLetter
                    System.out.println(averageLetter.getLetterGrade());         //print result
                    System.out.println("Please enter a new command");       //  ask for new command
                    continue;
                }

                if (commandInput.equals("median score")) {        // if this command is given the program calcs median
                    System.out.println(myGradebook.calculateMedian());      // calculate median and print it
                    System.out.println("Please enter a new command");       // ask for new command
                    continue;
                }

                if (commandInput.equals("median letter")) {                         // if the command "median' is given, begin
                    Grade medianLetter = new Grade(myGradebook.calculateMedian());          //variable medianLetter created
                    System.out.println(medianLetter.getLetterGrade());                  //prints median letter
                    System.out.println("Please enter a new command");
                    continue;
                }

                if (commandInput.equals("tab scores")) {                     // if the command "tab scores' is given, begin
                    System.out.printf("First Name\t\tLast Name\t\tpID\t\t\tScore\n");       //print info
                    myGradebook.printAllStudents();                                 //print all students
                    System.out.println("Please enter a new command");
                    continue;
                }

                if (commandInput.equals("tab letters")) {       //if the command "tab letters' is given, begin
                    System.out.printf("First Name\t\tLast Name\t\tpID\t\t\tLetter Grade\n");    //print info
                    myGradebook.printAllStudentsLetterGrades();                                    //print all students
                    System.out.println("Please enter a new command");
                    continue;
                }

                if (tokens[0].equals("change")) {           // if the command "change' is given, begin
                    int counter = 0;        //counter
                    if (tokens.length != 3) {           // if the incorrect format is given try again
                        System.out.println("Invalid command format");       //error message
                    } else
                        for (Student s : myGradebook.getListOfStudents()) {     //enhanced for loop
                            if (tokens[1].equals(Integer.toString(s.getPid()))) {
                                s.setGrade(Integer.parseInt(tokens[2]));        // if the second text given equals the input continue
                                counter++;      //counter is increased
                                System.out.println("Please enter a new command");       //finished, enter a command
                            }
                        }

                    if (counter == 0) {         //if the counter has not increased the pID does not match any students
                        System.out.println("Invalid pID");      // invalid try again
                    }
                    continue;
                }


                if (commandInput.equals("quit")) {        //if this command is given the program ends
                    break;      // stops program
                }

                else {
                    System.out.println("Invalid command, try again");           // if an invalid command is given, try again
                }

            }
        }
        }




































