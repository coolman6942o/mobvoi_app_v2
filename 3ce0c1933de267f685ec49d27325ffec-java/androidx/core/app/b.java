package androidx.core.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.core.util.Pair;
/* compiled from: ActivityOptionsCompat.java */
/* loaded from: classes.dex */
public class b {

    /* compiled from: ActivityOptionsCompat.java */
    /* loaded from: classes.dex */
    private static class a extends b {

        /* renamed from: a  reason: collision with root package name */
        private final ActivityOptions f2233a;

        a(ActivityOptions activityOptions) {
            this.f2233a = activityOptions;
        }

        @Override // androidx.core.app.b
        public Bundle b() {
            return this.f2233a.toBundle();
        }
    }

    protected b() {
    }

    public static b a(Activity activity, Pair<View, String>... pairArr) {
        if (Build.VERSION.SDK_INT < 21) {
            return new b();
        }
        android.util.Pair[] pairArr2 = null;
        if (pairArr != null) {
            pairArr2 = new android.util.Pair[pairArr.length];
            for (int i10 = 0; i10 < pairArr.length; i10++) {
                pairArr2[i10] = android.util.Pair.create((View) pairArr[i10].f29364a, (String) pairArr[i10].f29365b);
            }
        }
        return new a(ActivityOptions.makeSceneTransitionAnimation(activity, pairArr2));
    }

    public Bundle b() {
        return null;
    }
}
