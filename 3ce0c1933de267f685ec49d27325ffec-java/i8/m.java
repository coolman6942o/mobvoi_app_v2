package i8;

import com.google.gson.e;
import com.google.gson.q;
import com.google.gson.stream.a;
import com.google.gson.stream.b;
import i8.i;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypeAdapterRuntimeTypeWrapper.java */
/* loaded from: classes.dex */
public final class m<T> extends q<T> {

    /* renamed from: a  reason: collision with root package name */
    private final e f28161a;

    /* renamed from: b  reason: collision with root package name */
    private final q<T> f28162b;

    /* renamed from: c  reason: collision with root package name */
    private final Type f28163c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(e eVar, q<T> qVar, Type type) {
        this.f28161a = eVar;
        this.f28162b = qVar;
        this.f28163c = type;
    }

    private Type e(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }

    @Override // com.google.gson.q
    public T b(a aVar) throws IOException {
        return this.f28162b.b(aVar);
    }

    @Override // com.google.gson.q
    public void d(b bVar, T t10) throws IOException {
        q<T> qVar = this.f28162b;
        Type e10 = e(this.f28163c, t10);
        if (e10 != this.f28163c) {
            qVar = this.f28161a.l(com.google.gson.reflect.a.get(e10));
            if (qVar instanceof i.b) {
                q<T> qVar2 = this.f28162b;
                if (!(qVar2 instanceof i.b)) {
                    qVar = qVar2;
                }
            }
        }
        qVar.d(bVar, t10);
    }
}
