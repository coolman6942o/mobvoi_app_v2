package t0;

import java.nio.ByteBuffer;
/* compiled from: Table.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    protected int f35036a;

    /* renamed from: b  reason: collision with root package name */
    protected ByteBuffer f35037b;

    /* renamed from: c  reason: collision with root package name */
    private int f35038c;

    /* renamed from: d  reason: collision with root package name */
    private int f35039d;

    public c() {
        d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(int i10) {
        return i10 + this.f35037b.getInt(i10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int b(int i10) {
        if (i10 < this.f35039d) {
            return this.f35037b.getShort(this.f35038c + i10);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i10, ByteBuffer byteBuffer) {
        this.f35037b = byteBuffer;
        if (byteBuffer != null) {
            this.f35036a = i10;
            int i11 = i10 - byteBuffer.getInt(i10);
            this.f35038c = i11;
            this.f35039d = this.f35037b.getShort(i11);
            return;
        }
        this.f35036a = 0;
        this.f35038c = 0;
        this.f35039d = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int d(int i10) {
        int i11 = i10 + this.f35036a;
        return i11 + this.f35037b.getInt(i11) + 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int e(int i10) {
        int i11 = i10 + this.f35036a;
        return this.f35037b.getInt(i11 + this.f35037b.getInt(i11));
    }
}
