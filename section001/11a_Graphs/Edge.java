public class Edge {
    private String label;
    private float weight;
    private Vertex endpoint1;
    private Vertex endpoint2;

    public Edge(String label, float weight, Vertex endpoint1, Vertex endpoint2) {
        this.label = label;
        this.weight = weight;
        this.endpoint1 = endpoint1;
        this.endpoint2 = endpoint2;
    }

    public String getLabel() { return this.label; }
    public float getWeight() { return this.weight; }
    public Vertex getEndpoint1() { return this.endpoint1; }
    public Vertex getEndpoint2() { return this.endpoint2; }

    public boolean isAdjacentTo(Vertex otherVertex) {
        if ((this.endpoint1 == otherVertex) || (this.endpoint2 == otherVertex)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.label + " (" + this.weight + ")";
    }
}
