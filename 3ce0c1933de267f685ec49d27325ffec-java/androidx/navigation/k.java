package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.collection.g;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* compiled from: NavDestination.java */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private final String f3508a;

    /* renamed from: b  reason: collision with root package name */
    private m f3509b;

    /* renamed from: c  reason: collision with root package name */
    private int f3510c;

    /* renamed from: d  reason: collision with root package name */
    private String f3511d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f3512e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<h> f3513f;

    /* renamed from: g  reason: collision with root package name */
    private g<d> f3514g;

    /* renamed from: h  reason: collision with root package name */
    private HashMap<String, e> f3515h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NavDestination.java */
    /* loaded from: classes.dex */
    public static class a implements Comparable<a> {

        /* renamed from: a  reason: collision with root package name */
        private final k f3516a;

        /* renamed from: b  reason: collision with root package name */
        private final Bundle f3517b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f3518c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f3519d;

        /* renamed from: e  reason: collision with root package name */
        private final int f3520e;

        a(k kVar, Bundle bundle, boolean z10, boolean z11, int i10) {
            this.f3516a = kVar;
            this.f3517b = bundle;
            this.f3518c = z10;
            this.f3519d = z11;
            this.f3520e = i10;
        }

        /* renamed from: a */
        public int compareTo(a aVar) {
            boolean z10 = this.f3518c;
            if (z10 && !aVar.f3518c) {
                return 1;
            }
            if (!z10 && aVar.f3518c) {
                return -1;
            }
            Bundle bundle = this.f3517b;
            if (bundle != null && aVar.f3517b == null) {
                return 1;
            }
            if (bundle == null && aVar.f3517b != null) {
                return -1;
            }
            if (bundle != null) {
                int size = bundle.size() - aVar.f3517b.size();
                if (size > 0) {
                    return 1;
                }
                if (size < 0) {
                    return -1;
                }
            }
            boolean z11 = this.f3519d;
            if (z11 && !aVar.f3519d) {
                return 1;
            }
            if (z11 || !aVar.f3519d) {
                return this.f3520e - aVar.f3520e;
            }
            return -1;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public k b() {
            return this.f3516a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Bundle c() {
            return this.f3517b;
        }
    }

    static {
        new HashMap();
    }

    public k(t<? extends k> tVar) {
        this(u.c(tVar.getClass()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String h(Context context, int i10) {
        if (i10 <= 16777215) {
            return Integer.toString(i10);
        }
        try {
            return context.getResources().getResourceName(i10);
        } catch (Resources.NotFoundException unused) {
            return Integer.toString(i10);
        }
    }

    public final void a(String str, e eVar) {
        if (this.f3515h == null) {
            this.f3515h = new HashMap<>();
        }
        this.f3515h.put(str, eVar);
    }

    public final void b(h hVar) {
        if (this.f3513f == null) {
            this.f3513f = new ArrayList<>();
        }
        this.f3513f.add(hVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle c(Bundle bundle) {
        HashMap<String, e> hashMap;
        if (bundle == null && ((hashMap = this.f3515h) == null || hashMap.isEmpty())) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        HashMap<String, e> hashMap2 = this.f3515h;
        if (hashMap2 != null) {
            for (Map.Entry<String, e> entry : hashMap2.entrySet()) {
                entry.getValue().d(entry.getKey(), bundle2);
            }
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
            HashMap<String, e> hashMap3 = this.f3515h;
            if (hashMap3 != null) {
                for (Map.Entry<String, e> entry2 : hashMap3.entrySet()) {
                    if (!entry2.getValue().e(entry2.getKey(), bundle2)) {
                        throw new IllegalArgumentException("Wrong argument type for '" + entry2.getKey() + "' in argument bundle. " + entry2.getValue().b().c() + " expected.");
                    }
                }
            }
        }
        return bundle2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] d() {
        ArrayDeque arrayDeque = new ArrayDeque();
        k kVar = this;
        while (true) {
            m l10 = kVar.l();
            if (l10 == null || l10.z() != kVar.i()) {
                arrayDeque.addFirst(kVar);
            }
            if (l10 == null) {
                break;
            }
            kVar = l10;
        }
        int[] iArr = new int[arrayDeque.size()];
        int i10 = 0;
        Iterator it = arrayDeque.iterator();
        while (it.hasNext()) {
            i10++;
            iArr[i10] = ((k) it.next()).i();
        }
        return iArr;
    }

    public final d e(int i10) {
        g<d> gVar = this.f3514g;
        d e10 = gVar == null ? null : gVar.e(i10);
        if (e10 != null) {
            return e10;
        }
        if (l() != null) {
            return l().e(i10);
        }
        return null;
    }

    public final Map<String, e> f() {
        HashMap<String, e> hashMap = this.f3515h;
        return hashMap == null ? Collections.emptyMap() : Collections.unmodifiableMap(hashMap);
    }

    public String g() {
        if (this.f3511d == null) {
            this.f3511d = Integer.toString(this.f3510c);
        }
        return this.f3511d;
    }

    public final int i() {
        return this.f3510c;
    }

    public final CharSequence j() {
        return this.f3512e;
    }

    public final String k() {
        return this.f3508a;
    }

    public final m l() {
        return this.f3509b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a m(j jVar) {
        ArrayList<h> arrayList = this.f3513f;
        if (arrayList == null) {
            return null;
        }
        Iterator<h> it = arrayList.iterator();
        a aVar = null;
        while (it.hasNext()) {
            h next = it.next();
            Uri c10 = jVar.c();
            Bundle c11 = c10 != null ? next.c(c10, f()) : null;
            String a10 = jVar.a();
            boolean z10 = a10 != null && a10.equals(next.b());
            String b10 = jVar.b();
            int d10 = b10 != null ? next.d(b10) : -1;
            if (c11 != null || z10 || d10 > -1) {
                a aVar2 = new a(this, c11, next.e(), z10, d10);
                if (aVar == null || aVar2.compareTo(aVar) > 0) {
                    aVar = aVar2;
                }
            }
        }
        return aVar;
    }

    public void n(Context context, AttributeSet attributeSet) {
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, c1.a.f5574v);
        p(obtainAttributes.getResourceId(c1.a.f5576x, 0));
        this.f3511d = h(context, this.f3510c);
        q(obtainAttributes.getText(c1.a.f5575w));
        obtainAttributes.recycle();
    }

    public final void o(int i10, d dVar) {
        if (!s()) {
            throw new UnsupportedOperationException("Cannot add action " + i10 + " to " + this + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
        } else if (i10 != 0) {
            if (this.f3514g == null) {
                this.f3514g = new g<>();
            }
            this.f3514g.j(i10, dVar);
        } else {
            throw new IllegalArgumentException("Cannot have an action with actionId 0");
        }
    }

    public final void p(int i10) {
        this.f3510c = i10;
        this.f3511d = null;
    }

    public final void q(CharSequence charSequence) {
        this.f3512e = charSequence;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void r(m mVar) {
        this.f3509b = mVar;
    }

    boolean s() {
        return true;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append("(");
        String str = this.f3511d;
        if (str == null) {
            sb2.append("0x");
            sb2.append(Integer.toHexString(this.f3510c));
        } else {
            sb2.append(str);
        }
        sb2.append(")");
        if (this.f3512e != null) {
            sb2.append(" label=");
            sb2.append(this.f3512e);
        }
        return sb2.toString();
    }

    public k(String str) {
        this.f3508a = str;
    }
}
