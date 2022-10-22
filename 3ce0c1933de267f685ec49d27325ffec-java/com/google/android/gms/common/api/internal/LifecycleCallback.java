package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public class LifecycleCallback {

    /* renamed from: a  reason: collision with root package name */
    protected final h f8504a;

    /* JADX INFO: Access modifiers changed from: protected */
    public LifecycleCallback(h hVar) {
        this.f8504a = hVar;
    }

    public static h c(Activity activity) {
        return d(new g(activity));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static h d(g gVar) {
        if (gVar.c()) {
            return z2.Z(gVar.b());
        }
        if (gVar.d()) {
            return x2.b(gVar.a());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    @Keep
    private static h getChimeraLifecycleFragmentImpl(g gVar) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public Activity b() {
        return this.f8504a.u();
    }

    public void e(int i10, int i11, Intent intent) {
    }

    public void f(Bundle bundle) {
    }

    public void g() {
    }

    public void h() {
    }

    public void i(Bundle bundle) {
    }

    public void j() {
    }

    public void k() {
    }
}
