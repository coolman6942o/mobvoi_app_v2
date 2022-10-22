package com.mobvoi.health.common.data.pojo;

import com.mobvoi.wear.common.base.Constants;
import xf.b;
import xf.c;
import xf.d;
import xf.e;
/* loaded from: classes2.dex */
public enum ActivityType implements c, e {
    Unknown(-1, ""),
    IndoorRunning(0, "indoor_running"),
    OutdoorWalk(1, Constants.Fitness.TYPE_OUTDOOR_WALK),
    OutdoorRunning(2, "outdoor_running"),
    OutdoorBike(3, "outdoor_bike"),
    FreeWorkout(4, "free_workout"),
    AutoRunning(10, "auto_running"),
    AutoWalking(11, "auto_walking"),
    AutoCycling(13, "auto_cycling"),
    AutoSwimming(14, ""),
    Swimming(12, ""),
    IndoorCycling(20, ""),
    Basketball(21, ""),
    Football(22, ""),
    Gymnastics(23, ""),
    RopeSkipping(24, ""),
    Spinning(25, ""),
    BodyMechanics(26, ""),
    Climbing(27, ""),
    EllipticalMachine(28, ""),
    RowingMachine(29, ""),
    OffRoad(30, ""),
    Yoga(31, ""),
    AutoSleep(100, "auto_sleep");
    
    public final String name;
    public final int typeCode;

    /* loaded from: classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17963a;

        static {
            int[] iArr = new int[ActivityType.values().length];
            f17963a = iArr;
            try {
                iArr[ActivityType.AutoWalking.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17963a[ActivityType.AutoRunning.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17963a[ActivityType.AutoCycling.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17963a[ActivityType.AutoSwimming.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    ActivityType(int i10, String str) {
        this.typeCode = i10;
        this.name = str;
    }

    public static ActivityType from(int i10) {
        return (ActivityType) b.b(ActivityType.class, i10);
    }

    public static ActivityType parseAutoType(MotionType motionType) {
        if (motionType == MotionType.Run || motionType == MotionType.FastRun) {
            return AutoRunning;
        }
        if (motionType == MotionType.FastWalk) {
            return AutoWalking;
        }
        if (motionType == MotionType.Bike) {
            return AutoCycling;
        }
        if (motionType == MotionType.Swimming) {
            return Unknown;
        }
        return Unknown;
    }

    public long getMinRecordDuration() {
        int i10 = a.f17963a[ordinal()];
        if (i10 == 1) {
            return pf.a.f32766a;
        }
        if (i10 == 2) {
            return pf.a.f32767b;
        }
        if (i10 == 3) {
            return pf.a.f32768c;
        }
        if (i10 != 4) {
            return 0L;
        }
        return pf.a.f32769d;
    }

    @Override // xf.e
    public String getName() {
        return this.name;
    }

    @Override // xf.c
    public int getTypeCode() {
        return this.typeCode;
    }

    public boolean isExercise() {
        int i10 = this.typeCode;
        return i10 >= 0 && i10 < AutoSleep.typeCode;
    }

    public /* bridge */ /* synthetic */ boolean isLocal() {
        return d.a(this);
    }

    public /* bridge */ /* synthetic */ boolean isPersistent() {
        return b.a(this);
    }

    public boolean isSleep() {
        return this == AutoSleep;
    }

    public static ActivityType from(String str) {
        return (ActivityType) d.b(ActivityType.class, str);
    }
}
