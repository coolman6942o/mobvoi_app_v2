package com.huawei.hmf.tasks.a;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.util.Log;
import com.huawei.hmf.tasks.ExecuteResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class g extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    private static final WeakHashMap<Activity, WeakReference<g>> f13680b = new WeakHashMap<>();

    /* renamed from: a  reason: collision with root package name */
    private final List<WeakReference<ExecuteResult<?>>> f13681a = new ArrayList();

    private static g a(Activity activity) {
        ClassCastException e10;
        WeakHashMap<Activity, WeakReference<g>> weakHashMap = f13680b;
        WeakReference<g> weakReference = weakHashMap.get(activity);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        g gVar = null;
        try {
            g gVar2 = (g) fragmentManager.findFragmentByTag("com.huawei.hmf.tasks.lifecycle_fragment_tag");
            if (gVar2 == null) {
                try {
                    gVar = a(fragmentManager);
                } catch (ClassCastException e11) {
                    e10 = e11;
                    gVar = gVar2;
                    Log.e("LifecycleCallbackFrg", "found LifecycleCallbackFragment but the type do not match. " + e10.getMessage());
                    return gVar;
                }
            } else {
                gVar = gVar2;
            }
            try {
                weakHashMap.put(activity, new WeakReference<>(gVar));
            } catch (ClassCastException e12) {
                e10 = e12;
                Log.e("LifecycleCallbackFrg", "found LifecycleCallbackFragment but the type do not match. " + e10.getMessage());
                return gVar;
            }
        } catch (ClassCastException e13) {
            e10 = e13;
        }
        return gVar;
    }

    private static g a(FragmentManager fragmentManager) {
        Exception e10;
        g gVar;
        g gVar2 = null;
        try {
            gVar = new g();
        } catch (Exception e11) {
            e10 = e11;
        }
        try {
            fragmentManager.beginTransaction().add(gVar, "com.huawei.hmf.tasks.lifecycle_fragment_tag").commitAllowingStateLoss();
            return gVar;
        } catch (Exception e12) {
            e10 = e12;
            gVar2 = gVar;
            Log.e("LifecycleCallbackFrg", "create fragment failed." + e10.getMessage());
            return gVar2;
        }
    }

    public static void a(Activity activity, ExecuteResult executeResult) {
        g a10 = a(activity);
        if (a10 != null) {
            synchronized (a10.f13681a) {
                a10.f13681a.add(new WeakReference<>(executeResult));
            }
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        synchronized (this.f13681a) {
            for (WeakReference<ExecuteResult<?>> weakReference : this.f13681a) {
                ExecuteResult<?> executeResult = weakReference.get();
                if (executeResult != null) {
                    executeResult.cancel();
                }
            }
            this.f13681a.clear();
        }
    }
}
