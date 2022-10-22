package androidx.coordinatorlayout.widget;

import j0.e;
import j0.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* compiled from: DirectedAcyclicGraph.java */
/* loaded from: classes.dex */
public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final e<ArrayList<T>> f2216a = new f(10);

    /* renamed from: b  reason: collision with root package name */
    private final androidx.collection.f<T, ArrayList<T>> f2217b = new androidx.collection.f<>();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<T> f2218c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final HashSet<T> f2219d = new HashSet<>();

    private void e(T t10, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t10)) {
            if (!hashSet.contains(t10)) {
                hashSet.add(t10);
                ArrayList<T> arrayList2 = this.f2217b.get(t10);
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        e(arrayList2.get(i10), arrayList, hashSet);
                    }
                }
                hashSet.remove(t10);
                arrayList.add(t10);
                return;
            }
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
    }

    private ArrayList<T> f() {
        ArrayList<T> b10 = this.f2216a.b();
        return b10 == null ? new ArrayList<>() : b10;
    }

    private void k(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f2216a.a(arrayList);
    }

    public void a(T t10, T t11) {
        if (!this.f2217b.containsKey(t10) || !this.f2217b.containsKey(t11)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList<T> arrayList = this.f2217b.get(t10);
        if (arrayList == null) {
            arrayList = f();
            this.f2217b.put(t10, arrayList);
        }
        arrayList.add(t11);
    }

    public void b(T t10) {
        if (!this.f2217b.containsKey(t10)) {
            this.f2217b.put(t10, null);
        }
    }

    public void c() {
        int size = this.f2217b.size();
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList<T> n10 = this.f2217b.n(i10);
            if (n10 != null) {
                k(n10);
            }
        }
        this.f2217b.clear();
    }

    public boolean d(T t10) {
        return this.f2217b.containsKey(t10);
    }

    public List g(T t10) {
        return this.f2217b.get(t10);
    }

    public List<T> h(T t10) {
        int size = this.f2217b.size();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList<T> n10 = this.f2217b.n(i10);
            if (n10 != null && n10.contains(t10)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f2217b.j(i10));
            }
        }
        return arrayList;
    }

    public ArrayList<T> i() {
        this.f2218c.clear();
        this.f2219d.clear();
        int size = this.f2217b.size();
        for (int i10 = 0; i10 < size; i10++) {
            e(this.f2217b.j(i10), this.f2218c, this.f2219d);
        }
        return this.f2218c;
    }

    public boolean j(T t10) {
        int size = this.f2217b.size();
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList<T> n10 = this.f2217b.n(i10);
            if (n10 != null && n10.contains(t10)) {
                return true;
            }
        }
        return false;
    }
}
