package jp;

import java.net.Proxy;
import okhttp3.u;
import okhttp3.z;
/* compiled from: RequestLine.kt */
/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final i f29674a = new i();

    private i() {
    }

    private final boolean b(z zVar, Proxy.Type type) {
        return !zVar.g() && type == Proxy.Type.HTTP;
    }

    public final String a(z request, Proxy.Type proxyType) {
        kotlin.jvm.internal.i.f(request, "request");
        kotlin.jvm.internal.i.f(proxyType, "proxyType");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(request.h());
        sb2.append(' ');
        i iVar = f29674a;
        if (iVar.b(request, proxyType)) {
            sb2.append(request.l());
        } else {
            sb2.append(iVar.c(request.l()));
        }
        sb2.append(" HTTP/1.1");
        String sb3 = sb2.toString();
        kotlin.jvm.internal.i.e(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    public final String c(u url) {
        kotlin.jvm.internal.i.f(url, "url");
        String d10 = url.d();
        String f10 = url.f();
        if (f10 == null) {
            return d10;
        }
        return d10 + '?' + f10;
    }
}
