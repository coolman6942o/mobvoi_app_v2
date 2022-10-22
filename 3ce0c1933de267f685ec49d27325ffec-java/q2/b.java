package q2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ byte f32911a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ byte f32912b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ List<byte[]> f32913c = new ArrayList();

    public void a(byte[] bArr) {
        this.f32913c.add(bArr);
    }

    public byte b() {
        return this.f32911a;
    }

    public byte[][] c() {
        return (byte[][]) this.f32913c.toArray((byte[][]) Array.newInstance(byte.class, 0, 0));
    }

    public byte d() {
        return this.f32912b;
    }

    public void e(byte b10) {
        this.f32911a = b10;
    }

    public void f(byte b10) {
        this.f32912b = b10;
    }
}
