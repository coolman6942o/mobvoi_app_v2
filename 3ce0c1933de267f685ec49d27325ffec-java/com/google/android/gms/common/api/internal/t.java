package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t implements e.a {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ BasePendingResult f8730a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ s f8731b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, BasePendingResult basePendingResult) {
        this.f8731b = sVar;
        this.f8730a = basePendingResult;
    }

    @Override // com.google.android.gms.common.api.e.a
    public final void a(Status status) {
        Map map;
        map = this.f8731b.f8721a;
        map.remove(this.f8730a);
    }
}
