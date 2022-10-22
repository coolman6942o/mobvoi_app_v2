package pp;

import com.mobvoi.wear.msgproxy.MessageProxyConstants;
import gp.a;
import gp.b;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.collections.m;
import kotlin.jvm.internal.i;
import kotlin.text.t;
import kotlin.text.u;
/* compiled from: OkHostnameVerifier.kt */
/* loaded from: classes3.dex */
public final class d implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    public static final d f32897a = new d();

    private d() {
    }

    private final List<String> b(X509Certificate x509Certificate, int i10) {
        List<String> g10;
        List<String> g11;
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames != null) {
                ArrayList arrayList = new ArrayList();
                for (List<?> list : subjectAlternativeNames) {
                    if (list != null && list.size() >= 2 && !(!i.b(list.get(0), Integer.valueOf(i10))) && (obj = list.get(1)) != null) {
                        arrayList.add((String) obj);
                    }
                }
                return arrayList;
            }
            g11 = m.g();
            return g11;
        } catch (CertificateParsingException unused) {
            g10 = m.g();
            return g10;
        }
    }

    private final boolean d(String str, String str2) {
        boolean D;
        boolean o10;
        boolean D2;
        boolean o11;
        boolean o12;
        boolean o13;
        boolean I;
        boolean D3;
        int S;
        boolean o14;
        int X;
        if (!(str == null || str.length() == 0)) {
            D = t.D(str, ".", false, 2, null);
            if (!D) {
                o10 = t.o(str, "..", false, 2, null);
                if (!o10) {
                    if (!(str2 == null || str2.length() == 0)) {
                        D2 = t.D(str2, ".", false, 2, null);
                        if (!D2) {
                            o11 = t.o(str2, "..", false, 2, null);
                            if (!o11) {
                                o12 = t.o(str, ".", false, 2, null);
                                if (!o12) {
                                    str = str + ".";
                                }
                                String str3 = str;
                                o13 = t.o(str2, ".", false, 2, null);
                                if (!o13) {
                                    str2 = str2 + ".";
                                }
                                Locale locale = Locale.US;
                                i.e(locale, "Locale.US");
                                Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
                                String lowerCase = str2.toLowerCase(locale);
                                i.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                                I = u.I(lowerCase, MessageProxyConstants.NODE_ID_ANY, false, 2, null);
                                if (!I) {
                                    return i.b(str3, lowerCase);
                                }
                                D3 = t.D(lowerCase, "*.", false, 2, null);
                                if (D3) {
                                    S = u.S(lowerCase, '*', 1, false, 4, null);
                                    if (S != -1 || str3.length() < lowerCase.length() || i.b("*.", lowerCase)) {
                                        return false;
                                    }
                                    String substring = lowerCase.substring(1);
                                    i.e(substring, "(this as java.lang.String).substring(startIndex)");
                                    o14 = t.o(str3, substring, false, 2, null);
                                    if (!o14) {
                                        return false;
                                    }
                                    int length = str3.length() - substring.length();
                                    if (length > 0) {
                                        X = u.X(str3, '.', length - 1, false, 4, null);
                                        if (X != -1) {
                                            return false;
                                        }
                                    }
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private final boolean e(String str, X509Certificate x509Certificate) {
        Locale locale = Locale.US;
        i.e(locale, "Locale.US");
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = str.toLowerCase(locale);
        i.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        List<String> b10 = b(x509Certificate, 2);
        if ((b10 instanceof Collection) && b10.isEmpty()) {
            return false;
        }
        for (String str2 : b10) {
            if (f32897a.d(lowerCase, str2)) {
                return true;
            }
        }
        return false;
    }

    private final boolean f(String str, X509Certificate x509Certificate) {
        String e10 = a.e(str);
        List<String> b10 = b(x509Certificate, 7);
        if ((b10 instanceof Collection) && b10.isEmpty()) {
            return false;
        }
        for (String str2 : b10) {
            if (i.b(e10, a.e(str2))) {
                return true;
            }
        }
        return false;
    }

    public final List<String> a(X509Certificate certificate) {
        List<String> N;
        i.f(certificate, "certificate");
        N = kotlin.collections.u.N(b(certificate, 7), b(certificate, 2));
        return N;
    }

    public final boolean c(String host, X509Certificate certificate) {
        i.f(host, "host");
        i.f(certificate, "certificate");
        return b.f(host) ? f(host, certificate) : e(host, certificate);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String host, SSLSession session) {
        i.f(host, "host");
        i.f(session, "session");
        try {
            Certificate certificate = session.getPeerCertificates()[0];
            if (certificate != null) {
                return c(host, (X509Certificate) certificate);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
        } catch (SSLException unused) {
            return false;
        }
    }
}
