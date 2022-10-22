package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.w;
import androidx.navigation.k;
import androidx.navigation.q;
import androidx.navigation.t;
import com.mobvoi.wear.lpa.LpaConstants;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* compiled from: FragmentNavigator.java */
@t.b("fragment")
/* loaded from: classes.dex */
public class b extends t<a> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f3470a;

    /* renamed from: b  reason: collision with root package name */
    private final FragmentManager f3471b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3472c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayDeque<Integer> f3473d = new ArrayDeque<>();

    /* compiled from: FragmentNavigator.java */
    /* loaded from: classes.dex */
    public static class a extends k {

        /* renamed from: i  reason: collision with root package name */
        private String f3474i;

        public a(t<? extends a> tVar) {
            super(tVar);
        }

        @Override // androidx.navigation.k
        public void n(Context context, AttributeSet attributeSet) {
            super.n(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, d.f3479c);
            String string = obtainAttributes.getString(d.f3480d);
            if (string != null) {
                u(string);
            }
            obtainAttributes.recycle();
        }

        public final String t() {
            String str = this.f3474i;
            if (str != null) {
                return str;
            }
            throw new IllegalStateException("Fragment class was not set");
        }

        @Override // androidx.navigation.k
        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(super.toString());
            sb2.append(" class=");
            String str = this.f3474i;
            if (str == null) {
                sb2.append(LpaConstants.VALUE_NULL);
            } else {
                sb2.append(str);
            }
            return sb2.toString();
        }

        public final a u(String str) {
            this.f3474i = str;
            return this;
        }
    }

    /* compiled from: FragmentNavigator.java */
    /* renamed from: androidx.navigation.fragment.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0039b implements t.a {

        /* renamed from: a  reason: collision with root package name */
        private final LinkedHashMap<View, String> f3475a;

        public Map<View, String> a() {
            return Collections.unmodifiableMap(this.f3475a);
        }
    }

    public b(Context context, FragmentManager fragmentManager, int i10) {
        this.f3470a = context;
        this.f3471b = fragmentManager;
        this.f3472c = i10;
    }

    private String g(int i10, int i11) {
        return i10 + "-" + i11;
    }

    @Override // androidx.navigation.t
    public void c(Bundle bundle) {
        int[] intArray;
        if (!(bundle == null || (intArray = bundle.getIntArray("androidx-nav-fragment:navigator:backStackIds")) == null)) {
            this.f3473d.clear();
            for (int i10 : intArray) {
                this.f3473d.add(Integer.valueOf(i10));
            }
        }
    }

    @Override // androidx.navigation.t
    public Bundle d() {
        Bundle bundle = new Bundle();
        int[] iArr = new int[this.f3473d.size()];
        Iterator<Integer> it = this.f3473d.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10++;
            iArr[i10] = it.next().intValue();
        }
        bundle.putIntArray("androidx-nav-fragment:navigator:backStackIds", iArr);
        return bundle;
    }

    @Override // androidx.navigation.t
    public boolean e() {
        if (this.f3473d.isEmpty()) {
            return false;
        }
        if (this.f3471b.N0()) {
            Log.i("FragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return false;
        }
        this.f3471b.Y0(g(this.f3473d.size(), this.f3473d.peekLast().intValue()), 1);
        this.f3473d.removeLast();
        return true;
    }

    /* renamed from: f */
    public a a() {
        return new a(this);
    }

    @Deprecated
    public Fragment h(Context context, FragmentManager fragmentManager, String str, Bundle bundle) {
        return fragmentManager.s0().a(context.getClassLoader(), str);
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0134 A[RETURN] */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public k b(a aVar, Bundle bundle, q qVar, t.a aVar2) {
        if (this.f3471b.N0()) {
            Log.i("FragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
            return null;
        }
        String t10 = aVar.t();
        boolean z10 = false;
        if (t10.charAt(0) == '.') {
            t10 = this.f3470a.getPackageName() + t10;
        }
        Fragment h10 = h(this.f3470a, this.f3471b, t10, bundle);
        h10.setArguments(bundle);
        w l10 = this.f3471b.l();
        int a10 = qVar != null ? qVar.a() : -1;
        int b10 = qVar != null ? qVar.b() : -1;
        int c10 = qVar != null ? qVar.c() : -1;
        int d10 = qVar != null ? qVar.d() : -1;
        if (!(a10 == -1 && b10 == -1 && c10 == -1 && d10 == -1)) {
            if (a10 == -1) {
                a10 = 0;
            }
            if (b10 == -1) {
                b10 = 0;
            }
            if (c10 == -1) {
                c10 = 0;
            }
            if (d10 == -1) {
                d10 = 0;
            }
            l10.v(a10, b10, c10, d10);
        }
        l10.s(this.f3472c, h10);
        l10.x(h10);
        int i10 = aVar.i();
        boolean isEmpty = this.f3473d.isEmpty();
        boolean z11 = qVar != null && !isEmpty && qVar.g() && this.f3473d.peekLast().intValue() == i10;
        if (!isEmpty) {
            if (z11) {
                if (this.f3473d.size() > 1) {
                    this.f3471b.Y0(g(this.f3473d.size(), this.f3473d.peekLast().intValue()), 1);
                    l10.h(g(this.f3473d.size(), i10));
                }
                if (aVar2 instanceof C0039b) {
                    for (Map.Entry<View, String> entry : ((C0039b) aVar2).a().entrySet()) {
                        l10.g(entry.getKey(), entry.getValue());
                    }
                }
                l10.y(true);
                l10.j();
                if (z10) {
                    return null;
                }
                this.f3473d.add(Integer.valueOf(i10));
                return aVar;
            }
            l10.h(g(this.f3473d.size() + 1, i10));
        }
        z10 = true;
        if (aVar2 instanceof C0039b) {
        }
        l10.y(true);
        l10.j();
        if (z10) {
        }
    }
}
