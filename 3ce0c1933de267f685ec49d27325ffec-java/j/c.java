package j;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.b;
import java.lang.reflect.Method;
/* compiled from: MenuItemWrapperICS.java */
/* loaded from: classes.dex */
public class c extends j.b implements MenuItem {

    /* renamed from: d  reason: collision with root package name */
    private final d0.b f29352d;

    /* renamed from: e  reason: collision with root package name */
    private Method f29353e;

    /* compiled from: MenuItemWrapperICS.java */
    /* loaded from: classes.dex */
    private class a extends androidx.core.view.b {

        /* renamed from: b  reason: collision with root package name */
        final ActionProvider f29354b;

        a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f29354b = actionProvider;
        }

        @Override // androidx.core.view.b
        public boolean a() {
            return this.f29354b.hasSubMenu();
        }

        @Override // androidx.core.view.b
        public View c() {
            return this.f29354b.onCreateActionView();
        }

        @Override // androidx.core.view.b
        public boolean e() {
            return this.f29354b.onPerformDefaultAction();
        }

        @Override // androidx.core.view.b
        public void f(SubMenu subMenu) {
            this.f29354b.onPrepareSubMenu(c.this.d(subMenu));
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* loaded from: classes.dex */
    private class b extends a implements ActionProvider.VisibilityListener {

        /* renamed from: d  reason: collision with root package name */
        private b.AbstractC0021b f29356d;

        b(c cVar, Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // androidx.core.view.b
        public boolean b() {
            return this.f29354b.isVisible();
        }

        @Override // androidx.core.view.b
        public View d(MenuItem menuItem) {
            return this.f29354b.onCreateActionView(menuItem);
        }

        @Override // androidx.core.view.b
        public boolean g() {
            return this.f29354b.overridesItemVisibility();
        }

        @Override // androidx.core.view.b
        public void j(b.AbstractC0021b bVar) {
            this.f29356d = bVar;
            this.f29354b.setVisibilityListener(bVar != null ? this : null);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z10) {
            b.AbstractC0021b bVar = this.f29356d;
            if (bVar != null) {
                bVar.onActionProviderVisibilityChanged(z10);
            }
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* renamed from: j.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0351c extends FrameLayout implements i.c {

        /* renamed from: a  reason: collision with root package name */
        final CollapsibleActionView f29357a;

        C0351c(View view) {
            super(view.getContext());
            this.f29357a = (CollapsibleActionView) view;
            addView(view);
        }

        View a() {
            return (View) this.f29357a;
        }

        @Override // i.c
        public void c() {
            this.f29357a.onActionViewExpanded();
        }

        @Override // i.c
        public void f() {
            this.f29357a.onActionViewCollapsed();
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* loaded from: classes.dex */
    private class d implements MenuItem.OnActionExpandListener {

        /* renamed from: a  reason: collision with root package name */
        private final MenuItem.OnActionExpandListener f29358a;

        d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f29358a = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f29358a.onMenuItemActionCollapse(c.this.c(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f29358a.onMenuItemActionExpand(c.this.c(menuItem));
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* loaded from: classes.dex */
    private class e implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        private final MenuItem.OnMenuItemClickListener f29360a;

        e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f29360a = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f29360a.onMenuItemClick(c.this.c(menuItem));
        }
    }

    public c(Context context, d0.b bVar) {
        super(context);
        if (bVar != null) {
            this.f29352d = bVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.f29352d.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.f29352d.expandActionView();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        androidx.core.view.b b10 = this.f29352d.b();
        if (b10 instanceof a) {
            return ((a) b10).f29354b;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.f29352d.getActionView();
        return actionView instanceof C0351c ? ((C0351c) actionView).a() : actionView;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f29352d.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f29352d.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f29352d.getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f29352d.getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f29352d.getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f29352d.getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f29352d.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f29352d.getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f29352d.getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f29352d.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f29352d.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f29352d.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f29352d.getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return d(this.f29352d.getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f29352d.getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f29352d.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f29352d.getTooltipText();
    }

    public void h(boolean z10) {
        try {
            if (this.f29353e == null) {
                this.f29353e = this.f29352d.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f29353e.invoke(this.f29352d, Boolean.valueOf(z10));
        } catch (Exception e10) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e10);
        }
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f29352d.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f29352d.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.f29352d.isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.f29352d.isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.f29352d.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.f29352d.isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        androidx.core.view.b bVar;
        if (Build.VERSION.SDK_INT >= 16) {
            bVar = new b(this, this.f29349a, actionProvider);
        } else {
            bVar = new a(this.f29349a, actionProvider);
        }
        d0.b bVar2 = this.f29352d;
        if (actionProvider == null) {
            bVar = null;
        }
        bVar2.a(bVar);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new C0351c(view);
        }
        this.f29352d.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10) {
        this.f29352d.setAlphabeticShortcut(c10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z10) {
        this.f29352d.setCheckable(z10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z10) {
        this.f29352d.setChecked(z10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f29352d.setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z10) {
        this.f29352d.setEnabled(z10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f29352d.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f29352d.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f29352d.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f29352d.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c10) {
        this.f29352d.setNumericShortcut(c10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f29352d.setOnActionExpandListener(onActionExpandListener != null ? new d(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f29352d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new e(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11) {
        this.f29352d.setShortcut(c10, c11);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i10) {
        this.f29352d.setShowAsAction(i10);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i10) {
        this.f29352d.setShowAsActionFlags(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f29352d.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f29352d.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f29352d.setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z10) {
        return this.f29352d.setVisible(z10);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        this.f29352d.setAlphabeticShortcut(c10, i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i10) {
        this.f29352d.setIcon(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c10, int i10) {
        this.f29352d.setNumericShortcut(c10, i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f29352d.setShortcut(c10, c11, i10, i11);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i10) {
        this.f29352d.setTitle(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i10) {
        this.f29352d.setActionView(i10);
        View actionView = this.f29352d.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f29352d.setActionView(new C0351c(actionView));
        }
        return this;
    }
}
