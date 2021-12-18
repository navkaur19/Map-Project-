/*Project: Project 2
* Class: DistanceFinderDemo.java
* Author: Navdeep Kaur
* Date:  March 27, 2021
* This class has the main method and runs the entire program.
*/ 
import java.io.FileNotFoundException;
import java.util.Scanner;
public class DistanceFinderDemo
{
   public static void main(String[] args) throws FileNotFoundException
   {
      Scanner in = new Scanner(System.in);
      System.out.print("File with city names: ");
      String filename = in.nextLine();
      DistanceFinder d = new DistanceFinder(filename);

      System.out.println("Shortest distance from " + d.getStartingCity());
      System.out.println(d.shortestDistances());
   }
}
