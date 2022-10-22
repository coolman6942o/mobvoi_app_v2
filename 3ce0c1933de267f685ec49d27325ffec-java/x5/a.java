package x5;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    private static int f36445b = 31;

    /* renamed from: a  reason: collision with root package name */
    private int f36446a = 1;

    public a a(Object obj) {
        this.f36446a = (f36445b * this.f36446a) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    public int b() {
        return this.f36446a;
    }

    public final a c(boolean z10) {
        this.f36446a = (f36445b * this.f36446a) + (z10 ? 1 : 0);
        return this;
    }
}
