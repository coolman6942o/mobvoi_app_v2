package hh;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
/* compiled from: WearCapabilities.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final Set<String> f27855a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, Set<String>> f27856b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, Set<String>> f27857c;

    /* compiled from: WearCapabilities.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Set<String> f27858a = new TreeSet();

        /* renamed from: b  reason: collision with root package name */
        public final Set<String> f27859b = new TreeSet();

        /* renamed from: c  reason: collision with root package name */
        public final Map<String, Set<String>> f27860c = new TreeMap();

        /* renamed from: d  reason: collision with root package name */
        public final Map<String, Set<String>> f27861d = new TreeMap();

        private a c(Set<String> set, Map<String, Set<String>> map, String str, List<String> list) {
            set.add(str);
            if (list != null && !list.isEmpty()) {
                for (String str2 : list) {
                    Set<String> set2 = map.get(str2);
                    if (set2 == null) {
                        set2 = new TreeSet<>();
                        map.put(str2, set2);
                    }
                    set2.add(str);
                }
            }
            return this;
        }

        public a a(String str, List<String> list) {
            return c(this.f27859b, this.f27861d, str, list);
        }

        public a b(String str, List<String> list) {
            return c(this.f27858a, this.f27860c, str, list);
        }

        public b d() {
            return new b(this.f27858a, this.f27859b, this.f27860c, this.f27861d);
        }
    }

    public b(Set<String> set, Set<String> set2, Map<String, Set<String>> map, Map<String, Set<String>> map2) {
        this.f27855a = set;
        this.f27856b = map;
        this.f27857c = map2;
    }

    public boolean a(String str) {
        return this.f27856b.get(str) != null && this.f27856b.get(str).size() == this.f27855a.size();
    }
}
