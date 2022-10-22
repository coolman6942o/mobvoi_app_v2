package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.collection.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import r6.d;
/* loaded from: classes.dex */
public final class x2 extends Fragment implements h {

    /* renamed from: d  reason: collision with root package name */
    private static WeakHashMap<Activity, WeakReference<x2>> f8787d = new WeakHashMap<>();

    /* renamed from: a  reason: collision with root package name */
    private Map<String, LifecycleCallback> f8788a = new a();

    /* renamed from: b  reason: collision with root package name */
    private int f8789b = 0;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f8790c;

    public static x2 b(Activity activity) {
        x2 x2Var;
        WeakReference<x2> weakReference = f8787d.get(activity);
        if (weakReference != null && (x2Var = weakReference.get()) != null) {
            return x2Var;
        }
        try {
            x2 x2Var2 = (x2) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (x2Var2 == null || x2Var2.isRemoving()) {
                x2Var2 = new x2();
                activity.getFragmentManager().beginTransaction().add(x2Var2, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            f8787d.put(activity, new WeakReference<>(x2Var2));
            return x2Var2;
        } catch (ClassCastException e10) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e10);
        }
    }

    @Override // android.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback lifecycleCallback : this.f8788a.values()) {
            lifecycleCallback.a(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.internal.h
    public final void g(String str, LifecycleCallback lifecycleCallback) {
        if (!this.f8788a.containsKey(str)) {
            this.f8788a.put(str, lifecycleCallback);
            if (this.f8789b > 0) {
                new d(Looper.getMainLooper()).post(new y2(this, lifecycleCallback, str));
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 59);
        sb2.append("LifecycleCallback with tag ");
        sb2.append(str);
        sb2.append(" already added to this fragment.");
        throw new IllegalArgumentException(sb2.toString());
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        for (LifecycleCallback lifecycleCallback : this.f8788a.values()) {
            lifecycleCallback.e(i10, i11, intent);
        }
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f8789b = 1;
        this.f8790c = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.f8788a.entrySet()) {
            entry.getValue().f(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f8789b = 5;
        for (LifecycleCallback lifecycleCallback : this.f8788a.values()) {
            lifecycleCallback.g();
        }
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f8789b = 3;
        for (LifecycleCallback lifecycleCallback : this.f8788a.values()) {
            lifecycleCallback.h();
        }
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry<String, LifecycleCallback> entry : this.f8788a.entrySet()) {
                Bundle bundle2 = new Bundle();
                entry.getValue().i(bundle2);
                bundle.putBundle(entry.getKey(), bundle2);
            }
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f8789b = 2;
        for (LifecycleCallback lifecycleCallback : this.f8788a.values()) {
            lifecycleCallback.j();
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f8789b = 4;
        for (LifecycleCallback lifecycleCallback : this.f8788a.values()) {
            lifecycleCallback.k();
        }
    }

    @Override // com.google.android.gms.common.api.internal.h
    public final <T extends LifecycleCallback> T t(String str, Class<T> cls) {
        return cls.cast(this.f8788a.get(str));
    }

    @Override // com.google.android.gms.common.api.internal.h
    public final Activity u() {
        return getActivity();
    }
}
