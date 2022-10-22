package com.bumptech.glide.load.engine;

import java.io.File;
import v4.a;
/* compiled from: DataCacheWriter.java */
/* loaded from: classes.dex */
class e<DataType> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    private final q4.a<DataType> f7888a;

    /* renamed from: b  reason: collision with root package name */
    private final DataType f7889b;

    /* renamed from: c  reason: collision with root package name */
    private final q4.e f7890c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(q4.a<DataType> aVar, DataType datatype, q4.e eVar) {
        this.f7888a = aVar;
        this.f7889b = datatype;
        this.f7890c = eVar;
    }

    @Override // v4.a.b
    public boolean a(File file) {
        return this.f7888a.b(this.f7889b, file, this.f7890c);
    }
}
