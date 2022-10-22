package com.google.android.gms.common.api;

import b6.i;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.n;
/* loaded from: classes.dex */
public final class f {

    /* loaded from: classes.dex */
    private static final class a<R extends h> extends BasePendingResult<R> {

        /* renamed from: q  reason: collision with root package name */
        private final R f8486q;

        public a(d dVar, R r10) {
            super(dVar);
            this.f8486q = r10;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public final R g(Status status) {
            return this.f8486q;
        }
    }

    public static <R extends h> e<R> a(R r10, d dVar) {
        i.l(r10, "Result must not be null");
        i.b(!r10.getStatus().K0(), "Status code must not be SUCCESS");
        a aVar = new a(dVar, r10);
        aVar.j(r10);
        return aVar;
    }

    public static e<Status> b(Status status, d dVar) {
        i.l(status, "Result must not be null");
        n nVar = new n(dVar);
        nVar.j(status);
        return nVar;
    }
}
