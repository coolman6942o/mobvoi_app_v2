package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.k;
import androidx.core.view.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import d.h;
import d0.b;
/* compiled from: MenuItemImpl.java */
/* loaded from: classes.dex */
public final class g implements b {
    private View A;
    private androidx.core.view.b B;
    private MenuItem.OnActionExpandListener C;
    private ContextMenu.ContextMenuInfo E;

    /* renamed from: a  reason: collision with root package name */
    private final int f728a;

    /* renamed from: b  reason: collision with root package name */
    private final int f729b;

    /* renamed from: c  reason: collision with root package name */
    private final int f730c;

    /* renamed from: d  reason: collision with root package name */
    private final int f731d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f732e;

    /* renamed from: f  reason: collision with root package name */
    private CharSequence f733f;

    /* renamed from: g  reason: collision with root package name */
    private Intent f734g;

    /* renamed from: h  reason: collision with root package name */
    private char f735h;

    /* renamed from: j  reason: collision with root package name */
    private char f737j;

    /* renamed from: l  reason: collision with root package name */
    private Drawable f739l;

    /* renamed from: n  reason: collision with root package name */
    e f741n;

    /* renamed from: o  reason: collision with root package name */
    private m f742o;

    /* renamed from: p  reason: collision with root package name */
    private Runnable f743p;

    /* renamed from: q  reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f744q;

    /* renamed from: r  reason: collision with root package name */
    private CharSequence f745r;

    /* renamed from: s  reason: collision with root package name */
    private CharSequence f746s;

    /* renamed from: z  reason: collision with root package name */
    private int f753z;

    /* renamed from: i  reason: collision with root package name */
    private int f736i = 4096;

    /* renamed from: k  reason: collision with root package name */
    private int f738k = 4096;

    /* renamed from: m  reason: collision with root package name */
    private int f740m = 0;

    /* renamed from: t  reason: collision with root package name */
    private ColorStateList f747t = null;

    /* renamed from: u  reason: collision with root package name */
    private PorterDuff.Mode f748u = null;

    /* renamed from: v  reason: collision with root package name */
    private boolean f749v = false;

    /* renamed from: w  reason: collision with root package name */
    private boolean f750w = false;

    /* renamed from: x  reason: collision with root package name */
    private boolean f751x = false;

    /* renamed from: y  reason: collision with root package name */
    private int f752y = 16;
    private boolean D = false;

    /* compiled from: MenuItemImpl.java */
    /* loaded from: classes.dex */
    class a implements b.AbstractC0021b {
        a() {
        }

        @Override // androidx.core.view.b.AbstractC0021b
        public void onActionProviderVisibilityChanged(boolean z10) {
            g gVar = g.this;
            gVar.f741n.L(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, int i10, int i11, int i12, int i13, CharSequence charSequence, int i14) {
        this.f753z = 0;
        this.f741n = eVar;
        this.f728a = i11;
        this.f729b = i10;
        this.f730c = i12;
        this.f731d = i13;
        this.f732e = charSequence;
        this.f753z = i14;
    }

    private static void d(StringBuilder sb2, int i10, int i11, String str) {
        if ((i10 & i11) == i11) {
            sb2.append(str);
        }
    }

    private Drawable e(Drawable drawable) {
        if (drawable != null && this.f751x && (this.f749v || this.f750w)) {
            drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
            if (this.f749v) {
                androidx.core.graphics.drawable.a.o(drawable, this.f747t);
            }
            if (this.f750w) {
                androidx.core.graphics.drawable.a.p(drawable, this.f748u);
            }
            this.f751x = false;
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean A() {
        return this.f741n.J() && g() != 0;
    }

    public boolean B() {
        return (this.f753z & 4) == 4;
    }

    @Override // d0.b
    public d0.b a(androidx.core.view.b bVar) {
        androidx.core.view.b bVar2 = this.B;
        if (bVar2 != null) {
            bVar2.h();
        }
        this.A = null;
        this.B = bVar;
        this.f741n.M(true);
        androidx.core.view.b bVar3 = this.B;
        if (bVar3 != null) {
            bVar3.j(new a());
        }
        return this;
    }

    @Override // d0.b
    public androidx.core.view.b b() {
        return this.B;
    }

    public void c() {
        this.f741n.K(this);
    }

    @Override // d0.b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f753z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f741n.f(this);
        }
        return false;
    }

    @Override // d0.b, android.view.MenuItem
    public boolean expandActionView() {
        if (!j()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f741n.m(this);
        }
        return false;
    }

    public int f() {
        return this.f731d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char g() {
        return this.f741n.I() ? this.f737j : this.f735h;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // d0.b, android.view.MenuItem
    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        androidx.core.view.b bVar = this.B;
        if (bVar == null) {
            return null;
        }
        View d10 = bVar.d(this);
        this.A = d10;
        return d10;
    }

    @Override // d0.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f738k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f737j;
    }

    @Override // d0.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f745r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f729b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f739l;
        if (drawable != null) {
            return e(drawable);
        }
        if (this.f740m == 0) {
            return null;
        }
        Drawable b10 = e.a.b(this.f741n.w(), this.f740m);
        this.f740m = 0;
        this.f739l = b10;
        return e(b10);
    }

