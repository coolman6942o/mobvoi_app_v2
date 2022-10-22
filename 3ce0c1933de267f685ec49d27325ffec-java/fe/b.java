package fe;
/* compiled from: IntentResult.java */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f26416a;

    /* renamed from: b  reason: collision with root package name */
    private final String f26417b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f26418c;

    /* renamed from: d  reason: collision with root package name */
    private final Integer f26419d;

    /* renamed from: e  reason: collision with root package name */
    private final String f26420e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        this(null, null, null, null, null);
    }

    public String a() {
        return this.f26416a;
    }

    public String toString() {
        byte[] bArr = this.f26418c;
        int length = bArr == null ? 0 : bArr.length;
        return "Format: " + this.f26417b + "\nContents: " + this.f26416a + "\nRaw bytes: (" + length + " bytes)\nOrientation: " + this.f26419d + "\nEC level: " + this.f26420e + '\n';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, String str2, byte[] bArr, Integer num, String str3) {
        this.f26416a = str;
        this.f26417b = str2;
        this.f26418c = bArr;
        this.f26419d = num;
        this.f26420e = str3;
    }
}
