
package util;


public class Grade {


    private double score;
    private String letterGrade;
    public double getScore() {
        return score;
    }
    public String getLetterGrade() {
        return letterGrade;
    }

    public Grade(double score){
        this.score = score;

        if (score >= 90) {          //check value of score
            this.letterGrade = "A";     //assign letter grade to variable
        }
        else if (score >= 86.67){
            this.letterGrade = "A-";
        }
        else if (score >= 83.33){
            this.letterGrade = "B+";
        }
       else if (score >= 80.00){
            this.letterGrade = "B";
        }

        else if (score >= 76.67){
            this.letterGrade = "B-";
        }
        else if (score >= 73.33){
            this.letterGrade = "C+";
        }
        else if (score >= 70.00){
            this.letterGrade = "C";
        }
        else if (score >=60.00){
            this.letterGrade = "D";
        }

        else {this.letterGrade = "F";}       // if none of the above scores match, F letter grade is assigned


    }




}


