package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.collection.g;
import androidx.navigation.k;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* compiled from: NavGraph.java */
/* loaded from: classes.dex */
public class m extends k implements Iterable<k> {

    /* renamed from: i  reason: collision with root package name */
    final g<k> f3521i = new g<>();

    /* renamed from: j  reason: collision with root package name */
    private int f3522j;

    /* renamed from: k  reason: collision with root package name */
    private String f3523k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NavGraph.java */
    /* loaded from: classes.dex */
    public class a implements Iterator<k> {

        /* renamed from: a  reason: collision with root package name */
        private int f3524a = -1;

        /* renamed from: b  reason: collision with root package name */
        private boolean f3525b = false;

        a() {
        }

        /* renamed from: a */
        public k next() {
            if (hasNext()) {
                this.f3525b = true;
                g<k> gVar = m.this.f3521i;
                int i10 = this.f3524a + 1;
                this.f3524a = i10;
                return gVar.m(i10);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f3524a + 1 < m.this.f3521i.l();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f3525b) {
                m.this.f3521i.m(this.f3524a).r(null);
                m.this.f3521i.k(this.f3524a);
                this.f3524a--;
                this.f3525b = false;
                return;
            }
            throw new IllegalStateException("You must call next() before you can remove an element");
        }
    }

    public m(t<? extends m> tVar) {
        super(tVar);
    }

    public final void A(int i10) {
        if (i10 != i()) {
            this.f3522j = i10;
            this.f3523k = null;
            return;
        }
        throw new IllegalArgumentException("Start destination " + i10 + " cannot use the same id as the graph " + this);
    }

    @Override // androidx.navigation.k
    public String g() {
        return i() != 0 ? super.g() : "the root navigation";
    }

    @Override // java.lang.Iterable
    public final Iterator<k> iterator() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.navigation.k
    public k.a m(j jVar) {
        k.a m10 = super.m(jVar);
        Iterator<k> it = iterator();
        while (it.hasNext()) {
            k.a m11 = it.next().m(jVar);
            if (m11 != null && (m10 == null || m11.compareTo(m10) > 0)) {
                m10 = m11;
            }
        }
        return m10;
    }

    @Override // androidx.navigation.k
    public void n(Context context, AttributeSet attributeSet) {
        super.n(context, attributeSet);
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, c1.a.f5572t);
        A(obtainAttributes.getResourceId(c1.a.f5573u, 0));
        this.f3523k = k.h(context, this.f3522j);
        obtainAttributes.recycle();
    }

    public final void t(k kVar) {
        int i10 = kVar.i();
        if (i10 == 0) {
            throw new IllegalArgumentException("Destinations must have an id. Call setId() or include an android:id in your navigation XML.");
        } else if (i10 != i()) {
            k e10 = this.f3521i.e(i10);
            if (e10 != kVar) {
                if (kVar.l() == null) {
                    if (e10 != null) {
                        e10.r(null);
                    }
                    kVar.r(this);
                    this.f3521i.j(kVar.i(), kVar);
                    return;
                }
                throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.");
            }
        } else {
            throw new IllegalArgumentException("Destination " + kVar + " cannot have the same id as graph " + this);
        }
    }

    @Override // androidx.navigation.k
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append(" startDestination=");
        k u10 = u(z());
        if (u10 == null) {
            String str = this.f3523k;
            if (str == null) {
                sb2.append("0x");
                sb2.append(Integer.toHexString(this.f3522j));
            } else {
                sb2.append(str);
            }
        } else {
            sb2.append("{");
            sb2.append(u10.toString());
            sb2.append("}");
        }
        return sb2.toString();
    }

    public final k u(int i10) {
        return w(i10, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final k w(int i10, boolean z10) {
        k e10 = this.f3521i.e(i10);
        if (e10 != null) {
            return e10;
        }
        if (!z10 || l() == null) {
            return null;
        }
        return l().u(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String y() {
        if (this.f3523k == null) {
            this.f3523k = Integer.toString(this.f3522j);
        }
        return this.f3523k;
    }

    public final int z() {
        return this.f3522j;
    }
}
