// CSCI 2010U - 11b Depth-first Search

import java.util.*;

public class Graph {
   private class Vertex {
      private String label;
      private List<Vertex> adjacencies;

      public Vertex(String label) {
         this.label = label;
         adjacencies = new ArrayList<>();
      }

      public String getLabel() { return this.label; }

      public void addAdjacency(Vertex other) {
         adjacencies.add(other);
      }

      public List<Vertex> getAdjacencies() { return adjacencies; }

      public int getDegree() {
         return adjacencies.size();
      }

      public String toString() { return label; }
   }

   private class Edge {
      private Vertex v1;
      private Vertex v2;

      public Edge(Vertex v1, Vertex v2) {
         this.v1 = v1;
         this.v2 = v2;
      }

      public Vertex getVertex1() { return v1; }
      public Vertex getVertex2() { return v2; }
   }

   private HashMap<String, Vertex> vertices;

   public Graph() {
      vertices = new HashMap<>();
   }

   public void addVertex(String label) {
      vertices.put(label, new Vertex(label));
   }

   public void addEdge(String v1label, String v2label) {
      // collect the references to each vertex
      Vertex v1 = vertices.get(v1label);
      Vertex v2 = vertices.get(v2label);

      // add an adjacency from v1 to v2 AND an adjacency from v2 to v1
      v1.addAdjacency(v2);
      v2.addAdjacency(v1);
   }

   public Vertex getVertex(String label) {
      return vertices.get(label);
   }

   // DFS code
   public Set<Vertex> visited;
   public Map<Vertex, Edge> discoveryEdges;

   public void dfs(String startVertexLabel) {
      // label all vertices as unvisited (empty visited set)
      visited = new HashSet<>();

      // label all edges as undiscovered (empty discovery edge map)
      discoveryEdges = new HashMap<>();

      Vertex startVertex = vertices.get(startVertexLabel);
      dfs(startVertex);
   }

   private void dfs(Vertex u) {
      // mark u as visited
      visited.add(u);

      // loop over the adjacencies of u
      List<Vertex> adjacencies = u.getAdjacencies();
      for (Vertex v : adjacencies) {
         // check if v has been visited
         if (!visited.contains(v)) {
            // mark the edge as a discovery edge for v
            discoveryEdges.put(v, new Edge(u, v));

            // recursively DFS on v
            dfs(v);
         }
      }
   }

   public static void main(String[] args) {
      Graph graph = new Graph();

      graph.addVertex("A");
      graph.addVertex("B");
      graph.addVertex("C");
      graph.addVertex("D");
      graph.addVertex("E");

      graph.addEdge("A", "B");
      graph.addEdge("A", "C");
      graph.addEdge("B", "D");
      graph.addEdge("C", "D");
      graph.addEdge("B", "E");
      graph.addEdge("D", "E");

      Vertex d = graph.getVertex("D");
      System.out.printf("degree of D: %d\n", d.getDegree());
      List<Vertex> adjacencies = d.getAdjacencies();
      System.out.println("Adjacencies of D: ");
      for (Vertex v: adjacencies) {
         System.out.printf("\t%s, adjacencies:\n", v.getLabel());

         for (Vertex a: v.getAdjacencies()) {
            System.out.printf("\t\t%s\n", a.getLabel());
         }
         System.out.println("");
      }

      // test code for DFS
      graph.dfs("D");

      // print the visited vertices
      System.out.println("Visited vertices:");
      for (Vertex v : graph.visited) {
         System.out.printf("\t%s\n", v.getLabel());
      }

      // print the discovery edges
      System.out.println("Discovery edges:");
      for (Vertex v : graph.discoveryEdges.keySet()) {
         Edge edge = graph.discoveryEdges.get(v);
         System.out.printf(
            "\tVertex %s, discovered by edge (%s,%s)\n",
            v.toString(),
            edge.getVertex1().toString(),
            edge.getVertex2().toString()
         );
      }
   }
}
