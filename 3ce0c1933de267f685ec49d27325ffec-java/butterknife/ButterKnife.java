package butterknife;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class ButterKnife {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f5535a = false;

    /* renamed from: b  reason: collision with root package name */
    static final Map<Class<?>, Constructor<? extends Unbinder>> f5536b = new LinkedHashMap();

    private ButterKnife() {
        throw new AssertionError("No instances.");
    }

    public static Unbinder a(Object obj, View view) {
        Class<?> cls = obj.getClass();
        if (f5535a) {
            Log.d("ButterKnife", "Looking up binding for " + cls.getName());
        }
        Constructor<? extends Unbinder> b10 = b(cls);
        if (b10 == null) {
            return Unbinder.f5537a;
        }
        try {
            return b10.newInstance(obj, view);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Unable to invoke " + b10, e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException("Unable to invoke " + b10, e11);
        } catch (InvocationTargetException e12) {
            Throwable cause = e12.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unable to create binding instance.", cause);
            }
        }
    }

    private static Constructor<? extends Unbinder> b(Class<?> cls) {
        Constructor<? extends Unbinder> constructor;
        Map<Class<?>, Constructor<? extends Unbinder>> map = f5536b;
        Constructor<? extends Unbinder> constructor2 = map.get(cls);
        if (constructor2 != null || map.containsKey(cls)) {
            if (f5535a) {
                Log.d("ButterKnife", "HIT: Cached in binding map.");
            }
            return constructor2;
        }
        String name = cls.getName();
        if (!name.startsWith("android.") && !name.startsWith("java.") && !name.startsWith("androidx.")) {
            try {
                ClassLoader classLoader = cls.getClassLoader();
                constructor = classLoader.loadClass(name + "_ViewBinding").getConstructor(cls, View.class);
                if (f5535a) {
                    Log.d("ButterKnife", "HIT: Loaded binding class and constructor.");
                }
            } catch (ClassNotFoundException unused) {
                if (f5535a) {
                    Log.d("ButterKnife", "Not found. Trying superclass " + cls.getSuperclass().getName());
                }
                constructor = b(cls.getSuperclass());
            } catch (NoSuchMethodException e10) {
                throw new RuntimeException("Unable to find binding constructor for " + name, e10);
            }
            f5536b.put(cls, constructor);
            return constructor;
        } else if (!f5535a) {
            return null;
        } else {
            Log.d("ButterKnife", "MISS: Reached framework class. Abandoning search.");
            return null;
        }
    }
}
