package okhttp3.internal.platform;

import android.annotation.SuppressLint;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.m;
import kotlin.jvm.internal.f;
import np.b;
import np.g;
import np.i;
import np.j;
import np.k;
import okhttp3.Protocol;
import pp.c;
/* compiled from: Android10Platform.kt */
/* loaded from: classes3.dex */
public final class a extends h {

    /* renamed from: e  reason: collision with root package name */
    private static final boolean f32181e;

    /* renamed from: f  reason: collision with root package name */
    public static final C0437a f32182f = new C0437a(null);

    /* renamed from: d  reason: collision with root package name */
    private final List<k> f32183d;

    /* compiled from: Android10Platform.kt */
    /* renamed from: okhttp3.internal.platform.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0437a {
        private C0437a() {
        }

        public final h a() {
            if (b()) {
                return new a();
            }
            return null;
        }

        public final boolean b() {
            return a.f32181e;
        }

        public /* synthetic */ C0437a(f fVar) {
            this();
        }
    }

    static {
        f32181e = h.f32213c.h() && Build.VERSION.SDK_INT >= 29;
    }

    public a() {
        List k10;
        k10 = m.k(np.a.f31314a.a(), new j(np.f.f31323g.d()), new j(i.f31337b.a()), new j(g.f31331b.a()));
        ArrayList arrayList = new ArrayList();
        for (Object obj : k10) {
            if (((k) obj).b()) {
                arrayList.add(obj);
            }
        }
        this.f32183d = arrayList;
    }

    @Override // okhttp3.internal.platform.h
    public c c(X509TrustManager trustManager) {
        kotlin.jvm.internal.i.f(trustManager, "trustManager");
        b a10 = b.f31315d.a(trustManager);
        return a10 != null ? a10 : super.c(trustManager);
    }

    @Override // okhttp3.internal.platform.h
    public void e(SSLSocket sslSocket, String str, List<? extends Protocol> protocols) {
        Object obj;
        kotlin.jvm.internal.i.f(sslSocket, "sslSocket");
        kotlin.jvm.internal.i.f(protocols, "protocols");
        Iterator<T> it = this.f32183d.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((k) obj).a(sslSocket)) {
                break;
            }
        }
        k kVar = (k) obj;
        if (kVar != null) {
            kVar.d(sslSocket, str, protocols);
        }
    }

    @Override // okhttp3.internal.platform.h
    public String h(SSLSocket sslSocket) {
        Object obj;
        kotlin.jvm.internal.i.f(sslSocket, "sslSocket");
        Iterator<T> it = this.f32183d.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((k) obj).a(sslSocket)) {
                break;
            }
        }
        k kVar = (k) obj;
        if (kVar != null) {
            return kVar.c(sslSocket);
        }
        return null;
    }

    @Override // okhttp3.internal.platform.h
    @SuppressLint({"NewApi"})
    public boolean j(String hostname) {
        kotlin.jvm.internal.i.f(hostname, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(hostname);
    }
}
