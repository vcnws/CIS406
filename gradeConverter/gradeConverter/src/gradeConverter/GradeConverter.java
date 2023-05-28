//Christopher Crawford - CIS406 - Grade Converter

package gradeConverter;
import java.util.Scanner;

public class GradeConverter {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Welcome to the Letter Grade Converter\n");

            var yesNo = "y";
            while (yesNo.equalsIgnoreCase("y")){
                System.out.print("Enter a numerical grade:             ");

                var gradeNumber = Integer.parseInt(sc.nextLine());
                var letterGrade = "F";

                if (gradeNumber >= 90)
                    letterGrade = "A";

                if (gradeNumber >= 80 && gradeNumber < 90)
                    letterGrade = "B";

                if (gradeNumber >= 70 && gradeNumber < 80)
                    letterGrade = "C";

                if (gradeNumber >= 60 && gradeNumber < 70)
                    letterGrade = "D";

                System.out.println("Letter Grade:                        " + letterGrade);

                System.out.print("Would you like to continue (y/n)?    ");
                yesNo = sc.nextLine();
                System.out.println();
            }

            System.out.print("Thanks for playing!");

        } catch (Exception ex){

        } finally {
            sc.close();
        }
    }
}
