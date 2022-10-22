package com.mobvoi.health.common.data.throwable;
/* loaded from: classes2.dex */
public class SensorThrowable extends Throwable {
    public int mType;

    public SensorThrowable(int i10, String str) {
        super(str);
        this.mType = i10;
    }
}
