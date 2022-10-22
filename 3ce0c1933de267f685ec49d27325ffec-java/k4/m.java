package k4;

import com.amap.api.mapcore2d.g;
import com.amap.api.mapcore2d.n;
import java.util.HashMap;
/* compiled from: LogInfo.java */
/* loaded from: classes.dex */
public abstract class m {
    @f(a = "b1", b = 6)

    /* renamed from: b  reason: collision with root package name */
    protected String f29751b;
    @f(a = "b2", b = 2)

    /* renamed from: a  reason: collision with root package name */
    protected int f29750a = -1;
    @f(a = "b3", b = 2)

    /* renamed from: c  reason: collision with root package name */
    protected int f29752c = 1;

    public static String h(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("b1", str);
        return n.e(hashMap);
    }

    public int a() {
        return this.f29750a;
    }

    public void b(int i10) {
        this.f29750a = i10;
    }

    public void c(String str) {
        this.f29751b = str;
    }

    public String d() {
        return this.f29751b;
    }

    public void e(int i10) {
        this.f29752c = i10;
    }

    public void f(String str) {
        g.g(str);
    }

    public int g() {
        return this.f29752c;
    }
}
