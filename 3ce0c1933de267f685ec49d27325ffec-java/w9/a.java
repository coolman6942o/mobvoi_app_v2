package w9;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.permission.PermissionConstant;
/* compiled from: BatteryInfoTracker.java */
/* loaded from: classes2.dex */
public class a extends b<Object> {

    /* renamed from: a  reason: collision with root package name */
    private static int f36155a = 100;

    /* compiled from: BatteryInfoTracker.java */
    /* renamed from: w9.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0523a {

        /* renamed from: a  reason: collision with root package name */
        private int f36156a;

        /* renamed from: b  reason: collision with root package name */
        private int f36157b;

        /* renamed from: c  reason: collision with root package name */
        public int f36158c;

        /* renamed from: d  reason: collision with root package name */
        public int f36159d;

        /* renamed from: e  reason: collision with root package name */
        public int f36160e;

        public boolean equals(Object obj) {
            if (!(obj instanceof C0523a)) {
                return false;
            }
            C0523a aVar = (C0523a) obj;
            return this.f36158c == aVar.f36158c && this.f36159d == aVar.f36159d && this.f36160e == aVar.f36160e;
        }

        public String toString() {
            return "BatteryInfo[level=" + this.f36156a + ", scale=" + this.f36157b + ", percent=" + this.f36158c + ", plugged=" + this.f36160e + "]";
        }
    }

    private static void a(C0523a aVar) {
        if (aVar.f36156a > aVar.f36157b) {
            k.f("BatteryInfoTracker", "Bad battery data! level: %d, scale: %d, sBatteryScale: %d", Integer.valueOf(aVar.f36156a), Integer.valueOf(aVar.f36157b), Integer.valueOf(f36155a));
            if (aVar.f36156a % 100 == 0) {
                f36155a = aVar.f36156a;
            }
        }
        int i10 = aVar.f36157b;
        int i11 = f36155a;
        if (i10 < i11) {
            aVar.f36157b = i11;
        }
    }

    public static C0523a b(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            return c(registerReceiver);
        }
        C0523a aVar = new C0523a();
        aVar.f36159d = 1;
        return aVar;
    }

    private static C0523a c(Intent intent) {
        C0523a aVar = new C0523a();
        aVar.f36156a = intent.getIntExtra("level", 0);
        aVar.f36157b = intent.getIntExtra("scale", 100);
        aVar.f36159d = intent.getIntExtra(PermissionConstant.Columns.STATUS, 1);
        aVar.f36160e = intent.getIntExtra("plugged", 0);
        a(aVar);
        int i10 = aVar.f36157b < 1 ? aVar.f36156a : (aVar.f36156a * 100) / aVar.f36157b;
        if (i10 >= 0 && i10 <= 100) {
            aVar.f36158c = i10;
        } else if (i10 < 0) {
            aVar.f36158c = 0;
        } else if (i10 > 100) {
            aVar.f36158c = 100;
        }
        return aVar;
    }
}
