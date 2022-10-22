package com.mobvoi.companion.aw.ui.main;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import c2.a;
import com.mobvoi.companion.aw.R;
/* loaded from: classes2.dex */
public class StoreTabFragment_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private StoreTabFragment f16296b;

    public StoreTabFragment_ViewBinding(StoreTabFragment storeTabFragment, View view) {
        this.f16296b = storeTabFragment;
        storeTabFragment.mProgressBar = (ProgressBar) a.c(view, R.id.progress_bar_store, "field 'mProgressBar'", ProgressBar.class);
        storeTabFragment.mFrameLayout = (FrameLayout) a.c(view, R.id.fl_store, "field 'mFrameLayout'", FrameLayout.class);
    }

    @Override // butterknife.Unbinder
    public void a() {
        StoreTabFragment storeTabFragment = this.f16296b;
        if (storeTabFragment != null) {
            this.f16296b = null;
            storeTabFragment.mProgressBar = null;
            storeTabFragment.mFrameLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
