package java2.series;

public abstract class SeriesGenerator {
    private int index = 0;
    protected double sum = 0.0;
    protected double previousValue = 0.0;

    abstract double generateCurrentValue();

    public double nextValue() {
        // increment the index
        index++;

        // determine the next value in the series
        double currentValue = generateCurrentValue();

        // update the sum
        sum += currentValue;

        return currentValue;
    }

    public double sumSoFar() {
        return sum;
    }
}
