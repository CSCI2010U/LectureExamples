import java.util.*;

public class Vertex {
    private String label;
    private Collection<Edge> adjacencies;

    public Vertex(String label) { 
        this.label = label;
        this.adjacencies = new ArrayList<>();
    }

    public String getLabel() { return this.label; }

    public void addAdjacency(Edge edge) {
        adjacencies.add(edge);
    }

    public Collection<Edge> getAdjacencies() { return this.adjacencies; }

    public int getDegree() {
        return this.adjacencies.size();
    }

    public String toString() {
        return this.label;
    }
}
