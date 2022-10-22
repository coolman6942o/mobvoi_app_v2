package okhttp3;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.f;
import kotlin.text.t;
/* compiled from: CipherSuite.kt */
/* loaded from: classes3.dex */
public final class i {

    /* renamed from: b  reason: collision with root package name */
    private static final Comparator<String> f31853b = new a();

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, i> f31854c = new LinkedHashMap();

    /* renamed from: d  reason: collision with root package name */
    public static final i f31855d;

    /* renamed from: e  reason: collision with root package name */
    public static final i f31856e;

    /* renamed from: f  reason: collision with root package name */
    public static final i f31857f;

    /* renamed from: g  reason: collision with root package name */
    public static final i f31858g;

    /* renamed from: h  reason: collision with root package name */
    public static final i f31859h;

    /* renamed from: i  reason: collision with root package name */
    public static final i f31860i;

    /* renamed from: j  reason: collision with root package name */
    public static final i f31861j;

    /* renamed from: k  reason: collision with root package name */
    public static final i f31862k;

    /* renamed from: l  reason: collision with root package name */
    public static final i f31863l;

    /* renamed from: m  reason: collision with root package name */
    public static final i f31864m;

    /* renamed from: n  reason: collision with root package name */
    public static final i f31865n;

    /* renamed from: o  reason: collision with root package name */
    public static final i f31866o;

    /* renamed from: p  reason: collision with root package name */
    public static final i f31867p;

    /* renamed from: q  reason: collision with root package name */
    public static final i f31868q;

    /* renamed from: r  reason: collision with root package name */
    public static final i f31869r;

    /* renamed from: s  reason: collision with root package name */
    public static final i f31870s;

    /* renamed from: t  reason: collision with root package name */
    public static final b f31871t;

    /* renamed from: a  reason: collision with root package name */
    private final String f31872a;

    /* compiled from: CipherSuite.kt */
    /* loaded from: classes3.dex */
    public static final class a implements Comparator<String> {
        a() {
        }

        /* renamed from: a */
        public int compare(String a10, String b10) {
            kotlin.jvm.internal.i.f(a10, "a");
            kotlin.jvm.internal.i.f(b10, "b");
            int min = Math.min(a10.length(), b10.length());
            for (int i10 = 4; i10 < min; i10++) {
                char charAt = a10.charAt(i10);
                char charAt2 = b10.charAt(i10);
                if (charAt != charAt2) {
                    return kotlin.jvm.internal.i.h(charAt, charAt2) < 0 ? -1 : 1;
                }
            }
            int length = a10.length();
            int length2 = b10.length();
            if (length != length2) {
                return length < length2 ? -1 : 1;
            }
            return 0;
        }
    }

