//Christopher Crawford - CIS406 - Powers Table

package powersTable;
import java.util.Scanner;

public class PowersTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Welcome to the Squares and Cubes Table\n");

            var yesNo = "y";
            while (yesNo.equalsIgnoreCase("y")){
                StringBuilder table = new StringBuilder();
                table.append(GetPaddedString("Number"))
                        .append("\t")
                        .append(GetPaddedString("Squared"))
                        .append("\t")
                        .append(GetPaddedString("Cubed"))
                        .append("\n");

                table.append("=========\t=========\t========\n");

                System.out.print("Enter an integer value:      ");
                var num = Integer.parseInt(sc.nextLine());

                for(var i = 1; i <= num; i++){
                    int square = i * i;
                    int cube = i * i * i;
                    table.append(GetPaddedString(String.valueOf(i)))
                            .append("\t")
                            .append(GetPaddedString(String.valueOf(square)))
                            .append("\t")
                            .append(GetPaddedString(String.valueOf(cube)))
                            .append("\n");
                }
                System.out.println(table);

                System.out.print("Continue? (y/n)              ");
                yesNo = sc.nextLine();
                System.out.println();
            }

            System.out.print("Thanks for playing!");

        } catch (Exception ex){
            System.out.print(ex.getMessage());
        } finally {
            sc.close();
        }
    }

    private static String GetPaddedString(String input){
        StringBuilder inputBuilder = new StringBuilder(input);
        while (inputBuilder.length() < 9){
            inputBuilder.append(" ");
        }
        input = inputBuilder.toString();
        return input;
    }
}
