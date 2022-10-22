package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.collection.a;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.f;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import r6.d;
/* loaded from: classes.dex */
public final class z2 extends Fragment implements h {

    /* renamed from: d  reason: collision with root package name */
    private static WeakHashMap<f, WeakReference<z2>> f8802d = new WeakHashMap<>();

    /* renamed from: a  reason: collision with root package name */
    private Map<String, LifecycleCallback> f8803a = new a();

    /* renamed from: b  reason: collision with root package name */
    private int f8804b = 0;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f8805c;

    public static z2 Z(f fVar) {
        z2 z2Var;
        WeakReference<z2> weakReference = f8802d.get(fVar);
        if (weakReference != null && (z2Var = weakReference.get()) != null) {
            return z2Var;
        }
        try {
            z2 z2Var2 = (z2) fVar.getSupportFragmentManager().g0("SupportLifecycleFragmentImpl");
            if (z2Var2 == null || z2Var2.isRemoving()) {
                z2Var2 = new z2();
                fVar.getSupportFragmentManager().l().e(z2Var2, "SupportLifecycleFragmentImpl").k();
            }
            f8802d.put(fVar, new WeakReference<>(z2Var2));
            return z2Var2;
        } catch (ClassCastException e10) {
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e10);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback lifecycleCallback : this.f8803a.values()) {
            lifecycleCallback.a(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.internal.h
    public final void g(String str, LifecycleCallback lifecycleCallback) {
        if (!this.f8803a.containsKey(str)) {
            this.f8803a.put(str, lifecycleCallback);
            if (this.f8804b > 0) {
                new d(Looper.getMainLooper()).post(new a3(this, lifecycleCallback, str));
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

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        for (LifecycleCallback lifecycleCallback : this.f8803a.values()) {
            lifecycleCallback.e(i10, i11, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f8804b = 1;
        this.f8805c = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.f8803a.entrySet()) {
            entry.getValue().f(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f8804b = 5;
        for (LifecycleCallback lifecycleCallback : this.f8803a.values()) {
            lifecycleCallback.g();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f8804b = 3;
        for (LifecycleCallback lifecycleCallback : this.f8803a.values()) {
            lifecycleCallback.h();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry<String, LifecycleCallback> entry : this.f8803a.entrySet()) {
                Bundle bundle2 = new Bundle();
                entry.getValue().i(bundle2);
                bundle.putBundle(entry.getKey(), bundle2);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f8804b = 2;
        for (LifecycleCallback lifecycleCallback : this.f8803a.values()) {
            lifecycleCallback.j();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f8804b = 4;
        for (LifecycleCallback lifecycleCallback : this.f8803a.values()) {
            lifecycleCallback.k();
        }
    }

    @Override // com.google.android.gms.common.api.internal.h
    public final <T extends LifecycleCallback> T t(String str, Class<T> cls) {
        return cls.cast(this.f8803a.get(str));
    }

    @Override // com.google.android.gms.common.api.internal.h
    public final /* synthetic */ Activity u() {
        return getActivity();
    }
}
