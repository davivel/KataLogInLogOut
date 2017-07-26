package com.karumi.training.kataloginlogout;

/**
 * Created by David A. Velasco on 26/7/17.
 */

public class StubClock extends Clock {

    private final long fixedTime;

    public StubClock(long fixedTime) {
        this.fixedTime = fixedTime;
    }

    @Override
    public long getCurrentTime() {
        return fixedTime;
    }
}
