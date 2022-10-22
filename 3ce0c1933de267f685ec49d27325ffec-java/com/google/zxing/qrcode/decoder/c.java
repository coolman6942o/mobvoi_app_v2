package com.google.zxing.qrcode.decoder;
/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* compiled from: DataMask.java */
/* loaded from: classes.dex */
abstract class c extends Enum<c> {
    private static final /* synthetic */ c[] $VALUES;
    public static final c DATA_MASK_000;
    public static final c DATA_MASK_001;
    public static final c DATA_MASK_010;
    public static final c DATA_MASK_011;
    public static final c DATA_MASK_100;
    public static final c DATA_MASK_101;
    public static final c DATA_MASK_110;
    public static final c DATA_MASK_111;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: DataMask.java */
    /* loaded from: classes.dex */
    static class a extends c {
        a(String str, int i10) {
            super(str, i10, null);
        }

        @Override // com.google.zxing.qrcode.decoder.c
        boolean a(int i10, int i11) {
            return ((i10 + i11) & 1) == 0;
        }
    }

    static {
        a aVar = new a("DATA_MASK_000", 0);
        DATA_MASK_000 = aVar;
        c bVar = new c("DATA_MASK_001", 1) { // from class: com.google.zxing.qrcode.decoder.c.b
            @Override // com.google.zxing.qrcode.decoder.c
            boolean a(int i10, int i11) {
                return (i10 & 1) == 0;
            }
        };
        DATA_MASK_001 = bVar;
        c cVar = new c("DATA_MASK_010", 2) { // from class: com.google.zxing.qrcode.decoder.c.c
            @Override // com.google.zxing.qrcode.decoder.c
            boolean a(int i10, int i11) {
                return i11 % 3 == 0;
            }
        };
        DATA_MASK_010 = cVar;
        c dVar = new c("DATA_MASK_011", 3) { // from class: com.google.zxing.qrcode.decoder.c.d
            @Override // com.google.zxing.qrcode.decoder.c
            boolean a(int i10, int i11) {
                return (i10 + i11) % 3 == 0;
            }
        };
        DATA_MASK_011 = dVar;
        c eVar = new c("DATA_MASK_100", 4) { // from class: com.google.zxing.qrcode.decoder.c.e
            @Override // com.google.zxing.qrcode.decoder.c
            boolean a(int i10, int i11) {
                return (((i10 / 2) + (i11 / 3)) & 1) == 0;
            }
        };
        DATA_MASK_100 = eVar;
        c fVar = new c("DATA_MASK_101", 5) { // from class: com.google.zxing.qrcode.decoder.c.f
            @Override // com.google.zxing.qrcode.decoder.c
            boolean a(int i10, int i11) {
                return (i10 * i11) % 6 == 0;
            }
        };
        DATA_MASK_101 = fVar;
        c gVar = new c("DATA_MASK_110", 6) { // from class: com.google.zxing.qrcode.decoder.c.g
            @Override // com.google.zxing.qrcode.decoder.c
            boolean a(int i10, int i11) {
                return (i10 * i11) % 6 < 3;
            }
        };
        DATA_MASK_110 = gVar;
        c hVar = new c("DATA_MASK_111", 7) { // from class: com.google.zxing.qrcode.decoder.c.h
            @Override // com.google.zxing.qrcode.decoder.c
            boolean a(int i10, int i11) {
                return (((i10 + i11) + ((i10 * i11) % 3)) & 1) == 0;
            }
        };
        DATA_MASK_111 = hVar;
        $VALUES = new c[]{aVar, bVar, cVar, dVar, eVar, fVar, gVar, hVar};
    }

    private c(String str, int i10) {
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) $VALUES.clone();
    }

    abstract boolean a(int i10, int i11);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(com.google.zxing.common.b bVar, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            for (int i12 = 0; i12 < i10; i12++) {
                if (a(i11, i12)) {
                    bVar.c(i12, i11);
                }
            }
        }
    }

    /* synthetic */ c(String str, int i10, a aVar) {
        this(str, i10);
    }
}
