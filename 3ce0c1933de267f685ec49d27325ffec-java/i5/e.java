package i5;

import com.bumptech.glide.load.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: ResourceDecoderRegistry.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f28090a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, List<a<?, ?>>> f28091b = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ResourceDecoderRegistry.java */
    /* loaded from: classes.dex */
    public static class a<T, R> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f28092a;

        /* renamed from: b  reason: collision with root package name */
        final Class<R> f28093b;

        /* renamed from: c  reason: collision with root package name */
        final b<T, R> f28094c;

        public a(Class<T> cls, Class<R> cls2, b<T, R> bVar) {
            this.f28092a = cls;
            this.f28093b = cls2;
            this.f28094c = bVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.f28092a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f28093b);
        }
    }

    private synchronized List<a<?, ?>> c(String str) {
        List<a<?, ?>> list;
        if (!this.f28090a.contains(str)) {
            this.f28090a.add(str);
        }
        list = this.f28091b.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f28091b.put(str, list);
        }
        return list;
    }

    public synchronized <T, R> void a(String str, b<T, R> bVar, Class<T> cls, Class<R> cls2) {
        c(str).add(new a<>(cls, cls2, bVar));
    }

    public synchronized <T, R> List<b<T, R>> b(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f28090a) {
            List<a<?, ?>> list = this.f28091b.get(str);
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f28094c);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> List<Class<R>> d(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f28090a) {
            List<a<?, ?>> list = this.f28091b.get(str);
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f28093b)) {
                        arrayList.add(aVar.f28093b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized void e(List<String> list) {
        ArrayList<String> arrayList = new ArrayList(this.f28090a);
        this.f28090a.clear();
        this.f28090a.addAll(list);
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.f28090a.add(str);
            }
        }
    }
}
