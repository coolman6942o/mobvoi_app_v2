package kotlinx.coroutines.internal;

import io.b;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kotlin.collections.n;
import kotlin.collections.r;
import kotlin.collections.u;
import kotlin.jvm.internal.i;
import kotlin.text.t;
/* compiled from: FastServiceLoader.kt */
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f30217a = new g();

    private g() {
    }

    private final <S> S a(String str, ClassLoader classLoader, Class<S> cls) {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (cls.isAssignableFrom(cls2)) {
            return cls.cast(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
    }

    private final <S> List<S> b(Class<S> cls, ClassLoader classLoader) {
        List<S> U;
        try {
            return d(cls, classLoader);
        } catch (Throwable unused) {
            U = u.U(ServiceLoader.load(cls, classLoader));
            return U;
        }
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Throwable, java.lang.Object, java.lang.String] */
    private final List<String> e(URL url) {
        boolean D;
        String x02;
        String C0;
        String x03;
        String url2 = url.toString();
        th = 0;
        D = t.D(url2, "jar", false, 2, th);
        if (D) {
            x02 = kotlin.text.u.x0(url2, "jar:file:", th, 2, th);
            C0 = kotlin.text.u.C0(x02, '!', th, 2, th);
            x03 = kotlin.text.u.x0(url2, "!/", th, 2, th);
            JarFile jarFile = new JarFile(C0, false);
            try {
                List<String> f10 = f30217a.f(new BufferedReader(new InputStreamReader(jarFile.getInputStream(new ZipEntry(x03)), "UTF-8")));
                jarFile.close();
                return f10;
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    try {
                        jarFile.close();
                        throw th3;
                    } catch (Throwable th4) {
                        b.a(th2, th4);
                        throw th2;
                    }
                }
            }
        } else {
            try {
                return f30217a.f(new BufferedReader(new InputStreamReader(url.openStream())));
            } finally {
                try {
                    throw th;
                } finally {
                }
            }
        }
    }

    private final List<String> f(BufferedReader bufferedReader) {
        List<String> U;
        String D0;
        CharSequence E0;
        boolean z10;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                U = u.U(linkedHashSet);
                return U;
            }
            D0 = kotlin.text.u.D0(readLine, "#", null, 2, null);
            Objects.requireNonNull(D0, "null cannot be cast to non-null type kotlin.CharSequence");
            E0 = kotlin.text.u.E0(D0);
            String obj = E0.toString();
            boolean z11 = false;
            int i10 = 0;
            while (true) {
                if (i10 >= obj.length()) {
                    z10 = true;
                    break;
                }
                char charAt = obj.charAt(i10);
                if (!(charAt == '.' || Character.isJavaIdentifierPart(charAt))) {
                    z10 = false;
                    break;
                }
                i10++;
            }
            if (z10) {
                if (obj.length() > 0) {
                    z11 = true;
                }
                if (z11) {
                    linkedHashSet.add(obj);
                }
            } else {
                throw new IllegalArgumentException(i.n("Illegal service provider class name: ", obj).toString());
            }
        }
    }

    public final List<MainDispatcherFactory> c() {
        MainDispatcherFactory mainDispatcherFactory;
        if (!h.a()) {
            return b(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
        }
        try {
            ArrayList arrayList = new ArrayList(2);
            MainDispatcherFactory mainDispatcherFactory2 = null;
            try {
                mainDispatcherFactory = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused) {
                mainDispatcherFactory = null;
            }
            if (mainDispatcherFactory != null) {
                arrayList.add(mainDispatcherFactory);
            }
            try {
                mainDispatcherFactory2 = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused2) {
            }
            if (mainDispatcherFactory2 == null) {
                return arrayList;
            }
            arrayList.add(mainDispatcherFactory2);
            return arrayList;
        } catch (Throwable unused3) {
            return b(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
        }
    }

    public final <S> List<S> d(Class<S> cls, ClassLoader classLoader) {
        Set<String> X;
        int p10;
        ArrayList<URL> list = Collections.list(classLoader.getResources(i.n("META-INF/services/", cls.getName())));
        i.e(list, "java.util.Collections.list(this)");
        ArrayList arrayList = new ArrayList();
        for (URL url : list) {
            r.s(arrayList, f30217a.e(url));
        }
        X = u.X(arrayList);
        if (!X.isEmpty()) {
            p10 = n.p(X, 10);
            ArrayList arrayList2 = new ArrayList(p10);
            for (String str : X) {
                arrayList2.add(f30217a.a(str, classLoader, cls));
            }
            return arrayList2;
        }
        throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
    }
}
