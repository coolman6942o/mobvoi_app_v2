package kotlin.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.c0;
import kotlin.collections.d0;
import kotlin.collections.m;
import kotlin.text.u;
import qo.b;
import qo.e;
import qo.f;
import qo.g;
import qo.h;
import qo.i;
import qo.j;
import qo.k;
import qo.l;
import qo.n;
import qo.o;
import qo.p;
import qo.q;
import qo.r;
import qo.s;
import qo.t;
import qo.v;
import qo.w;
import wo.c;
/* compiled from: ClassReference.kt */
/* loaded from: classes3.dex */
public final class d implements c<Object>, c {

    /* renamed from: b  reason: collision with root package name */
    private static final Map<Class<? extends io.c<?>>, Integer> f30075b;

    /* renamed from: c  reason: collision with root package name */
    private static final HashMap<String, String> f30076c;

    /* renamed from: d  reason: collision with root package name */
    private static final HashMap<String, String> f30077d;

    /* renamed from: e  reason: collision with root package name */
    private static final HashMap<String, String> f30078e;

    /* renamed from: f  reason: collision with root package name */
    private static final Map<String, String> f30079f;

    /* renamed from: g  reason: collision with root package name */
    public static final a f30080g = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f30081a;

    /* compiled from: ClassReference.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0040, code lost:
            if (r1 != null) goto L15;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String a(Class<?> jClass) {
            String str;
            Method enclosingMethod;
            String str2;
            String w02;
            Constructor<?> enclosingConstructor;
            i.f(jClass, "jClass");
            String str3 = null;
            if (!jClass.isAnonymousClass()) {
                if (jClass.isLocalClass()) {
                    String name = jClass.getSimpleName();
                    if (jClass.getEnclosingMethod() != null) {
                        i.e(name, "name");
                        str2 = u.x0(name, enclosingMethod.getName() + "$", null, 2, null);
                    }
                    if (jClass.getEnclosingConstructor() != null) {
                        i.e(name, "name");
                        str2 = u.x0(name, enclosingConstructor.getName() + "$", null, 2, null);
                    } else {
                        str2 = null;
                    }
                    if (str2 != null) {
                        return str2;
                    }
                    i.e(name, "name");
                    w02 = u.w0(name, '$', null, 2, null);
                    return w02;
                } else if (jClass.isArray()) {
                    Class<?> componentType = jClass.getComponentType();
                    i.e(componentType, "componentType");
                    if (componentType.isPrimitive() && (str = (String) d.f30079f.get(componentType.getName())) != null) {
                        str3 = str + "Array";
                    }
                    if (str3 == null) {
                        return "Array";
                    }
                } else {
                    String str4 = (String) d.f30079f.get(jClass.getName());
                    return str4 != null ? str4 : jClass.getSimpleName();
                }
            }
            return str3;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        List j10;
        int p10;
        Map<Class<? extends io.c<?>>, Integer> l10;
        int b10;
        String z02;
        String z03;
        int i10 = 0;
        j10 = m.j(qo.a.class, l.class, p.class, q.class, r.class, s.class, t.class, qo.u.class, v.class, w.class, b.class, qo.c.class, qo.d.class, e.class, f.class, g.class, h.class, i.class, j.class, k.class, qo.m.class, n.class, o.class);
        p10 = kotlin.collections.n.p(j10, 10);
        ArrayList arrayList = new ArrayList(p10);
        for (Object obj : j10) {
            i10++;
            if (i10 < 0) {
                m.o();
            }
            arrayList.add(io.j.a((Class) obj, Integer.valueOf(i10)));
        }
        l10 = d0.l(arrayList);
        f30075b = l10;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        f30076c = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f30077d = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        i.e(values, "primitiveFqNames.values");
        for (String kotlinName : values) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("kotlin.jvm.internal.");
            i.e(kotlinName, "kotlinName");
            z03 = u.z0(kotlinName, '.', null, 2, null);
            sb2.append(z03);
            sb2.append("CompanionObject");
            Pair a10 = io.j.a(sb2.toString(), kotlinName + ".Companion");
            hashMap3.put(a10.getFirst(), a10.getSecond());
        }
        for (Map.Entry<Class<? extends io.c<?>>, Integer> entry : f30075b.entrySet()) {
            int intValue = entry.getValue().intValue();
            hashMap3.put(entry.getKey().getName(), "kotlin.Function" + intValue);
        }
        f30078e = hashMap3;
        b10 = c0.b(hashMap3.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(b10);
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            Object key = entry2.getKey();
            z02 = u.z0((String) entry2.getValue(), '.', null, 2, null);
            linkedHashMap.put(key, z02);
        }
        f30079f = linkedHashMap;
    }

    public d(Class<?> jClass) {
        i.f(jClass, "jClass");
        this.f30081a = jClass;
    }

    @Override // wo.c
    public String a() {
        return f30080g.a(b());
    }

    @Override // kotlin.jvm.internal.c
    public Class<?> b() {
        return this.f30081a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && i.b(po.a.b(this), po.a.b((c) obj));
    }

    public int hashCode() {
        return po.a.b(this).hashCode();
    }

    public String toString() {
        return b().toString() + " (Kotlin reflection is not available)";
    }
}
