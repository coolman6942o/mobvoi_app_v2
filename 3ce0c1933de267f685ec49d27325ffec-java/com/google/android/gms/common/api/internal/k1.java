package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.h;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public interface k1 {
    void a();

    void b();

    <A extends a.b, T extends c<? extends h, A>> T d(T t10);

    void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    <A extends a.b, R extends h, T extends c<R, A>> T f(T t10);

    boolean g(l lVar);

    void h();

    ConnectionResult i();

    boolean isConnected();
}
