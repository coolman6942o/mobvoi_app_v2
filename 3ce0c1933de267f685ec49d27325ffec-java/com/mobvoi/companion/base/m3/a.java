package com.mobvoi.companion.base.m3;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.d;
import androidx.core.view.d0;
import androidx.core.view.m0;
import androidx.core.view.n0;
import androidx.core.view.o0;
import b0.b;
import java.util.Objects;
import kotlin.jvm.internal.i;
/* compiled from: BaseActivity.kt */
/* loaded from: classes2.dex */
public class a extends d {
    public boolean needFitsSystemWindows() {
        return false;
    }

    public n0 onApplyWindowInsets(View contentView, n0 windowInsets) {
        i.f(contentView, "contentView");
        i.f(windowInsets, "windowInsets");
        b f10 = windowInsets.f(n0.m.b());
        i.e(f10, "windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())");
        ViewGroup.LayoutParams layoutParams = contentView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.leftMargin = f10.f4959a;
        marginLayoutParams.bottomMargin = f10.f4962d;
        marginLayoutParams.rightMargin = f10.f4961c;
        marginLayoutParams.topMargin = f10.f4960b;
        contentView.setLayoutParams(marginLayoutParams);
        n0 CONSUMED = n0.f2580b;
        i.e(CONSUMED, "CONSUMED");
        return CONSUMED;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int b10 = j7.a.b(this, gc.a.f27326b, -1);
        int b11 = j7.a.b(this, 16842801, -1);
        boolean f10 = j7.a.f(b11);
        getWindow().setBackgroundDrawable(new ColorDrawable(b11));
        getWindow().setStatusBarColor(b10);
        getWindow().setNavigationBarColor(b10);
        m0.b(getWindow(), needFitsSystemWindows());
        o0 P = d0.P(getWindow().getDecorView());
        if (P != null) {
            P.c(n0.m.b());
        }
        if (P != null) {
            P.b(f10);
        }
        if (P != null) {
            P.a(f10);
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            return;
        }
        if (f10) {
            int i11 = 8448;
            if (i10 >= 26) {
                i11 = 8464;
            }
            getWindow().getDecorView().setSystemUiVisibility(i11);
            return;
        }
        getWindow().getDecorView().setSystemUiVisibility(256);
    }
}
