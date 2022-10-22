package ef;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
/* compiled from: SportPointCollection.java */
/* loaded from: classes2.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    private final SortedSet<p> f25974a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f25975b;

    /* renamed from: c  reason: collision with root package name */
    private final List<p> f25976c;

    /* renamed from: d  reason: collision with root package name */
    private final List<p> f25977d;

    /* compiled from: SportPointCollection.java */
    /* loaded from: classes2.dex */
    private class b implements Comparator<p> {
        private b(q qVar) {
        }

        /* renamed from: a */
        public int compare(p pVar, p pVar2) {
            long j10 = pVar.f25952b;
            if (j10 == 0 && pVar2.f25952b == 0) {
                return Long.compare(pVar.f25951a, pVar2.f25951a);
            }
            return Long.compare(j10, pVar2.f25952b);
        }
    }

    public q() {
        this.f25974a = new TreeSet(new b());
        this.f25975b = new Object();
        this.f25976c = new ArrayList();
        this.f25977d = new ArrayList();
    }

    public void a(List<p> list) {
        synchronized (this.f25975b) {
            this.f25974a.addAll(list);
            this.f25977d.addAll(list);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x009c, code lost:
        if ((r4 - r1.f25952b) < (r3.f25952b - r4)) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x009f, code lost:
        r1 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a1, code lost:
        if (r0 == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a4, code lost:
        r1.b(r14);
        r14 = r13.f25975b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a9, code lost:
        monitor-enter(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b0, code lost:
        if (r13.f25977d.contains(r1) != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b8, code lost:
        if (r13.f25976c.contains(r1) != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ba, code lost:
        r13.f25976c.add(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00bf, code lost:
        monitor-exit(r14);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(p pVar) {
        p pVar2 = new p();
        pVar2.f25952b = pVar.f25952b + 1;
        SortedSet<p> headSet = this.f25974a.headSet(pVar2);
        p pVar3 = null;
        p last = headSet.isEmpty() ? null : headSet.last();
        boolean z10 = false;
        boolean z11 = last == null || pVar.f25952b > last.f25952b + 1000;
        boolean z12 = !pVar.a();
        SortedSet<p> tailSet = this.f25974a.tailSet(pVar2);
        if (!tailSet.isEmpty()) {
            pVar3 = tailSet.first();
        }
        boolean z13 = pVar3 == null || pVar.f25952b < pVar3.f25952b - 1000;
        if ((z11 && z13) || pVar.f25967q > 0) {
            z10 = true;
        }
        if (z10) {
            p pVar4 = new p(pVar);
            boolean add = this.f25974a.add(pVar4);
            synchronized (this.f25975b) {
                if (add && z12) {
                    if (!this.f25977d.contains(pVar4)) {
                        this.f25977d.add(pVar4);
                    }
                }
            }
        } else if (z12) {
            if (!z11 && !z13) {
                long j10 = pVar.f25952b;
            }
        }
        return z10;
    }

    public Iterable<p> c() {
        return this.f25974a;
    }

    public List<p> d() {
        List<p> list;
        synchronized (this.f25975b) {
            if (this.f25977d.isEmpty()) {
                list = Collections.emptyList();
            } else {
                list = new ArrayList<>(this.f25977d);
                this.f25977d.clear();
            }
        }
        return list;
    }

    public List<p> e() {
        List<p> list;
        synchronized (this.f25975b) {
            if (this.f25976c.isEmpty()) {
                list = Collections.emptyList();
            } else {
                list = new ArrayList<>(this.f25976c);
                this.f25976c.clear();
            }
        }
        return list;
    }

    public int f() {
        return this.f25974a.size();
    }

    public q(List<p> list) {
        this(list, false);
    }

    public q(List<p> list, boolean z10) {
        TreeSet treeSet = new TreeSet(new b());
        this.f25974a = treeSet;
        this.f25975b = new Object();
        this.f25976c = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.f25977d = arrayList;
        treeSet.addAll(list);
        if (z10) {
            arrayList.addAll(list);
        }
    }
}
