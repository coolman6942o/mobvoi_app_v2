package k4;

import android.content.Context;
import com.amap.api.mapcore2d.f;
import java.util.List;
/* compiled from: SDKDBOperation.java */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private com.amap.api.mapcore2d.n f29753a;

    /* renamed from: b  reason: collision with root package name */
    private Context f29754b;

    public n(Context context, boolean z10) {
        this.f29754b = context;
        this.f29753a = a(context, z10);
    }

    private com.amap.api.mapcore2d.n a(Context context, boolean z10) {
        try {
            return new com.amap.api.mapcore2d.n(context, com.amap.api.mapcore2d.n.g(k.class));
        } catch (Throwable th2) {
            if (!z10) {
                d.b(th2, "SDKDB", "getDB");
            } else {
                th2.printStackTrace();
            }
            return null;
        }
    }

    public List<f> b() {
        try {
            return this.f29753a.f(f.g(), f.class, true);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }
}
