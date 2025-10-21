package SCRP;

//Menu Interface of SmartCityRoutePlanner

import java.util.*;

public class SmartCityRoutePlanner {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     Graph graph = new Graph();
     LocationManager manager = new LocationManager(graph);
     AVLTree tree = new AVLTree();

     int choice;
     do {
         System.out.println("\n--- Smart City Route Planner ---");
         System.out.println("1. Add a new location");
         System.out.println("2. Remove a location");
         System.out.println("3. Add a road between locations");
         System.out.println("4. Remove a road");
         System.out.println("5. Display all connections");
         System.out.println("6. Display all locations (Tree)");
         System.out.println("7. Exit");
         System.out.print("Enter your choice: ");
         choice = sc.nextInt();
         sc.nextLine();

         switch (choice) {
             case 1 -> {
                 System.out.print("Enter location name: ");
                 String loc = sc.nextLine();
                 manager.addLocation(loc);
                 tree.insert(loc);
             }
             case 2 -> {
                 System.out.print("Enter location name to remove: ");
                 String loc = sc.nextLine();
                 manager.removeLocation(loc);
             }
             case 3 -> {
                 System.out.print("Enter first location: ");
                 String from = sc.nextLine();
                 System.out.print("Enter second location: ");
                 String to = sc.nextLine();
                 manager.addRoad(from, to);
             }
             case 4 -> {
                 System.out.print("Enter first location: ");
                 String from = sc.nextLine();
                 System.out.print("Enter second location: ");
                 String to = sc.nextLine();
                 manager.removeRoad(from, to);
             }
             case 5 -> graph.displayConnections();
             case 6 -> {
                 System.out.println("Locations in sorted order:");
                 tree.inorder();
                 System.out.println();
             }
             case 7 -> System.out.println("Exiting...");
             default -> System.out.println("Invalid choice! Please try again.");
         }
     } while (choice != 7);
 }
}