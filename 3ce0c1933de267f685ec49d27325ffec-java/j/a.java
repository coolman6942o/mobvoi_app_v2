package j;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import d0.b;
/* compiled from: ActionMenuItem.java */
/* loaded from: classes.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final int f29330a;

    /* renamed from: b  reason: collision with root package name */
    private final int f29331b;

    /* renamed from: c  reason: collision with root package name */
    private final int f29332c;

    /* renamed from: d  reason: collision with root package name */
    private CharSequence f29333d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f29334e;

    /* renamed from: f  reason: collision with root package name */
    private Intent f29335f;

    /* renamed from: g  reason: collision with root package name */
    private char f29336g;

    /* renamed from: i  reason: collision with root package name */
    private char f29338i;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f29340k;

    /* renamed from: l  reason: collision with root package name */
    private Context f29341l;

    /* renamed from: m  reason: collision with root package name */
    private CharSequence f29342m;

    /* renamed from: n  reason: collision with root package name */
    private CharSequence f29343n;

    /* renamed from: h  reason: collision with root package name */
    private int f29337h = 4096;

    /* renamed from: j  reason: collision with root package name */
    private int f29339j = 4096;

    /* renamed from: o  reason: collision with root package name */
    private ColorStateList f29344o = null;

    /* renamed from: p  reason: collision with root package name */
    private PorterDuff.Mode f29345p = null;

    /* renamed from: q  reason: collision with root package name */
    private boolean f29346q = false;

    /* renamed from: r  reason: collision with root package name */
    private boolean f29347r = false;

    /* renamed from: s  reason: collision with root package name */
    private int f29348s = 16;

    public a(Context context, int i10, int i11, int i12, int i13, CharSequence charSequence) {
        this.f29341l = context;
        this.f29330a = i11;
        this.f29331b = i10;
        this.f29332c = i13;
        this.f29333d = charSequence;
    }

    private void c() {
        Drawable drawable = this.f29340k;
        if (drawable == null) {
            return;
        }
        if (this.f29346q || this.f29347r) {
            Drawable r10 = androidx.core.graphics.drawable.a.r(drawable);
            this.f29340k = r10;
            Drawable mutate = r10.mutate();
            this.f29340k = mutate;
            if (this.f29346q) {
                androidx.core.graphics.drawable.a.o(mutate, this.f29344o);
            }
            if (this.f29347r) {
                androidx.core.graphics.drawable.a.p(this.f29340k, this.f29345p);
            }
        }
    }

    @Override // d0.b
    public b a(androidx.core.view.b bVar) {
        throw new UnsupportedOperationException();
    }

    @Override // d0.b
    public androidx.core.view.b b() {
        return null;
    }

    @Override // d0.b, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    /* renamed from: d */
    public b setActionView(int i10) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: e */
    public b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // d0.b, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    /* renamed from: f */
    public b setShowAsActionFlags(int i10) {
        setShowAsAction(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // d0.b, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // d0.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f29339j;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f29338i;
    }

    @Override // d0.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f29342m;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f29331b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f29340k;
    }

    @Override // d0.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f29344o;
    }

    @Override // d0.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f29345p;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f29335f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f29330a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // d0.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f29337h;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f29336g;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f29332c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f29333d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f29334e;
        return charSequence != null ? charSequence : this.f29333d;
    }

    @Override // d0.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f29343n;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // d0.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f29348s & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f29348s & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f29348s & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f29348s & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10) {
        this.f29338i = Character.toLowerCase(c10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z10) {
        this.f29348s = (z10 ? 1 : 0) | (this.f29348s & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z10) {
        this.f29348s = (z10 ? 2 : 0) | (this.f29348s & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z10) {
        this.f29348s = (z10 ? 16 : 0) | (this.f29348s & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f29340k = drawable;
        c();
        return this;
    }

    @Override // d0.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f29344o = colorStateList;
        this.f29346q = true;
        c();
        return this;
    }

    @Override // d0.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f29345p = mode;
        this.f29347r = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f29335f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c10) {
        this.f29336g = c10;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11) {
        this.f29336g = c10;
        this.f29338i = Character.toLowerCase(c11);
        return this;
    }

    @Override // d0.b, android.view.MenuItem
    public void setShowAsAction(int i10) {
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f29333d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f29334e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z10) {
        int i10 = 8;
        int i11 = this.f29348s & 8;
        if (z10) {
            i10 = 0;
        }
        this.f29348s = i11 | i10;
        return this;
    }

    @Override // d0.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        this.f29338i = Character.toLowerCase(c10);
        this.f29339j = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @Override // d0.b, android.view.MenuItem
    public b setContentDescription(CharSequence charSequence) {
        this.f29342m = charSequence;
        return this;
    }

    @Override // d0.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c10, int i10) {
        this.f29336g = c10;
        this.f29337h = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i10) {
        this.f29333d = this.f29341l.getResources().getString(i10);
        return this;
    }

    @Override // d0.b, android.view.MenuItem
    public b setTooltipText(CharSequence charSequence) {
        this.f29343n = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i10) {
        this.f29340k = androidx.core.content.b.e(this.f29341l, i10);
        c();
        return this;
    }

    @Override // d0.b, android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f29336g = c10;
        this.f29337h = KeyEvent.normalizeMetaState(i10);
        this.f29338i = Character.toLowerCase(c11);
        this.f29339j = KeyEvent.normalizeMetaState(i11);
        return this;
    }
}
