package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.b;
import f5.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import n5.j;
import t4.c;
/* compiled from: DecodePath.java */
/* loaded from: classes.dex */
public class i<DataType, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<DataType> f7946a;

    /* renamed from: b  reason: collision with root package name */
    private final List<? extends b<DataType, ResourceType>> f7947b;

    /* renamed from: c  reason: collision with root package name */
    private final e<ResourceType, Transcode> f7948c;

    /* renamed from: d  reason: collision with root package name */
    private final j0.e<List<Throwable>> f7949d;

    /* renamed from: e  reason: collision with root package name */
    private final String f7950e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DecodePath.java */
    /* loaded from: classes.dex */
    public interface a<ResourceType> {
        c<ResourceType> a(c<ResourceType> cVar);
    }

    public i(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends b<DataType, ResourceType>> list, e<ResourceType, Transcode> eVar, j0.e<List<Throwable>> eVar2) {
        this.f7946a = cls;
        this.f7947b = list;
        this.f7948c = eVar;
        this.f7949d = eVar2;
        this.f7950e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private c<ResourceType> b(r4.e<DataType> eVar, int i10, int i11, q4.e eVar2) throws GlideException {
        List<Throwable> list = (List) j.d(this.f7949d.b());
        try {
            return c(eVar, i10, i11, eVar2, list);
        } finally {
            this.f7949d.a(list);
        }
    }

    private c<ResourceType> c(r4.e<DataType> eVar, int i10, int i11, q4.e eVar2, List<Throwable> list) throws GlideException {
        int size = this.f7947b.size();
        c<ResourceType> cVar = null;
        for (int i12 = 0; i12 < size; i12++) {
            b<DataType, ResourceType> bVar = this.f7947b.get(i12);
            try {
                if (bVar.b(eVar.a(), eVar2)) {
                    cVar = bVar.a(eVar.a(), i10, i11, eVar2);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e10) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + bVar, e10);
                }
                list.add(e10);
            }
            if (cVar != null) {
                break;
            }
        }
        if (cVar != null) {
            return cVar;
        }
        throw new GlideException(this.f7950e, new ArrayList(list));
    }

    public c<Transcode> a(r4.e<DataType> eVar, int i10, int i11, q4.e eVar2, a<ResourceType> aVar) throws GlideException {
        return this.f7948c.a(aVar.a(b(eVar, i10, i11, eVar2)), eVar2);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f7946a + ", decoders=" + this.f7947b + ", transcoder=" + this.f7948c + '}';
    }
}
