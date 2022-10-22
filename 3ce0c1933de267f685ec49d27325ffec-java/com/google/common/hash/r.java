package com.google.common.hash;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import sun.misc.Unsafe;
/* compiled from: Striped64.java */
/* loaded from: classes.dex */
abstract class r extends Number {
    private static final Unsafe UNSAFE;
    private static final long baseOffset;
    private static final long busyOffset;
    volatile transient long base;
    volatile transient int busy;
    volatile transient b[] cells;
    static final ThreadLocal<int[]> threadHashCode = new ThreadLocal<>();
    static final Random rng = new Random();
    static final int NCPU = Runtime.getRuntime().availableProcessors();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Striped64.java */
    /* loaded from: classes.dex */
    public class a implements PrivilegedExceptionAction<Unsafe> {
        a() {
        }

        /* renamed from: a */
        public Unsafe run() throws Exception {
            Field[] declaredFields;
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            throw new NoSuchFieldError("the Unsafe");
        }
    }

    /* compiled from: Striped64.java */
    /* loaded from: classes.dex */
    static final class b {

        /* renamed from: b  reason: collision with root package name */
        private static final Unsafe f12322b;

        /* renamed from: c  reason: collision with root package name */
        private static final long f12323c;

        /* renamed from: a  reason: collision with root package name */
        volatile long f12324a;

        static {
            try {
                Unsafe j10 = r.j();
                f12322b = j10;
                f12323c = j10.objectFieldOffset(b.class.getDeclaredField("a"));
            } catch (Exception e10) {
                throw new Error(e10);
            }
        }

        b(long j10) {
            this.f12324a = j10;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean a(long j10, long j11) {
            return f12322b.compareAndSwapLong(this, f12323c, j10, j11);
        }
    }

    static {
        try {
            Unsafe j10 = j();
            UNSAFE = j10;
            baseOffset = j10.objectFieldOffset(r.class.getDeclaredField("base"));
            busyOffset = j10.objectFieldOffset(r.class.getDeclaredField("busy"));
        } catch (Exception e10) {
            throw new Error(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Unsafe j() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (PrivilegedActionException e10) {
                throw new RuntimeException("Could not initialize intrinsics", e10.getCause());
            }
        } catch (SecurityException unused) {
            return (Unsafe) AccessController.doPrivileged(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean g(long j10, long j11) {
        return UNSAFE.compareAndSwapLong(this, baseOffset, j10, j11);
    }

    final boolean h() {
        return UNSAFE.compareAndSwapInt(this, busyOffset, 0, 1);
    }

    abstract long i(long j10, long j11);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0023 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00ee A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k(long j10, int[] iArr, boolean z10) {
        int[] iArr2;
        int i10;
        boolean z11;
        int length;
        boolean z12;
        int length2;
        if (iArr == null) {
            iArr2 = new int[1];
            threadHashCode.set(iArr2);
            i10 = rng.nextInt();
            if (i10 == 0) {
                i10 = 1;
            }
            iArr2[0] = i10;
        } else {
            i10 = iArr[0];
            iArr2 = iArr;
        }
        boolean z13 = false;
        int i11 = i10;
        boolean z14 = z10;
        while (true) {
            b[] bVarArr = this.cells;
            if (bVarArr != null && (length = bVarArr.length) > 0) {
                b bVar = bVarArr[(length - 1) & i11];
                if (bVar == null) {
                    if (this.busy == 0) {
                        b bVar2 = new b(j10);
                        if (this.busy == 0 && h()) {
                            try {
                                b[] bVarArr2 = this.cells;
                                if (bVarArr2 != null && (length2 = bVarArr2.length) > 0) {
                                    int i12 = (length2 - 1) & i11;
                                    if (bVarArr2[i12] == null) {
                                        bVarArr2[i12] = bVar2;
                                        z12 = true;
                                        if (!z12) {
                                            return;
                                        }
                                    }
                                }
                                z12 = false;
                                if (!z12) {
                                }
                            } finally {
                            }
                        }
                    }
                    z13 = false;
                } else if (!z14) {
                    z14 = true;
                } else {
                    long j11 = bVar.f12324a;
                    if (!bVar.a(j11, i(j11, j10))) {
                        if (length < NCPU && this.cells == bVarArr) {
                            if (!z13) {
                                z13 = true;
                            } else if (this.busy == 0 && h()) {
                                try {
                                    if (this.cells == bVarArr) {
                                        b[] bVarArr3 = new b[length << 1];
                                        for (int i13 = 0; i13 < length; i13++) {
                                            bVarArr3[i13] = bVarArr[i13];
                                        }
                                        this.cells = bVarArr3;
                                    }
                                    this.busy = 0;
                                    z13 = false;
                                } finally {
                                }
                            }
                        }
                        z13 = false;
                    } else {
                        return;
                    }
                }
                int i14 = i11 ^ (i11 << 13);
                int i15 = i14 ^ (i14 >>> 17);
                i11 = i15 ^ (i15 << 5);
                iArr2[0] = i11;
            } else if (this.busy == 0 && this.cells == bVarArr && h()) {
                try {
                    if (this.cells == bVarArr) {
                        b[] bVarArr4 = new b[2];
                        bVarArr4[i11 & 1] = new b(j10);
                        this.cells = bVarArr4;
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11) {
                        return;
                    }
                } finally {
                }
            } else {
                long j12 = this.base;
                if (g(j12, i(j12, j10))) {
                    return;
                }
            }
        }
    }
}
