package n4;

import com.amap.api.services.a.f;
import com.amap.api.services.a.m;
import java.util.HashMap;
/* compiled from: LogInfo.java */
/* loaded from: classes.dex */
public abstract class l {
    @e(a = "b1", b = 6)

    /* renamed from: b  reason: collision with root package name */
    protected String f31018b;
    @e(a = "b2", b = 2)

    /* renamed from: a  reason: collision with root package name */
    protected int f31017a = -1;
    @e(a = "b3", b = 2)

    /* renamed from: c  reason: collision with root package name */
    protected int f31019c = 1;

    public static String h(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("b1", str);
        return m.e(hashMap);
    }

    public int a() {
        return this.f31017a;
    }

    public void b(int i10) {
        this.f31017a = i10;
    }

    public void c(String str) {
        this.f31018b = str;
    }

    public String d() {
        return this.f31018b;
    }

    public void e(int i10) {
        this.f31019c = i10;
    }

    public void f(String str) {
        f.f(str);
    }

    public int g() {
        return this.f31019c;
    }
}
