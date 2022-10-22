package com.google.protobuf;

import com.google.protobuf.a;
import com.google.protobuf.a.AbstractC0170a;
import com.google.protobuf.g0;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
/* compiled from: RepeatedFieldBuilderV3.java */
/* loaded from: classes.dex */
public class o0<MType extends com.google.protobuf.a, BType extends a.AbstractC0170a, IType extends g0> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    private a.b f13308a;

    /* renamed from: b  reason: collision with root package name */
    private List<MType> f13309b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13310c;

    /* renamed from: d  reason: collision with root package name */
    private List<q0<MType, BType, IType>> f13311d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f13312e;

    /* renamed from: f  reason: collision with root package name */
    private b<MType, BType, IType> f13313f;

    /* renamed from: g  reason: collision with root package name */
    private a<MType, BType, IType> f13314g;

    /* renamed from: h  reason: collision with root package name */
    private c<MType, BType, IType> f13315h;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RepeatedFieldBuilderV3.java */
    /* loaded from: classes.dex */
    public static class a<MType extends com.google.protobuf.a, BType extends a.AbstractC0170a, IType extends g0> extends AbstractList<BType> {

        /* renamed from: a  reason: collision with root package name */
        o0<MType, BType, IType> f13316a;

        a(o0<MType, BType, IType> o0Var) {
            this.f13316a = o0Var;
        }

        /* renamed from: a */
        public BType get(int i10) {
            return this.f13316a.l(i10);
        }

        void b() {
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f13316a.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RepeatedFieldBuilderV3.java */
    /* loaded from: classes.dex */
    public static class b<MType extends com.google.protobuf.a, BType extends a.AbstractC0170a, IType extends g0> extends AbstractList<MType> {

        /* renamed from: a  reason: collision with root package name */
        o0<MType, BType, IType> f13317a;

        b(o0<MType, BType, IType> o0Var) {
            this.f13317a = o0Var;
        }

        /* renamed from: a */
        public MType get(int i10) {
            return this.f13317a.o(i10);
        }

        void b() {
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f13317a.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RepeatedFieldBuilderV3.java */
    /* loaded from: classes.dex */
    public static class c<MType extends com.google.protobuf.a, BType extends a.AbstractC0170a, IType extends g0> extends AbstractList<IType> {

        /* renamed from: a  reason: collision with root package name */
        o0<MType, BType, IType> f13318a;

        c(o0<MType, BType, IType> o0Var) {
            this.f13318a = o0Var;
        }

        /* renamed from: a */
        public IType get(int i10) {
            return this.f13318a.r(i10);
        }

        void b() {
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f13318a.n();
        }
    }

    public o0(List<MType> list, boolean z10, a.b bVar, boolean z11) {
        this.f13309b = list;
        this.f13310c = z10;
        this.f13308a = bVar;
        this.f13312e = z11;
    }

    private void j() {
        if (this.f13311d == null) {
            this.f13311d = new ArrayList(this.f13309b.size());
            for (int i10 = 0; i10 < this.f13309b.size(); i10++) {
                this.f13311d.add(null);
            }
        }
    }

    private void k() {
        if (!this.f13310c) {
            this.f13309b = new ArrayList(this.f13309b);
            this.f13310c = true;
        }
    }

    private MType p(int i10, boolean z10) {
        List<q0<MType, BType, IType>> list = this.f13311d;
        if (list == null) {
            return this.f13309b.get(i10);
        }
        q0<MType, BType, IType> q0Var = list.get(i10);
        if (q0Var == null) {
            return this.f13309b.get(i10);
        }
        return z10 ? q0Var.b() : q0Var.f();
    }

    private void t() {
        b<MType, BType, IType> bVar = this.f13313f;
        if (bVar != null) {
            bVar.b();
        }
        a<MType, BType, IType> aVar = this.f13314g;
        if (aVar != null) {
            aVar.b();
        }
        c<MType, BType, IType> cVar = this.f13315h;
        if (cVar != null) {
            cVar.b();
        }
    }

    private void v() {
        a.b bVar;
        if (this.f13312e && (bVar = this.f13308a) != null) {
            bVar.a();
            this.f13312e = false;
        }
    }

    @Override // com.google.protobuf.a.b
    public void a() {
        v();
    }

    public o0<MType, BType, IType> b(Iterable<? extends MType> iterable) {
        for (MType mtype : iterable) {
            Objects.requireNonNull(mtype);
        }
        int i10 = -1;
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() == 0) {
                return this;
            }
            i10 = collection.size();
        }
        k();
        if (i10 >= 0) {
            List<MType> list = this.f13309b;
            if (list instanceof ArrayList) {
                ((ArrayList) list).ensureCapacity(list.size() + i10);
            }
        }
        for (MType mtype2 : iterable) {
            f(mtype2);
        }
        v();
        t();
        return this;
    }

    public BType c(int i10, MType mtype) {
        k();
        j();
        q0<MType, BType, IType> q0Var = new q0<>(mtype, this, this.f13312e);
        this.f13309b.add(i10, null);
        this.f13311d.add(i10, q0Var);
        v();
        t();
        return q0Var.e();
    }

    public BType d(MType mtype) {
        k();
        j();
        q0<MType, BType, IType> q0Var = new q0<>(mtype, this, this.f13312e);
        this.f13309b.add(null);
        this.f13311d.add(q0Var);
        v();
        t();
        return q0Var.e();
    }

    public o0<MType, BType, IType> e(int i10, MType mtype) {
        Objects.requireNonNull(mtype);
        k();
        this.f13309b.add(i10, mtype);
        List<q0<MType, BType, IType>> list = this.f13311d;
        if (list != null) {
            list.add(i10, null);
        }
        v();
        t();
        return this;
    }

    public o0<MType, BType, IType> f(MType mtype) {
        Objects.requireNonNull(mtype);
        k();
        this.f13309b.add(mtype);
        List<q0<MType, BType, IType>> list = this.f13311d;
        if (list != null) {
            list.add(null);
        }
        v();
        t();
        return this;
    }

    public List<MType> g() {
        boolean z10;
        this.f13312e = true;
        boolean z11 = this.f13310c;
        if (!z11 && this.f13311d == null) {
            return this.f13309b;
        }
        if (!z11) {
            int i10 = 0;
            while (true) {
                if (i10 >= this.f13309b.size()) {
                    z10 = true;
                    break;
                }
                MType mtype = this.f13309b.get(i10);
                q0<MType, BType, IType> q0Var = this.f13311d.get(i10);
                if (!(q0Var == null || q0Var.b() == mtype)) {
                    z10 = false;
                    break;
                }
                i10++;
            }
            if (z10) {
                return this.f13309b;
            }
        }
        k();
        for (int i11 = 0; i11 < this.f13309b.size(); i11++) {
            this.f13309b.set(i11, p(i11, true));
        }
        List<MType> unmodifiableList = Collections.unmodifiableList(this.f13309b);
        this.f13309b = unmodifiableList;
        this.f13310c = false;
        return unmodifiableList;
    }

    public void h() {
        this.f13309b = Collections.emptyList();
        this.f13310c = false;
        List<q0<MType, BType, IType>> list = this.f13311d;
        if (list != null) {
            for (q0<MType, BType, IType> q0Var : list) {
                if (q0Var != null) {
                    q0Var.d();
                }
            }
            this.f13311d = null;
        }
        v();
        t();
    }

    public void i() {
        this.f13308a = null;
    }

    public BType l(int i10) {
        j();
        q0<MType, BType, IType> q0Var = this.f13311d.get(i10);
        if (q0Var == null) {
            q0<MType, BType, IType> q0Var2 = new q0<>(this.f13309b.get(i10), this, this.f13312e);
            this.f13311d.set(i10, q0Var2);
            q0Var = q0Var2;
        }
        return q0Var.e();
    }

    public List<BType> m() {
        if (this.f13314g == null) {
            this.f13314g = new a<>(this);
        }
        return this.f13314g;
    }

    public int n() {
        return this.f13309b.size();
    }

    public MType o(int i10) {
        return p(i10, false);
    }

    public List<MType> q() {
        if (this.f13313f == null) {
            this.f13313f = new b<>(this);
        }
        return this.f13313f;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.google.protobuf.g0, IType extends com.google.protobuf.g0] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.google.protobuf.g0, IType extends com.google.protobuf.g0] */
    public IType r(int i10) {
        List<q0<MType, BType, IType>> list = this.f13311d;
        if (list == null) {
            return this.f13309b.get(i10);
        }
        q0<MType, BType, IType> q0Var = list.get(i10);
        if (q0Var == null) {
            return this.f13309b.get(i10);
        }
        return q0Var.g();
    }

    public List<IType> s() {
        if (this.f13315h == null) {
            this.f13315h = new c<>(this);
        }
        return this.f13315h;
    }

    public boolean u() {
        return this.f13309b.isEmpty();
    }

    public void w(int i10) {
        q0<MType, BType, IType> remove;
        k();
        this.f13309b.remove(i10);
        List<q0<MType, BType, IType>> list = this.f13311d;
        if (!(list == null || (remove = list.remove(i10)) == null)) {
            remove.d();
        }
        v();
        t();
    }

    public o0<MType, BType, IType> x(int i10, MType mtype) {
        q0<MType, BType, IType> q0Var;
        Objects.requireNonNull(mtype);
        k();
        this.f13309b.set(i10, mtype);
        List<q0<MType, BType, IType>> list = this.f13311d;
        if (!(list == null || (q0Var = list.set(i10, null)) == null)) {
            q0Var.d();
        }
        v();
        t();
        return this;
    }
}
