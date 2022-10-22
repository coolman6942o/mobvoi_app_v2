package com.bjleisen.iface.sdk.a;

import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
/* compiled from: ResponseHandlerInterface.java */
/* loaded from: classes.dex */
public interface h {
    void a(int i10);

    void a(int i10, int i11);

    void a(int i10, Header[] headerArr, byte[] bArr);

    void a(int i10, Header[] headerArr, byte[] bArr, Throwable th2);

    void a(URI uri);

    void a(HttpResponse httpResponse);

    void a(boolean z10);

    void a(Header[] headerArr);

    URI j();

    Header[] k();

    boolean l();

    void n();

    void o();

    void p();
}
