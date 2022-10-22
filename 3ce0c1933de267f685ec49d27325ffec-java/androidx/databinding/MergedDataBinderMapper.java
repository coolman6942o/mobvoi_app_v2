package androidx.databinding;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public class MergedDataBinderMapper extends d {

    /* renamed from: a  reason: collision with root package name */
    private Set<Class<? extends d>> f2708a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private List<d> f2709b = new CopyOnWriteArrayList();

    public MergedDataBinderMapper() {
        new CopyOnWriteArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(d dVar) {
        if (this.f2708a.add(dVar.getClass())) {
            this.f2709b.add(dVar);
            for (d dVar2 : dVar.a()) {
                b(dVar2);
            }
        }
    }
}
