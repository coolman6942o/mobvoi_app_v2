package wd;

import android.content.Context;
import android.text.TextUtils;
import ce.h;
import com.mobvoi.android.common.utils.b;
import ta.a;
/* compiled from: UnitUserInfoMetricImpl.java */
/* loaded from: classes2.dex */
public class c implements a {
    @Override // wd.a
    public int a(String str) {
        try {
            return (int) Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    @Override // wd.a
    public String b(String str) {
        return str;
    }

    @Override // wd.a
    public int[] c() {
        return h(a.k());
    }

    @Override // wd.a
    public String d(int i10) {
        return String.valueOf(i10);
    }

    @Override // wd.a
    public int e() {
        int i10 = 0;
        try {
            if (!TextUtils.isEmpty(a.w())) {
                i10 = (int) Float.parseFloat(a.w());
            }
        } catch (NumberFormatException unused) {
        }
        if (i10 == 0) {
            return 60;
        }
        return i10;
    }

    @Override // wd.a
    public String f(Object... objArr) {
        return (objArr == null || objArr.length <= 0) ? "" : String.valueOf(objArr[0]);
    }

    @Override // wd.a
    public String g(float f10) {
        return j().getString(h.A, Integer.valueOf((int) f10));
    }

    @Override // wd.a
    public int[] h(String str) {
        int[] iArr = new int[1];
        float f10 = 0.0f;
        try {
            if (!TextUtils.isEmpty(str)) {
                f10 = Float.parseFloat(str);
            }
        } catch (NumberFormatException unused) {
        }
        iArr[0] = (int) f10;
        if (iArr[0] == 0) {
            iArr[0] = 170;
        }
        return iArr;
    }

    @Override // wd.a
    public String i(float f10) {
        if (f10 == 0.0f) {
            f10 = 170.0f;
        }
        return ((int) f10) + k();
    }

    public Context j() {
        return b.e();
    }

    public String k() {
        return j().getString(h.f5840d);
    }
}
