import java.util.*;

public class AdjacencyListGraph {
    private HashMap<String, Vertex> vertices;

    public AdjacencyListGraph() {
        this.vertices = new HashMap<>();
    }

    public void addVertex(String label) {
        this.vertices.put(label, new Vertex(label));
    }

    public void addEdge(String label, float weight, String vertexLabel1, String vertexLabel2) {
        Vertex v1 = this.vertices.get(vertexLabel1);
        Vertex v2 = this.vertices.get(vertexLabel2);

        Edge newEdge = new Edge(label, weight, v1, v2);

        v1.addAdjacency(newEdge);
        v2.addAdjacency(newEdge);
    }

    Vertex getVertex(String label) {
        return this.vertices.get(label);
    }

    public static void main(String[] args) {
        AdjacencyListGraph graph = new AdjacencyListGraph();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge("ab", 1.0f, "A", "B");
        graph.addEdge("ac", 3.0f, "A", "C");
        graph.addEdge("bd", 1.5f, "B", "D");
        graph.addEdge("be", 0.1f, "B", "E");
        graph.addEdge("cd", 8.0f, "C", "D");
        graph.addEdge("de", 0.8f, "D", "E");

        Vertex d = graph.getVertex("D");
        System.out.printf("Degree of D: %d\n", d.getDegree());
        System.out.println("Adjacencies of D:");
        Collection<Edge> adjacencies = d.getAdjacencies();
        for (Edge edge : adjacencies) {
            System.out.println(edge);
            System.out.println("\t" + edge.getEndpoint1());
            System.out.println("\t" + edge.getEndpoint2());
        }
    }
}