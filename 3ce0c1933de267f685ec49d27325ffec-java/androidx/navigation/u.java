package androidx.navigation;

import android.annotation.SuppressLint;
import androidx.navigation.t;
import java.util.HashMap;
import java.util.Map;
/* compiled from: NavigatorProvider.java */
@SuppressLint({"TypeParameterUnusedInFormals"})
/* loaded from: classes.dex */
public class u {

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap<Class<?>, String> f3562b = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, t<? extends k>> f3563a = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(Class<? extends t> cls) {
        HashMap<Class<?>, String> hashMap = f3562b;
        String str = hashMap.get(cls);
        if (str == null) {
            t.b bVar = (t.b) cls.getAnnotation(t.b.class);
            str = bVar != null ? bVar.value() : null;
            if (g(str)) {
                hashMap.put(cls, str);
            } else {
                throw new IllegalArgumentException("No @Navigator.Name annotation found for " + cls.getSimpleName());
            }
        }
        return str;
    }

    private static boolean g(String str) {
        return str != null && !str.isEmpty();
    }

    public final t<? extends k> a(t<? extends k> tVar) {
        return b(c(tVar.getClass()), tVar);
    }

    public t<? extends k> b(String str, t<? extends k> tVar) {
        if (g(str)) {
            return this.f3563a.put(str, tVar);
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string");
    }

    public final <T extends t<?>> T d(Class<T> cls) {
        return (T) e(c(cls));
    }

    public <T extends t<?>> T e(String str) {
        if (g(str)) {
            t<? extends k> tVar = this.f3563a.get(str);
            if (tVar != null) {
                return tVar;
            }
            throw new IllegalStateException("Could not find Navigator with name \"" + str + "\". You must call NavController.addNavigator() for each navigation type.");
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, t<? extends k>> f() {
        return this.f3563a;
    }
}
