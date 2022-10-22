package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import b6.i;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.d;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class c<T extends IInterface> extends b<T> implements a.f, d.a {
    private final b6.c B;
    private final Set<Scope> C;
    private final Account D;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, Looper looper, int i10, b6.c cVar, d.b bVar, d.c cVar2) {
        this(context, looper, e.a(context), b.q(), i10, cVar, (d.b) i.k(bVar), (d.c) i.k(cVar2));
    }

    private static b.a n0(d.b bVar) {
        if (bVar == null) {
            return null;
        }
        return new m(bVar);
    }

    private static b.AbstractC0108b o0(d.c cVar) {
        if (cVar == null) {
            return null;
        }
        return new n(cVar);
    }

    private final Set<Scope> p0(Set<Scope> set) {
        Set<Scope> m02 = m0(set);
        for (Scope scope : m02) {
            if (!set.contains(scope)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return m02;
    }

    @Override // com.google.android.gms.common.internal.b
    public final Account A() {
        return this.D;
    }

    @Override // com.google.android.gms.common.internal.b
    protected final Set<Scope> F() {
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final b6.c l0() {
        return this.B;
    }

    protected Set<Scope> m0(Set<Scope> set) {
        return set;
    }

    @Override // com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public int p() {
        return super.p();
    }

    protected c(Context context, Looper looper, e eVar, com.google.android.gms.common.b bVar, int i10, b6.c cVar, d.b bVar2, d.c cVar2) {
        super(context, looper, eVar, bVar, i10, n0(bVar2), o0(cVar2), cVar.h());
        this.B = cVar;
        this.D = cVar.a();
        this.C = p0(cVar.d());
    }
}
