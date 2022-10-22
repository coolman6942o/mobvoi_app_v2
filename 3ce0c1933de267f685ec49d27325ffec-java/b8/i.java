package b8;

import android.content.Context;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5089a;

    /* renamed from: b  reason: collision with root package name */
    private final l f5090b;

    public i(Context context) {
        this(context, new k());
    }

    private i(Context context, l lVar) {
        this.f5089a = context;
        this.f5090b = lVar;
    }

    private static List<e> a(List<String> list) {
        Throwable e10;
        String str;
        ArrayList arrayList = new ArrayList();
        for (String str2 : list) {
            try {
                Class<?> cls = Class.forName(str2);
                if (!e.class.isAssignableFrom(cls)) {
                    Log.w("ComponentDiscovery", String.format("Class %s is not an instance of %s", str2, "com.google.firebase.components.ComponentRegistrar"));
                } else {
                    arrayList.add((e) cls.newInstance());
                }
            } catch (ClassNotFoundException e11) {
                e10 = e11;
                str = String.format("Class %s is not an found.", str2);
                Log.w("ComponentDiscovery", str, e10);
            } catch (IllegalAccessException e12) {
                e10 = e12;
                str = String.format("Could not instantiate %s.", str2);
                Log.w("ComponentDiscovery", str, e10);
            } catch (InstantiationException e13) {
                e10 = e13;
                str = String.format("Could not instantiate %s.", str2);
                Log.w("ComponentDiscovery", str, e10);
            }
        }
        return arrayList;
    }

    public final List<e> b() {
        return a(this.f5090b.a(this.f5089a));
    }
}
