public class Ruler {
    public static void drawRuler(int numTicks, int majorLength) {
        drawLine(majorLength, 0);
        for (int tickNum = 1; tickNum <= numTicks; tickNum++) {
            drawInterval(majorLength - 1);
            drawLine(majorLength, tickNum);
        }
    }

    // binary recursion (two recursive calls)
    public static void drawInterval(int centreLength) {
        if (centreLength >= 1) {
            drawInterval(centreLength - 1);
            drawLine(centreLength);
            drawInterval(centreLength - 1);
        }
    }

    public static void drawLine(int tickLength, int tickLabel) {
        // draw the line
        for (int dashNum = 0; dashNum < tickLength; dashNum++) {
            System.out.print("-");
        }

        // optionally, draw the label
        if (tickLabel >= 0) {
            System.out.printf(" %d", tickLabel);
        }

        // add a line break
        System.out.println("");
    }

    public static void drawLine(int tickLength) {
        // convenience function for drawing lines without labels
        drawLine(tickLength, -1);
    }

    public static void main(String[] args) {
        drawRuler(2, 4);
    }
}
