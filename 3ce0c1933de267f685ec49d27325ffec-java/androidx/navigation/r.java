package androidx.navigation;

import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
/* compiled from: NavType.java */
/* loaded from: classes.dex */
public abstract class r<T> {

    /* renamed from: b  reason: collision with root package name */
    public static final r<Integer> f3545b = new c(false);

    /* renamed from: c  reason: collision with root package name */
    public static final r<Integer> f3546c = new d(false);

    /* renamed from: d  reason: collision with root package name */
    public static final r<int[]> f3547d = new e(true);

    /* renamed from: e  reason: collision with root package name */
    public static final r<Long> f3548e = new f(false);

    /* renamed from: f  reason: collision with root package name */
    public static final r<long[]> f3549f = new g(true);

    /* renamed from: g  reason: collision with root package name */
    public static final r<Float> f3550g = new h(false);

    /* renamed from: h  reason: collision with root package name */
    public static final r<float[]> f3551h = new i(true);

    /* renamed from: i  reason: collision with root package name */
    public static final r<Boolean> f3552i = new j(false);

    /* renamed from: j  reason: collision with root package name */
    public static final r<boolean[]> f3553j = new k(true);

    /* renamed from: k  reason: collision with root package name */
    public static final r<String> f3554k = new a(true);

    /* renamed from: l  reason: collision with root package name */
    public static final r<String[]> f3555l = new b(true);

