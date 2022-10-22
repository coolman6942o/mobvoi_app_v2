package zj;

import android.content.Context;
import com.mobvoi.health.common.data.pojo.MotionType;
import com.mobvoi.sleep.data.pojo.SleepRecord;
/* compiled from: ColorUtils.java */
/* loaded from: classes2.dex */
public class a {

    /* compiled from: ColorUtils.java */
    /* renamed from: zj.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class C0548a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f37620a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f37621b;

        static {
            int[] iArr = new int[MotionType.values().length];
            f37621b = iArr;
            try {
                iArr[MotionType.Rem.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37621b[MotionType.LightSleep.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37621b[MotionType.DeepSleep.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f37621b[MotionType.Awake.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[SleepRecord.TimeType.values().length];
            f37620a = iArr2;
            try {
                iArr2[SleepRecord.TimeType.Awake.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f37620a[SleepRecord.TimeType.Rem.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f37620a[SleepRecord.TimeType.LightSleep.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f37620a[SleepRecord.TimeType.DeepSleep.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static int a(Context context, int i10) {
        if (i10 == 0) {
            return context.getResources().getColor(wj.a.f36257d);
        }
        if (i10 == 1) {
            return context.getResources().getColor(wj.a.f36256c);
        }
        if (i10 == 2) {
            return context.getResources().getColor(wj.a.f36255b);
        }
        if (i10 == 3) {
            return context.getResources().getColor(wj.a.f36258e);
        }
        if (i10 != 4) {
            return context.getResources().getColor(wj.a.f36257d);
        }
        return context.getResources().getColor(wj.a.f36254a);
    }

    public static int b(Context context, MotionType motionType) {
        int i10 = C0548a.f37621b[motionType.ordinal()];
        if (i10 == 1) {
            return context.getResources().getColor(wj.a.f36266m);
        }
        if (i10 == 2) {
            return context.getResources().getColor(wj.a.f36265l);
        }
        if (i10 != 3) {
            return context.getResources().getColor(wj.a.f36263j);
        }
        return context.getResources().getColor(wj.a.f36264k);
    }

    public static int c(Context context, SleepRecord.TimeType timeType) {
        int i10 = C0548a.f37620a[timeType.ordinal()];
        if (i10 == 1) {
            return context.getResources().getColor(wj.a.f36263j);
        }
        if (i10 == 2) {
            return context.getResources().getColor(wj.a.f36266m);
        }
        if (i10 == 3) {
            return context.getResources().getColor(wj.a.f36265l);
        }
        if (i10 != 4) {
            return context.getResources().getColor(17170443);
        }
        return context.getResources().getColor(wj.a.f36264k);
    }
}
