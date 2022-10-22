package com.google.protobuf;

import com.google.protobuf.a;
import com.google.protobuf.a.AbstractC0170a;
import com.google.protobuf.g0;
import java.util.Objects;
/* compiled from: SingleFieldBuilderV3.java */
/* loaded from: classes.dex */
public class q0<MType extends a, BType extends a.AbstractC0170a, IType extends g0> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    private a.b f13333a;

    /* renamed from: b  reason: collision with root package name */
    private BType f13334b;

    /* renamed from: c  reason: collision with root package name */
    private MType f13335c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f13336d;

    public q0(MType mtype, a.b bVar, boolean z10) {
        Objects.requireNonNull(mtype);
        this.f13335c = mtype;
        this.f13333a = bVar;
        this.f13336d = z10;
    }

    private void i() {
        a.b bVar;
        if (this.f13334b != null) {
            this.f13335c = null;
        }
        if (this.f13336d && (bVar = this.f13333a) != null) {
            bVar.a();
            this.f13336d = false;
        }
    }

    @Override // com.google.protobuf.a.b
    public void a() {
        i();
    }

    public MType b() {
        this.f13336d = true;
        return f();
    }

    public q0<MType, BType, IType> c() {
        d0 d0Var;
        MType mtype = this.f13335c;
        if (mtype != null) {
            d0Var = mtype.getDefaultInstanceForType();
        } else {
            d0Var = this.f13334b.getDefaultInstanceForType();
        }
        this.f13335c = (MType) d0Var;
        BType btype = this.f13334b;
        if (btype != null) {
            btype.dispose();
            this.f13334b = null;
        }
        i();
        return this;
    }

    public void d() {
        this.f13333a = null;
    }

    public BType e() {
        if (this.f13334b == null) {
            BType btype = (BType) this.f13335c.newBuilderForType(this);
            this.f13334b = btype;
            btype.mergeFrom(this.f13335c);
            this.f13334b.markClean();
        }
        return this.f13334b;
    }

    public MType f() {
        if (this.f13335c == null) {
            this.f13335c = (MType) this.f13334b.buildPartial();
        }
        return this.f13335c;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [BType extends com.google.protobuf.a$a, IType extends com.google.protobuf.g0] */
    /* JADX WARN: Type inference failed for: r0v1, types: [MType extends com.google.protobuf.a, IType extends com.google.protobuf.g0] */
    public IType g() {
        BType btype = this.f13334b;
        return btype != 0 ? btype : this.f13335c;
    }

    public q0<MType, BType, IType> h(MType mtype) {
        if (this.f13334b == null) {
            d0 d0Var = this.f13335c;
            if (d0Var == d0Var.getDefaultInstanceForType()) {
                this.f13335c = mtype;
                i();
                return this;
            }
        }
        e().mergeFrom(mtype);
        i();
        return this;
    }

    public q0<MType, BType, IType> j(MType mtype) {
        Objects.requireNonNull(mtype);
        this.f13335c = mtype;
        BType btype = this.f13334b;
        if (btype != null) {
            btype.dispose();
            this.f13334b = null;
        }
        i();
        return this;
    }
}
