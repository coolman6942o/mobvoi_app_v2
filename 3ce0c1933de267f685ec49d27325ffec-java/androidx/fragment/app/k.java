package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.app.a;
import androidx.core.content.b;
import j0.h;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* compiled from: FragmentHostCallback.java */
/* loaded from: classes.dex */
public abstract class k<E> extends h {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f3144a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f3145b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f3146c;

    /* renamed from: d  reason: collision with root package name */
    final FragmentManager f3147d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this(fVar, fVar, new Handler(), 0);
    }

    @Override // androidx.fragment.app.h
    public View c(int i10) {
        return null;
    }

    @Override // androidx.fragment.app.h
    public boolean d() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Activity e() {
        return this.f3144a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context f() {
        return this.f3145b;
    }

    public Handler g() {
        return this.f3146c;
    }

    public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public abstract E i();

    public LayoutInflater j() {
        return LayoutInflater.from(this.f3145b);
    }

    @Deprecated
    public void k(Fragment fragment, String[] strArr, int i10) {
    }

    public boolean l(String str) {
        return false;
    }

    public void m(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i10, Bundle bundle) {
        if (i10 == -1) {
            b.m(this.f3145b, intent, bundle);
            return;
        }
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    @Deprecated
    public void n(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) throws IntentSender.SendIntentException {
        if (i10 == -1) {
            a.y(this.f3144a, intentSender, i10, intent, i11, i12, i13, bundle);
            return;
        }
        throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
    }

    public void o() {
    }

    k(Activity activity, Context context, Handler handler, int i10) {
        this.f3147d = new o();
        this.f3144a = activity;
        this.f3145b = (Context) h.h(context, "context == null");
        this.f3146c = (Handler) h.h(handler, "handler == null");
    }
}
