package i8;

import com.google.gson.e;
import com.google.gson.internal.c;
import com.google.gson.j;
import com.google.gson.p;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.reflect.a;
import h8.b;
/* compiled from: JsonAdapterAnnotationTypeAdapterFactory.java */
/* loaded from: classes.dex */
public final class d implements r {

    /* renamed from: a  reason: collision with root package name */
    private final c f28114a;

    public d(c cVar) {
        this.f28114a = cVar;
    }

    @Override // com.google.gson.r
    public <T> q<T> a(e eVar, a<T> aVar) {
        b bVar = (b) aVar.getRawType().getAnnotation(b.class);
        if (bVar == null) {
            return null;
        }
        return (q<T>) b(this.f28114a, eVar, aVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q<?> b(c cVar, e eVar, a<?> aVar, b bVar) {
        q<?> qVar;
        Object a10 = cVar.a(a.get((Class) bVar.value())).a();
        if (a10 instanceof q) {
            qVar = (q) a10;
        } else if (a10 instanceof r) {
            qVar = ((r) a10).a(eVar, aVar);
        } else {
            boolean z10 = a10 instanceof p;
            if (z10 || (a10 instanceof j)) {
                j jVar = null;
                p pVar = z10 ? (p) a10 : null;
                if (a10 instanceof j) {
                    jVar = (j) a10;
                }
                qVar = new l<>(pVar, jVar, eVar, aVar, null);
            } else {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + a10.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
        }
        return (qVar == null || !bVar.nullSafe()) ? qVar : qVar.a();
    }
}
