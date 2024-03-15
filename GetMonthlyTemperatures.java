/* Module 5 CTA | Option 2: Get Monthly Temperatures
 * Develop a Java program that will store data in the form of monthly temperatures for a year. 
 * Store the month and temperature in two different arrays. 
 * Your program should prompt the user for the month to be viewed and display both the month and average temperature. 
 * If "year" is entered, the output for your program should provide the temperature for each month along with the 
 * yearly average as well as the highest and lowest monthly averages. Use the looping and decision constructs 
 * in combination with the arrays to complete this assignment.
 */
import java.util.Scanner;

public class GetMonthlyTemperatures {
   
   // Simple method to print the month and temperature.
   // This is a private method because it should not be called outside of local usage
   private void PrintMonth(String month, double temperature) {
      System.out.println("Month: " + month);
      System.out.printf("Average Temperature: %.1f", temperature);
   }
   
   public static void main(String[] args) {
      // "s" object will be used to scan for user input and saved into the userInput string variable
      Scanner s = new Scanner(System.in);
      String userInput;
      
      // Initialize input validation to false to avoid unnecessary assignment in the do-while loop
      boolean validateInput = false;
      boolean enteredYear = false;
      
      // Declare integers to keep track of array index locations for month, max, and min temperatures
      int monthIndex, maxTempIndex, minTempIndex;
      
      // Declare and initialize the running total for yearly average calculation
      double tempTotal = 0;
      
      // Month array holds the names of the months as strings
      final String[] monthArray = new String[] {
            "January", "February", "March", "April", 
            "May", "June", "July", "August", 
            "September", "October", "November", "December"
      };
      
      /* Temperature array holds the average temperature for all twelve months,
       * referenced by an index number that matches the index for the month in monthArray.
       * Temperatures are taken from the 2023 monthly average temperatures for Everett, WA 
       * (https://www.weather.gov)
       */
      final double[] temperatureArray = new double[] {
            42.5,  40.5,  43.5,  48.6,  
            61.6,  61.6,  67.0,  68.0,  
            61.1,  54.2,  44.5,  44.2
      };
      
      /* Prompt the user for initial input of month.  
       * Perform input validation to ensure a correct month is chosen.
       * Use a do/while loop to re-prompt if incorrect input is received.
       */
      do {
         System.out.print("Enter the name of a month (e.g., January), or type the word "
               + "\"year\" to print all months: ");
         userInput = s.nextLine();
         
         // A for loop is used to cycle through the monthArray elements to ensure the input matches a value.
         for (int i = 0; i < monthArray.length; i++) {
            /* validateInput remains FALSE if the input does not match any element and 
             * does not match the word "year"
             * Convert all to lowercase to account for case mismatches.
             */
            if (userInput.toLowerCase().compareTo(monthArray[i].toLowerCase()) == 0) {
               validateInput = true;
               enteredYear = false;
               monthIndex = i;
               break;
            }
            else if (userInput.toLowerCase().compareTo("year") == 0){
               validateInput = true;
               enteredYear = true;
               break;
            }
         }
         
         if (!validateInput) {
            System.out.println("Invalid input. Please try again!");
         }
         
      } while (!validateInput);
      
      
   }
}
