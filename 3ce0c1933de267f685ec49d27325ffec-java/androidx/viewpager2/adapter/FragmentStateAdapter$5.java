package androidx.viewpager2.adapter;

import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.n;
import androidx.lifecycle.p;
/* loaded from: classes.dex */
class FragmentStateAdapter$5 implements n {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Handler f4605a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Runnable f4606b;

    @Override // androidx.lifecycle.n
    public void c(p pVar, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.f4605a.removeCallbacks(this.f4606b);
            pVar.getLifecycle().c(this);
        }
    }
}
