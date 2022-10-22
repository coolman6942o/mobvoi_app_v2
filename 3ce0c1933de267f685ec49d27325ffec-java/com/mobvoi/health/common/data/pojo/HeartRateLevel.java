package com.mobvoi.health.common.data.pojo;

import mf.b;
import mf.d;
/* loaded from: classes2.dex */
public enum HeartRateLevel {
    NONE,
    RESTING,
    WARM_UP,
    FAT_BURN,
    AEROBIC,
    ANAEROBIC,
    DANGEROUS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17964a;

        static {
            int[] iArr = new int[HeartRateLevel.values().length];
            f17964a = iArr;
            try {
                iArr[HeartRateLevel.RESTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17964a[HeartRateLevel.WARM_UP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17964a[HeartRateLevel.FAT_BURN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17964a[HeartRateLevel.AEROBIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17964a[HeartRateLevel.ANAEROBIC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17964a[HeartRateLevel.DANGEROUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17964a[HeartRateLevel.NONE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static int endHeartRateOf(HeartRateLevel heartRateLevel, int i10) {
        if (i10 <= 0 || i10 >= 220) {
            i10 = 25;
        }
        int i11 = 220 - i10;
        switch (a.f17964a[heartRateLevel.ordinal()]) {
            case 1:
                return i11 / 2;
            case 2:
                return (i11 * 6) / 10;
            case 3:
                return (i11 * 7) / 10;
            case 4:
                return (i11 * 9) / 10;
            case 5:
                return i11;
            case 6:
                return 220;
            default:
                return 0;
        }
    }

    public static int getHeartRateColor(HeartRateLevel heartRateLevel) {
        switch (a.f17964a[heartRateLevel.ordinal()]) {
            case 1:
            case 7:
                return b.f30671i;
            case 2:
                return b.f30672j;
            case 3:
                return b.f30670h;
            case 4:
                return b.f30667e;
            case 5:
                return b.f30668f;
            case 6:
                return b.f30669g;
            default:
                return b.f30671i;
        }
    }

    public static int getHeartRateString(HeartRateLevel heartRateLevel) {
        switch (a.f17964a[heartRateLevel.ordinal()]) {
            case 1:
                return d.f30736u1;
            case 2:
                return d.f30739v1;
            case 3:
                return d.f30733t1;
            case 4:
                return d.f30724q1;
            case 5:
                return d.f30727r1;
            case 6:
                return d.f30730s1;
            default:
                return d.f30736u1;
        }
    }

    public static HeartRateLevel levelOf(int i10, int i11) {
        HeartRateLevel[] heartRateLevelArr = {DANGEROUS, ANAEROBIC, AEROBIC, FAT_BURN, WARM_UP, RESTING};
        for (int i12 = 0; i12 < 6; i12++) {
            HeartRateLevel heartRateLevel = heartRateLevelArr[i12];
            if (i10 >= startHeartRateOf(heartRateLevel, i11)) {
                return heartRateLevel;
            }
        }
        return NONE;
    }

    public static int[] rangHeartRateOf(HeartRateLevel heartRateLevel) {
        int i10 = a.f17964a[heartRateLevel.ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 != 5 ? new int[]{0, 0} : new int[]{90, 10} : new int[]{70, 90} : new int[]{60, 70} : new int[]{50, 60} : new int[]{0, 50};
    }

    public static int startHeartRateOf(HeartRateLevel heartRateLevel, int i10) {
        if (i10 <= 0 || i10 >= 220) {
            i10 = 25;
        }
        int i11 = 220 - i10;
        int i12 = a.f17964a[heartRateLevel.ordinal()];
        if (i12 == 2) {
            return i11 / 2;
        }
        if (i12 == 3) {
            return (i11 * 6) / 10;
        }
        if (i12 == 4) {
            return (i11 * 7) / 10;
        }
        if (i12 == 5) {
            return (i11 * 9) / 10;
        }
        if (i12 != 6) {
            return 0;
        }
        return i11;
    }
}
