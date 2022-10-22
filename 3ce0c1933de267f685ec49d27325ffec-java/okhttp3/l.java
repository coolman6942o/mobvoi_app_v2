package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.collections.u;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: ConnectionSpec.kt */
/* loaded from: classes3.dex */
public final class l {

    /* renamed from: e  reason: collision with root package name */
    private static final i[] f32223e;

    /* renamed from: f  reason: collision with root package name */
    private static final i[] f32224f;

    /* renamed from: g  reason: collision with root package name */
    public static final l f32225g;

    /* renamed from: h  reason: collision with root package name */
    public static final l f32226h = new a(false).a();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f32227a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f32228b;

    /* renamed from: c  reason: collision with root package name */
    private final String[] f32229c;

    /* renamed from: d  reason: collision with root package name */
    private final String[] f32230d;

    /* compiled from: ConnectionSpec.kt */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f32231a;

        /* renamed from: b  reason: collision with root package name */
        private String[] f32232b;

        /* renamed from: c  reason: collision with root package name */
        private String[] f32233c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f32234d;

        public a(boolean z10) {
            this.f32231a = z10;
        }

        public final l a() {
            return new l(this.f32231a, this.f32234d, this.f32232b, this.f32233c);
        }

        public final a b(String... cipherSuites) {
            i.f(cipherSuites, "cipherSuites");
            if (this.f32231a) {
                if (!(cipherSuites.length == 0)) {
                    Object clone = cipherSuites.clone();
                    Objects.requireNonNull(clone, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                    this.f32232b = (String[]) clone;
                    return this;
                }
                throw new IllegalArgumentException("At least one cipher suite is required".toString());
            }
            throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
        }

        public final a c(i... cipherSuites) {
            i.f(cipherSuites, "cipherSuites");
            if (this.f32231a) {
                ArrayList arrayList = new ArrayList(cipherSuites.length);
                for (i iVar : cipherSuites) {
                    arrayList.add(iVar.c());
                }
                Object[] array = arrayList.toArray(new String[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                String[] strArr = (String[]) array;
                return b((String[]) Arrays.copyOf(strArr, strArr.length));
            }
            throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
        }

        public final a d(boolean z10) {
            if (this.f32231a) {
                this.f32234d = z10;
                return this;
            }
            throw new IllegalArgumentException("no TLS extensions for cleartext connections".toString());
        }

        public final a e(String... tlsVersions) {
            i.f(tlsVersions, "tlsVersions");
            if (this.f32231a) {
                if (!(tlsVersions.length == 0)) {
                    Object clone = tlsVersions.clone();
                    Objects.requireNonNull(clone, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                    this.f32233c = (String[]) clone;
                    return this;
                }
                throw new IllegalArgumentException("At least one TLS version is required".toString());
            }
            throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
        }

        public final a f(TlsVersion... tlsVersions) {
            i.f(tlsVersions, "tlsVersions");
            if (this.f32231a) {
                ArrayList arrayList = new ArrayList(tlsVersions.length);
                for (TlsVersion tlsVersion : tlsVersions) {
                    arrayList.add(tlsVersion.javaName());
                }
                Object[] array = arrayList.toArray(new String[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                String[] strArr = (String[]) array;
                return e((String[]) Arrays.copyOf(strArr, strArr.length));
            }
            throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
        }

        public a(l connectionSpec) {
            i.f(connectionSpec, "connectionSpec");
            this.f32231a = connectionSpec.f();
            this.f32232b = connectionSpec.f32229c;
            this.f32233c = connectionSpec.f32230d;
            this.f32234d = connectionSpec.h();
        }
    }

    /* compiled from: ConnectionSpec.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    static {
        new b(null);
        i iVar = i.f31868q;
        i iVar2 = i.f31869r;
        i iVar3 = i.f31870s;
        i iVar4 = i.f31862k;
        i iVar5 = i.f31864m;
        i iVar6 = i.f31863l;
        i iVar7 = i.f31865n;
        i iVar8 = i.f31867p;
        i iVar9 = i.f31866o;
        i[] iVarArr = {iVar, iVar2, iVar3, iVar4, iVar5, iVar6, iVar7, iVar8, iVar9};
        f32223e = iVarArr;
        i[] iVarArr2 = {iVar, iVar2, iVar3, iVar4, iVar5, iVar6, iVar7, iVar8, iVar9, i.f31860i, i.f31861j, i.f31858g, i.f31859h, i.f31856e, i.f31857f, i.f31855d};
        f32224f = iVarArr2;
        a c10 = new a(true).c((i[]) Arrays.copyOf(iVarArr, iVarArr.length));
        TlsVersion tlsVersion = TlsVersion.TLS_1_3;
        TlsVersion tlsVersion2 = TlsVersion.TLS_1_2;
        c10.f(tlsVersion, tlsVersion2).d(true).a();
        f32225g = new a(true).c((i[]) Arrays.copyOf(iVarArr2, iVarArr2.length)).f(tlsVersion, tlsVersion2).d(true).a();
        new a(true).c((i[]) Arrays.copyOf(iVarArr2, iVarArr2.length)).f(tlsVersion, tlsVersion2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).d(true).a();
    }

    public l(boolean z10, boolean z11, String[] strArr, String[] strArr2) {
        this.f32227a = z10;
        this.f32228b = z11;
        this.f32229c = strArr;
        this.f32230d = strArr2;
    }

    private final l g(SSLSocket sSLSocket, boolean z10) {
        String[] cipherSuitesIntersection;
        String[] tlsVersionsIntersection;
        Comparator b10;
        if (this.f32229c != null) {
            String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
            i.e(enabledCipherSuites, "sslSocket.enabledCipherSuites");
            cipherSuitesIntersection = gp.b.B(enabledCipherSuites, this.f32229c, i.f31871t.c());
        } else {
            cipherSuitesIntersection = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f32230d != null) {
            String[] enabledProtocols = sSLSocket.getEnabledProtocols();
            i.e(enabledProtocols, "sslSocket.enabledProtocols");
            String[] strArr = this.f32230d;
            b10 = jo.b.b();
            tlsVersionsIntersection = gp.b.B(enabledProtocols, strArr, b10);
        } else {
            tlsVersionsIntersection = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        i.e(supportedCipherSuites, "supportedCipherSuites");
        int u10 = gp.b.u(supportedCipherSuites, "TLS_FALLBACK_SCSV", i.f31871t.c());
        if (z10 && u10 != -1) {
            i.e(cipherSuitesIntersection, "cipherSuitesIntersection");
            String str = supportedCipherSuites[u10];
            i.e(str, "supportedCipherSuites[indexOfFallbackScsv]");
            cipherSuitesIntersection = gp.b.l(cipherSuitesIntersection, str);
        }
        a aVar = new a(this);
        i.e(cipherSuitesIntersection, "cipherSuitesIntersection");
        a b11 = aVar.b((String[]) Arrays.copyOf(cipherSuitesIntersection, cipherSuitesIntersection.length));
        i.e(tlsVersionsIntersection, "tlsVersionsIntersection");
        return b11.e((String[]) Arrays.copyOf(tlsVersionsIntersection, tlsVersionsIntersection.length)).a();
    }

    public final void c(SSLSocket sslSocket, boolean z10) {
        i.f(sslSocket, "sslSocket");
        l g10 = g(sslSocket, z10);
        if (g10.i() != null) {
            sslSocket.setEnabledProtocols(g10.f32230d);
        }
        if (g10.d() != null) {
            sslSocket.setEnabledCipherSuites(g10.f32229c);
        }
    }

    public final List<i> d() {
        List<i> U;
        String[] strArr = this.f32229c;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(i.f31871t.b(str));
        }
        U = u.U(arrayList);
        return U;
    }

    public final boolean e(SSLSocket socket) {
        Comparator b10;
        i.f(socket, "socket");
        if (!this.f32227a) {
            return false;
        }
        String[] strArr = this.f32230d;
        if (strArr != null) {
            String[] enabledProtocols = socket.getEnabledProtocols();
            b10 = jo.b.b();
            if (!gp.b.r(strArr, enabledProtocols, b10)) {
                return false;
            }
        }
        String[] strArr2 = this.f32229c;
        return strArr2 == null || gp.b.r(strArr2, socket.getEnabledCipherSuites(), i.f31871t.c());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        boolean z10 = this.f32227a;
        l lVar = (l) obj;
        if (z10 != lVar.f32227a) {
            return false;
        }
        return !z10 || (Arrays.equals(this.f32229c, lVar.f32229c) && Arrays.equals(this.f32230d, lVar.f32230d) && this.f32228b == lVar.f32228b);
    }

    public final boolean f() {
        return this.f32227a;
    }

    public final boolean h() {
        return this.f32228b;
    }

    public int hashCode() {
        if (!this.f32227a) {
            return 17;
        }
        String[] strArr = this.f32229c;
        int i10 = 0;
        int hashCode = (527 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.f32230d;
        if (strArr2 != null) {
            i10 = Arrays.hashCode(strArr2);
        }
        return ((hashCode + i10) * 31) + (!this.f32228b ? 1 : 0);
    }

    public final List<TlsVersion> i() {
        List<TlsVersion> U;
        String[] strArr = this.f32230d;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(TlsVersion.Companion.a(str));
        }
        U = u.U(arrayList);
        return U;
    }

    public String toString() {
        if (!this.f32227a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(d(), "[all enabled]") + ", tlsVersions=" + Objects.toString(i(), "[all enabled]") + ", supportsTlsExtensions=" + this.f32228b + ')';
    }
}
