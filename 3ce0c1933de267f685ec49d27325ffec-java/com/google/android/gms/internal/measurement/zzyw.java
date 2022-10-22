package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class zzyw implements Serializable, Iterable<Byte> {
    public static final zzyw zzbqx = new y7(d8.f9239b);
    private static final w7 zzbqy;
    private int zzboc = 0;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.gms.internal.measurement.u7] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.google.android.gms.internal.measurement.z7] */
    static {
        zzbqy = s7.b() ? new z7(null) : new u7(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i10, int i11, int i12) {
        int i13 = i11 - i10;
        if ((i10 | i11 | i13 | (i12 - i11)) >= 0) {
            return i13;
        }
        if (i10 < 0) {
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append("Beginning index: ");
            sb2.append(i10);
            sb2.append(" < 0");
            throw new IndexOutOfBoundsException(sb2.toString());
        } else if (i11 < i10) {
            StringBuilder sb3 = new StringBuilder(66);
            sb3.append("Beginning index larger than ending index: ");
            sb3.append(i10);
            sb3.append(", ");
            sb3.append(i11);
            throw new IndexOutOfBoundsException(sb3.toString());
        } else {
            StringBuilder sb4 = new StringBuilder(37);
            sb4.append("End index: ");
            sb4.append(i11);
            sb4.append(" >= ");
            sb4.append(i12);
            throw new IndexOutOfBoundsException(sb4.toString());
        }
    }

    public static zzyw zzfi(String str) {
        return new y7(str.getBytes(d8.f9238a));
    }

    protected abstract int a(int i10, int i11, int i12);

    /* JADX INFO: Access modifiers changed from: protected */
    public final int c() {
        return this.zzboc;
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i10 = this.zzboc;
        if (i10 == 0) {
            int size = size();
            i10 = a(size, 0, size);
            if (i10 == 0) {
                i10 = 1;
            }
            this.zzboc = i10;
        }
        return i10;
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new t7(this);
    }

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    public abstract byte zzae(int i10);

    public abstract zzyw zzb(int i10, int i11);
}
