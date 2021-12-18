/*Project: Project 2
* Class: DistanceTo.java
* Author: Navdeep Kaur
* Date:  March 27, 2021
* This class expresses the distance from one city to another city.
*/ 
public class DistanceTo implements Comparable<DistanceTo>
{
   private String target;
   private int distance;

   public DistanceTo(String city, int dist) { 
	   target = city; 
	   distance = dist; 
	   }
   public String getTarget() { 
	   return target; 
	   }
   public int getDistance() { 
	   return distance; 
	   }
   public int compareTo(DistanceTo other) { 
	   return distance - other.distance; 
	   }
   public String toString() { 
	   return "Distance to " + target + " is " + distance; 
	   }
}
