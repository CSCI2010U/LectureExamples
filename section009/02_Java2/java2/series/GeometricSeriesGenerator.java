package java2.series;

// each term is calculated by multiplying by a constant
// a * (r ^ n)
// 1, 2, 4, 8, 16, ...
// 1, 1/2, 1/4, 1/8, 1/16, ...
public class GeometricSeriesGenerator extends SeriesGenerator {
    private double termFactor = 0.0;

    public GeometricSeriesGenerator(double startValue, double termFactor) {
        this.termFactor = termFactor;
        this.previousValue = startValue;
        this.sum = startValue;
    }

    @Override
    double generateCurrentValue() {
        previousValue = previousValue * termFactor;
        return previousValue;
    }
    
}
