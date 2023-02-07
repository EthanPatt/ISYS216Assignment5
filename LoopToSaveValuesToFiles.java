//   Name:         Ethan Pattison
//   Course:       ISYS 216 
//   Professor:    Dr Kinuthia
//   Assignment:   Chapter 5 Programming 
//   Date:         3/25/2022

package chap5assignment;

// Import Random class to generate random numbers
import java.util.Random;

// Import scanner class to get keyboard data from user 
import java.util.Scanner;

// To use the PrintWriter Class
import java.io.*;

public class LoopToSaveValuesToFiles {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
// Set Variables        
        int numTimes = 0; 
        int number = 0;
        boolean numEven;
        
// File file = new File("evenNumFile.txt")
        FileWriter Even = new FileWriter("evenNumFile.txt");

// File file = new File("oddNumFile.txt");
        FileWriter Odd = new FileWriter("oddNumFile.txt");
// Initialize scanner objects
        Scanner keyboard = new Scanner(System.in);

// Initialize random object
        Random ranNum = new Random();
        
// Ask the User for the number of times it should generate the random numbers
        System.out.println("Enter the amount of randomly generated numbers: ");
                numTimes = keyboard.nextInt();
        
// Call function to generate random number and store returned value into number variable
        
        for (int count = 0; count<numTimes;count++){ //for loop should be controlled by user input
            
            number = generateNum(ranNum);
            
            System.out.println("Randomly generated number: "+ number);
            
//pass generated number to evaluate whether even or odd
            numEven = isEvenNum(number); 
            
            if (numEven){
               //add to the even file
                
                Even.append(String.valueOf(number)+"\n");
            }
            
             else{
               //add to the odd file
                Odd.append(String.valueOf(number)+"\n");
                
            }
        }
        // Close Both files
        Odd.close();
        Even.close();
        
       // Add Spacing
    System.out.println("");
   
    // Disply the total numbers generated
    System.out.println("Randoom numbers to be generated: "+numTimes);
    
    // Display that Even and Odd Numbers were added 
    System.out.println("Even numbers were added to evenNumFile.txt");
    System.out.println("Odd numbers were added to oddNumFile.txt");
    
    }

// Value returning Funtion to see if the number is even - true or false
    public static boolean isEvenNum(int number){
        if ((number % 2)==0) return true;
        else return false;
    }
// Value returning Function to generate a number from 1 - 1000
    public static int generateNum(Random numGen){
        int num;
        num = numGen.nextInt(1001) + 1;
        return num; 
    }

    }

