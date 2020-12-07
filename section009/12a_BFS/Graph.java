// CSCI 2010U - 12a Breadth-first Search

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Graph {
   private class Vertex {
      private String label;
      private List<Vertex> adjacencies;
      private boolean visited = false;
      private Vertex parent = null;

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

      public void labelVisited() { this.visited = true; }
      public boolean isVisited() { return visited; }

      public Vertex getParent() { return this.parent; }
      public void setParent(Vertex newParent) { this.parent = newParent; }
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

   // BFS code
   public Vertex bfs(String startVertexLabel, String destVertexLabel) throws InterruptedException {
      Vertex startVertex = this.vertices.get(startVertexLabel);
      startVertex.setParent(null);
      startVertex.labelVisited();

      LinkedBlockingQueue<Vertex> queue = new LinkedBlockingQueue<>();
      queue.put(startVertex);

      while (queue.size() > 0) {
         Vertex v = queue.remove();

         // check if we've reached the destination vertex
         if (v.getLabel() == destVertexLabel) {
            return v;
         }

         // process the adjacencies of v
         List<Vertex> adjacencies = v.getAdjacencies();
         for (Vertex w: adjacencies) {
            if (!w.isVisited()) {
               // remember the discovery edge
               w.setParent(v);

               // mark w as visited
               w.labelVisited();

               // add w to the queue
               queue.put(w);
            }
         }
      }

      return null;
   }

   public static void main(String[] args) {
      Graph graph = new Graph();

      graph.addVertex("A");
      graph.addVertex("B");
      graph.addVertex("C");
      graph.addVertex("D");
      graph.addVertex("E");
      graph.addVertex("F");

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

      // test code for BFS
      try {
         System.out.println("Testing BFS:");
         Vertex current = graph.bfs("E", "F");
         if (current == null) {
            System.out.println("No path found.");
         } else {
            while (current != null) {
               System.out.print(current.getLabel() + " <- ");
               current = current.getParent();
            }
         }
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}
