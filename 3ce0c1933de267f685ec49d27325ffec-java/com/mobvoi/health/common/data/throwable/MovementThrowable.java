package com.mobvoi.health.common.data.throwable;
/* loaded from: classes2.dex */
public class MovementThrowable extends SensorThrowable {
    private int mLevel;

    public MovementThrowable(int i10) {
        super(i10, "movement happens while detecting");
        if (3 == i10) {
            this.mLevel = 1;
        } else if (4 == i10) {
            this.mLevel = 2;
        }
    }

    public boolean isSlight() {
        return this.mLevel == 1;
    }

    public boolean isViolent() {
        return this.mLevel == 2;
    }
}
