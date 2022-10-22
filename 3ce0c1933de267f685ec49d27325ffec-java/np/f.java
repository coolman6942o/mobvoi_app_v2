package np;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.i;
import kotlin.text.t;
import np.j;
import okhttp3.Protocol;
import okhttp3.internal.platform.b;
import okhttp3.internal.platform.h;
/* compiled from: AndroidSocketAdapter.kt */
/* loaded from: classes3.dex */
public class f implements k {

    /* renamed from: f  reason: collision with root package name */
    private static final j.a f31322f;

    /* renamed from: g  reason: collision with root package name */
    public static final a f31323g;

    /* renamed from: a  reason: collision with root package name */
    private final Method f31324a;

    /* renamed from: b  reason: collision with root package name */
    private final Method f31325b;

    /* renamed from: c  reason: collision with root package name */
    private final Method f31326c;

    /* renamed from: d  reason: collision with root package name */
    private final Method f31327d;

    /* renamed from: e  reason: collision with root package name */
    private final Class<? super SSLSocket> f31328e;

    /* compiled from: AndroidSocketAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class a {

        /* compiled from: AndroidSocketAdapter.kt */
        /* renamed from: np.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0415a implements j.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f31329a;

            C0415a(String str) {
                this.f31329a = str;
            }

            @Override // np.j.a
            public boolean a(SSLSocket sslSocket) {
                boolean D;
                i.f(sslSocket, "sslSocket");
                String name = sslSocket.getClass().getName();
                i.e(name, "sslSocket.javaClass.name");
                D = t.D(name, this.f31329a + '.', false, 2, null);
                return D;
            }

            @Override // np.j.a
            public k b(SSLSocket sslSocket) {
                i.f(sslSocket, "sslSocket");
                return f.f31323g.b(sslSocket.getClass());
            }
        }

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final f b(Class<? super SSLSocket> cls) {
            Class<? super SSLSocket> cls2 = cls;
            while (cls2 != null && (!i.b(cls2.getSimpleName(), "OpenSSLSocketImpl"))) {
                cls2 = cls2.getSuperclass();
                if (cls2 == null) {
                    throw new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + cls);
                }
            }
            i.d(cls2);
            return new f(cls2);
        }

        public final j.a c(String packageName) {
            i.f(packageName, "packageName");
            return new C0415a(packageName);
        }

        public final j.a d() {
            return f.f31322f;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    static {
        a aVar = new a(null);
        f31323g = aVar;
        f31322f = aVar.c("com.google.android.gms.org.conscrypt");
    }

    public f(Class<? super SSLSocket> sslSocketClass) {
        i.f(sslSocketClass, "sslSocketClass");
        this.f31328e = sslSocketClass;
        Method declaredMethod = sslSocketClass.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        i.e(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.f31324a = declaredMethod;
        this.f31325b = sslSocketClass.getMethod("setHostname", String.class);
        this.f31326c = sslSocketClass.getMethod("getAlpnSelectedProtocol", new Class[0]);
        this.f31327d = sslSocketClass.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // np.k
    public boolean a(SSLSocket sslSocket) {
        i.f(sslSocket, "sslSocket");
        return this.f31328e.isInstance(sslSocket);
    }

    @Override // np.k
    public boolean b() {
        return b.f32185g.b();
    }

    @Override // np.k
    public String c(SSLSocket sslSocket) {
        i.f(sslSocket, "sslSocket");
        if (!a(sslSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.f31326c.invoke(sslSocket, new Object[0]);
            if (bArr == null) {
                return null;
            }
            Charset charset = StandardCharsets.UTF_8;
            i.e(charset, "StandardCharsets.UTF_8");
            return new String(bArr, charset);
        } catch (IllegalAccessException e10) {
            throw new AssertionError(e10);
        } catch (NullPointerException e11) {
            if (i.b(e11.getMessage(), "ssl == null")) {
                return null;
            }
            throw e11;
        } catch (InvocationTargetException e12) {
            throw new AssertionError(e12);
        }
    }

    @Override // np.k
    public void d(SSLSocket sslSocket, String str, List<? extends Protocol> protocols) {
        i.f(sslSocket, "sslSocket");
        i.f(protocols, "protocols");
        if (a(sslSocket)) {
            try {
                this.f31324a.invoke(sslSocket, Boolean.TRUE);
                if (str != null) {
                    this.f31325b.invoke(sslSocket, str);
                }
                this.f31327d.invoke(sslSocket, h.f32213c.c(protocols));
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            } catch (InvocationTargetException e11) {
                throw new AssertionError(e11);
            }
        }
    }
}
