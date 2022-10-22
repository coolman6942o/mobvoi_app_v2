package d1;

import android.annotation.SuppressLint;
import java.util.HashSet;
import java.util.Set;
/* compiled from: AppBarConfiguration.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Integer> f24990a;

    /* renamed from: b  reason: collision with root package name */
    private final o0.c f24991b;

    /* renamed from: c  reason: collision with root package name */
    private final c f24992c;

    /* compiled from: AppBarConfiguration.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final Set<Integer> f24993a;

        /* renamed from: b  reason: collision with root package name */
        private o0.c f24994b;

        /* renamed from: c  reason: collision with root package name */
        private c f24995c;

        public b(Set<Integer> set) {
            HashSet hashSet = new HashSet();
            this.f24993a = hashSet;
            hashSet.addAll(set);
        }

        @SuppressLint({"SyntheticAccessor"})
        public d a() {
            return new d(this.f24993a, this.f24994b, this.f24995c);
        }

        public b b(c cVar) {
            this.f24995c = cVar;
            return this;
        }

        public b c(o0.c cVar) {
            this.f24994b = cVar;
            return this;
        }
    }

    /* compiled from: AppBarConfiguration.java */
    /* loaded from: classes.dex */
    public interface c {
        boolean a();
    }

    public c a() {
        return this.f24992c;
    }

    public o0.c b() {
        return this.f24991b;
    }

    public Set<Integer> c() {
        return this.f24990a;
    }

    private d(Set<Integer> set, o0.c cVar, c cVar2) {
        this.f24990a = set;
        this.f24991b = cVar;
        this.f24992c = cVar2;
    }
}
