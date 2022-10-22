package zj;

import android.content.Context;
import android.text.format.DateFormat;
import com.mobvoi.health.common.data.pojo.MotionType;
import com.mobvoi.sleep.data.pojo.SleepRecord;
import java.util.Calendar;
import java.util.Date;
import wj.c;
/* compiled from: UiStrings.java */
/* loaded from: classes2.dex */
public class d {

    /* compiled from: UiStrings.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f37622a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f37623b;

        static {
            int[] iArr = new int[MotionType.values().length];
            f37623b = iArr;
            try {
                iArr[MotionType.Awake.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37623b[MotionType.Rem.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37623b[MotionType.LightSleep.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f37623b[MotionType.DeepSleep.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[SleepRecord.TimeType.values().length];
            f37622a = iArr2;
            try {
                iArr2[SleepRecord.TimeType.InBed.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f37622a[SleepRecord.TimeType.InSleep.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f37622a[SleepRecord.TimeType.FallAsleep.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f37622a[SleepRecord.TimeType.Awake.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f37622a[SleepRecord.TimeType.Rem.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f37622a[SleepRecord.TimeType.LightSleep.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f37622a[SleepRecord.TimeType.DeepSleep.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public static CharSequence a(Context context, long j10) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j10);
        return b(context, calendar);
    }

    public static CharSequence b(Context context, Calendar calendar) {
        if (DateFormat.is24HourFormat(context)) {
            return DateFormat.format("HH:mm", calendar);
        }
        return DateFormat.format("hh:mm a", calendar);
    }

    public static CharSequence c(Context context, Date date) {
        if (DateFormat.is24HourFormat(context)) {
            return DateFormat.format("HH:mm", date);
        }
        return DateFormat.format("hh:mm a", date);
    }

    public static int d(long j10) {
        if (j10 <= 0) {
            return 0;
        }
        float f10 = (((float) j10) / 1000.0f) / 60.0f;
        if (f10 < 1.0f) {
            return 1;
        }
        return Math.round(f10);
    }

    public static String e(Context context, MotionType motionType) {
        int i10;
        int i11 = a.f37623b[motionType.ordinal()];
        if (i11 == 1) {
            i10 = c.f36283m;
        } else if (i11 == 2) {
            i10 = c.f36289s;
        } else if (i11 == 3) {
            i10 = c.f36288r;
        } else if (i11 != 4) {
            i10 = c.f36283m;
        } else {
            i10 = c.f36284n;
        }
        return context.getString(i10);
    }

    public static String f(Context context, SleepRecord.TimeType timeType) {
        int i10;
        switch (a.f37622a[timeType.ordinal()]) {
            case 1:
                i10 = c.f36286p;
                break;
            case 2:
                i10 = c.f36287q;
                break;
            case 3:
                i10 = c.f36285o;
                break;
            case 4:
                i10 = c.f36283m;
                break;
            case 5:
                i10 = c.f36289s;
                break;
            case 6:
                i10 = c.f36288r;
                break;
            case 7:
                i10 = c.f36284n;
                break;
            default:
                i10 = 0;
                break;
        }
        return context.getString(i10);
    }
}
