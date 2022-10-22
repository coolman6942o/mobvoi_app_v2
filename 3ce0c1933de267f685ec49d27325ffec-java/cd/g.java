package cd;

import java.util.ServiceLoader;
/* compiled from: MapViewFactory.java */
/* loaded from: classes2.dex */
public class g {

    /* renamed from: b  reason: collision with root package name */
    private static g f5740b;

    /* renamed from: a  reason: collision with root package name */
    private h f5741a = (h) ServiceLoader.load(h.class).iterator().next();

    private g() {
    }

    public static g b() {
        if (f5740b == null) {
            synchronized (g.class) {
                if (f5740b == null) {
                    f5740b = new g();
                }
            }
        }
        return f5740b;
    }

    public h a() {
        return this.f5741a;
    }
}
