package jp;

import com.huawei.hms.framework.common.ContainerUtils;
import gp.b;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.d0;
import kotlin.jvm.internal.i;
import kotlin.text.t;
import okhttp3.Headers;
import okhttp3.b0;
import okhttp3.h;
import okhttp3.m;
import okhttp3.n;
import okhttp3.u;
import okio.ByteString;
import okio.c;
/* compiled from: HttpHeaders.kt */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final ByteString f29659a;

    /* renamed from: b  reason: collision with root package name */
    private static final ByteString f29660b;

    static {
        ByteString.a aVar = ByteString.Companion;
        f29659a = aVar.d("\"\\");
        f29660b = aVar.d("\t ,=");
    }

    public static final List<h> a(Headers parseChallenges, String headerName) {
        boolean p10;
        i.f(parseChallenges, "$this$parseChallenges");
        i.f(headerName, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = parseChallenges.size();
        for (int i10 = 0; i10 < size; i10++) {
            p10 = t.p(headerName, parseChallenges.name(i10), true);
            if (p10) {
                try {
                    c(new c().R(parseChallenges.value(i10)), arrayList);
                } catch (EOFException e10) {
                    okhttp3.internal.platform.h.f32213c.g().k("Unable to parse challenge", 5, e10);
                }
            }
        }
        return arrayList;
    }

    public static final boolean b(b0 promisesBody) {
        boolean p10;
        i.f(promisesBody, "$this$promisesBody");
        if (i.b(promisesBody.g0().h(), "HEAD")) {
            return false;
        }
        int n10 = promisesBody.n();
        if (((n10 >= 100 && n10 < 200) || n10 == 204 || n10 == 304) && b.s(promisesBody) == -1) {
            p10 = t.p("chunked", b0.w(promisesBody, "Transfer-Encoding", null, 2, null), true);
            if (!p10) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0085, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0085, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void c(c cVar, List<h> list) throws EOFException {
        String e10;
        Map e11;
        int H;
        String v10;
        while (true) {
            String str = null;
            while (true) {
                if (str == null) {
                    g(cVar);
                    str = e(cVar);
                    if (str == null) {
                        return;
                    }
                }
                boolean g10 = g(cVar);
                e10 = e(cVar);
                if (e10 != null) {
                    byte b10 = (byte) 61;
                    H = b.H(cVar, b10);
                    boolean g11 = g(cVar);
                    if (g10 || (!g11 && !cVar.B())) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        int H2 = H + b.H(cVar, b10);
                        while (true) {
                            if (e10 == null) {
                                e10 = e(cVar);
                                if (g(cVar)) {
                                    break;
                                }
                                H2 = b.H(cVar, b10);
                            }
                            if (H2 == 0) {
                                break;
                            } else if (H2 <= 1 && !g(cVar)) {
                                String d10 = h(cVar, (byte) 34) ? d(cVar) : e(cVar);
                                if (d10 != null && ((String) linkedHashMap.put(e10, d10)) == null) {
                                    if (g(cVar) || cVar.B()) {
                                        e10 = null;
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        list.add(new h(str, linkedHashMap));
                        str = e10;
                    }
                } else if (cVar.B()) {
                    e11 = d0.e();
                    list.add(new h(str, e11));
                    return;
                } else {
                    return;
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(e10);
            v10 = t.v(ContainerUtils.KEY_VALUE_DELIMITER, H);
            sb2.append(v10);
            Map singletonMap = Collections.singletonMap(null, sb2.toString());
            i.e(singletonMap, "Collections.singletonMap…ek + \"=\".repeat(eqCount))");
            list.add(new h(str, singletonMap));
        }
    }

    private static final String d(c cVar) throws EOFException {
        byte b10 = (byte) 34;
        if (cVar.readByte() == b10) {
            c cVar2 = new c();
            while (true) {
                long F = cVar.F(f29659a);
                if (F == -1) {
                    return null;
                }
                if (cVar.u(F) == b10) {
                    cVar2.Z(cVar, F);
                    cVar.readByte();
                    return cVar2.V();
                } else if (cVar.i0() == F + 1) {
                    return null;
                } else {
                    cVar2.Z(cVar, F);
                    cVar.readByte();
                    cVar2.Z(cVar, 1L);
                }
            }
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    private static final String e(c cVar) {
        long F = cVar.F(f29660b);
        if (F == -1) {
            F = cVar.i0();
        }
        if (F != 0) {
            return cVar.W(F);
        }
        return null;
    }

    public static final void f(n receiveHeaders, u url, Headers headers) {
        i.f(receiveHeaders, "$this$receiveHeaders");
        i.f(url, "url");
        i.f(headers, "headers");
        if (receiveHeaders != n.f32253a) {
            List<m> e10 = m.f32243n.e(url, headers);
            if (!e10.isEmpty()) {
                receiveHeaders.a(url, e10);
            }
        }
    }

    private static final boolean g(c cVar) {
        boolean z10 = false;
        while (!cVar.B()) {
            byte u10 = cVar.u(0L);
            if (u10 == 9 || u10 == 32) {
                cVar.readByte();
            } else if (u10 != 44) {
                break;
            } else {
                cVar.readByte();
                z10 = true;
            }
        }
        return z10;
    }

    private static final boolean h(c cVar, byte b10) {
        return !cVar.B() && cVar.u(0L) == b10;
    }
}
