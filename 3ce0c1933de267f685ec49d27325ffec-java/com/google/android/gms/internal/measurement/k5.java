package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k5 implements f1 {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f9462a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ j5 f9463b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k5(j5 j5Var, String str) {
        this.f9463b = j5Var;
        this.f9462a = str;
    }

    @Override // com.google.android.gms.internal.measurement.f1
    public final void a(String str, int i10, Throwable th2, byte[] bArr, Map<String, List<String>> map) {
        this.f9463b.h(i10, th2, bArr, this.f9462a);
    }
}
