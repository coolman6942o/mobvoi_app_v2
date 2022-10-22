package com.mobvoi.health.common.data.pojo;

import xf.b;
import xf.c;
/* loaded from: classes2.dex */
public enum MoodType implements c {
    Unknown(-1),
    Excited(0),
    Smile(1),
    Normal(2),
    Sad(3),
    Angry(4);
    
    public final int typeCode;

    MoodType(int i10) {
        this.typeCode = i10;
    }

    public static MoodType from(int i10) {
        return (MoodType) b.b(MoodType.class, i10);
    }

    @Override // xf.c
    public int getTypeCode() {
        return this.typeCode;
    }

    public /* bridge */ /* synthetic */ boolean isPersistent() {
        return b.a(this);
    }
}
