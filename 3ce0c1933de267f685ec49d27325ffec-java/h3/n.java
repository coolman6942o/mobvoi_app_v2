package h3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import l3.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseAnimatableValue.java */
/* loaded from: classes.dex */
public abstract class n<V, O> implements m<V, O> {

    /* renamed from: a  reason: collision with root package name */
    final List<a<V>> f27728a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(V v10) {
        this(Collections.singletonList(new a(v10)));
    }

    @Override // h3.m
    public List<a<V>> b() {
        return this.f27728a;
    }

    @Override // h3.m
    public boolean c() {
        return this.f27728a.isEmpty() || (this.f27728a.size() == 1 && this.f27728a.get(0).h());
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (!this.f27728a.isEmpty()) {
            sb2.append("values=");
            sb2.append(Arrays.toString(this.f27728a.toArray()));
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(List<a<V>> list) {
        this.f27728a = list;
    }
}
