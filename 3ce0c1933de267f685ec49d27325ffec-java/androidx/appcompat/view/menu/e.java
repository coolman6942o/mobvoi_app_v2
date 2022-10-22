package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.f0;
import com.mobvoi.wear.common.base.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* compiled from: MenuBuilder.java */
/* loaded from: classes.dex */
public class e implements d0.a {
    private static final int[] A = {1, 4, 5, 3, 2, 0};

    /* renamed from: a  reason: collision with root package name */
    private final Context f698a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f699b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f700c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f701d;

    /* renamed from: e  reason: collision with root package name */
    private a f702e;

    /* renamed from: m  reason: collision with root package name */
    private ContextMenu.ContextMenuInfo f710m;

    /* renamed from: n  reason: collision with root package name */
    CharSequence f711n;

    /* renamed from: o  reason: collision with root package name */
    Drawable f712o;

    /* renamed from: p  reason: collision with root package name */
    View f713p;

    /* renamed from: x  reason: collision with root package name */
    private g f721x;

    /* renamed from: z  reason: collision with root package name */
    private boolean f723z;

    /* renamed from: l  reason: collision with root package name */
    private int f709l = 0;

    /* renamed from: q  reason: collision with root package name */
    private boolean f714q = false;

    /* renamed from: r  reason: collision with root package name */
    private boolean f715r = false;

    /* renamed from: s  reason: collision with root package name */
    private boolean f716s = false;

    /* renamed from: t  reason: collision with root package name */
    private boolean f717t = false;

    /* renamed from: u  reason: collision with root package name */
    private boolean f718u = false;

    /* renamed from: v  reason: collision with root package name */
    private ArrayList<g> f719v = new ArrayList<>();

    /* renamed from: w  reason: collision with root package name */
    private CopyOnWriteArrayList<WeakReference<j>> f720w = new CopyOnWriteArrayList<>();

    /* renamed from: y  reason: collision with root package name */
    private boolean f722y = false;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<g> f703f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<g> f704g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private boolean f705h = true;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<g> f706i = new ArrayList<>();

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<g> f707j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    private boolean f708k = true;

