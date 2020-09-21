package java2.series;

// 1/1 + 1/2 + 1/3 + 1/4 + ...
// 2/2 + 2/4 + 2/6 + 2/8 + ...
// 1/1 - 1/2 + 1/3 - 1/4 + ...
public class HarmonicSeriesGenerator extends SeriesGenerator {
    private double denominatorIncrement = 1.0;
    private double denominator = 1.0;
    private double numerator = 1.0;
    private boolean alternating = false;

    public HarmonicSeriesGenerator(double denominatorIncrement,
                                   double startDenominator,
                                   double numerator,
                                   boolean alternating) {
        this.denominatorIncrement = denominatorIncrement;
        this.denominator = startDenominator;
        this.numerator = numerator;
        this.alternating = alternating;

        this.previousValue = numerator / startDenominator;
        this.sum = previousValue;
    }

    @Override
    double generateCurrentValue() {
        // update the denominator
        denominator += denominatorIncrement;

        // calculate the next value
        double currentValue = numerator / denominator;

        // handle the alternating terms
        if (alternating && previousValue > 0.0) {
            currentValue *= -1.0;
        }

        previousValue = currentValue;
        return previousValue;
    }
    
}
