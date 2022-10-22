package b8;

import com.google.firebase.components.Component;
import com.google.firebase.components.DependencyCycleException;
import com.google.firebase.components.MissingDependencyException;
import e8.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class m implements c {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<?>> f5091a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, o<?>> f5092b = new HashMap();

    public m(Iterable<e> iterable, Component<?>... componentArr) {
        n nVar;
        ArrayList<a> arrayList = new ArrayList();
        for (e eVar : iterable) {
            arrayList.addAll(eVar.getComponents());
        }
        Collections.addAll(arrayList, componentArr);
        HashMap hashMap = new HashMap(arrayList.size());
        for (a aVar : arrayList) {
            n nVar2 = new n(aVar);
            for (Class cls : aVar.c()) {
                if (hashMap.put(cls, nVar2) != null) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", cls));
                }
            }
        }
        for (n nVar3 : hashMap.values()) {
            for (f fVar : nVar3.e().d()) {
                if (fVar.d() && (nVar = (n) hashMap.get(fVar.b())) != null) {
                    nVar3.a(nVar);
                    nVar.b(nVar3);
                }
            }
        }
        HashSet<n> hashSet = new HashSet(hashMap.values());
        HashSet hashSet2 = new HashSet();
        for (n nVar4 : hashSet) {
            if (nVar4.f()) {
                hashSet2.add(nVar4);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        while (!hashSet2.isEmpty()) {
            n nVar5 = (n) hashSet2.iterator().next();
            hashSet2.remove(nVar5);
            arrayList2.add(nVar5.e());
            for (n nVar6 : nVar5.d()) {
                nVar6.c(nVar5);
                if (nVar6.f()) {
                    hashSet2.add(nVar6);
                }
            }
        }
        if (arrayList2.size() == arrayList.size()) {
            Collections.reverse(arrayList2);
            List<a<?>> unmodifiableList = Collections.unmodifiableList(arrayList2);
            this.f5091a = unmodifiableList;
            for (a<?> aVar2 : unmodifiableList) {
                o<?> oVar = new o<>(aVar2.e(), new r(aVar2.d(), this));
                for (Class<? super Object> cls2 : aVar2.c()) {
                    this.f5092b.put(cls2, oVar);
                }
            }
            for (a<?> aVar3 : this.f5091a) {
                for (f fVar2 : aVar3.d()) {
                    if (fVar2.c() && !this.f5092b.containsKey(fVar2.b())) {
                        throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", aVar3, fVar2.b()));
                    }
                }
            }
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        for (n nVar7 : hashSet) {
            if (!nVar7.f() && !nVar7.g()) {
                arrayList3.add(nVar7.e());
            }
        }
        throw new DependencyCycleException(arrayList3);
    }

    @Override // b8.c
    public final Object a(Class cls) {
        return b.a(this, cls);
    }

    @Override // b8.c
    public final <T> a<T> b(Class<T> cls) {
        q.b(cls, "Null interface requested.");
        return this.f5092b.get(cls);
    }

    public final void c(boolean z10) {
        for (a<?> aVar : this.f5091a) {
            if (aVar.f() || (aVar.g() && z10)) {
                a(aVar.c().iterator().next());
            }
        }
    }
}
