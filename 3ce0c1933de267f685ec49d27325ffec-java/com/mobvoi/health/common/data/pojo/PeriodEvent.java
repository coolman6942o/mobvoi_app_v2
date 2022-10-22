package com.mobvoi.health.common.data.pojo;

import xf.b;
import xf.c;
/* loaded from: classes2.dex */
public enum PeriodEvent implements c {
    Unknown(-1),
    PeriodStart(0),
    PeriodEnd(1);
    
    public final int typeCode;

    PeriodEvent(int i10) {
        this.typeCode = i10;
    }

    public static PeriodEvent from(int i10) {
        return (PeriodEvent) b.b(PeriodEvent.class, i10);
    }

    @Override // xf.c
    public int getTypeCode() {
        return this.typeCode;
    }

    public /* bridge */ /* synthetic */ boolean isPersistent() {
        return b.a(this);
    }
}
