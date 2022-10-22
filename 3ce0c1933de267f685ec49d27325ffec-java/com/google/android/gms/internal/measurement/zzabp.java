package com.google.android.gms.internal.measurement;
/* JADX WARN: Init of enum zzbvl can be incorrect */
/* JADX WARN: Init of enum zzbvm can be incorrect */
/* JADX WARN: Init of enum zzbvn can be incorrect */
/* JADX WARN: Init of enum zzbvo can be incorrect */
/* JADX WARN: Init of enum zzbvp can be incorrect */
/* JADX WARN: Init of enum zzbvr can be incorrect */
/* JADX WARN: Init of enum zzbvs can be incorrect */
/* JADX WARN: Init of enum zzbvt can be incorrect */
/* JADX WARN: Init of enum zzbvu can be incorrect */
/* JADX WARN: Init of enum zzbvv can be incorrect */
/* JADX WARN: Init of enum zzbvx can be incorrect */
/* JADX WARN: Init of enum zzbvy can be incorrect */
/* JADX WARN: Init of enum zzbvz can be incorrect */
/* JADX WARN: Init of enum zzbwa can be incorrect */
/* loaded from: classes.dex */
public enum zzabp {
    DOUBLE(zzabu.DOUBLE, 1),
    FLOAT(zzabu.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(zzabu.BOOLEAN, 0),
    STRING(r13, 2) { // from class: com.google.android.gms.internal.measurement.c
    },
    GROUP(r13, 3) { // from class: com.google.android.gms.internal.measurement.d
    },
    MESSAGE(r13, 2) { // from class: com.google.android.gms.internal.measurement.e
    },
    BYTES(r13, 2) { // from class: com.google.android.gms.internal.measurement.f
    },
    UINT32(r11, 0),
    ENUM(zzabu.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final zzabu zzbwb;
    private final int zzbwc;

    static {
        zzabu zzabuVar = zzabu.LONG;
        zzabu zzabuVar2 = zzabu.INT;
        final zzabu zzabuVar3 = zzabu.STRING;
        final zzabu zzabuVar4 = zzabu.MESSAGE;
        final zzabu zzabuVar5 = zzabu.BYTE_STRING;
    }

    zzabp(zzabu zzabuVar, int i10) {
        this.zzbwb = zzabuVar;
        this.zzbwc = i10;
    }

    public final zzabu zzuv() {
        return this.zzbwb;
    }
}
