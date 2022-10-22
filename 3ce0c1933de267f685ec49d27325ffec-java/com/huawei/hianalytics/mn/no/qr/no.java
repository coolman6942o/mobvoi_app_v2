package com.huawei.hianalytics.mn.no.qr;

import android.util.Log;
import com.huawei.hianalytics.mn.st.mn;
/* loaded from: classes.dex */
public class no {

    /* renamed from: mn  reason: collision with root package name */
    private boolean f13609mn = false;

    /* renamed from: no  reason: collision with root package name */
    private int f13610no = 4;

    private static String mn() {
        return "HiAnalyticsSDK_2.2.0.304" + mn.mn();
    }

    public void mn(int i10) {
        Log.i("HiAnalyticsSDK", "\n=======================================\n " + mn() + "\n=======================================");
        this.f13610no = i10;
        this.f13609mn = true;
    }

    public void mn(int i10, String str, String str2) {
        no(i10, "HiAnalyticsSDK", str + "=> " + str2);
    }

    public void no(int i10, String str, String str2) {
        if (i10 == 3) {
            Log.d(str, str2);
        } else if (i10 == 4) {
            Log.i(str, str2);
        } else if (i10 == 5) {
            Log.w(str, str2);
        } else if (i10 != 6) {
            Log.i(str, str2);
        } else {
            Log.e(str, str2);
        }
    }

    public boolean no(int i10) {
        return this.f13609mn && i10 >= this.f13610no;
    }
}
