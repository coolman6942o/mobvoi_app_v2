package com.google.common.collect;

import com.google.common.base.p;
import com.google.common.collect.j6;
import com.google.common.collect.m6;
import com.google.common.primitives.d;
import com.mobvoi.wear.contacts.ContactConstant;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.ObjIntConsumer;
/* compiled from: AbstractMapBasedMultiset.java */
/* loaded from: classes.dex */
abstract class m<E> extends p<E> implements Serializable {
    private static final long serialVersionUID = -2250766705698539974L;
    private transient Map<E, b3> backingMap;
    private transient long size;

    /* compiled from: AbstractMapBasedMultiset.java */
    /* loaded from: classes.dex */
    class a implements Iterator<E> {

        /* renamed from: a  reason: collision with root package name */
        Map.Entry<E, b3> f12103a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Iterator f12104b;

        a(Iterator it) {
            this.f12104b = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12104b.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            Map.Entry<E, b3> entry = (Map.Entry) this.f12104b.next();
            this.f12103a = entry;
            return entry.getKey();
        }

        @Override // java.util.Iterator
        public void remove() {
            p2.e(this.f12103a != null);
            m.i(m.this, this.f12103a.getValue().d(0));
            this.f12104b.remove();
            this.f12103a = null;
        }
    }

    /* compiled from: AbstractMapBasedMultiset.java */
    /* loaded from: classes.dex */
    class b implements Iterator<j6.a<E>> {

        /* renamed from: a  reason: collision with root package name */
        Map.Entry<E, b3> f12106a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Iterator f12107b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AbstractMapBasedMultiset.java */
        /* loaded from: classes.dex */
        public class a extends m6.b<E> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map.Entry f12109a;

            a(Map.Entry entry) {
                this.f12109a = entry;
            }

            @Override // com.google.common.collect.j6.a
            public E a() {
                return (E) this.f12109a.getKey();
            }

            @Override // com.google.common.collect.j6.a
            public int getCount() {
                b3 b3Var;
                b3 b3Var2 = (b3) this.f12109a.getValue();
                if ((b3Var2 == null || b3Var2.c() == 0) && (b3Var = (b3) m.this.backingMap.get(a())) != null) {
                    return b3Var.c();
                }
                if (b3Var2 == null) {
                    return 0;
                }
                return b3Var2.c();
            }
        }

        b(Iterator it) {
            this.f12107b = it;
        }

