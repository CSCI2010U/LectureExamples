import java.util.*;

public class AdjacencyListGraph {
    private class Vertex {
        private String label;
        private Collection<Vertex> adjacencies;

        public Vertex(String label) {
            this.label = label;
            this.adjacencies = new ArrayList<>();
        }

        public String getLabel() { return this.label; }

        public void addAdjacency(Vertex other) {
            this.adjacencies.add(other);
        }

        public Collection<Vertex> getAdjacencies() { return this.adjacencies; }

        public int getDegree() {
            return this.adjacencies.size();
        }

        public String toString() { return this.label; }
    }

    private Map<String,Vertex> vertices;

    public AdjacencyListGraph() {
        this.vertices = new HashMap<>();
    }

    public void addVertex(String label) {
        this.vertices.put(label, new Vertex(label));
    }

    public void addEdge(String endpoint1Label, String endpoint2Label) {
        // collect the endpoint vertices
        Vertex endpoint1 = this.vertices.get(endpoint1Label);
        Vertex endpoint2 = this.vertices.get(endpoint2Label);
        
        // create adjacencies in each direction (undirected graph)
        endpoint1.addAdjacency(endpoint2);
        endpoint2.addAdjacency(endpoint1);
    }

    public Vertex getVertex(String label) {
        return this.vertices.get(label);
    }

    public static void main(String[] args) {
        AdjacencyListGraph graph = new AdjacencyListGraph();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("B", "E");
        graph.addEdge("C", "D");
        graph.addEdge("D", "E");

        Vertex d = graph.getVertex("D");
        System.out.printf("Degree of D: %d\n", d.getDegree());
        Collection<Vertex> adjacencies = d.getAdjacencies();
        for (Vertex v: adjacencies) {
            System.out.println(v);
        }
    }
}