package oj;

import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;
/* compiled from: PlatformSupportManager.java */
/* loaded from: classes2.dex */
public abstract class d<T> {

    /* renamed from: d  reason: collision with root package name */
    private static final String f31727d = "d";

    /* renamed from: a  reason: collision with root package name */
    private final Class<T> f31728a;

    /* renamed from: b  reason: collision with root package name */
    private final T f31729b;

    /* renamed from: c  reason: collision with root package name */
    private final SortedMap<Integer, String> f31730c;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Class<T> cls, T t10) {
        if (!cls.isInterface()) {
            throw new IllegalArgumentException();
        } else if (cls.isInstance(t10)) {
            this.f31728a = cls;
            this.f31729b = t10;
            this.f31730c = new TreeMap(Collections.reverseOrder());
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i10, String str) {
        this.f31730c.put(Integer.valueOf(i10), str);
    }

    public final T b() {
        Iterator<Integer> it = this.f31730c.keySet().iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            if (Build.VERSION.SDK_INT >= next.intValue()) {
                try {
                    Class<? extends U> asSubclass = Class.forName(this.f31730c.get(next)).asSubclass((Class<T>) this.f31728a);
                    String str = f31727d;
                    Log.i(str, "Using implementation " + asSubclass + " of " + this.f31728a + " for SDK " + next);
                    return (T) asSubclass.getConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (ClassNotFoundException e10) {
                    Log.w(f31727d, e10);
                } catch (IllegalAccessException e11) {
                    Log.w(f31727d, e11);
                } catch (InstantiationException e12) {
                    Log.w(f31727d, e12);
                } catch (NoSuchMethodException e13) {
                    Log.w(f31727d, e13);
                } catch (InvocationTargetException e14) {
                    Log.w(f31727d, e14);
                }
            }
        }
        String str2 = f31727d;
        Log.i(str2, "Using default implementation " + this.f31729b.getClass() + " of " + this.f31728a);
        return this.f31729b;
    }
}
