package com.tendcloud.tenddata;

import android.os.Environment;
import org.json.JSONArray;
/* compiled from: td */
/* loaded from: classes2.dex */
public class ck extends ch {
    public ck() {
        a("manufacture", j.d());
        a("brand", j.e());
        a("model", j.f());
        a("dummy0", k.a("dummy0"));
        JSONArray jSONArray = new JSONArray();
        for (String str : j.n()) {
            jSONArray.put(str);
        }
        a("cpuInfo", jSONArray);
        JSONArray jSONArray2 = new JSONArray();
        for (int i10 : j.r()) {
            jSONArray2.put(i10);
        }
        a("memoryInfo", jSONArray2);
        JSONArray jSONArray3 = new JSONArray();
        for (int i11 : j.q()) {
            jSONArray3.put(i11);
        }
        a("sdCardInfo", jSONArray3);
        j.a(ab.f22568h, this.f22803b);
        j.b(ab.f22568h, this.f22803b);
        a("totalDiskSpace", Integer.valueOf(a()));
        a("cpu", j.o());
    }

    public static int a() {
        try {
            int[] s10 = j.s();
            if (s10 == null) {
                return 0;
            }
            if (!Environment.isExternalStorageEmulated()) {
                return s10[0] + s10[2];
            }
            return s10[0];
        } catch (Throwable unused) {
            return 0;
        }
    }

    public void setSlots(int i10) {
        a("slots", Integer.valueOf(i10));
    }
}
