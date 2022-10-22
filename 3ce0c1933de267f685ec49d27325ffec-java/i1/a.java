package i1;
/* compiled from: SimpleSQLiteQuery.java */
/* loaded from: classes.dex */
public final class a implements e {

    /* renamed from: a  reason: collision with root package name */
    private final String f28011a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f28012b;

    public a(String str, Object[] objArr) {
        this.f28011a = str;
        this.f28012b = objArr;
    }

    private static void a(d dVar, int i10, Object obj) {
        if (obj == null) {
            dVar.l0(i10);
        } else if (obj instanceof byte[]) {
            dVar.P(i10, (byte[]) obj);
        } else if (obj instanceof Float) {
            dVar.y(i10, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            dVar.y(i10, ((Double) obj).doubleValue());
        } else if (obj instanceof Long) {
            dVar.K(i10, ((Long) obj).longValue());
        } else if (obj instanceof Integer) {
            dVar.K(i10, ((Integer) obj).intValue());
        } else if (obj instanceof Short) {
            dVar.K(i10, ((Short) obj).shortValue());
        } else if (obj instanceof Byte) {
            dVar.K(i10, ((Byte) obj).byteValue());
        } else if (obj instanceof String) {
            dVar.m(i10, (String) obj);
        } else if (obj instanceof Boolean) {
            dVar.K(i10, ((Boolean) obj).booleanValue() ? 1L : 0L);
        } else {
            throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i10 + " Supported types: null, byte[], float, double, long, int, short, byte, string");
        }
    }

    public static void b(d dVar, Object[] objArr) {
        if (objArr != null) {
            int length = objArr.length;
            int i10 = 0;
            while (i10 < length) {
                Object obj = objArr[i10];
                i10++;
                a(dVar, i10, obj);
            }
        }
    }

    @Override // i1.e
    public void c(d dVar) {
        b(dVar, this.f28012b);
    }

    @Override // i1.e
    public String d() {
        return this.f28011a;
    }

    public a(String str) {
        this(str, null);
    }
}
