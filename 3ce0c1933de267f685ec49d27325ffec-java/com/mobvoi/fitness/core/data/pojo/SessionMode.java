package com.mobvoi.fitness.core.data.pojo;
/* loaded from: classes2.dex */
public enum SessionMode {
    UNKNOWN(-1),
    UserAction(0),
    AutoMotion(1);
    
    public int typeCode;

    SessionMode(int i10) {
        this.typeCode = i10;
    }

    public static SessionMode from(int i10) {
        SessionMode[] values;
        for (SessionMode sessionMode : values()) {
            if (i10 == sessionMode.typeCode) {
                return sessionMode;
            }
        }
        return UNKNOWN;
    }
}
