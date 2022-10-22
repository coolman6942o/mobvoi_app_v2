package pk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import xe.b;
/* compiled from: FitnessHandler.java */
/* loaded from: classes2.dex */
public final class o implements j, p {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, j> f32814a;

    public o(b bVar) {
        HashMap hashMap = new HashMap();
        this.f32814a = hashMap;
        hashMap.put(ArrayList.class, new u0(new y(), bVar));
    }

    @Override // pk.j
    public void a(Object obj) {
        j jVar = this.f32814a.get(obj.getClass());
        if (jVar != null) {
            jVar.a(obj);
        }
    }
}
