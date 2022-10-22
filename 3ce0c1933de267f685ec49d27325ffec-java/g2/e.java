package g2;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class e {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f27218a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f27219b;

    /* renamed from: c  reason: collision with root package name */
    /* synthetic */ List<c> f27220c = new ArrayList();

    public void a(c cVar) {
        this.f27220c.add(cVar);
    }

    public int b() {
        return this.f27218a;
    }

    public c[] c() {
        return (c[]) this.f27220c.toArray(new c[0]);
    }

    public String d() {
        return this.f27219b;
    }

    public void e(int i10) {
        this.f27218a = i10;
    }

    public void f(String str) {
        this.f27219b = str;
    }
}
