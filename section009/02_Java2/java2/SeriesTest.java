package java2;

import java2.series.GeometricSeriesGenerator;
import java2.series.HarmonicSeriesGenerator;
import java2.series.SeriesGenerator;

public class SeriesTest {
    public static void main(String[] args) {
        // 1, 2, 4, 8, 16, ...
        SeriesGenerator powersOf2 = new GeometricSeriesGenerator(1.0, 2.0);
        System.out.println("1, 2, 4, 8, 16, ...");
        for (int i = 0; i < 5; i++) {
            System.out.printf("%.2f (sum: %.2f)\n", powersOf2.nextValue(), powersOf2.sumSoFar());
        }

        // 1, 1/2, 1/4, 1/8, 1/16, ...
        SeriesGenerator negativePowersOf2 = new GeometricSeriesGenerator(1.0, 0.5);
        System.out.println("1, 1/2, 1/4, 1/8, 1/16, ...");
        for (int i = 0; i < 5; i++) {
            System.out.printf("%.3f (sum: %.3f)\n", negativePowersOf2.nextValue(), negativePowersOf2.sumSoFar());
        }

        // 1/1 + 1/2 + 1/3 + 1/4 + ...
        SeriesGenerator harmonic1 = new HarmonicSeriesGenerator(1.0, 1.0, 1.0, false);
        System.out.println("1/1 + 1/2 + 1/3 + 1/4 + ...");
        for (int i = 0; i < 5; i++) {
            System.out.printf("%.3f (sum: %.3f)\n", harmonic1.nextValue(), harmonic1.sumSoFar());
        }

        // 2/2 + 2/4 + 2/6 + 2/8 + ...
        SeriesGenerator harmonic2 = new HarmonicSeriesGenerator(2.0, 2.0, 2.0, false);
        System.out.println("2/2 + 2/4 + 2/6 + 2/8 + ...");
        for (int i = 0; i < 5; i++) {
            System.out.printf("%.3f (sum: %.3f)\n", harmonic2.nextValue(), harmonic2.sumSoFar());
        }

        // 1/1 - 1/2 + 1/3 - 1/4 + ...
        SeriesGenerator harmonic3 = new HarmonicSeriesGenerator(1.0, 1.0, 1.0, true);
        System.out.println("1/1 - 1/2 + 1/3 - 1/4 + ...");
        for (int i = 0; i < 5; i++) {
            System.out.printf("%.3f (sum: %.3f)\n", harmonic3.nextValue(), harmonic3.sumSoFar());
        }

    }
}
