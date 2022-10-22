package okhttp3.internal.platform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import okhttp3.Protocol;
/* compiled from: Jdk8WithJettyBootPlatform.kt */
/* loaded from: classes3.dex */
public final class e extends h {

    /* renamed from: i  reason: collision with root package name */
    public static final b f32197i = new b(null);

    /* renamed from: d  reason: collision with root package name */
    private final Method f32198d;

    /* renamed from: e  reason: collision with root package name */
    private final Method f32199e;

    /* renamed from: f  reason: collision with root package name */
    private final Method f32200f;

    /* renamed from: g  reason: collision with root package name */
    private final Class<?> f32201g;

    /* renamed from: h  reason: collision with root package name */
    private final Class<?> f32202h;

    /* compiled from: Jdk8WithJettyBootPlatform.kt */
    /* loaded from: classes3.dex */
    private static final class a implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        private boolean f32203a;

        /* renamed from: b  reason: collision with root package name */
        private String f32204b;

        /* renamed from: c  reason: collision with root package name */
        private final List<String> f32205c;

        public a(List<String> protocols) {
            i.f(protocols, "protocols");
            this.f32205c = protocols;
        }

        public final String a() {
            return this.f32204b;
        }

        public final boolean b() {
            return this.f32203a;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object proxy, Method method, Object[] objArr) throws Throwable {
            i.f(proxy, "proxy");
            i.f(method, "method");
            if (objArr == null) {
                objArr = new Object[0];
            }
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (i.b(name, "supports") && i.b(Boolean.TYPE, returnType)) {
                return Boolean.TRUE;
            }
            if (!i.b(name, "unsupported") || !i.b(Void.TYPE, returnType)) {
                if (i.b(name, "protocols")) {
                    if (objArr.length == 0) {
                        return this.f32205c;
                    }
                }
                if ((i.b(name, "selectProtocol") || i.b(name, "select")) && i.b(String.class, returnType) && objArr.length == 1 && (objArr[0] instanceof List)) {
                    Object obj = objArr[0];
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.collections.List<*>");
                    List list = (List) obj;
                    int size = list.size();
                    if (size >= 0) {
                        int i10 = 0;
                        while (true) {
                            Object obj2 = list.get(i10);
                            Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj2;
                            if (!this.f32205c.contains(str)) {
                                if (i10 == size) {
                                    break;
                                }
                                i10++;
                            } else {
                                this.f32204b = str;
                                return str;
                            }
                        }
                    }
                    String str2 = this.f32205c.get(0);
                    this.f32204b = str2;
                    return str2;
                } else if ((!i.b(name, "protocolSelected") && !i.b(name, "selected")) || objArr.length != 1) {
                    return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
                } else {
                    Object obj3 = objArr[0];
                    Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.String");
                    this.f32204b = (String) obj3;
                    return null;
                }
            } else {
                this.f32203a = true;
                return null;
            }
        }
    }

    /* compiled from: Jdk8WithJettyBootPlatform.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        public final h a() {
            String jvmVersion = System.getProperty("java.specification.version", "unknown");
            try {
                i.e(jvmVersion, "jvmVersion");
                if (Integer.parseInt(jvmVersion) >= 9) {
                    return null;
                }
            } catch (NumberFormatException unused) {
            }
            try {
                Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                Class<?> clientProviderClass = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                Class<?> serverProviderClass = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                Method putMethod = cls.getMethod("put", SSLSocket.class, cls2);
                Method getMethod = cls.getMethod("get", SSLSocket.class);
                Method removeMethod = cls.getMethod("remove", SSLSocket.class);
                i.e(putMethod, "putMethod");
                i.e(getMethod, "getMethod");
                i.e(removeMethod, "removeMethod");
                i.e(clientProviderClass, "clientProviderClass");
                i.e(serverProviderClass, "serverProviderClass");
                return new e(putMethod, getMethod, removeMethod, clientProviderClass, serverProviderClass);
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                return null;
            }
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    public e(Method putMethod, Method getMethod, Method removeMethod, Class<?> clientProviderClass, Class<?> serverProviderClass) {
        i.f(putMethod, "putMethod");
        i.f(getMethod, "getMethod");
        i.f(removeMethod, "removeMethod");
        i.f(clientProviderClass, "clientProviderClass");
        i.f(serverProviderClass, "serverProviderClass");
        this.f32198d = putMethod;
        this.f32199e = getMethod;
        this.f32200f = removeMethod;
        this.f32201g = clientProviderClass;
        this.f32202h = serverProviderClass;
    }

    @Override // okhttp3.internal.platform.h
    public void b(SSLSocket sslSocket) {
        i.f(sslSocket, "sslSocket");
        try {
            this.f32200f.invoke(null, sslSocket);
        } catch (IllegalAccessException e10) {
            throw new AssertionError("failed to remove ALPN", e10);
        } catch (InvocationTargetException e11) {
            throw new AssertionError("failed to remove ALPN", e11);
        }
    }

    @Override // okhttp3.internal.platform.h
    public void e(SSLSocket sslSocket, String str, List<? extends Protocol> protocols) {
        i.f(sslSocket, "sslSocket");
        i.f(protocols, "protocols");
        try {
            this.f32198d.invoke(null, sslSocket, Proxy.newProxyInstance(h.class.getClassLoader(), new Class[]{this.f32201g, this.f32202h}, new a(h.f32213c.b(protocols))));
        } catch (IllegalAccessException e10) {
            throw new AssertionError("failed to set ALPN", e10);
        } catch (InvocationTargetException e11) {
            throw new AssertionError("failed to set ALPN", e11);
        }
    }

    @Override // okhttp3.internal.platform.h
    public String h(SSLSocket sslSocket) {
        i.f(sslSocket, "sslSocket");
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.f32199e.invoke(null, sslSocket));
            if (invocationHandler != null) {
                a aVar = (a) invocationHandler;
                if (!aVar.b() && aVar.a() == null) {
                    h.l(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);
                    return null;
                } else if (aVar.b()) {
                    return null;
                } else {
                    return aVar.a();
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            }
        } catch (IllegalAccessException e10) {
            throw new AssertionError("failed to get ALPN selected protocol", e10);
        } catch (InvocationTargetException e11) {
            throw new AssertionError("failed to get ALPN selected protocol", e11);
        }
    }
}