        /* renamed from: a */
        public j6.a<E> next() {
            Map.Entry<E, b3> entry = (Map.Entry) this.f12107b.next();
            this.f12106a = entry;
            return new a(entry);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12107b.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            p2.e(this.f12106a != null);
            m.i(m.this, this.f12106a.getValue().d(0));
            this.f12107b.remove();
            this.f12106a = null;
        }
    }

    /* compiled from: AbstractMapBasedMultiset.java */
    /* loaded from: classes.dex */
    private class c implements Iterator<E> {

        /* renamed from: a  reason: collision with root package name */
        final Iterator<Map.Entry<E, b3>> f12111a;

        /* renamed from: b  reason: collision with root package name */
        Map.Entry<E, b3> f12112b;

        /* renamed from: c  reason: collision with root package name */
        int f12113c;

        /* renamed from: d  reason: collision with root package name */
        boolean f12114d;

        c() {
            this.f12111a = m.this.backingMap.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12113c > 0 || this.f12111a.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.f12113c == 0) {
                Map.Entry<E, b3> next = this.f12111a.next();
                this.f12112b = next;
                this.f12113c = next.getValue().c();
            }
            this.f12113c--;
            this.f12114d = true;
            return this.f12112b.getKey();
        }

        @Override // java.util.Iterator
        public void remove() {
            p2.e(this.f12114d);
            if (this.f12112b.getValue().c() > 0) {
                if (this.f12112b.getValue().b(-1) == 0) {
                    this.f12111a.remove();
                }
                m.h(m.this);
                this.f12114d = false;
                return;
            }
            throw new ConcurrentModificationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public m(Map<E, b3> map) {
        p.d(map.isEmpty());
        this.backingMap = map;
    }

    static /* synthetic */ long h(m mVar) {
        long j10 = mVar.size;
        mVar.size = j10 - 1;
        return j10;
    }

    static /* synthetic */ long i(m mVar, long j10) {
        long j11 = mVar.size - j10;
        mVar.size = j11;
        return j11;
    }

    private static int k(b3 b3Var, int i10) {
        if (b3Var == null) {
            return 0;
        }
        return b3Var.d(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l(ObjIntConsumer objIntConsumer, Object obj, b3 b3Var) {
        objIntConsumer.accept(obj, b3Var.c());
    }

    @Override // com.google.common.collect.p, com.google.common.collect.j6
    public int add(E e10, int i10) {
        if (i10 == 0) {
            return count(e10);
        }
        boolean z10 = true;
        int i11 = 0;
        p.f(i10 > 0, "occurrences cannot be negative: %s", i10);
        b3 b3Var = this.backingMap.get(e10);
        if (b3Var == null) {
            this.backingMap.put(e10, new b3(i10));
        } else {
            int c10 = b3Var.c();
            long j10 = c10 + i10;
            if (j10 > 2147483647L) {
                z10 = false;
            }
            p.h(z10, "too many occurrences: %s", j10);
            b3Var.a(i10);
            i11 = c10;
        }
        this.size += i10;
        return i11;
    }

    @Override // com.google.common.collect.p
    int b() {
        return this.backingMap.size();
    }

    @Override // com.google.common.collect.p
    Iterator<E> c() {
        return new a(this.backingMap.entrySet().iterator());
    }

    @Override // com.google.common.collect.p, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        for (b3 b3Var : this.backingMap.values()) {
            b3Var.g(0);
        }
        this.backingMap.clear();
        this.size = 0L;
    }

    public int count(Object obj) {
        b3 b3Var = (b3) w5.p(this.backingMap, obj);
        if (b3Var == null) {
            return 0;
        }
        return b3Var.c();
    }

    @Override // com.google.common.collect.p
    Iterator<j6.a<E>> d() {
        return new b(this.backingMap.entrySet().iterator());
    }

    @Override // com.google.common.collect.p, com.google.common.collect.j6
    public Set<j6.a<E>> entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.p, com.google.common.collect.j6
    public void forEachEntry(final ObjIntConsumer<? super E> objIntConsumer) {
        p.o(objIntConsumer);
        this.backingMap.forEach(new BiConsumer() { // from class: com.google.common.collect.l
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                m.l(objIntConsumer, obj, (b3) obj2);
            }
        });
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new c();
    }

    @Override // com.google.common.collect.p, com.google.common.collect.j6
    public int remove(Object obj, int i10) {
        if (i10 == 0) {
            return count(obj);
        }
        p.f(i10 > 0, "occurrences cannot be negative: %s", i10);
        b3 b3Var = this.backingMap.get(obj);
        if (b3Var == null) {
            return 0;
        }
        int c10 = b3Var.c();
        if (c10 <= i10) {
            this.backingMap.remove(obj);
            i10 = c10;
        }
        b3Var.a(-i10);
        this.size -= i10;
        return c10;
    }

    @Override // com.google.common.collect.p, com.google.common.collect.j6
    public int setCount(E e10, int i10) {
        int i11;
        p2.b(i10, ContactConstant.CallsRecordKeys.COUNT);
        if (i10 == 0) {
            i11 = k(this.backingMap.remove(e10), i10);
        } else {
            b3 b3Var = this.backingMap.get(e10);
            int k10 = k(b3Var, i10);
            if (b3Var == null) {
                this.backingMap.put(e10, new b3(i10));
            }
            i11 = k10;
        }
        this.size += i10 - i11;
        return i11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.j6
    public int size() {
        return d.h(this.size);
    }
}
