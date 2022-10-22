package com.huawei.hms.feature.dynamic;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.huawei.hms.feature.dynamic.LifecycleDelegate;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class DeferredLifecycleHelper<T extends LifecycleDelegate> {
    public static final int STATUS_ONCREATED = 1;
    public static final int STATUS_ONCREATEVIEW = 2;
    public static final int STATUS_ONINFLATE = 0;
    public static final int STATUS_ONRESUME = 5;
    public static final int STATUS_ONSTART = 4;

    /* renamed from: a  reason: collision with root package name */
    private static final String f13734a = "DeferredLifecycleHelper";

    /* renamed from: b  reason: collision with root package name */
    private T f13735b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f13736c;

    /* renamed from: d  reason: collision with root package name */
    private LinkedList<a> f13737d;

    /* renamed from: e  reason: collision with root package name */
    private OnDelegateCreatedListener<T> f13738e = (OnDelegateCreatedListener<T>) new OnDelegateCreatedListener<LifecycleDelegate>() { // from class: com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.1
        @Override // com.huawei.hms.feature.dynamic.OnDelegateCreatedListener
        public final void onDelegateCreated(LifecycleDelegate lifecycleDelegate) {
            DeferredLifecycleHelper.this.f13735b = lifecycleDelegate;
            Iterator it = DeferredLifecycleHelper.this.f13737d.iterator();
            while (it.hasNext()) {
                ((a) it.next()).a(DeferredLifecycleHelper.this.f13735b);
            }
            DeferredLifecycleHelper.this.f13737d.clear();
            DeferredLifecycleHelper.this.f13736c = null;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        int a();

        void a(LifecycleDelegate lifecycleDelegate);
    }

    private void a(int i10) {
        while (!this.f13737d.isEmpty() && this.f13737d.getLast().a() >= i10) {
            this.f13737d.removeLast();
        }
    }

    private final void a(Bundle bundle, a aVar) {
        T t10 = this.f13735b;
        if (t10 != null) {
            aVar.a(t10);
            return;
        }
        if (this.f13737d == null) {
            this.f13737d = new LinkedList<>();
        }
        this.f13737d.add(aVar);
        if (bundle != null) {
            Bundle bundle2 = this.f13736c;
            if (bundle2 == null) {
                this.f13736c = (Bundle) bundle.clone();
            } else {
                bundle2.putAll(bundle);
            }
        }
        createDelegate(this.f13738e);
    }

    protected abstract void createDelegate(OnDelegateCreatedListener<T> onDelegateCreatedListener);

    public T getDelegate() {
        return this.f13735b;
    }

    public void onCreate(final Bundle bundle) {
        a(bundle, new a() { // from class: com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.3
            @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.a
            public final int a() {
                return 1;
            }

            @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.a
            public final void a(LifecycleDelegate lifecycleDelegate) {
                Log.d(DeferredLifecycleHelper.f13734a, "IDelegateLifeCycleCall onCreate:");
                lifecycleDelegate.onCreate(bundle);
            }
        });
    }

    public View onCreateView(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        final FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        a(bundle, new a() { // from class: com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.4
            @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.a
            public final int a() {
                return 2;
            }

            @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.a
            public final void a(LifecycleDelegate lifecycleDelegate) {
                frameLayout.removeAllViews();
                frameLayout.addView(DeferredLifecycleHelper.this.f13735b.onCreateView(layoutInflater, viewGroup, bundle));
            }
        });
        return frameLayout;
    }

    public void onDestroy() {
        T t10 = this.f13735b;
        if (t10 != null) {
            t10.onDestroy();
        } else {
            a(0);
        }
    }

    public void onDestroyView() {
        T t10 = this.f13735b;
        if (t10 != null) {
            t10.onDestroyView();
        } else {
            a(1);
        }
    }

    public void onInflate(final Activity activity, final Bundle bundle, final Bundle bundle2) {
        a(bundle2, new a() { // from class: com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.2
            @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.a
            public final int a() {
                return 0;
            }

            @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.a
            public final void a(LifecycleDelegate lifecycleDelegate) {
                DeferredLifecycleHelper.this.f13735b.onInflate(activity, bundle, bundle2);
            }
        });
    }

    public void onLowMemory() {
        T t10 = this.f13735b;
        if (t10 != null) {
            t10.onLowMemory();
        }
    }

    public void onPause() {
        T t10 = this.f13735b;
        if (t10 != null) {
            t10.onPause();
        } else {
            a(5);
        }
    }

    public void onResume() {
        a((Bundle) null, new a() { // from class: com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.6
            @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.a
            public final int a() {
                return 5;
            }

            @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.a
            public final void a(LifecycleDelegate lifecycleDelegate) {
                Log.d(DeferredLifecycleHelper.f13734a, "IDelegateLifeCycleCall onResume:");
                lifecycleDelegate.onResume();
            }
        });
    }

    public void onSaveInstanceState(Bundle bundle) {
        T t10 = this.f13735b;
        if (t10 != null) {
            t10.onSaveInstanceState(bundle);
            return;
        }
        Bundle bundle2 = this.f13736c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }

    public void onStart() {
        a((Bundle) null, new a() { // from class: com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.5
            @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.a
            public final int a() {
                return 4;
            }

            @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.a
            public final void a(LifecycleDelegate lifecycleDelegate) {
                Log.d(DeferredLifecycleHelper.f13734a, "IDelegateLifeCycleCall onStart:");
                lifecycleDelegate.onStart();
            }
        });
    }

    public void onStop() {
        T t10 = this.f13735b;
        if (t10 != null) {
            t10.onStop();
        } else {
            a(4);
        }
    }
}
