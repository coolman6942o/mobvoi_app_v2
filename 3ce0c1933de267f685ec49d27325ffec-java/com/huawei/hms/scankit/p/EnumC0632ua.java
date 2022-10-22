package com.huawei.hms.scankit.p;
/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* compiled from: DataMask.java */
/* renamed from: com.huawei.hms.scankit.p.ua  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class EnumC0632ua extends Enum<EnumC0632ua> {

    /* renamed from: a  reason: collision with root package name */
    public static final EnumC0632ua f14959a;

    /* renamed from: b  reason: collision with root package name */
    public static final EnumC0632ua f14960b;

    /* renamed from: c  reason: collision with root package name */
    public static final EnumC0632ua f14961c;

    /* renamed from: d  reason: collision with root package name */
    public static final EnumC0632ua f14962d;

    /* renamed from: e  reason: collision with root package name */
    public static final EnumC0632ua f14963e;

    /* renamed from: f  reason: collision with root package name */
    public static final EnumC0632ua f14964f;

    /* renamed from: g  reason: collision with root package name */
    public static final EnumC0632ua f14965g;

    /* renamed from: h  reason: collision with root package name */
    public static final EnumC0632ua f14966h;

    /* renamed from: i  reason: collision with root package name */
    private static final /* synthetic */ EnumC0632ua[] f14967i;

    static {
        C0609ma maVar = new C0609ma("DATA_MASK_000", 0);
        f14959a = maVar;
        EnumC0632ua naVar = new EnumC0632ua("DATA_MASK_001", 1) { // from class: com.huawei.hms.scankit.p.na
            @Override // com.huawei.hms.scankit.p.EnumC0632ua
            boolean a(int i10, int i11) {
                return (i10 & 1) == 0;
            }
        };
        f14960b = naVar;
        EnumC0632ua oaVar = new EnumC0632ua("DATA_MASK_010", 2) { // from class: com.huawei.hms.scankit.p.oa
            @Override // com.huawei.hms.scankit.p.EnumC0632ua
            boolean a(int i10, int i11) {
                return i11 % 3 == 0;
            }
        };
        f14961c = oaVar;
        EnumC0632ua paVar = new EnumC0632ua("DATA_MASK_011", 3) { // from class: com.huawei.hms.scankit.p.pa
            @Override // com.huawei.hms.scankit.p.EnumC0632ua
            boolean a(int i10, int i11) {
                return (i10 + i11) % 3 == 0;
            }
        };
        f14962d = paVar;
        EnumC0632ua qaVar = new EnumC0632ua("DATA_MASK_100", 4) { // from class: com.huawei.hms.scankit.p.qa
            @Override // com.huawei.hms.scankit.p.EnumC0632ua
            boolean a(int i10, int i11) {
                return (((i10 / 2) + (i11 / 3)) & 1) == 0;
            }
        };
        f14963e = qaVar;
        EnumC0632ua raVar = new EnumC0632ua("DATA_MASK_101", 5) { // from class: com.huawei.hms.scankit.p.ra
            @Override // com.huawei.hms.scankit.p.EnumC0632ua
            boolean a(int i10, int i11) {
                return (i10 * i11) % 6 == 0;
            }
        };
        f14964f = raVar;
        EnumC0632ua saVar = new EnumC0632ua("DATA_MASK_110", 6) { // from class: com.huawei.hms.scankit.p.sa
            @Override // com.huawei.hms.scankit.p.EnumC0632ua
            boolean a(int i10, int i11) {
                return (i10 * i11) % 6 < 3;
            }
        };
        f14965g = saVar;
        EnumC0632ua taVar = new EnumC0632ua("DATA_MASK_111", 7) { // from class: com.huawei.hms.scankit.p.ta
            @Override // com.huawei.hms.scankit.p.EnumC0632ua
            boolean a(int i10, int i11) {
                return (((i10 + i11) + ((i10 * i11) % 3)) & 1) == 0;
            }
        };
        f14966h = taVar;
        f14967i = new EnumC0632ua[]{maVar, naVar, oaVar, paVar, qaVar, raVar, saVar, taVar};
    }

    private EnumC0632ua(String str, int i10) {
    }

    public static EnumC0632ua valueOf(String str) {
        return (EnumC0632ua) Enum.valueOf(EnumC0632ua.class, str);
    }

    public static EnumC0632ua[] values() {
        return (EnumC0632ua[]) f14967i.clone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(C0595i iVar, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            for (int i12 = 0; i12 < i10; i12++) {
                if (a(i11, i12)) {
                    iVar.a(i12, i11);
                }
            }
        }
    }

    abstract boolean a(int i10, int i11);

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ EnumC0632ua(String str, int i10, C0609ma maVar) {
        this(str, i10);
    }
}
