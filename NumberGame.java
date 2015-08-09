/**     ___  ___       ___   _____       ___   _   _    _  
*      /   |/   |     /   | /  ___/     /   | | | / /  | | 
*     / /|   /| |    / /| | | |___     / /| | | |/ /   | | 
*    / / |__/ | |   / / | | \___  \   / / | | | |\ \   | | 
*   / /       | |  / /  | |  ___| |  / /  | | | | \ \  | | 
*  /_/        |_| /_/   |_| /_____/ /_/   |_| |_|  \_\ |_| 
*
*/
package numbergame;

/**
 *
 * @author Takahashi
 */
import java.util.Scanner;
public class NumberGame {
     static final int MIN = 0;
static final int MAX = 100;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    int accumulator = 0;
String choice = "y";
while (choice.equalsIgnoreCase("y"))
{
 //Welcome statement to the user.
System.out.println("Welcome to the Guess Number Game");
System.out.println("+++++++++++++++++++++++++++++++++");
System.out.println();

System.out.println("I'm thinking of a number from 1 to 100.");
System.out.println("Try to guess it.");
System.out.println();

//Generate the computer's random guess.
int gen = 1 + (int) (Math.random() * 100);

//System.out.println(gen); Used for testing only.
//Have the user enter guesses.
Scanner sc = new Scanner(System.in);
System.out.println("Enter number: ");
int y = -1;
while (y != gen)
{
y = getInt(sc, y);
if (y > gen + 10)
{
System.out.println("Way too high! Guess again.");
} else if (y < gen)
{
System.out.println("Too low! Guess again.");
} else
System.out.println("Too high! Guess again.");
accumulator += 1;
}
if (accumulator <= 3)
{
System.out.println("Great work! You are a mathematical wizard.");
}
else if (accumulator > 7)
{
System.out.println("What took you so long? Maybe you should take some lessons.");
}
else
{
System.out.println("Not too bad! You've got some potential.");
}
System.out.println("Would you like to play again? (y/n): ");
choice = sc.next();
}
System.out.println();
System.out.println("Thanks for playing!");
}
public static boolean validateWithinRange(int y)
{
if (y <= MIN)
{
System.out.println("Error! Number must be greater than " + MIN + ".");
return false;
}
else if (y >= MAX)
{
System.out.println("Error! Number must be less than or equal to " + MAX + ".");
return false;
}
return true;
}
public static int getInt(Scanner sc, int y){
y = 0;
boolean isValid = false;
while (!isValid)
{
String raw_input = sc.nextLine();
try
{
y = Integer.parseInt(raw_input);
if (validateWithinRange(y))
{
isValid = true;
}
}
catch(NumberFormatException e)
{
System.out.println("Error! Invalid integer value. Try again.");
}
}
return y;
}
}
