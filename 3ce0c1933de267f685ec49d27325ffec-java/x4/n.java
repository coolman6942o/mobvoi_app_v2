package x4;

import java.util.Collections;
import java.util.List;
import n5.j;
import q4.b;
import q4.e;
import r4.d;
/* compiled from: ModelLoader.java */
/* loaded from: classes.dex */
public interface n<Model, Data> {

    /* compiled from: ModelLoader.java */
    /* loaded from: classes.dex */
    public static class a<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final b f36402a;

        /* renamed from: b  reason: collision with root package name */
        public final List<b> f36403b;

        /* renamed from: c  reason: collision with root package name */
        public final d<Data> f36404c;

        public a(b bVar, d<Data> dVar) {
            this(bVar, Collections.emptyList(), dVar);
        }

        public a(b bVar, List<b> list, d<Data> dVar) {
            this.f36402a = (b) j.d(bVar);
            this.f36403b = (List) j.d(list);
            this.f36404c = (d) j.d(dVar);
        }
    }

    boolean a(Model model);

    a<Data> b(Model model, int i10, int i11, e eVar);
}
