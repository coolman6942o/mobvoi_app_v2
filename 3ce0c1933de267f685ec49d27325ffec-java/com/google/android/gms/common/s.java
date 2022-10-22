package com.google.android.gms.common;

import java.util.concurrent.Callable;
/* loaded from: classes.dex */
final class s extends q {

    /* renamed from: e  reason: collision with root package name */
    private final Callable<String> f8981e;

    private s(Callable<String> callable) {
        super(false, null, null);
        this.f8981e = callable;
    }

    @Override // com.google.android.gms.common.q
    final String a() {
        try {
            return this.f8981e.call();
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }
}
