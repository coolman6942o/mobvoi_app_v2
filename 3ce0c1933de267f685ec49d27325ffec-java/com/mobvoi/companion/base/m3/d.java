package com.mobvoi.companion.base.m3;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.c;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.d0;
import androidx.core.view.o0;
import gc.e;
import j7.a;
import k7.b;
import kotlin.jvm.internal.i;
/* compiled from: BaseToolbarActivity.kt */
/* loaded from: classes2.dex */
public abstract class d extends androidx.appcompat.app.d {
    private c _progressDialog;
    private FrameLayout contentView;
    private Toolbar toolbar;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: webViewBack$lambda-0  reason: not valid java name */
    public static final void m7webViewBack$lambda0(d this$0, View view) {
        i.f(this$0, "this$0");
        this$0.onNavigationClicked();
    }

    public final FrameLayout getContentView() {
        FrameLayout frameLayout = this.contentView;
        if (frameLayout != null) {
            return frameLayout;
        }
        i.u("contentView");
        throw null;
    }

    protected abstract int getLayoutId();

    public final Toolbar getToolbar() {
        Toolbar toolbar = this.toolbar;
        if (toolbar != null) {
            return toolbar;
        }
        i.u("toolbar");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void hideLoading() {
        c cVar = this._progressDialog;
        if (cVar != null) {
            i.d(cVar);
            if (cVar.isShowing()) {
                c cVar2 = this._progressDialog;
                i.d(cVar2);
                cVar2.dismiss();
                this._progressDialog = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(e.f27354a);
        int b10 = a.b(this, gc.a.f27326b, -1);
        int b11 = a.b(this, 16842801, -1);
        boolean f10 = a.f(b11);
        getWindow().setBackgroundDrawable(new ColorDrawable(b11));
        getWindow().setStatusBarColor(b10);
        getWindow().setNavigationBarColor(b10);
        o0 P = d0.P(getWindow().getDecorView());
        if (P != null) {
            P.b(f10);
        }
        if (P != null) {
            P.a(f10);
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 30) {
            if (f10) {
                int i11 = 8448;
                if (i10 >= 26) {
                    i11 = 8464;
                }
                getWindow().getDecorView().setSystemUiVisibility(i11);
            } else {
                getWindow().getDecorView().setSystemUiVisibility(256);
            }
        }
        View findViewById = findViewById(gc.d.f27341l);
        i.e(findViewById, "findViewById(R.id.mainContentContainer)");
        this.contentView = (FrameLayout) findViewById;
        View findViewById2 = findViewById(gc.d.f27350u);
        i.e(findViewById2, "findViewById(R.id.toolbar)");
        Toolbar toolbar = (Toolbar) findViewById2;
        this.toolbar = toolbar;
        if (toolbar != null) {
            toolbar.setBackgroundColor(b10);
            Toolbar toolbar2 = this.toolbar;
            if (toolbar2 != null) {
                setSupportActionBar(toolbar2);
                androidx.appcompat.app.a supportActionBar = getSupportActionBar();
                if (supportActionBar != null) {
                    supportActionBar.t(true);
                }
                androidx.appcompat.app.a supportActionBar2 = getSupportActionBar();
                if (supportActionBar2 != null) {
                    supportActionBar2.u(true);
                }
                androidx.appcompat.app.a supportActionBar3 = getSupportActionBar();
                if (supportActionBar3 != null) {
                    supportActionBar3.w(gc.c.f27329a);
                }
                if (getLayoutId() != 0) {
                    setContentView(getLayoutId());
                    return;
                }
                return;
            }
            i.u("toolbar");
            throw null;
        }
        i.u("toolbar");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        hideLoading();
    }

    protected final void onNavigationClicked() {
        androidx.core.app.a.p(this);
    }

    @Override // androidx.appcompat.app.d
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override // androidx.appcompat.app.d, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        getContentView().removeAllViews();
        LayoutInflater.from(this).inflate(i10, getContentView());
    }

    public final void setSubtitle(int i10) {
        Toolbar toolbar = this.toolbar;
        if (toolbar != null) {
            toolbar.setSubtitle(i10);
        } else {
            i.u("toolbar");
            throw null;
        }
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.z(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void showLoading(String text) {
        i.f(text, "text");
        hideLoading();
        View inflate = LayoutInflater.from(this).inflate(e.f27357d, (ViewGroup) null);
        ((TextView) inflate.findViewById(gc.d.f27345p)).setText(text);
        c a10 = new b(this).s(inflate).d(false).a();
        this._progressDialog = a10;
        i.d(a10);
        a10.show();
    }

    public final void webViewBack() {
        Toolbar toolbar = this.toolbar;
        if (toolbar != null) {
            toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.base.m3.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.m7webViewBack$lambda0(d.this, view);
                }
            });
        } else {
            i.u("toolbar");
            throw null;
        }
    }

    public final void setSubtitle(CharSequence charSequence) {
        Toolbar toolbar = this.toolbar;
        if (toolbar != null) {
            toolbar.setSubtitle(charSequence);
        } else {
            i.u("toolbar");
            throw null;
        }
    }

    @Override // androidx.appcompat.app.d, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        getContentView().removeAllViews();
        getContentView().addView(view);
    }

    @Override // androidx.appcompat.app.d, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getContentView().removeAllViews();
        getContentView().addView(view, layoutParams);
    }
}
