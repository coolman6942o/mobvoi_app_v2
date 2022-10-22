package com.mobvoi.health.core.data.pojo;
/* loaded from: classes2.dex */
public enum DataType {
    Step(0),
    Exercise(1),
    Active(2),
    Calorie(3),
    Distance(4),
    Motion(5),
    Temperature(6),
    Sleep(7),
    Mood(8),
    TicMotion,
    Speed,
    Fitness;
    
    public static final int TYPE_NON_PERSISTENCE = -1;
    public final int typeCode;

    DataType() {
        this(-1);
    }

    public boolean isPersistent() {
        return this.typeCode >= 0;
    }

    DataType(int i10) {
        this.typeCode = i10;
    }
}
