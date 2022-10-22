package okhttp3;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: TlsVersion.kt */
/* loaded from: classes3.dex */
public enum TlsVersion {
    TLS_1_3("TLSv1.3"),
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");
    
    public static final a Companion = new a(null);
    private final String javaName;

    /* compiled from: TlsVersion.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final TlsVersion a(String javaName) {
            i.f(javaName, "javaName");
            int hashCode = javaName.hashCode();
            if (hashCode != 79201641) {
                if (hashCode != 79923350) {
                    switch (hashCode) {
                        case -503070503:
                            if (javaName.equals("TLSv1.1")) {
                                return TlsVersion.TLS_1_1;
                            }
                            break;
                        case -503070502:
                            if (javaName.equals("TLSv1.2")) {
                                return TlsVersion.TLS_1_2;
                            }
                            break;
                        case -503070501:
                            if (javaName.equals("TLSv1.3")) {
                                return TlsVersion.TLS_1_3;
                            }
                            break;
                    }
                } else if (javaName.equals("TLSv1")) {
                    return TlsVersion.TLS_1_0;
                }
            } else if (javaName.equals("SSLv3")) {
                return TlsVersion.SSL_3_0;
            }
            throw new IllegalArgumentException("Unexpected TLS version: " + javaName);
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    TlsVersion(String str) {
        this.javaName = str;
    }

    public static final TlsVersion forJavaName(String str) {
        return Companion.a(str);
    }

    /* renamed from: -deprecated_javaName  reason: not valid java name */
    public final String m38deprecated_javaName() {
        return this.javaName;
    }

    public final String javaName() {
        return this.javaName;
    }
}
