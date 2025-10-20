package SCRP;

// LocationManager.java
public class LocationManager {
    private Graph graph;

    public LocationManager(Graph graph) {
        this.graph = graph;
    }

    public void addLocation(String name) {
        if (graph.getAllLocations().contains(name)) {
            System.out.println("Location already exists!");
        } else {
            graph.addLocation(name);
            System.out.println("✅ Location added successfully!");
        }
    }

    public void removeLocation(String name) {
        if (!graph.getAllLocations().contains(name)) {
            System.out.println("❌ Location not found!");
        } else {
            graph.removeLocation(name);
            System.out.println("✅ Location removed successfully!");
        }
    }

    public void addRoad(String from, String to) {
        if (graph.getAllLocations().contains(from) && graph.getAllLocations().contains(to)) {
            graph.addRoad(from, to);
            System.out.println("✅ Road added successfully!");
        } else {
            System.out.println("❌ Both locations must exist before adding a road!");
        }
    }

    public void removeRoad(String from, String to) {
        graph.removeRoad(from, to);
        System.out.println("✅ Road removed successfully!");
    }
}
