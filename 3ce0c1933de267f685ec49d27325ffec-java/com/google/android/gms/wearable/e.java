package com.google.android.gms.wearable;

import c7.m;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.data.DataHolder;
/* loaded from: classes.dex */
public class e extends a6.e<Object> implements h {

    /* renamed from: d  reason: collision with root package name */
    private final Status f10214d;

    public e(DataHolder dataHolder) {
        super(dataHolder);
        this.f10214d = new Status(dataHolder.J0());
    }

    @Override // a6.e
    protected /* synthetic */ Object b(int i10, int i11) {
        return new m(this.f102a, i10, i11);
    }

    @Override // a6.e
    protected String c() {
        return "path";
    }

    @Override // com.google.android.gms.common.api.h
    public Status getStatus() {
        return this.f10214d;
    }
}
