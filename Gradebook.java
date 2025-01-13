
package util;

import java.util.*;


public class Gradebook {
    public Gradebook() {
        this.listOfStudents = new ArrayList<Student>();
    }



    public void addStudent(String firstName, String lastName, String pIdString, String scoreString){
        listOfStudents.add(new Student(firstName,lastName, Integer.parseInt(pIdString), scoreString));
    }
    private ArrayList<Student> listOfStudents;
    public double calculateAvg() {
        double sum = 0;
        for(Student s: listOfStudents)
            sum += s.getGrade().getScore();
        return sum / listOfStudents.size();
    }
    public float calculateMedian() {
        int i = 0, n = listOfStudents.size();
        int[] scores = new int[n];
        for(Student s: listOfStudents)
            scores[i++] = (int) s.getGrade().getScore();
        Arrays.sort(scores);
        if (n % 2 == 0)
            return (scores[n / 2] + scores[n / 2 - 1]) / 2.0f;
        else
            return scores[n / 2];
    }
    public void printAllStudents() {
        for(Student s: listOfStudents)
            System.out.printf("%-7s\t\t\t%-7s\t\t\t%d\t\t%.0f\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getScore());
    }

    public void printAllStudentsLetterGrades(){
        for(Student s: listOfStudents)
            System.out.printf("%-7s\t\t\t%-7s\t\t\t%d\t\t%-7s\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getLetterGrade());
    }

    public ArrayList<Student> getListOfStudents() {
        return listOfStudents;
    }
}