    /* renamed from: a  reason: collision with root package name */
    private final boolean f3556a;

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    class a extends r<String> {
        a(boolean z10) {
            super(z10);
        }

        @Override // androidx.navigation.r
        public String c() {
            return "string";
        }

        /* renamed from: j */
        public String b(Bundle bundle, String str) {
            return (String) bundle.get(str);
        }

        /* renamed from: k */
        public String h(String str) {
            return str;
        }

        /* renamed from: l */
        public void i(Bundle bundle, String str, String str2) {
            bundle.putString(str, str2);
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    class b extends r<String[]> {
        b(boolean z10) {
            super(z10);
        }

        @Override // androidx.navigation.r
        public String c() {
            return "string[]";
        }

        /* renamed from: j */
        public String[] b(Bundle bundle, String str) {
            return (String[]) bundle.get(str);
        }

        /* renamed from: k */
        public String[] h(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* renamed from: l */
        public void i(Bundle bundle, String str, String[] strArr) {
            bundle.putStringArray(str, strArr);
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    class c extends r<Integer> {
        c(boolean z10) {
            super(z10);
        }

        @Override // androidx.navigation.r
        public String c() {
            return "integer";
        }

        /* renamed from: j */
        public Integer b(Bundle bundle, String str) {
            return (Integer) bundle.get(str);
        }

        /* renamed from: k */
        public Integer h(String str) {
            if (str.startsWith("0x")) {
                return Integer.valueOf(Integer.parseInt(str.substring(2), 16));
            }
            return Integer.valueOf(Integer.parseInt(str));
        }

        /* renamed from: l */
        public void i(Bundle bundle, String str, Integer num) {
            bundle.putInt(str, num.intValue());
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    class d extends r<Integer> {
        d(boolean z10) {
            super(z10);
        }

        @Override // androidx.navigation.r
        public String c() {
            return "reference";
        }

        /* renamed from: j */
        public Integer b(Bundle bundle, String str) {
            return (Integer) bundle.get(str);
        }

        /* renamed from: k */
        public Integer h(String str) {
            if (str.startsWith("0x")) {
                return Integer.valueOf(Integer.parseInt(str.substring(2), 16));
            }
            return Integer.valueOf(Integer.parseInt(str));
        }

        /* renamed from: l */
        public void i(Bundle bundle, String str, Integer num) {
            bundle.putInt(str, num.intValue());
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    class e extends r<int[]> {
        e(boolean z10) {
            super(z10);
        }

        @Override // androidx.navigation.r
        public String c() {
            return "integer[]";
        }

        /* renamed from: j */
        public int[] b(Bundle bundle, String str) {
            return (int[]) bundle.get(str);
        }

        /* renamed from: k */
        public int[] h(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* renamed from: l */
        public void i(Bundle bundle, String str, int[] iArr) {
            bundle.putIntArray(str, iArr);
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    class f extends r<Long> {
        f(boolean z10) {
            super(z10);
        }

        @Override // androidx.navigation.r
        public String c() {
            return "long";
        }

        /* renamed from: j */
        public Long b(Bundle bundle, String str) {
            return (Long) bundle.get(str);
        }

        /* renamed from: k */
        public Long h(String str) {
            if (str.endsWith("L")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.startsWith("0x")) {
                return Long.valueOf(Long.parseLong(str.substring(2), 16));
            }
            return Long.valueOf(Long.parseLong(str));
        }

        /* renamed from: l */
        public void i(Bundle bundle, String str, Long l10) {
            bundle.putLong(str, l10.longValue());
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    class g extends r<long[]> {
        g(boolean z10) {
            super(z10);
        }

        @Override // androidx.navigation.r
        public String c() {
            return "long[]";
        }

        /* renamed from: j */
        public long[] b(Bundle bundle, String str) {
            return (long[]) bundle.get(str);
        }

        /* renamed from: k */
        public long[] h(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* renamed from: l */
        public void i(Bundle bundle, String str, long[] jArr) {
            bundle.putLongArray(str, jArr);
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    class h extends r<Float> {
        h(boolean z10) {
            super(z10);
        }

        @Override // androidx.navigation.r
        public String c() {
            return "float";
        }

        /* renamed from: j */
        public Float b(Bundle bundle, String str) {
            return (Float) bundle.get(str);
        }

        /* renamed from: k */
        public Float h(String str) {
            return Float.valueOf(Float.parseFloat(str));
        }

        /* renamed from: l */
        public void i(Bundle bundle, String str, Float f10) {
            bundle.putFloat(str, f10.floatValue());
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    class i extends r<float[]> {
        i(boolean z10) {
            super(z10);
        }

        @Override // androidx.navigation.r
        public String c() {
            return "float[]";
        }

        /* renamed from: j */
        public float[] b(Bundle bundle, String str) {
            return (float[]) bundle.get(str);
        }

        /* renamed from: k */
        public float[] h(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* renamed from: l */
        public void i(Bundle bundle, String str, float[] fArr) {
            bundle.putFloatArray(str, fArr);
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    class j extends r<Boolean> {
        j(boolean z10) {
            super(z10);
        }

        @Override // androidx.navigation.r
        public String c() {
            return "boolean";
        }

        /* renamed from: j */
        public Boolean b(Bundle bundle, String str) {
            return (Boolean) bundle.get(str);
        }

        /* renamed from: k */
        public Boolean h(String str) {
            if ("true".equals(str)) {
                return Boolean.TRUE;
            }
            if ("false".equals(str)) {
                return Boolean.FALSE;
            }
            throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
        }

        /* renamed from: l */
        public void i(Bundle bundle, String str, Boolean bool) {
            bundle.putBoolean(str, bool.booleanValue());
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    class k extends r<boolean[]> {
        k(boolean z10) {
            super(z10);
        }

        @Override // androidx.navigation.r
        public String c() {
            return "boolean[]";
        }

        /* renamed from: j */
        public boolean[] b(Bundle bundle, String str) {
            return (boolean[]) bundle.get(str);
        }

        /* renamed from: k */
        public boolean[] h(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* renamed from: l */
        public void i(Bundle bundle, String str, boolean[] zArr) {
            bundle.putBooleanArray(str, zArr);
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    public static final class l<D extends Enum> extends p<D> {

        /* renamed from: n  reason: collision with root package name */
        private final Class<D> f3557n;

        public l(Class<D> cls) {
            super(false, cls);
            if (cls.isEnum()) {
                this.f3557n = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " is not an Enum type.");
        }

        @Override // androidx.navigation.r.p, androidx.navigation.r
        public String c() {
            return this.f3557n.getName();
        }

        /* renamed from: m */
        public D k(String str) {
            D[] enumConstants;
            for (D d10 : this.f3557n.getEnumConstants()) {
                if (d10.name().equals(str)) {
                    return d10;
                }
            }
            throw new IllegalArgumentException("Enum value " + str + " not found for type " + this.f3557n.getName() + ".");
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    public static final class m<D extends Parcelable> extends r<D[]> {

        /* renamed from: m  reason: collision with root package name */
        private final Class<D[]> f3558m;

        public m(Class<D> cls) {
            super(true);
            if (Parcelable.class.isAssignableFrom(cls)) {
                try {
                    this.f3558m = (Class<D[]>) Class.forName("[L" + cls.getName() + ";");
                } catch (ClassNotFoundException e10) {
                    throw new RuntimeException(e10);
                }
            } else {
                throw new IllegalArgumentException(cls + " does not implement Parcelable.");
            }
        }

        @Override // androidx.navigation.r
        public String c() {
            return this.f3558m.getName();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || m.class != obj.getClass()) {
                return false;
            }
            return this.f3558m.equals(((m) obj).f3558m);
        }

        public int hashCode() {
            return this.f3558m.hashCode();
        }

        /* renamed from: j */
        public D[] b(Bundle bundle, String str) {
            return (D[]) ((Parcelable[]) bundle.get(str));
        }

        /* renamed from: k */
        public D[] h(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* renamed from: l */
        public void i(Bundle bundle, String str, D[] dArr) {
            this.f3558m.cast(dArr);
            bundle.putParcelableArray(str, dArr);
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    public static final class n<D> extends r<D> {

        /* renamed from: m  reason: collision with root package name */
        private final Class<D> f3559m;

        public n(Class<D> cls) {
            super(true);
            if (Parcelable.class.isAssignableFrom(cls) || Serializable.class.isAssignableFrom(cls)) {
                this.f3559m = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " does not implement Parcelable or Serializable.");
        }

        @Override // androidx.navigation.r
        public D b(Bundle bundle, String str) {
            return (D) bundle.get(str);
        }

        @Override // androidx.navigation.r
        public String c() {
            return this.f3559m.getName();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || n.class != obj.getClass()) {
                return false;
            }
            return this.f3559m.equals(((n) obj).f3559m);
        }

        @Override // androidx.navigation.r
        public D h(String str) {
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        public int hashCode() {
            return this.f3559m.hashCode();
        }

        @Override // androidx.navigation.r
        public void i(Bundle bundle, String str, D d10) {
            this.f3559m.cast(d10);
            if (d10 == null || (d10 instanceof Parcelable)) {
                bundle.putParcelable(str, (Parcelable) d10);
            } else if (d10 instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) d10);
            }
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    public static final class o<D extends Serializable> extends r<D[]> {

        /* renamed from: m  reason: collision with root package name */
        private final Class<D[]> f3560m;

        public o(Class<D> cls) {
            super(true);
            if (Serializable.class.isAssignableFrom(cls)) {
                try {
                    this.f3560m = (Class<D[]>) Class.forName("[L" + cls.getName() + ";");
                } catch (ClassNotFoundException e10) {
                    throw new RuntimeException(e10);
                }
            } else {
                throw new IllegalArgumentException(cls + " does not implement Serializable.");
            }
        }

        @Override // androidx.navigation.r
        public String c() {
            return this.f3560m.getName();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || o.class != obj.getClass()) {
                return false;
            }
            return this.f3560m.equals(((o) obj).f3560m);
        }

        public int hashCode() {
            return this.f3560m.hashCode();
        }

        /* renamed from: j */
        public D[] b(Bundle bundle, String str) {
            return (D[]) ((Serializable[]) bundle.get(str));
        }

        /* renamed from: k */
        public D[] h(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: l */
        public void i(Bundle bundle, String str, D[] dArr) {
            this.f3560m.cast(dArr);
            bundle.putSerializable(str, dArr);
        }
    }

    r(boolean z10) {
        this.f3556a = z10;
    }

    public static r<?> a(String str, String str2) {
        String str3;
        r<Integer> rVar = f3545b;
        if (rVar.c().equals(str)) {
            return rVar;
        }
        r rVar2 = f3547d;
        if (rVar2.c().equals(str)) {
            return rVar2;
        }
        r<Long> rVar3 = f3548e;
        if (rVar3.c().equals(str)) {
            return rVar3;
        }
        r rVar4 = f3549f;
        if (rVar4.c().equals(str)) {
            return rVar4;
        }
        r<Boolean> rVar5 = f3552i;
        if (rVar5.c().equals(str)) {
            return rVar5;
        }
        r rVar6 = f3553j;
        if (rVar6.c().equals(str)) {
            return rVar6;
        }
        r<String> rVar7 = f3554k;
        if (rVar7.c().equals(str)) {
            return rVar7;
        }
        r rVar8 = f3555l;
        if (rVar8.c().equals(str)) {
            return rVar8;
        }
        r<Float> rVar9 = f3550g;
        if (rVar9.c().equals(str)) {
            return rVar9;
        }
        r rVar10 = f3551h;
        if (rVar10.c().equals(str)) {
            return rVar10;
        }
        r<Integer> rVar11 = f3546c;
        if (rVar11.c().equals(str)) {
            return rVar11;
        }
        if (str == null || str.isEmpty()) {
            return rVar7;
        }
        try {
            if (!str.startsWith(".") || str2 == null) {
                str3 = str;
            } else {
                str3 = str2 + str;
            }
            if (str.endsWith("[]")) {
                str3 = str3.substring(0, str3.length() - 2);
                Class<?> cls = Class.forName(str3);
                if (Parcelable.class.isAssignableFrom(cls)) {
                    return new m(cls);
                }
                if (Serializable.class.isAssignableFrom(cls)) {
                    return new o(cls);
                }
            } else {
                Class<?> cls2 = Class.forName(str3);
                if (Parcelable.class.isAssignableFrom(cls2)) {
                    return new n(cls2);
                }
                if (Enum.class.isAssignableFrom(cls2)) {
                    return new l(cls2);
                }
                if (Serializable.class.isAssignableFrom(cls2)) {
                    return new p(cls2);
                }
            }
            throw new IllegalArgumentException(str3 + " is not Serializable or Parcelable.");
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r d(String str) {
        try {
            try {
                try {
                    try {
                        r<Integer> rVar = f3545b;
                        rVar.h(str);
                        return rVar;
                    } catch (IllegalArgumentException unused) {
                        r<Boolean> rVar2 = f3552i;
                        rVar2.h(str);
                        return rVar2;
                    }
                } catch (IllegalArgumentException unused2) {
                    r<Float> rVar3 = f3550g;
                    rVar3.h(str);
                    return rVar3;
                }
            } catch (IllegalArgumentException unused3) {
                r<Long> rVar4 = f3548e;
                rVar4.h(str);
                return rVar4;
            }
        } catch (IllegalArgumentException unused4) {
            return f3554k;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r e(Object obj) {
        if (obj instanceof Integer) {
            return f3545b;
        }
        if (obj instanceof int[]) {
            return f3547d;
        }
        if (obj instanceof Long) {
            return f3548e;
        }
        if (obj instanceof long[]) {
            return f3549f;
        }
        if (obj instanceof Float) {
            return f3550g;
        }
        if (obj instanceof float[]) {
            return f3551h;
        }
        if (obj instanceof Boolean) {
            return f3552i;
        }
        if (obj instanceof boolean[]) {
            return f3553j;
        }
        if ((obj instanceof String) || obj == null) {
            return f3554k;
        }
        if (obj instanceof String[]) {
            return f3555l;
        }
        if (obj.getClass().isArray() && Parcelable.class.isAssignableFrom(obj.getClass().getComponentType())) {
            return new m(obj.getClass().getComponentType());
        }
        if (obj.getClass().isArray() && Serializable.class.isAssignableFrom(obj.getClass().getComponentType())) {
            return new o(obj.getClass().getComponentType());
        }
        if (obj instanceof Parcelable) {
            return new n(obj.getClass());
        }
        if (obj instanceof Enum) {
            return new l(obj.getClass());
        }
        if (obj instanceof Serializable) {
            return new p(obj.getClass());
        }
        throw new IllegalArgumentException("Object of type " + obj.getClass().getName() + " is not supported for navigation arguments.");
    }

    public abstract T b(Bundle bundle, String str);

    public abstract String c();

    public boolean f() {
        return this.f3556a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public T g(Bundle bundle, String str, String str2) {
        T h10 = h(str2);
        i(bundle, str, h10);
        return h10;
    }

    public abstract T h(String str);

    public abstract void i(Bundle bundle, String str, T t10);

    public String toString() {
        return c();
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    public static class p<D extends Serializable> extends r<D> {

        /* renamed from: m  reason: collision with root package name */
        private final Class<D> f3561m;

        public p(Class<D> cls) {
            super(true);
            if (!Serializable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException(cls + " does not implement Serializable.");
            } else if (!cls.isEnum()) {
                this.f3561m = cls;
            } else {
                throw new IllegalArgumentException(cls + " is an Enum. You should use EnumType instead.");
            }
        }

        @Override // androidx.navigation.r
        public String c() {
            return this.f3561m.getName();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof p)) {
                return false;
            }
            return this.f3561m.equals(((p) obj).f3561m);
        }

        public int hashCode() {
            return this.f3561m.hashCode();
        }

        /* renamed from: j */
        public D b(Bundle bundle, String str) {
            return (D) bundle.get(str);
        }

        /* renamed from: k */
        public D h(String str) {
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        /* renamed from: l */
        public void i(Bundle bundle, String str, D d10) {
            this.f3561m.cast(d10);
            bundle.putSerializable(str, d10);
        }

        p(boolean z10, Class<D> cls) {
            super(z10);
            if (Serializable.class.isAssignableFrom(cls)) {
                this.f3561m = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " does not implement Serializable.");
        }
    }
}