    @Override // d0.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f747t;
    }

    @Override // d0.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f748u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f734g;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f728a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    @Override // d0.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f736i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f735h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f730c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f742o;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f732e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f733f;
        if (charSequence == null) {
            charSequence = this.f732e;
        }
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    @Override // d0.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f746s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h() {
        char g10 = g();
        if (g10 == 0) {
            return "";
        }
        Resources resources = this.f741n.w().getResources();
        StringBuilder sb2 = new StringBuilder();
        if (ViewConfiguration.get(this.f741n.w()).hasPermanentMenuKey()) {
            sb2.append(resources.getString(h.f24847m));
        }
        int i10 = this.f741n.I() ? this.f738k : this.f736i;
        d(sb2, i10, WXMediaMessage.THUMB_LENGTH_LIMIT, resources.getString(h.f24843i));
        d(sb2, i10, 4096, resources.getString(h.f24839e));
        d(sb2, i10, 2, resources.getString(h.f24838d));
        d(sb2, i10, 1, resources.getString(h.f24844j));
        d(sb2, i10, 4, resources.getString(h.f24846l));
        d(sb2, i10, 8, resources.getString(h.f24842h));
        if (g10 == '\b') {
            sb2.append(resources.getString(h.f24840f));
        } else if (g10 == '\n') {
            sb2.append(resources.getString(h.f24841g));
        } else if (g10 != ' ') {
            sb2.append(g10);
        } else {
            sb2.append(resources.getString(h.f24845k));
        }
        return sb2.toString();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f742o != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence i(k.a aVar) {
        if (aVar == null || !aVar.d()) {
            return getTitle();
        }
        return getTitleCondensed();
    }

