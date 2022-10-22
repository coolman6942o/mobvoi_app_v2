package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.d;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.g;
import java.lang.reflect.Method;
/* compiled from: MenuPopupWindow.java */
/* loaded from: classes.dex */
public class m0 extends k0 implements l0 {
    private static Method J;
    private l0 I;

    /* compiled from: MenuPopupWindow.java */
    /* loaded from: classes.dex */
    public static class a extends h0 {

        /* renamed from: o  reason: collision with root package name */
        final int f1258o;

        /* renamed from: p  reason: collision with root package name */
        final int f1259p;

        /* renamed from: q  reason: collision with root package name */
        private l0 f1260q;

        /* renamed from: r  reason: collision with root package name */
        private MenuItem f1261r;

        public a(Context context, boolean z10) {
            super(context, z10);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT < 17 || 1 != configuration.getLayoutDirection()) {
                this.f1258o = 22;
                this.f1259p = 21;
                return;
            }
            this.f1258o = 21;
            this.f1259p = 22;
        }

        @Override // androidx.appcompat.widget.h0, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            int i10;
            d dVar;
            int pointToPosition;
            int i11;
            if (this.f1260q != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i10 = headerViewListAdapter.getHeadersCount();
                    dVar = (d) headerViewListAdapter.getWrappedAdapter();
                } else {
                    i10 = 0;
                    dVar = (d) adapter;
                }
                g gVar = null;
                if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i11 = pointToPosition - i10) >= 0 && i11 < dVar.getCount()) {
                    gVar = dVar.getItem(i11);
                }
                MenuItem menuItem = this.f1261r;
                if (menuItem != gVar) {
                    e b10 = dVar.b();
                    if (menuItem != null) {
                        this.f1260q.h(b10, menuItem);
                    }
                    this.f1261r = gVar;
                    if (gVar != null) {
                        this.f1260q.e(b10, gVar);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i10, KeyEvent keyEvent) {
            d dVar;
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i10 == this.f1258o) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i10 != this.f1259p) {
                return super.onKeyDown(i10, keyEvent);
            } else {
                setSelection(-1);
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    dVar = (d) ((HeaderViewListAdapter) adapter).getWrappedAdapter();
                } else {
                    dVar = (d) adapter;
                }
                dVar.b().e(false);
                return true;
            }
        }

        public void setHoverListener(l0 l0Var) {
            this.f1260q = l0Var;
        }

        @Override // androidx.appcompat.widget.h0, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                J = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public m0(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }

    public void R(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.E.setEnterTransition((Transition) obj);
        }
    }

    public void S(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.E.setExitTransition((Transition) obj);
        }
    }

    public void T(l0 l0Var) {
        this.I = l0Var;
    }

    public void U(boolean z10) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = J;
            if (method != null) {
                try {
                    method.invoke(this.E, Boolean.valueOf(z10));
                } catch (Exception unused) {
                    Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
                }
            }
        } else {
            this.E.setTouchModal(z10);
        }
    }

    @Override // androidx.appcompat.widget.l0
    public void e(e eVar, MenuItem menuItem) {
        l0 l0Var = this.I;
        if (l0Var != null) {
            l0Var.e(eVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.l0
    public void h(e eVar, MenuItem menuItem) {
        l0 l0Var = this.I;
        if (l0Var != null) {
            l0Var.h(eVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.k0
    h0 s(Context context, boolean z10) {
        a aVar = new a(context, z10);
        aVar.setHoverListener(this);
        return aVar;
    }
}
