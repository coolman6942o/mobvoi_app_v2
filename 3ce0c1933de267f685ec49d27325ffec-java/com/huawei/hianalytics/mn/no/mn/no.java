package com.huawei.hianalytics.mn.no.mn;

import java.nio.charset.Charset;
/* loaded from: classes.dex */
public final class no {

    /* renamed from: mn  reason: collision with root package name */
    public static final Charset f13538mn = Charset.forName("UTF-8");

    /* renamed from: no  reason: collision with root package name */
    private static no f13539no;

    /* renamed from: op  reason: collision with root package name */
    private rs f13540op;

    /* renamed from: com.huawei.hianalytics.mn.no.mn.no$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: mn  reason: collision with root package name */
        static final /* synthetic */ int[] f13541mn;

        static {
            int[] iArr = new int[mn.values().length];
            f13541mn = iArr;
            try {
                iArr[mn.AES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13541mn[mn.HMCSHA256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13541mn[mn.RSA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13541mn[mn.OTHER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum mn {
        AES(16),
        RSA(128),
        HMCSHA256(16),
        OTHER(0);
        
        private int qr;

        mn(int i10) {
            this.qr = i10;
        }

        public final int mn() {
            return this.qr;
        }
    }

    private no() {
    }

    public static no mn() {
        if (f13539no == null) {
            no();
        }
        return f13539no;
    }

    private static synchronized void no() {
        synchronized (no.class) {
            if (f13539no == null) {
                f13539no = new no();
            }
        }
    }

    public final rs mn(mn mnVar) {
        rs rsVar;
        int i10 = AnonymousClass1.f13541mn[mnVar.ordinal()];
        if (i10 == 1) {
            rsVar = new com.huawei.hianalytics.mn.no.mn.mn();
        } else if (i10 == 2) {
            rsVar = new qr();
        } else if (i10 != 3) {
            com.huawei.hianalytics.mn.no.qr.mn.no("CryptFactory", "crypt type is other");
            return this.f13540op;
        } else {
            rsVar = new st();
        }
        this.f13540op = rsVar;
        return this.f13540op;
    }

    public final String mn(String str) {
        return op.mn(str);
    }

    public final String mn(char[] cArr, byte[] bArr) {
        return op.mn(cArr, bArr);
    }

    public final String no(mn mnVar) {
        return pq.mn(mnVar.mn());
    }

    public final byte[] no(String str) {
        return pq.mn(str);
    }
}
