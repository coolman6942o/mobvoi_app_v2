package k8;

import com.google.gson.internal.e;
import java.lang.reflect.AccessibleObject;
/* compiled from: ReflectionAccessor.java */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static final b f29803a;

    static {
        f29803a = e.c() < 9 ? new a() : new c();
    }

    public static b a() {
        return f29803a;
    }

    public abstract void b(AccessibleObject accessibleObject);
}
