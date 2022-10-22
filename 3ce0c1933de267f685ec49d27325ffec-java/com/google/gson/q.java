package com.google.gson;

import com.google.gson.stream.JsonToken;
import com.google.gson.stream.b;
import i8.f;
import java.io.IOException;
/* compiled from: TypeAdapter.java */
/* loaded from: classes.dex */
public abstract class q<T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapter.java */
    /* loaded from: classes.dex */
    public class a extends q<T> {
        a() {
        }

        @Override // com.google.gson.q
        public T b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() != JsonToken.NULL) {
                return (T) q.this.b(aVar);
            }
            aVar.g0();
            return null;
        }

        @Override // com.google.gson.q
        public void d(b bVar, T t10) throws IOException {
            if (t10 == null) {
                bVar.I();
            } else {
                q.this.d(bVar, t10);
            }
        }
    }

    public final q<T> a() {
        return new a();
    }

    public abstract T b(com.google.gson.stream.a aVar) throws IOException;

    public final k c(T t10) {
        try {
            f fVar = new f();
            d(fVar, t10);
            return fVar.w0();
        } catch (IOException e10) {
            throw new JsonIOException(e10);
        }
    }

    public abstract void d(b bVar, T t10) throws IOException;
}
