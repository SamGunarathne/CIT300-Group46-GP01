package SCRP;

import java.util.*;

public class Graph {
    private Map<String, List<String>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    // Add new location
    public void addLocation(String location) {
        adjList.putIfAbsent(location, new ArrayList<>());
    }

    // Remove location and related roads
    public void removeLocation(String location) {
        adjList.remove(location);
        for (List<String> connections : adjList.values()) {
            connections.remove(location);
        }
    }

    // Add a two-way road
    public void addRoad(String from, String to) {
        if (!adjList.containsKey(from) || !adjList.containsKey(to)) {
            System.out.println("One or both locations do not exist.");
            return;
        }
        adjList.get(from).add(to);
        adjList.get(to).add(from);
    }

    // Remove a road
    public void removeRoad(String from, String to) {
        if (adjList.containsKey(from)) adjList.get(from).remove(to);
        if (adjList.containsKey(to)) adjList.get(to).remove(from);
    }

    // Display all connections
    public void displayConnections() {
        for (String location : adjList.keySet()) {
            System.out.println(location + " → " + adjList.get(location));
        }
    }

    public boolean hasLocation(String location) {
        return adjList.containsKey(location);
    }
}
