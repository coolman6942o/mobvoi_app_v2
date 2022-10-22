package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.h0;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.c;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
/* compiled from: SavedStateViewModelFactory.java */
/* loaded from: classes.dex */
public final class c0 extends h0.c {

    /* renamed from: f  reason: collision with root package name */
    private static final Class<?>[] f3296f = {Application.class, b0.class};

    /* renamed from: g  reason: collision with root package name */
    private static final Class<?>[] f3297g = {b0.class};

    /* renamed from: a  reason: collision with root package name */
    private final Application f3298a;

    /* renamed from: b  reason: collision with root package name */
    private final h0.b f3299b;

    /* renamed from: c  reason: collision with root package name */
    private final Bundle f3300c;

    /* renamed from: d  reason: collision with root package name */
    private final Lifecycle f3301d;

    /* renamed from: e  reason: collision with root package name */
    private final SavedStateRegistry f3302e;

    @SuppressLint({"LambdaLast"})
    public c0(Application application, c cVar, Bundle bundle) {
        h0.b bVar;
        this.f3302e = cVar.getSavedStateRegistry();
        this.f3301d = cVar.getLifecycle();
        this.f3300c = bundle;
        this.f3298a = application;
        if (application != null) {
            bVar = h0.a.g(application);
        } else {
            bVar = h0.d.d();
        }
        this.f3299b = bVar;
    }

    private static <T> Constructor<T> d(Class<T> cls, Class<?>[] clsArr) {
        for (Constructor<?> constructor : cls.getConstructors()) {
            Constructor<T> constructor2 = (Constructor<T>) constructor;
            if (Arrays.equals(clsArr, constructor2.getParameterTypes())) {
                return constructor2;
            }
        }
        return null;
    }

    @Override // androidx.lifecycle.h0.c, androidx.lifecycle.h0.b
    public <T extends f0> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) c(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.h0.e
    public void b(f0 f0Var) {
        SavedStateHandleController.d(f0Var, this.f3302e, this.f3301d);
    }

    @Override // androidx.lifecycle.h0.c
    public <T extends f0> T c(String str, Class<T> cls) {
        Constructor constructor;
        T t10;
        boolean isAssignableFrom = b.class.isAssignableFrom(cls);
        if (!isAssignableFrom || this.f3298a == null) {
            constructor = d(cls, f3297g);
        } else {
            constructor = d(cls, f3296f);
        }
        if (constructor == null) {
            return (T) this.f3299b.a(cls);
        }
        SavedStateHandleController j10 = SavedStateHandleController.j(this.f3302e, this.f3301d, str, this.f3300c);
        if (isAssignableFrom) {
            try {
                Application application = this.f3298a;
                if (application != null) {
                    t10 = (T) constructor.newInstance(application, j10.k());
                    t10.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", j10);
                    return t10;
                }
            } catch (IllegalAccessException e10) {
                throw new RuntimeException("Failed to access " + cls, e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException("A " + cls + " cannot be instantiated.", e11);
            } catch (InvocationTargetException e12) {
                throw new RuntimeException("An exception happened in constructor of " + cls, e12.getCause());
            }
        }
        t10 = (T) constructor.newInstance(j10.k());
        t10.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", j10);
        return t10;
    }
}
