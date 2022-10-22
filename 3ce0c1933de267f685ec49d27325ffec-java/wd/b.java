package wd;

import android.content.Context;
import android.text.TextUtils;
import ce.h;
import com.mobvoi.wear.util.UnitsUtility;
import ta.a;
/* compiled from: UnitUserInfoImperialImpl.java */
/* loaded from: classes2.dex */
public class b implements a {
    @Override // wd.a
    public int a(String str) {
        int kg2PoundValue = !TextUtils.isEmpty(str) ? UnitsUtility.kg2PoundValue(str) : 0;
        if (kg2PoundValue == 0) {
            return 155;
        }
        return kg2PoundValue;
    }

    @Override // wd.a
    public String b(String str) {
        return UnitsUtility.pound2KgStr(str);
    }

    @Override // wd.a
    public int[] c() {
        return h(a.k());
    }

    @Override // wd.a
    public String d(int i10) {
        return UnitsUtility.pound2KgStr(i10);
    }

    @Override // wd.a
    public int e() {
        return a(a.w());
    }

    @Override // wd.a
    public String f(Object... objArr) {
        return (objArr == null || objArr.length != 2) ? "" : String.valueOf(UnitsUtility.inch2Cm(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue()));
    }

    @Override // wd.a
    public String g(float f10) {
        int intValue = Float.valueOf(UnitsUtility.kg2PoundValue(f10)).intValue();
        return intValue + j().getString(h.M);
    }

    @Override // wd.a
    public int[] h(String str) {
        int[] iArr = new int[2];
        if (!TextUtils.isEmpty(str)) {
            iArr[0] = UnitsUtility.totalInch2Foot(UnitsUtility.cm2Inch(Float.parseFloat(str)));
            iArr[1] = UnitsUtility.totalInch2Inch(UnitsUtility.cm2Inch(Float.parseFloat(str)));
        }
        if (iArr[0] == 0 && iArr[1] == 0) {
            iArr[0] = 5;
            iArr[1] = 7;
        }
        return iArr;
    }

    @Override // wd.a
    public String i(float f10) {
        return f10 > 0.0f ? UnitsUtility.cm2FootAInch(f10) : "5' 7''";
    }

    public Context j() {
        return com.mobvoi.android.common.utils.b.e();
    }
}
