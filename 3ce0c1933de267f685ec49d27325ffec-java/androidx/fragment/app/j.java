package androidx.fragment.app;

import androidx.collection.f;
import androidx.fragment.app.Fragment;
/* compiled from: FragmentFactory.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final f<ClassLoader, f<String, Class<?>>> f3143a = new f<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(ClassLoader classLoader, String str) {
        try {
            return Fragment.class.isAssignableFrom(c(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static Class<?> c(ClassLoader classLoader, String str) throws ClassNotFoundException {
        f<ClassLoader, f<String, Class<?>>> fVar = f3143a;
        f<String, Class<?>> fVar2 = fVar.get(classLoader);
        if (fVar2 == null) {
            fVar2 = new f<>();
            fVar.put(classLoader, fVar2);
        }
        Class<?> cls = fVar2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        fVar2.put(str, cls2);
        return cls2;
    }

    public static Class<? extends Fragment> d(ClassLoader classLoader, String str) {
        try {
            return c(classLoader, str);
        } catch (ClassCastException e10) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e10);
        } catch (ClassNotFoundException e11) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists", e11);
        }
    }

    public Fragment a(ClassLoader classLoader, String str) {
        throw null;
    }
}
