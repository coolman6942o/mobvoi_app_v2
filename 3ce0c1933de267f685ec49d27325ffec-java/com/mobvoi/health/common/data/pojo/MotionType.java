package com.mobvoi.health.common.data.pojo;

import xf.b;
import xf.c;
/* loaded from: classes2.dex */
public enum MotionType implements c {
    Unknown(-1),
    Static(0),
    Walk(1),
    FastWalk(2),
    Run(3),
    FastRun(4),
    Bike(5),
    OffWrist(6),
    Awake(7),
    Rem(8),
    LightSleep(9),
    DeepSleep(10),
    Swimming(11),
    Undefined(99),
    FreeTrain(100);
    
    public final int typeCode;

    MotionType(int i10) {
        this.typeCode = i10;
    }

    public static MotionType from(int i10) {
        return (MotionType) b.b(MotionType.class, i10);
    }

    @Override // xf.c
    public int getTypeCode() {
        return this.typeCode;
    }

    public boolean isExercise() {
        return this == FastWalk || this == Run || this == FastRun || this == Bike || this == FreeTrain || this == Swimming;
    }

    public boolean isIdle() {
        return this == Static || this == OffWrist;
    }

    public /* bridge */ /* synthetic */ boolean isPersistent() {
        return b.a(this);
    }

    public boolean isSleep() {
        return this == Awake || this == Rem || this == LightSleep || this == DeepSleep;
    }
}