    /* compiled from: MenuBuilder.java */
    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, MenuItem menuItem);

        void b(e eVar);
    }

    /* compiled from: MenuBuilder.java */
    /* loaded from: classes.dex */
    public interface b {
        boolean a(g gVar);
    }

    public e(Context context) {
        this.f698a = context;
        this.f699b = context.getResources();
        f0(true);
    }

    private static int D(int i10) {
        int i11 = ((-65536) & i10) >> 16;
        if (i11 >= 0) {
            int[] iArr = A;
            if (i11 < iArr.length) {
                return (i10 & 65535) | (iArr[i11] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void P(int i10, boolean z10) {
        if (i10 >= 0 && i10 < this.f703f.size()) {
            this.f703f.remove(i10);
            if (z10) {
                M(true);
            }
        }
    }

    private void a0(int i10, CharSequence charSequence, int i11, Drawable drawable, View view) {
        Resources E = E();
        if (view != null) {
            this.f713p = view;
            this.f711n = null;
            this.f712o = null;
        } else {
            if (i10 > 0) {
                this.f711n = E.getText(i10);
            } else if (charSequence != null) {
                this.f711n = charSequence;
            }
            if (i11 > 0) {
                this.f712o = androidx.core.content.b.e(w(), i11);
            } else if (drawable != null) {
                this.f712o = drawable;
            }
            this.f713p = null;
        }
        M(false);
    }

    private void f0(boolean z10) {
        boolean z11 = true;
        if (!z10 || this.f699b.getConfiguration().keyboard == 1 || !f0.f(ViewConfiguration.get(this.f698a), this.f698a)) {
            z11 = false;
        }
        this.f701d = z11;
    }

    private g g(int i10, int i11, int i12, int i13, CharSequence charSequence, int i14) {
        return new g(this, i10, i11, i12, i13, charSequence, i14);
    }

    private void i(boolean z10) {
        if (!this.f720w.isEmpty()) {
            h0();
            Iterator<WeakReference<j>> it = this.f720w.iterator();
            while (it.hasNext()) {
                WeakReference<j> next = it.next();
                j jVar = next.get();
                if (jVar == null) {
                    this.f720w.remove(next);
                } else {
                    jVar.d(z10);
                }
            }
            g0();
        }
    }

    private void j(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null && !this.f720w.isEmpty()) {
            Iterator<WeakReference<j>> it = this.f720w.iterator();
            while (it.hasNext()) {
                WeakReference<j> next = it.next();
                j jVar = next.get();
                if (jVar == null) {
                    this.f720w.remove(next);
                } else {
                    int id2 = jVar.getId();
                    if (id2 > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id2)) != null) {
                        jVar.j(parcelable);
                    }
                }
            }
        }
    }

    private void k(Bundle bundle) {
        Parcelable m10;
        if (!this.f720w.isEmpty()) {
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            Iterator<WeakReference<j>> it = this.f720w.iterator();
            while (it.hasNext()) {
                WeakReference<j> next = it.next();
                j jVar = next.get();
                if (jVar == null) {
                    this.f720w.remove(next);
                } else {
                    int id2 = jVar.getId();
                    if (id2 > 0 && (m10 = jVar.m()) != null) {
                        sparseArray.put(id2, m10);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
        }
    }

    private boolean l(m mVar, j jVar) {
        boolean z10 = false;
        if (this.f720w.isEmpty()) {
            return false;
        }
        if (jVar != null) {
            z10 = jVar.l(mVar);
        }
        Iterator<WeakReference<j>> it = this.f720w.iterator();
        while (it.hasNext()) {
            WeakReference<j> next = it.next();
            j jVar2 = next.get();
            if (jVar2 == null) {
                this.f720w.remove(next);
            } else if (!z10) {
                z10 = jVar2.l(mVar);
            }
        }
        return z10;
    }

    private static int p(ArrayList<g> arrayList, int i10) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).f() <= i10) {
                return size + 1;
            }
        }
        return 0;
    }

    public View A() {
        return this.f713p;
    }

    public ArrayList<g> B() {
        t();
        return this.f707j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean C() {
        return this.f717t;
    }

    Resources E() {
        return this.f699b;
    }

    public e F() {
        return this;
    }

    public ArrayList<g> G() {
        if (!this.f705h) {
            return this.f704g;
        }
        this.f704g.clear();
        int size = this.f703f.size();
        for (int i10 = 0; i10 < size; i10++) {
            g gVar = this.f703f.get(i10);
            if (gVar.isVisible()) {
                this.f704g.add(gVar);
            }
        }
        this.f705h = false;
        this.f708k = true;
        return this.f704g;
    }

    public boolean H() {
        return this.f722y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean I() {
        return this.f700c;
    }

    public boolean J() {
        return this.f701d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(g gVar) {
        this.f708k = true;
        M(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(g gVar) {
        this.f705h = true;
        M(true);
    }

    public void M(boolean z10) {
        if (!this.f714q) {
            if (z10) {
                this.f705h = true;
                this.f708k = true;
            }
            i(z10);
            return;
        }
        this.f715r = true;
        if (z10) {
            this.f716s = true;
        }
    }

    public boolean N(MenuItem menuItem, int i10) {
        return O(menuItem, null, i10);
    }

    public boolean O(MenuItem menuItem, j jVar, int i10) {
        g gVar = (g) menuItem;
        if (gVar == null || !gVar.isEnabled()) {
            return false;
        }
        boolean k10 = gVar.k();
        androidx.core.view.b b10 = gVar.b();
        boolean z10 = b10 != null && b10.a();
        if (gVar.j()) {
            k10 |= gVar.expandActionView();
            if (k10) {
                e(true);
            }
        } else if (gVar.hasSubMenu() || z10) {
            if ((i10 & 4) == 0) {
                e(false);
            }
            if (!gVar.hasSubMenu()) {
                gVar.x(new m(w(), this, gVar));
            }
            m mVar = (m) gVar.getSubMenu();
            if (z10) {
                b10.f(mVar);
            }
            k10 |= l(mVar, jVar);
            if (!k10) {
                e(true);
            }
        } else if ((i10 & 1) == 0) {
            e(true);
        }
        return k10;
    }

    public void Q(j jVar) {
        Iterator<WeakReference<j>> it = this.f720w.iterator();
        while (it.hasNext()) {
            WeakReference<j> next = it.next();
            j jVar2 = next.get();
            if (jVar2 == null || jVar2 == jVar) {
                this.f720w.remove(next);
            }
        }
    }

    public void R(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(v());
            int size = size();
            for (int i10 = 0; i10 < size; i10++) {
                MenuItem item = getItem(i10);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((m) item.getSubMenu()).R(bundle);
                }
            }
            int i11 = bundle.getInt("android:menu:expandedactionview");
            if (i11 > 0 && (findItem = findItem(i11)) != null) {
                findItem.expandActionView();
            }
        }
    }

    public void S(Bundle bundle) {
        j(bundle);
    }

    public void T(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = getItem(i10);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((m) item.getSubMenu()).T(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(v(), sparseArray);
        }
    }

    public void U(Bundle bundle) {
        k(bundle);
    }

    public void V(a aVar) {
        this.f702e = aVar;
    }

    public e W(int i10) {
        this.f709l = i10;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f703f.size();
        h0();
        for (int i10 = 0; i10 < size; i10++) {
            g gVar = this.f703f.get(i10);
            if (gVar.getGroupId() == groupId && gVar.m() && gVar.isCheckable()) {
                gVar.s(gVar == menuItem);
            }
        }
        g0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e Y(int i10) {
        a0(0, null, i10, null, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e Z(Drawable drawable) {
        a0(0, null, 0, drawable, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MenuItem a(int i10, int i11, int i12, CharSequence charSequence) {
        int D = D(i12);
        g g10 = g(i10, i11, i12, D, charSequence, this.f709l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f710m;
        if (contextMenuInfo != null) {
            g10.v(contextMenuInfo);
        }
        ArrayList<g> arrayList = this.f703f;
        arrayList.add(p(arrayList, D), g10);
        M(true);
        return g10;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i10, int i11, int i12, ComponentName componentName, Intent[] intentArr, Intent intent, int i13, MenuItem[] menuItemArr) {
        int i14;
        PackageManager packageManager = this.f698a.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i13 & 1) == 0) {
            removeGroup(i10);
        }
        for (int i15 = 0; i15 < size; i15++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i15);
            int i16 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i16 < 0 ? intent : intentArr[i16]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i10, i11, i12, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i14 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i14] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(j jVar) {
        c(jVar, this.f698a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e b0(int i10) {
        a0(i10, null, 0, null, null);
        return this;
    }

    public void c(j jVar, Context context) {
        this.f720w.add(new WeakReference<>(jVar));
        jVar.i(context, this);
        this.f708k = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e c0(CharSequence charSequence) {
        a0(0, charSequence, 0, null, null);
        return this;
    }

    @Override // android.view.Menu
    public void clear() {
        g gVar = this.f721x;
        if (gVar != null) {
            f(gVar);
        }
        this.f703f.clear();
        M(true);
    }

    public void clearHeader() {
        this.f712o = null;
        this.f711n = null;
        this.f713p = null;
        M(false);
    }

    @Override // android.view.Menu
    public void close() {
        e(true);
    }

    public void d() {
        a aVar = this.f702e;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e d0(View view) {
        a0(0, null, 0, null, view);
        return this;
    }

    public final void e(boolean z10) {
        if (!this.f718u) {
            this.f718u = true;
            Iterator<WeakReference<j>> it = this.f720w.iterator();
            while (it.hasNext()) {
                WeakReference<j> next = it.next();
                j jVar = next.get();
                if (jVar == null) {
                    this.f720w.remove(next);
                } else {
                    jVar.c(this, z10);
                }
            }
            this.f718u = false;
        }
    }

    public void e0(boolean z10) {
        this.f723z = z10;
    }

    public boolean f(g gVar) {
        boolean z10 = false;
        if (!this.f720w.isEmpty() && this.f721x == gVar) {
            h0();
            Iterator<WeakReference<j>> it = this.f720w.iterator();
            while (it.hasNext()) {
                WeakReference<j> next = it.next();
                j jVar = next.get();
                if (jVar == null) {
                    this.f720w.remove(next);
                } else {
                    z10 = jVar.f(this, gVar);
                    if (z10) {
                        break;
                    }
                }
            }
            g0();
            if (z10) {
                this.f721x = null;
            }
        }
        return z10;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i10) {
        MenuItem findItem;
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            g gVar = this.f703f.get(i11);
            if (gVar.getItemId() == i10) {
                return gVar;
            }
            if (gVar.hasSubMenu() && (findItem = gVar.getSubMenu().findItem(i10)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public void g0() {
        this.f714q = false;
        if (this.f715r) {
            this.f715r = false;
            M(this.f716s);
        }
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i10) {
        return this.f703f.get(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(e eVar, MenuItem menuItem) {
        a aVar = this.f702e;
        return aVar != null && aVar.a(eVar, menuItem);
    }

    public void h0() {
        if (!this.f714q) {
            this.f714q = true;
            this.f715r = false;
            this.f716s = false;
        }
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.f723z) {
            return true;
        }
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f703f.get(i10).isVisible()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i10, KeyEvent keyEvent) {
        return r(i10, keyEvent) != null;
    }

    public boolean m(g gVar) {
        boolean z10 = false;
        if (this.f720w.isEmpty()) {
            return false;
        }
        h0();
        Iterator<WeakReference<j>> it = this.f720w.iterator();
        while (it.hasNext()) {
            WeakReference<j> next = it.next();
            j jVar = next.get();
            if (jVar == null) {
                this.f720w.remove(next);
            } else {
                z10 = jVar.g(this, gVar);
                if (z10) {
                    break;
                }
            }
        }
        g0();
        if (z10) {
            this.f721x = gVar;
        }
        return z10;
    }

    public int n(int i10) {
        return o(i10, 0);
    }

    public int o(int i10, int i11) {
        int size = size();
        if (i11 < 0) {
            i11 = 0;
        }
        while (i11 < size) {
            if (this.f703f.get(i11).getGroupId() == i10) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i10, int i11) {
        return N(findItem(i10), i11);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i10, KeyEvent keyEvent, int i11) {
        g r10 = r(i10, keyEvent);
        boolean N = r10 != null ? N(r10, i11) : false;
        if ((i11 & 2) != 0) {
            e(true);
        }
        return N;
    }

    public int q(int i10) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            if (this.f703f.get(i11).getItemId() == i10) {
                return i11;
            }
        }
        return -1;
    }

    g r(int i10, KeyEvent keyEvent) {
        char c10;
        ArrayList<g> arrayList = this.f719v;
        arrayList.clear();
        s(arrayList, i10, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean I = I();
        for (int i11 = 0; i11 < size; i11++) {
            g gVar = arrayList.get(i11);
            if (I) {
                c10 = gVar.getAlphabeticShortcut();
            } else {
                c10 = gVar.getNumericShortcut();
            }
            char[] cArr = keyData.meta;
            if ((c10 == cArr[0] && (metaState & 2) == 0) || ((c10 == cArr[2] && (metaState & 2) != 0) || (I && c10 == '\b' && i10 == 67))) {
                return gVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public void removeGroup(int i10) {
        int n10 = n(i10);
        if (n10 >= 0) {
            int size = this.f703f.size() - n10;
            int i11 = 0;
            while (true) {
                i11++;
                if (i11 >= size || this.f703f.get(n10).getGroupId() != i10) {
                    break;
                }
                P(n10, false);
            }
            M(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i10) {
        P(q(i10), true);
    }

    void s(List<g> list, int i10, KeyEvent keyEvent) {
        boolean I = I();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i10 == 67) {
            int size = this.f703f.size();
            for (int i11 = 0; i11 < size; i11++) {
                g gVar = this.f703f.get(i11);
                if (gVar.hasSubMenu()) {
                    ((e) gVar.getSubMenu()).s(list, i10, keyEvent);
                }
                char alphabeticShortcut = I ? gVar.getAlphabeticShortcut() : gVar.getNumericShortcut();
                if (((modifiers & Constants.Sensor.MOBVOI_RRI_SENSOR_TYPE) == ((I ? gVar.getAlphabeticModifiers() : gVar.getNumericModifiers()) & Constants.Sensor.MOBVOI_RRI_SENSOR_TYPE)) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (I && alphabeticShortcut == '\b' && i10 == 67)) && gVar.isEnabled()) {
                        list.add(gVar);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i10, boolean z10, boolean z11) {
        int size = this.f703f.size();
        for (int i11 = 0; i11 < size; i11++) {
            g gVar = this.f703f.get(i11);
            if (gVar.getGroupId() == i10) {
                gVar.t(z11);
                gVar.setCheckable(z10);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z10) {
        this.f722y = z10;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i10, boolean z10) {
        int size = this.f703f.size();
        for (int i11 = 0; i11 < size; i11++) {
            g gVar = this.f703f.get(i11);
            if (gVar.getGroupId() == i10) {
                gVar.setEnabled(z10);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i10, boolean z10) {
        int size = this.f703f.size();
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            g gVar = this.f703f.get(i11);
            if (gVar.getGroupId() == i10 && gVar.y(z10)) {
                z11 = true;
            }
        }
        if (z11) {
            M(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z10) {
        this.f700c = z10;
        M(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f703f.size();
    }

    public void t() {
        ArrayList<g> G = G();
        if (this.f708k) {
            Iterator<WeakReference<j>> it = this.f720w.iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                WeakReference<j> next = it.next();
                j jVar = next.get();
                if (jVar == null) {
                    this.f720w.remove(next);
                } else {
                    z10 |= jVar.e();
                }
            }
            if (z10) {
                this.f706i.clear();
                this.f707j.clear();
                int size = G.size();
                for (int i10 = 0; i10 < size; i10++) {
                    g gVar = G.get(i10);
                    if (gVar.l()) {
                        this.f706i.add(gVar);
                    } else {
                        this.f707j.add(gVar);
                    }
                }
            } else {
                this.f706i.clear();
                this.f707j.clear();
                this.f707j.addAll(G());
            }
            this.f708k = false;
        }
    }

    public ArrayList<g> u() {
        t();
        return this.f706i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String v() {
        return "android:menu:actionviewstates";
    }

    public Context w() {
        return this.f698a;
    }

    public g x() {
        return this.f721x;
    }

    public Drawable y() {
        return this.f712o;
    }

    public CharSequence z() {
        return this.f711n;
    }

    @Override // android.view.Menu
    public MenuItem add(int i10) {
        return a(0, 0, 0, this.f699b.getString(i10));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10) {
        return addSubMenu(0, 0, 0, this.f699b.getString(i10));
    }

    @Override // android.view.Menu
    public MenuItem add(int i10, int i11, int i12, CharSequence charSequence) {
        return a(i10, i11, i12, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence) {
        g gVar = (g) a(i10, i11, i12, charSequence);
        m mVar = new m(this.f698a, this, gVar);
        gVar.x(mVar);
        return mVar;
    }

    @Override // android.view.Menu
    public MenuItem add(int i10, int i11, int i12, int i13) {
        return a(i10, i11, i12, this.f699b.getString(i13));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, int i13) {
        return addSubMenu(i10, i11, i12, this.f699b.getString(i13));
    }
}
