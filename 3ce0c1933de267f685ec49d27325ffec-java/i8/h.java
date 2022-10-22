package i8;

import com.google.gson.e;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
/* compiled from: ObjectTypeAdapter.java */
/* loaded from: classes.dex */
public final class h extends q<Object> {

    /* renamed from: b  reason: collision with root package name */
    public static final r f28131b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final e f28132a;

    /* compiled from: ObjectTypeAdapter.java */
    /* loaded from: classes.dex */
    static class a implements r {
        a() {
        }

        @Override // com.google.gson.r
        public <T> q<T> a(e eVar, com.google.gson.reflect.a<T> aVar) {
            if (aVar.getRawType() == Object.class) {
                return new h(eVar);
            }
            return null;
        }
    }

    /* compiled from: ObjectTypeAdapter.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f28133a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f28133a = iArr;
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28133a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f28133a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f28133a[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f28133a[JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f28133a[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    h(e eVar) {
        this.f28132a = eVar;
    }

    @Override // com.google.gson.q
    public Object b(com.google.gson.stream.a aVar) throws IOException {
        switch (b.f28133a[aVar.k0().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                aVar.c();
                while (aVar.v()) {
                    arrayList.add(b(aVar));
                }
                aVar.o();
                return arrayList;
            case 2:
                LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
                aVar.d();
                while (aVar.v()) {
                    linkedTreeMap.put(aVar.V(), b(aVar));
                }
                aVar.q();
                return linkedTreeMap;
            case 3:
                return aVar.i0();
            case 4:
                return Double.valueOf(aVar.O());
            case 5:
                return Boolean.valueOf(aVar.I());
            case 6:
                aVar.g0();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.q
    public void d(com.google.gson.stream.b bVar, Object obj) throws IOException {
        if (obj == null) {
            bVar.I();
            return;
        }
        q m10 = this.f28132a.m(obj.getClass());
        if (m10 instanceof h) {
            bVar.i();
            bVar.q();
            return;
        }
        m10.d(bVar, obj);
    }
}
