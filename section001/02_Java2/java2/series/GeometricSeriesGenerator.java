package java2.series;

// 1, 2, 4, 8, 16, ...
public class GeometricSeriesGenerator extends SeriesGenerator {
    private double termFactor = 0.0;

    public GeometricSeriesGenerator(double termFactor, double startValue) {
        this.termFactor = termFactor;
        this.previousValue = startValue;
        this.sum = startValue;
    }

    public double generateCurrentValue() {
        previousValue = previousValue * termFactor;
        return previousValue;
    }

    public static void main(String[] args) {
        GeometricSeriesGenerator gen = new GeometricSeriesGenerator(2.0, 1.0);
        for (int i = 0; i < 10; i++) {
            System.out.printf("%.3f (sum: %.3f)\n", gen.nextValue(), gen.getSumSoFar());
        }
    }
}
