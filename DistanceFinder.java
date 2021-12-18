/*Project: Project 2
* Class: DistanceFinder.java
* Author: Navdeep Kaur
* Date:  March 27, 2021
* This class helps get the starting city of a file and print its shortest 
* distances to other cities.
*/ 

import java.util.*;
import java.util.HashSet;
import java.io.*;
/**
   Class for simulating finding the shortest distance
   from a city to all other cities.
*/
public class DistanceFinder
{
   private String startFrom;
   private Map<String, HashSet<DistanceTo>> directConnections;
   
   /**
      Construct a Distance finder.
      @param filename the file containing the connections.
   */
   
   // ---------------------------------------------------------------
   // This method constructs a distance finder according to the file contents.
   public DistanceFinder(String filename) throws FileNotFoundException
   {
	   directConnections = new HashMap<>();
      // Read the file and intialize the instance variables
     Scanner input = new Scanner (new File (filename));
     while(input.hasNext()) {
    	 String from = input.next();
    	 String to = input.next();
    	 int distance = input.nextInt();
    	 
    	 if(startFrom == null) {
    		 startFrom = from;
    	 }
    	 
    	 if(directConnections.get(from) == null) {
    		 directConnections.put(from, new HashSet<>());
    	 }
    	 
    	 directConnections.get(from).add(new DistanceTo (to, distance));
    	 
    	 if(directConnections.get(to) == null) {
    		 directConnections.put(to, new HashSet<>());
    	 }
    	 
    	 directConnections.get(to).add(new DistanceTo(from, distance));
     }
     System.out.println(directConnections);

   }

   /**
      Return the city that we start from.
   */
   // ---------------------------------------------------------------
   // This method returns the starting city.
   public String getStartingCity()
   {
      return startFrom;
   }

   /**
      Return the shortest distances.
      @return the shortest distances.
   */
   
   // ---------------------------------------------------------------
   // This method computes the shortest distances and returns it. 
   public Map<String, Integer> shortestDistances()
   {
      // Follow the algorithm in the instruction
      // Remember the starting point is the first city in the file.
	   //Let from be the starting point
     String from = startFrom;
	   
	   //Add DistanceTo(from,0) to priority queue
	   PriorityQueue<DistanceTo> Q = new PriorityQueue<DistanceTo>();
	   Q.add(new DistanceTo(from,0));
	   
	   //Construct a map shortestKnownDistance from city names to distances 
	   Map<String, Integer> shortestKnownDistance = new HashMap<String, Integer>();

	   DistanceTo smallest;
	   
	   // while the priority queue is not empty
	   while (Q.size() > 0) {
		  
		   // get its smallest element
		  smallest = Q.remove();
			  
		  	//If its target is not a key in shortestKnownDistance
			   if(!shortestKnownDistance.containsKey(smallest.getTarget()) ) {
				   int d = smallest.getDistance();
				   shortestKnownDistance.put(smallest.getTarget(), d);
				   HashSet<DistanceTo> range = new HashSet<DistanceTo>();
				range = directConnections.get(smallest.getTarget());
				
				//Add DistanceTo(c,d + distance from target to c) to the priority queue
				for(DistanceTo c: range) {
					if(directConnections.containsKey(c.getTarget())) {
						DistanceTo e = new DistanceTo(c.getTarget(), d + c.getDistance());
						Q.add(e);
					}
				}
				   
			   }
		   }
		   
	   
	   return shortestKnownDistance;




   }
}
