package com.google.android.material.navigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.g;
/* compiled from: NavigationBarMenu.java */
/* loaded from: classes.dex */
public final class b extends e {
    private final Class<?> B;
    private final int C;

    public b(Context context, Class<?> cls, int i10) {
        super(context);
        this.B = cls;
        this.C = i10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.view.menu.e
    public MenuItem a(int i10, int i11, int i12, CharSequence charSequence) {
        if (size() + 1 <= this.C) {
            h0();
            MenuItem a10 = super.a(i10, i11, i12, charSequence);
            if (a10 instanceof g) {
                ((g) a10).t(true);
            }
            g0();
            return a10;
        }
        String simpleName = this.B.getSimpleName();
        throw new IllegalArgumentException("Maximum number of items supported by " + simpleName + " is " + this.C + ". Limit can be checked with " + simpleName + "#getMaxItemCount()");
    }

    @Override // androidx.appcompat.view.menu.e, android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence) {
        throw new UnsupportedOperationException(this.B.getSimpleName() + " does not support submenus");
    }
}