    @Override // d0.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.D;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f752y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f752y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f752y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        androidx.core.view.b bVar = this.B;
        return (bVar == null || !bVar.g()) ? (this.f752y & 8) == 0 : (this.f752y & 8) == 0 && this.B.b();
    }

    public boolean j() {
        androidx.core.view.b bVar;
        if ((this.f753z & 8) == 0) {
            return false;
        }
        if (this.A == null && (bVar = this.B) != null) {
            this.A = bVar.d(this);
        }
        return this.A != null;
    }

    public boolean k() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f744q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        e eVar = this.f741n;
        if (eVar.h(eVar, this)) {
            return true;
        }
        Runnable runnable = this.f743p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f734g != null) {
            try {
                this.f741n.w().startActivity(this.f734g);
                return true;
            } catch (ActivityNotFoundException e10) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e10);
            }
        }
        androidx.core.view.b bVar = this.B;
        return bVar != null && bVar.e();
    }

    public boolean l() {
        return (this.f752y & 32) == 32;
    }

    public boolean m() {
        return (this.f752y & 4) != 0;
    }

    public boolean n() {
        return (this.f753z & 1) == 1;
    }

    public boolean o() {
        return (this.f753z & 2) == 2;
    }

    /* renamed from: p */
    public d0.b setActionView(int i10) {
        Context w10 = this.f741n.w();
        setActionView(LayoutInflater.from(w10).inflate(i10, (ViewGroup) new LinearLayout(w10), false));
        return this;
    }

    /* renamed from: q */
    public d0.b setActionView(View view) {
        int i10;
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1 && (i10 = this.f728a) > 0) {
            view.setId(i10);
        }
        this.f741n.K(this);
        return this;
    }

    public void r(boolean z10) {
        this.D = z10;
        this.f741n.M(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(boolean z10) {
        int i10 = this.f752y;
        int i11 = (z10 ? 2 : 0) | (i10 & (-3));
        this.f752y = i11;
        if (i10 != i11) {
            this.f741n.M(false);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10) {
        if (this.f737j == c10) {
            return this;
        }
        this.f737j = Character.toLowerCase(c10);
        this.f741n.M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z10) {
        int i10 = this.f752y;
        int i11 = (z10 ? 1 : 0) | (i10 & (-2));
        this.f752y = i11;
        if (i10 != i11) {
            this.f741n.M(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z10) {
        if ((this.f752y & 4) != 0) {
            this.f741n.X(this);
        } else {
            s(z10);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z10) {
        if (z10) {
            this.f752y |= 16;
        } else {
            this.f752y &= -17;
        }
        this.f741n.M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f740m = 0;
        this.f739l = drawable;
        this.f751x = true;
        this.f741n.M(false);
        return this;
    }

    @Override // d0.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f747t = colorStateList;
        this.f749v = true;
        this.f751x = true;
        this.f741n.M(false);
        return this;
    }

    @Override // d0.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f748u = mode;
        this.f750w = true;
        this.f751x = true;
        this.f741n.M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f734g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c10) {
        if (this.f735h == c10) {
            return this;
        }
        this.f735h = c10;
        this.f741n.M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f744q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11) {
        this.f735h = c10;
        this.f737j = Character.toLowerCase(c11);
        this.f741n.M(false);
        return this;
    }

    @Override // d0.b, android.view.MenuItem
    public void setShowAsAction(int i10) {
        int i11 = i10 & 3;
        if (i11 == 0 || i11 == 1 || i11 == 2) {
            this.f753z = i10;
            this.f741n.K(this);
            return;
        }
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f732e = charSequence;
        this.f741n.M(false);
        m mVar = this.f742o;
        if (mVar != null) {
            mVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f733f = charSequence;
        this.f741n.M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z10) {
        if (y(z10)) {
            this.f741n.L(this);
        }
        return this;
    }

    public void t(boolean z10) {
        this.f752y = (z10 ? 4 : 0) | (this.f752y & (-5));
    }

    public String toString() {
        CharSequence charSequence = this.f732e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(boolean z10) {
        if (z10) {
            this.f752y |= 32;
        } else {
            this.f752y &= -33;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    /* renamed from: w */
    public d0.b setShowAsActionFlags(int i10) {
        setShowAsAction(i10);
        return this;
    }

    public void x(m mVar) {
        this.f742o = mVar;
        mVar.setHeaderTitle(getTitle());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean y(boolean z10) {
        int i10 = this.f752y;
        int i11 = (z10 ? 0 : 8) | (i10 & (-9));
        this.f752y = i11;
        return i10 != i11;
    }

    public boolean z() {
        return this.f741n.C();
    }

    @Override // d0.b, android.view.MenuItem
    public d0.b setContentDescription(CharSequence charSequence) {
        this.f745r = charSequence;
        this.f741n.M(false);
        return this;
    }

    @Override // d0.b, android.view.MenuItem
    public d0.b setTooltipText(CharSequence charSequence) {
        this.f746s = charSequence;
        this.f741n.M(false);
        return this;
    }

    @Override // d0.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        if (this.f737j == c10 && this.f738k == i10) {
            return this;
        }
        this.f737j = Character.toLowerCase(c10);
        this.f738k = KeyEvent.normalizeMetaState(i10);
        this.f741n.M(false);
        return this;
    }

    @Override // d0.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c10, int i10) {
        if (this.f735h == c10 && this.f736i == i10) {
            return this;
        }
        this.f735h = c10;
        this.f736i = KeyEvent.normalizeMetaState(i10);
        this.f741n.M(false);
        return this;
    }

    @Override // d0.b, android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f735h = c10;
        this.f736i = KeyEvent.normalizeMetaState(i10);
        this.f737j = Character.toLowerCase(c11);
        this.f738k = KeyEvent.normalizeMetaState(i11);
        this.f741n.M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i10) {
        this.f739l = null;
        this.f740m = i10;
        this.f751x = true;
        this.f741n.M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i10) {
        return setTitle(this.f741n.w().getString(i10));
    }
}
