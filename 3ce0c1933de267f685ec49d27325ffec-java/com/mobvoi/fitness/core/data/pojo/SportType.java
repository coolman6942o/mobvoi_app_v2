package com.mobvoi.fitness.core.data.pojo;
/* loaded from: classes2.dex */
public enum SportType {
    Unknown(-1),
    OutdoorRunning(0),
    OutdoorWalk(1),
    IndoorRunning(2),
    OutdoorBike(3),
    FreeWorkout(4),
    AutoWalking(5),
    AutoRunning(6),
    BandRunning(7),
    BandAutoWalking(8),
    Swimming(9),
    AutoCycling(10),
    AutoSwimming(11),
    IndoorCycling(12),
    RowingMachine(13),
    Yoga(15),
    Climbing(17),
    CrossCountry(18),
    RopeSkipping(19),
    Gymnastics(20),
    Football(21),
    Basketball(22),
    Spinning(23);
    
    public final int typeCode;

    /* loaded from: classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17918a;

        static {
            int[] iArr = new int[SportType.values().length];
            f17918a = iArr;
            try {
                iArr[SportType.OutdoorWalk.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17918a[SportType.OutdoorRunning.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17918a[SportType.OutdoorBike.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17918a[SportType.AutoWalking.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17918a[SportType.AutoRunning.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17918a[SportType.AutoCycling.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17918a[SportType.BandRunning.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f17918a[SportType.AutoSwimming.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    SportType(int i10) {
        this.typeCode = i10;
    }

    public static SportType from(int i10) {
        SportType[] values;
        for (SportType sportType : values()) {
            if (sportType.typeCode == i10) {
                return sportType;
            }
        }
        return Unknown;
    }

    public long getMinRecordDuration() {
        int i10 = a.f17918a[ordinal()];
        if (i10 == 4) {
            return pf.a.f32766a;
        }
        if (i10 == 5) {
            return pf.a.f32767b;
        }
        if (i10 == 6) {
            return pf.a.f32768c;
        }
        if (i10 != 8) {
            return pf.a.f32772g;
        }
        return pf.a.f32769d;
    }

    public long getMotionDelayTime(boolean z10) {
        if (a.f17918a[ordinal()] == 5 && z10) {
            return pf.a.f32770e;
        }
        return pf.a.f32771f;
    }

    public boolean isAutoSport() {
        return this == AutoWalking || this == AutoCycling || this == AutoRunning || this == AutoSwimming || this == BandAutoWalking;
    }

    public boolean isRunning() {
        return this == AutoRunning || this == OutdoorRunning || this == IndoorRunning;
    }

    public boolean isSwimming() {
        return this == AutoSwimming || this == Swimming;
    }

    public boolean supportGps() {
        switch (a.f17918a[ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return true;
            default:
                return false;
        }
    }

    public static SportType from(String str) {
        try {
            return valueOf(str);
        } catch (Exception unused) {
            return Unknown;
        }
    }
}
