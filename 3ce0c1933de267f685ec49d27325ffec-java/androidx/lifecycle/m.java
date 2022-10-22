package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: LifecycleDispatcher.java */
/* loaded from: classes.dex */
class m {

    /* renamed from: a  reason: collision with root package name */
    private static AtomicBoolean f3323a = new AtomicBoolean(false);

    /* compiled from: LifecycleDispatcher.java */
    /* loaded from: classes.dex */
    static class a extends g {
        a() {
        }

        @Override // androidx.lifecycle.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            a0.g(activity);
        }

        @Override // androidx.lifecycle.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // androidx.lifecycle.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context) {
        if (!f3323a.getAndSet(true)) {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new a());
        }
    }
}
