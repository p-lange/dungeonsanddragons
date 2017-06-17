package peter.dnd.model;

import java.util.concurrent.ThreadLocalRandom;

public enum dice {
    D4(4),
    D6(6),
    D8(8),
    D10(10),
    D12(12),
    D20(20),
    D100(100);

    private int mDieSize;
    private int totalResult = 0;
    private double avgResult = 0d;

    dice(int dieSize) {
        mDieSize = dieSize;
        this.avgResult = ((dieSize + 1d) / 2d);
    }

    public int getDieSize() {
        return mDieSize;
    }

    public int rollDice() {
        totalResult = 0;
        return totalResult = ThreadLocalRandom.current().nextInt(1, mDieSize + 1);
    }

    public int rollDice(int number) {
        totalResult = 0;
        for (int i = 1; i < number; i++) {
           int rand = ThreadLocalRandom.current().nextInt(1, mDieSize + 1);
            totalResult += rand;
        }
        return totalResult;
    }

    public double getAvgResult() {
        return avgResult;
    }
    public double getAvgResult(int number){
        return avgResult * number;
    }
}
