package n4;

import android.content.Context;
import com.amap.api.services.a.e;
import java.util.List;
/* compiled from: SDKDBOperation.java */
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private com.amap.api.services.a.m f31020a;

    /* renamed from: b  reason: collision with root package name */
    private Context f31021b;

    public m(Context context, boolean z10) {
        this.f31021b = context;
        this.f31020a = a(context, z10);
    }

    private com.amap.api.services.a.m a(Context context, boolean z10) {
        try {
            return new com.amap.api.services.a.m(context, com.amap.api.services.a.m.g(j.class));
        } catch (Throwable th2) {
            if (!z10) {
                c.b(th2, "SDKDB", "getDB");
            } else {
                th2.printStackTrace();
            }
            return null;
        }
    }

    public List<e> b() {
        try {
            return this.f31020a.f(e.g(), e.class, true);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }
}
