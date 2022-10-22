package o8;

import java.util.List;
/* compiled from: DecoderResult.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f31458a;

    /* renamed from: b  reason: collision with root package name */
    private int f31459b;

    /* renamed from: c  reason: collision with root package name */
    private final String f31460c;

    /* renamed from: d  reason: collision with root package name */
    private final List<byte[]> f31461d;

    /* renamed from: e  reason: collision with root package name */
    private final String f31462e;

    /* renamed from: f  reason: collision with root package name */
    private Object f31463f;

    /* renamed from: g  reason: collision with root package name */
    private final int f31464g;

    /* renamed from: h  reason: collision with root package name */
    private final int f31465h;

    public b(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public List<byte[]> a() {
        return this.f31461d;
    }

    public String b() {
        return this.f31462e;
    }

    public int c() {
        return this.f31459b;
    }

    public Object d() {
        return this.f31463f;
    }

    public byte[] e() {
        return this.f31458a;
    }

    public int f() {
        return this.f31464g;
    }

    public int g() {
        return this.f31465h;
    }

    public String h() {
        return this.f31460c;
    }

    public boolean i() {
        return this.f31464g >= 0 && this.f31465h >= 0;
    }

    public void j(Integer num) {
    }

    public void k(Integer num) {
    }

    public void l(int i10) {
        this.f31459b = i10;
    }

    public void m(Object obj) {
        this.f31463f = obj;
    }

    public b(byte[] bArr, String str, List<byte[]> list, String str2, int i10, int i11) {
        this.f31458a = bArr;
        this.f31459b = bArr == null ? 0 : bArr.length * 8;
        this.f31460c = str;
        this.f31461d = list;
        this.f31462e = str2;
        this.f31464g = i11;
        this.f31465h = i10;
    }
}