    /* compiled from: CipherSuite.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final i d(String str, int i10) {
            i iVar = new i(str, null);
            i.f31854c.put(str, iVar);
            return iVar;
        }

        private final String e(String str) {
            boolean D;
            boolean D2;
            D = t.D(str, "TLS_", false, 2, null);
            if (D) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("SSL_");
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                String substring = str.substring(4);
                kotlin.jvm.internal.i.e(substring, "(this as java.lang.String).substring(startIndex)");
                sb2.append(substring);
                return sb2.toString();
            }
            D2 = t.D(str, "SSL_", false, 2, null);
            if (!D2) {
                return str;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("TLS_");
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            String substring2 = str.substring(4);
            kotlin.jvm.internal.i.e(substring2, "(this as java.lang.String).substring(startIndex)");
            sb3.append(substring2);
            return sb3.toString();
        }

        public final synchronized i b(String javaName) {
            i iVar;
            kotlin.jvm.internal.i.f(javaName, "javaName");
            iVar = (i) i.f31854c.get(javaName);
            if (iVar == null) {
                iVar = (i) i.f31854c.get(e(javaName));
                if (iVar == null) {
                    iVar = new i(javaName, null);
                }
                i.f31854c.put(javaName, iVar);
            }
            return iVar;
        }

        public final Comparator<String> c() {
            return i.f31853b;
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    static {
        b bVar = new b(null);
        f31871t = bVar;
        bVar.d("SSL_RSA_WITH_NULL_MD5", 1);
        bVar.d("SSL_RSA_WITH_NULL_SHA", 2);
        bVar.d("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        bVar.d("SSL_RSA_WITH_RC4_128_MD5", 4);
        bVar.d("SSL_RSA_WITH_RC4_128_SHA", 5);
        bVar.d("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        bVar.d("SSL_RSA_WITH_DES_CBC_SHA", 9);
        f31855d = bVar.d("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        bVar.d("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        bVar.d("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        bVar.d("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        bVar.d("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        bVar.d("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        bVar.d("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        bVar.d("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        bVar.d("SSL_DH_anon_WITH_RC4_128_MD5", 24);
        bVar.d("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        bVar.d("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        bVar.d("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        bVar.d("TLS_KRB5_WITH_DES_CBC_SHA", 30);
        bVar.d("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        bVar.d("TLS_KRB5_WITH_RC4_128_SHA", 32);
        bVar.d("TLS_KRB5_WITH_DES_CBC_MD5", 34);
        bVar.d("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        bVar.d("TLS_KRB5_WITH_RC4_128_MD5", 36);
        bVar.d("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        bVar.d("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        bVar.d("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        bVar.d("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        f31856e = bVar.d("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        bVar.d("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        bVar.d("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        bVar.d("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        f31857f = bVar.d("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        bVar.d("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        bVar.d("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        bVar.d("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        bVar.d("TLS_RSA_WITH_NULL_SHA256", 59);
        bVar.d("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        bVar.d("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        bVar.d("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        bVar.d("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        bVar.d("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        bVar.d("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        bVar.d("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        bVar.d("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        bVar.d("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        bVar.d("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        bVar.d("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        bVar.d("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
        bVar.d("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
        bVar.d("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
        bVar.d("TLS_PSK_WITH_RC4_128_SHA", 138);
        bVar.d("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
        bVar.d("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
        bVar.d("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
        bVar.d("TLS_RSA_WITH_SEED_CBC_SHA", 150);
        f31858g = bVar.d("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        f31859h = bVar.d("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        bVar.d("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
        bVar.d("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
        bVar.d("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
        bVar.d("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
        bVar.d("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
        bVar.d("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
        bVar.d("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        bVar.d("TLS_FALLBACK_SCSV", 22016);
        bVar.d("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        bVar.d("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        bVar.d("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        bVar.d("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        bVar.d("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
        bVar.d("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
        bVar.d("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        bVar.d("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        bVar.d("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        bVar.d("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        bVar.d("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        bVar.d("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        bVar.d("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        bVar.d("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        bVar.d("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        bVar.d("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        bVar.d("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        bVar.d("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        f31860i = bVar.d("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        f31861j = bVar.d("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        bVar.d("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        bVar.d("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        bVar.d("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        bVar.d("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        bVar.d("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        bVar.d("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        bVar.d("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        bVar.d("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        bVar.d("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        bVar.d("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        bVar.d("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        bVar.d("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        bVar.d("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        f31862k = bVar.d("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        f31863l = bVar.d("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        bVar.d("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        bVar.d("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        f31864m = bVar.d("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        f31865n = bVar.d("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        bVar.d("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        bVar.d("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        bVar.d("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        bVar.d("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        f31866o = bVar.d("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        f31867p = bVar.d("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
        bVar.d("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
        bVar.d("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
        f31868q = bVar.d("TLS_AES_128_GCM_SHA256", 4865);
        f31869r = bVar.d("TLS_AES_256_GCM_SHA384", 4866);
        f31870s = bVar.d("TLS_CHACHA20_POLY1305_SHA256", 4867);
        bVar.d("TLS_AES_128_CCM_SHA256", 4868);
        bVar.d("TLS_AES_128_CCM_8_SHA256", 4869);
    }

    private i(String str) {
        this.f31872a = str;
    }

    public final String c() {
        return this.f31872a;
    }

    public String toString() {
        return this.f31872a;
    }

    public /* synthetic */ i(String str, f fVar) {
        this(str);
    }
}
