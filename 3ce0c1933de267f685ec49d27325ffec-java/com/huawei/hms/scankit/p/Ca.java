package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.A;
import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.z;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* compiled from: FinderPatternFinder.java */
/* loaded from: classes2.dex */
public class Ca {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f14474a = {1, 3, 1, 1};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f14475b = {1, 1, 3, 1};

    /* renamed from: c  reason: collision with root package name */
    private static boolean f14476c = false;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f14477d = false;

    /* renamed from: e  reason: collision with root package name */
    private static final b f14478e = new b();

    /* renamed from: f  reason: collision with root package name */
    private final C0595i f14479f;

    /* renamed from: j  reason: collision with root package name */
    private final A f14483j;

    /* renamed from: g  reason: collision with root package name */
    private final List<Aa> f14480g = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private final int[] f14482i = new int[5];

    /* renamed from: h  reason: collision with root package name */
    private final List<Aa> f14481h = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FinderPatternFinder.java */
    /* loaded from: classes2.dex */
    public static final class a implements Comparator<Aa>, Serializable {

        /* renamed from: a  reason: collision with root package name */
        private final float f14484a;

        /* renamed from: a */
        public int compare(Aa aa2, Aa aa3) {
            int compare = Integer.compare(aa3.a(), aa2.a());
            return compare == 0 ? Float.compare(Math.abs(aa2.e() - this.f14484a), Math.abs(aa3.e() - this.f14484a)) : compare;
        }

        private a(float f10) {
            this.f14484a = f10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FinderPatternFinder.java */
    /* loaded from: classes2.dex */
    public static final class b implements Comparator<Aa>, Serializable {
        private b() {
        }

        /* renamed from: a */
        public int compare(Aa aa2, Aa aa3) {
            return Float.compare(aa2.e(), aa3.e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FinderPatternFinder.java */
    /* loaded from: classes2.dex */
    public static final class c implements Comparator<Aa>, Serializable {

        /* renamed from: a  reason: collision with root package name */
        private final float f14485a;

        /* renamed from: a */
        public int compare(Aa aa2, Aa aa3) {
            return Float.compare(Math.abs(aa3.e() - this.f14485a), Math.abs(aa2.e() - this.f14485a));
        }

        private c(float f10) {
            this.f14485a = f10;
        }
    }

    public Ca(C0595i iVar, A a10) {
        this.f14479f = iVar;
        this.f14483j = a10;
    }

    protected static float a(int[] iArr, int[] iArr2, float f10) {
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            i10 += iArr[i12];
            i11 += iArr2[i12];
        }
        if (i10 < i11) {
            return Float.POSITIVE_INFINITY;
        }
        float f11 = i10;
        float f12 = f11 / i11;
        float f13 = f10 * f12;
        float f14 = 0.0f;
        for (int i13 = 0; i13 < length; i13++) {
            float f15 = iArr2[i13] * f12;
            float f16 = iArr[i13];
            float f17 = f16 > f15 ? f16 - f15 : f15 - f16;
            if (f17 > f13) {
                return Float.POSITIVE_INFINITY;
            }
            f14 += f17;
        }
        return f14 / f11;
    }

    private boolean b(int[] iArr, int[] iArr2) {
        if ((iArr2[0] & 1) != 0) {
            int i10 = iArr2[0];
            iArr[i10] = iArr[i10] + 1;
        } else if (iArr2[0] == 4) {
            if (a(iArr, false)) {
                boolean a10 = a(iArr, iArr2[1], iArr2[2], false);
                if (a10) {
                    iArr2[4] = 2;
                }
                if (!a10) {
                    a10 = a(iArr, iArr2[1], iArr2[2]);
                }
                if (a10) {
                    iArr2[0] = 0;
                    a(iArr);
                    return true;
                }
            }
            if (b(iArr)) {
                int i11 = iArr2[2];
                for (int i12 = iArr2[0]; i12 > 2; i12--) {
                    i11 -= iArr[i12];
                }
                if (b(iArr, iArr2[1], i11)) {
                    d(iArr);
                    iArr2[0] = 3;
                    return true;
                }
            }
            if (!Ka.f14566d || !a(iArr, true) || !a(iArr, iArr2[1], iArr2[2], true)) {
                d(iArr);
                iArr2[0] = 3;
            } else {
                iArr2[0] = 0;
                a(iArr);
                return true;
            }
        } else {
            int i13 = iArr2[0] + 1;
            iArr2[0] = i13;
            iArr[i13] = iArr[i13] + 1;
        }
        return false;
    }

    private Aa[] c() throws C0550a {
        Aa[] a10 = this.f14480g.size() > 2 ? a(true) : null;
        if (this.f14480g.size() == 2) {
            int i10 = this.f14480g.get(0).e() > this.f14480g.get(1).e() ? 0 : 1;
            if (Math.max(this.f14480g.get(0).e(), this.f14480g.get(1).e()) / Math.min(this.f14480g.get(0).e(), this.f14480g.get(1).e()) > 1.5d) {
                this.f14480g.clear();
                this.f14480g.add(this.f14480g.get(i10));
            }
        }
        if (this.f14480g.size() == 1 && this.f14481h.size() > 1) {
            a10 = g();
        }
        if (this.f14480g.size() == 1 && this.f14481h.size() == 1) {
            this.f14480g.addAll(this.f14481h);
            this.f14481h.clear();
        }
        if (this.f14480g.size() == 2) {
            try {
                a10 = h();
            } catch (C0550a unused) {
                a10 = b();
            }
        }
        if (this.f14480g.size() != 0) {
            return a10;
        }
        this.f14480g.addAll(this.f14481h);
        if (this.f14480g.size() < 20) {
            return a(false);
        }
        return f();
    }

    private int[] d() {
        a(this.f14482i);
        return this.f14482i;
    }

    private static void e() {
        f14476c = false;
        f14477d = false;
    }

    private Aa[] f() throws C0550a {
        float f10;
        int size = this.f14480g.size();
        if (size >= 3) {
            float f11 = 0.0f;
            if (size > 3) {
                float f12 = 0.0f;
                float f13 = 0.0f;
                for (Aa aa2 : this.f14480g) {
                    float e10 = aa2.e();
                    f12 += e10;
                    f13 += e10 * e10;
                }
                float f14 = f12 / size;
                float sqrt = (float) Math.sqrt((f13 / f10) - (f14 * f14));
                Collections.sort(this.f14480g, new c(f14));
                float max = Math.max(0.2f * f14, sqrt);
                int i10 = 0;
                while (i10 < this.f14480g.size() && this.f14480g.size() > 3) {
                    if (Math.abs(this.f14480g.get(i10).e() - f14) > max) {
                        this.f14480g.remove(i10);
                        i10--;
                    }
                    i10++;
                }
            }
            if (this.f14480g.size() > 3) {
                for (Aa aa3 : this.f14480g) {
                    f11 += aa3.e();
                }
                Collections.sort(this.f14480g, new a(f11 / this.f14480g.size()));
                List<Aa> list = this.f14480g;
                list.subList(3, list.size()).clear();
            }
            double[] dArr = {a(this.f14480g.get(0), this.f14480g.get(1)), a(this.f14480g.get(1), this.f14480g.get(2)), a(this.f14480g.get(0), this.f14480g.get(2))};
            Arrays.sort(dArr);
            if (Math.abs(((dArr[1] + dArr[0]) - dArr[2]) / ((Math.sqrt(dArr[0]) * 2.0d) * Math.sqrt(dArr[1]))) <= 0.25d) {
                return new Aa[]{this.f14480g.get(0), this.f14480g.get(1), this.f14480g.get(2)};
            }
            throw C0550a.a();
        }
        throw C0550a.a();
    }

    private Aa[] g() throws C0550a {
        boolean z10;
        Collections.sort(this.f14481h, f14478e);
        double[] dArr = new double[3];
        Aa[] aaArr = new Aa[3];
        int i10 = 0;
        double d10 = Double.MAX_VALUE;
        while (i10 < this.f14480g.size()) {
            Aa aa2 = this.f14480g.get(i10);
            float e10 = aa2.e();
            for (int i11 = 0; i11 < this.f14481h.size() - 1; i11++) {
                Aa aa3 = this.f14481h.get(i11);
                double e11 = aa3.e() / e10;
                if (e11 <= 1.25d && e11 >= 0.75d) {
                    double a10 = a(aa2, aa3);
                    if (Math.sqrt(a10) >= e10 * 13.0f) {
                        for (int i12 = i11 + 1; i12 < this.f14481h.size(); i12++) {
                            Aa aa4 = this.f14481h.get(i12);
                            i10 = i10;
                            double e12 = aa4.e() / e10;
                            if (e12 > 1.25d || e12 < 0.75d) {
                                z10 = true;
                            } else {
                                dArr[0] = a10;
                                dArr[1] = a(aa3, aa4);
                                dArr[2] = a(aa2, aa4);
                                Arrays.sort(dArr);
                                double abs = (Math.abs(dArr[2] - (dArr[1] * 2.0d)) + Math.abs(dArr[2] - (dArr[0] * 2.0d))) / dArr[2];
                                z10 = true;
                                double sqrt = ((dArr[1] + dArr[0]) - dArr[2]) / ((Math.sqrt(dArr[0]) * 2.0d) * Math.sqrt(dArr[1]));
                                if (abs < d10 && Math.abs(sqrt) < 0.2d) {
                                    aaArr[0] = aa2;
                                    aaArr[1] = aa3;
                                    aaArr[2] = aa4;
                                    d10 = abs;
                                }
                            }
                        }
                    }
                }
                i10 = i10;
            }
            i10++;
        }
        if (d10 != Double.MAX_VALUE) {
            return aaArr;
        }
        throw C0550a.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x01c6, code lost:
        if (r4 == false) goto L52;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Aa[] h() throws C0550a {
        double d10;
        Aa aa2;
        Aa aa3;
        char c10 = 0;
        Aa aa4 = this.f14480g.get(0);
        char c11 = 1;
        Aa aa5 = this.f14480g.get(1);
        Aa aa6 = this.f14480g.get(1);
        double a10 = a(aa4, aa5);
        double[] dArr = new double[3];
        float min = Math.min(aa4.e(), aa5.e());
        Collections.sort(this.f14480g, new c(min));
        int i10 = 0;
        double d11 = Double.MAX_VALUE;
        while (i10 < this.f14481h.size()) {
            Aa aa7 = this.f14481h.get(i10);
            float e10 = aa7.e();
            if (e10 > 1.25f * min || e10 < 0.75f * min) {
                aa2 = aa4;
                aa3 = aa5;
                d10 = a10;
            } else {
                dArr[c10] = a10;
                dArr[c11] = a(aa5, aa7);
                dArr[2] = a(aa4, aa7);
                Arrays.sort(dArr);
                double abs = (Math.abs(dArr[2] - (dArr[c11] * 2.0d)) + Math.abs(dArr[2] - (dArr[c10] * 2.0d))) / dArr[2];
                double sqrt = ((dArr[c11] + dArr[c10]) - dArr[2]) / ((Math.sqrt(dArr[c10]) * 2.0d) * Math.sqrt(dArr[c11]));
                if (!Ka.f14566d || Math.abs(sqrt) >= 0.25d) {
                    aa2 = aa4;
                    aa3 = aa5;
                    d10 = a10;
                } else {
                    boolean z10 = aa4.b() < ((float) this.f14479f.d()) * 0.3f && aa5.b() > ((float) this.f14479f.d()) * 0.7f;
                    boolean z11 = aa5.b() < ((float) this.f14479f.d()) * 0.3f && aa4.b() > ((float) this.f14479f.d()) * 0.7f;
                    boolean z12 = aa4.c() < ((float) this.f14479f.b()) * 0.3f && aa5.c() > ((float) this.f14479f.b()) * 0.7f;
                    aa3 = aa5;
                    boolean z13 = aa5.c() < ((float) this.f14479f.b()) * 0.3f && aa4.c() > ((float) this.f14479f.b()) * 0.7f;
                    aa2 = aa4;
                    boolean z14 = aa7.b() < ((float) this.f14479f.d()) * 0.3f || aa7.b() > ((float) this.f14479f.d()) * 0.7f;
                    d10 = a10;
                    boolean z15 = aa7.c() < ((float) this.f14479f.b()) * 0.3f || aa7.c() > ((float) this.f14479f.b()) * 0.7f;
                    if (!z10) {
                    }
                    if (!z14) {
                    }
                    if ((z12 || z13) && !z15) {
                    }
                }
                if (abs < d11 && Math.abs(sqrt) < 0.25d) {
                    aa6 = aa7;
                    d11 = abs;
                }
            }
            i10++;
            aa5 = aa3;
            aa4 = aa2;
            a10 = d10;
            c10 = 0;
            c11 = 1;
        }
        if (d11 != Double.MAX_VALUE) {
            this.f14480g.add(aa6);
            return new Aa[]{this.f14480g.get(0), this.f14480g.get(1), this.f14480g.get(2)};
        }
        throw C0550a.a();
    }

    protected final void d(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Da a() throws C0550a {
        int b10 = this.f14479f.b();
        int d10 = this.f14479f.d();
        int i10 = (b10 * 3) / 388;
        if (i10 < 3) {
            i10 = 3;
        }
        if (Ka.f14571i) {
            i10 = 2;
        }
        a(i10, b10, d10);
        Aa[] c10 = c();
        if (c10 != null) {
            z.a(c10);
            if ((this.f14479f.b() * this.f14479f.d()) / (Math.sqrt(a(c10[0], c10[1])) * Math.sqrt(a(c10[1], c10[2]))) <= 900.0d) {
                return new Da(c10);
            }
            throw C0550a.a();
        }
        throw C0550a.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
        if (r8[3] <= r7) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0020, code lost:
        if (r5 < 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0026, code lost:
        if (r0.b(r6, r5) == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002a, code lost:
        if (r8[2] > r7) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002c, code lost:
        r8[2] = r8[2] + 1;
        r5 = r5 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0034, code lost:
        if (r5 < 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0038, code lost:
        if (r8[2] <= r7) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003b, code lost:
        if (r5 < 0) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0041, code lost:
        if (r0.b(r6, r5) != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0045, code lost:
        if (r8[1] > r7) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0047, code lost:
        r8[1] = r8[1] + 1;
        r5 = r5 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004f, code lost:
        if (r5 < 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0053, code lost:
        if (r8[1] <= r7) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0057, code lost:
        if (r5 < 0) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005d, code lost:
        if (r0.b(r6, r5) == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0061, code lost:
        if (r8[0] > r7) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0063, code lost:
        r8[0] = r8[0] + 1;
        r5 = r5 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x006d, code lost:
        if (r8[0] <= r7) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x006f, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0070, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean d(int i10, int i11, int i12, int[] iArr) {
        C0595i iVar = this.f14479f;
        while (i10 >= 0 && !iVar.b(i11, i10) && iArr[3] <= i12) {
            iArr[3] = iArr[3] + 1;
            i10--;
        }
        return true;
    }

    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    private void a(int r11, int r12, int r13) {
        /*
            r10 = this;
            r0 = 5
            int[] r1 = new int[r0]
            int r2 = r11 + (-1)
        L5:
            if (r2 >= r12) goto L5e
            r10.a(r1)
            int[] r3 = new int[r0]
            r4 = 0
            r3[r4] = r4
            r5 = 1
            r3[r5] = r2
            r6 = 2
            r3[r6] = r4
            r7 = 3
            r3[r7] = r13
            r7 = 4
            r3[r7] = r11
            r8 = r4
        L1c:
            if (r8 >= r13) goto L39
            r3[r6] = r8
            com.huawei.hms.scankit.p.i r9 = r10.f14479f
            boolean r9 = r9.b(r8, r2)
            if (r9 == 0) goto L2c
            r10.a(r1, r3)
            goto L33
        L2c:
            boolean r9 = r10.b(r1, r3)
            if (r9 == 0) goto L33
            goto L37
        L33:
            r8 = r3[r6]
            r11 = r3[r7]
        L37:
            int r8 = r8 + r5
            goto L1c
        L39:
            boolean r5 = b(r1)
            if (r5 == 0) goto L4e
            r3 = r3[r4]
            r5 = r13
        L42:
            if (r3 <= r6) goto L4a
            r7 = r1[r3]
            int r5 = r5 - r7
            int r3 = r3 + (-1)
            goto L42
        L4a:
            r10.b(r1, r2, r5)
            goto L4f
        L4e:
            r5 = r13
        L4f:
            boolean r3 = a(r1, r4)
            if (r3 == 0) goto L5c
            boolean r3 = r10.a(r1, r2, r5, r4)
            if (r3 == 0) goto L5c
            r11 = r6
        L5c:
            int r2 = r2 + r11
            goto L5
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.Ca.a(int, int, int):void");
    }

    protected static boolean c(int[] iArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 5; i11++) {
            int i12 = iArr[i11];
            if (i12 == 0) {
                return false;
            }
            i10 += i12;
        }
        if (i10 < 7) {
            return false;
        }
        float f10 = i10 / 7.0f;
        float f11 = 0.75f * f10;
        return Math.abs(f10 - ((float) iArr[0])) < f11 && Math.abs(f10 - ((float) iArr[1])) < f11 && Math.abs((f10 * 3.0f) - ((float) iArr[2])) < 3.0f * f11 && Math.abs(f10 - ((float) iArr[3])) < f11 && Math.abs(f10 - ((float) iArr[4])) < f11;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0042, code lost:
        if (r2[3] < r12) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
        if (r10 >= r1) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004c, code lost:
        if (r0.b(r11, r10) == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0050, code lost:
        if (r2[4] >= r12) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0052, code lost:
        r2[4] = r2[4] + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005c, code lost:
        if (r2[4] < r12) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0060, code lost:
        if (com.huawei.hms.scankit.p.Ca.f14477d != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0064, code lost:
        if (com.huawei.hms.scankit.p.Ca.f14476c != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0066, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0067, code lost:
        r11 = (((r2[0] + r2[1]) + r2[2]) + r2[3]) + r2[4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0076, code lost:
        if (r14 == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0080, code lost:
        if ((java.lang.Math.abs(r11 - r13) * 5) < (r13 * 3)) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0084, code lost:
        if (com.huawei.hms.scankit.p.Ca.f14477d != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0088, code lost:
        if (com.huawei.hms.scankit.p.Ca.f14476c != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x008a, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x008d, code lost:
        if (r11 >= (r13 * 3)) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0090, code lost:
        if ((r11 * 3) > r13) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0097, code lost:
        if (a(r2, r14) == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x009d, code lost:
        return a(r2, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:?, code lost:
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private float b(int i10, int i11, int i12, int i13, boolean z10) {
        C0595i iVar = this.f14479f;
        int b10 = iVar.b();
        int[] d10 = d();
        if (b(i10, i11, i12, d10)) {
            return Float.NaN;
        }
        int i14 = i10 + 1;
        while (i14 < b10 && iVar.b(i11, i14)) {
            d10[2] = d10[2] + 1;
            i14++;
        }
        if (i14 == b10) {
            return Float.NaN;
        }
        while (i14 < b10 && !iVar.b(i11, i14) && d10[3] < i12) {
            d10[3] = d10[3] + 1;
            i14++;
        }
        return Float.NaN;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001b, code lost:
        if (r8[1] <= r7) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001f, code lost:
        if (r5 < 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0025, code lost:
        if (r0.b(r6, r5) == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0029, code lost:
        if (r8[0] > r7) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002b, code lost:
        r8[0] = r8[0] + 1;
        r5 = r5 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0035, code lost:
        if (r8[0] <= r7) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0037, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0038, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean c(int i10, int i11, int i12, int[] iArr) {
        C0595i iVar = this.f14479f;
        while (i10 >= 0 && !iVar.b(i11, i10) && iArr[1] <= i12) {
            iArr[1] = iArr[1] + 1;
            i10--;
        }
        return true;
    }

    private void a(int[] iArr, int[] iArr2) {
        if ((iArr2[0] & 1) == 1) {
            iArr2[0] = iArr2[0] + 1;
        }
        if (iArr2[0] >= 0 && iArr2[0] < iArr.length) {
            int i10 = iArr2[0];
            iArr[i10] = iArr[i10] + 1;
        }
        if (iArr2[2] == iArr2[3] - 1 && iArr2[0] == 4) {
            if (a(iArr, false)) {
                boolean a10 = a(iArr, iArr2[1], iArr2[2], false);
                if (a10) {
                    iArr2[4] = 2;
                }
                if (!a10) {
                    a10 = a(iArr, iArr2[1], iArr2[2]);
                }
                if (a10) {
                    iArr2[0] = 0;
                    a(iArr);
                    while (iArr2[2] < this.f14479f.d() && !this.f14479f.b(iArr2[2], iArr2[1])) {
                        iArr2[2] = iArr2[2] + 1;
                    }
                }
            }
            if (Ka.f14566d && a(iArr, true) && a(iArr, iArr2[1], iArr2[2], true)) {
                iArr2[0] = 0;
                a(iArr);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
        if (r8[1] <= r7) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0033, code lost:
        if (r5 < 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
        if (r0.b(r6, r5) == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003d, code lost:
        if (r8[0] > r7) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003f, code lost:
        r8[0] = r8[0] + 1;
        r5 = r5 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0049, code lost:
        if (r8[0] <= r7) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004d, code lost:
        if (com.huawei.hms.scankit.p.Ca.f14477d != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0051, code lost:
        if (com.huawei.hms.scankit.p.Ca.f14476c != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0053, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0054, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(int i10, int i11, int i12, int[] iArr) {
        C0595i iVar = this.f14479f;
        while (i10 >= 0 && iVar.b(i11, i10)) {
            iArr[2] = iArr[2] + 1;
            i10--;
        }
        if (i10 < 0) {
            return true;
        }
        while (i10 >= 0 && !iVar.b(i11, i10) && iArr[1] <= i12) {
            iArr[1] = iArr[1] + 1;
            i10--;
        }
        return true;
    }

    protected static boolean b(int[] iArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 3; i11++) {
            int i12 = iArr[i11];
            if (i12 == 0) {
                return false;
            }
            i10 += i12;
        }
        if (i10 < 7) {
            return false;
        }
        float f10 = i10 / 7.0f;
        float f11 = 0.5f * f10;
        return Math.abs(f10 - ((float) iArr[0])) < f11 && Math.abs((5.0f * f10) - ((float) iArr[1])) < f11 && Math.abs(f10 - ((float) iArr[2])) < f11;
    }

    private static float a(int[] iArr, int i10) {
        return ((i10 - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    protected static boolean a(int[] iArr, boolean z10) {
        float f10;
        float f11;
        e();
        int i10 = 0;
        for (int i11 = 0; i11 < 5; i11++) {
            int i12 = iArr[i11];
            if (i12 == 0) {
                return false;
            }
            i10 += i12;
        }
        if (i10 < 7) {
            return false;
        }
        if (!z10 || !Ka.f14566d) {
            f10 = 3.0f;
            f11 = 0.5f;
        } else {
            f11 = 0.75f;
            f10 = 1.0f;
        }
        float f12 = i10 / 7.0f;
        float f13 = f11 * f12;
        if (Math.abs(f12 - iArr[0]) < f13 && Math.abs(f12 - iArr[1]) < f13 && Math.abs((3.0f * f12) - iArr[2]) < f10 * f13 && Math.abs(f12 - iArr[3]) < f13 && Math.abs(f12 - iArr[4]) < f13) {
            return true;
        }
        if (!z10) {
            return false;
        }
        int[] iArr2 = new int[iArr.length - 1];
        int i13 = 0;
        while (i13 < iArr.length - 1) {
            int i14 = i13 + 1;
            iArr2[i13] = iArr[i14];
            i13 = i14;
        }
        int[] iArr3 = new int[iArr.length - 1];
        for (int i15 = 0; i15 < iArr.length - 1; i15++) {
            iArr3[i15] = iArr[i15];
        }
        float a10 = a(iArr2, f14474a, 0.5f);
        float a11 = a(iArr3, f14475b, 0.5f);
        boolean z11 = a10 < 0.3f;
        f14476c = z11;
        boolean z12 = a11 < 0.3f;
        f14477d = z12;
        return z11 || z12;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
        if (r2[3] <= r11) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
        if (r9 >= r1) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0038, code lost:
        if (r0.b(r10, r9) == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
        r2[4] = r2[4] + 1;
        r9 = r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
        if (r2[4] <= r11) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0046, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005f, code lost:
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r2[4]) - r12) * 5) < (r12 * 2)) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0061, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
        if (a(r2, true) == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006c, code lost:
        return a(r2, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private float b(int i10, int i11, int i12, int i13) {
        C0595i iVar = this.f14479f;
        int b10 = iVar.b();
        int[] d10 = d();
        if (d(i10, i11, i12, d10)) {
            return Float.NaN;
        }
        int i14 = i10 + 1;
        while (i14 < b10 && !iVar.b(i11, i14) && d10[3] <= i12) {
            d10[3] = d10[3] + 1;
            i14++;
        }
        return Float.NaN;
    }

    protected final boolean b(int[] iArr, int i10, int i11) {
        int i12 = iArr[0] + iArr[1] + iArr[2];
        float f10 = i11 - (i12 / 2);
        int i13 = (int) f10;
        float a10 = a(i10, i13, iArr[1], i12);
        if (Float.isNaN(a10)) {
            a10 = a(i10, (int) (f10 - ((iArr[1] * 2) / 5)), (int) (((iArr[1] * 2) / 5) + f10), iArr[1], i12);
            if (Float.isNaN(a10) && Ka.f14566d) {
                a10 = b(i10, i13, iArr[1], i12);
            }
        }
        if (!Float.isNaN(a10)) {
            return a(false, a10, f10, i12 / 7.0f);
        }
        return false;
    }

    protected final void a(int[] iArr) {
        for (int i10 = 0; i10 < iArr.length; i10++) {
            iArr[i10] = 0;
        }
    }

    private boolean a(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int[] d10 = d();
        int i15 = 0;
        while (i10 >= i15 && i11 >= i15 && this.f14479f.b(i11 - i15, i10 - i15)) {
            d10[2] = d10[2] + 1;
            i15++;
        }
        if (d10[2] == 0) {
            return false;
        }
        while (i10 >= i15 && i11 >= i15 && !this.f14479f.b(i11 - i15, i10 - i15)) {
            d10[1] = d10[1] + 1;
            i15++;
        }
        if (d10[1] == 0) {
            return false;
        }
        while (i10 >= i15 && i11 >= i15 && this.f14479f.b(i11 - i15, i10 - i15)) {
            d10[0] = d10[0] + 1;
            i15++;
        }
        if (d10[0] == 0) {
            return false;
        }
        int b10 = this.f14479f.b();
        int d11 = this.f14479f.d();
        int i16 = 1;
        while (true) {
            int i17 = i10 + i16;
            if (i17 >= b10 || (i14 = i11 + i16) >= d11 || !this.f14479f.b(i14, i17)) {
                break;
            }
            d10[2] = d10[2] + 1;
            i16++;
        }
        while (true) {
            int i18 = i10 + i16;
            if (i18 >= b10 || (i13 = i11 + i16) >= d11 || this.f14479f.b(i13, i18)) {
                break;
            }
            d10[3] = d10[3] + 1;
            i16++;
        }
        if (d10[3] == 0) {
            return false;
        }
        while (true) {
            int i19 = i10 + i16;
            if (i19 >= b10 || (i12 = i11 + i16) >= d11 || !this.f14479f.b(i12, i19)) {
                break;
            }
            d10[4] = d10[4] + 1;
            i16++;
        }
        if (d10[4] == 0) {
            return false;
        }
        return c(d10);
    }

    private Aa[] b() throws C0550a {
        Aa aa2 = this.f14480g.get(0);
        Aa aa3 = this.f14480g.get(1);
        float[] fArr = aa2.b() < aa3.b() ? new float[]{aa2.b(), aa3.b()} : new float[]{aa3.b(), aa2.b()};
        float[] fArr2 = aa2.b() < aa3.b() ? new float[]{aa2.c(), aa3.c()} : new float[]{aa3.c(), aa2.c()};
        float e10 = (aa2.e() + aa3.e()) / 2.0f;
        float e11 = ((aa2.e() + aa3.e()) * 7.0f) / 1.5f;
        if (Math.abs(fArr[0] - fArr[1]) > e11 && Math.abs(fArr2[0] - fArr2[1]) <= e11) {
            this.f14480g.add(new Aa((fArr[0] + fArr2[0]) - fArr2[1], (fArr2[0] + fArr[1]) - fArr[0], e10, false, 0));
        } else if (Math.abs(fArr[0] - fArr[1]) > e11 || Math.abs(fArr2[0] - fArr2[1]) <= e11) {
            if (Math.abs(fArr[0] - fArr[1]) > e11 && Math.abs(fArr2[0] - fArr2[1]) > e11) {
                this.f14480g.add(new Aa((((fArr[0] + fArr[1]) + fArr2[1]) - fArr2[0]) / 2.0f, (((fArr2[0] + fArr2[1]) + fArr[0]) - fArr[1]) / 2.0f, e10, false, 0));
            }
        } else if (fArr[0] < fArr[1]) {
            this.f14480g.add(new Aa((fArr[1] + fArr2[0]) - fArr2[1], (fArr2[1] + fArr[1]) - fArr[0], e10, false, 0));
        } else {
            this.f14480g.add(new Aa((fArr[0] + fArr2[1]) - fArr2[0], (fArr2[0] + fArr[0]) - fArr[1], e10, false, 0));
        }
        if (this.f14480g.size() == 3) {
            return new Aa[]{this.f14480g.get(0), this.f14480g.get(1), this.f14480g.get(2)};
        }
        throw C0550a.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0042, code lost:
        if (r2[3] < r12) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
        if (r10 >= r1) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004c, code lost:
        if (r0.b(r10, r11) == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0050, code lost:
        if (r2[4] >= r12) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0052, code lost:
        r2[4] = r2[4] + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005c, code lost:
        if (r2[4] < r12) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0060, code lost:
        if (com.huawei.hms.scankit.p.Ca.f14477d != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0064, code lost:
        if (com.huawei.hms.scankit.p.Ca.f14476c != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0066, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x007d, code lost:
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r2[4]) - r13) * 5) < r13) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0081, code lost:
        if (com.huawei.hms.scankit.p.Ca.f14477d != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0085, code lost:
        if (com.huawei.hms.scankit.p.Ca.f14476c != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0087, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x008c, code lost:
        if (a(r2, r14) == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0092, code lost:
        return a(r2, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:?, code lost:
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private float a(int i10, int i11, int i12, int i13, boolean z10) {
        C0595i iVar = this.f14479f;
        int d10 = iVar.d();
        int[] d11 = d();
        if (a(i10, i11, i12, d11)) {
            return Float.NaN;
        }
        int i14 = i10 + 1;
        while (i14 < d10 && iVar.b(i14, i11)) {
            d11[2] = d11[2] + 1;
            i14++;
        }
        if (i14 == d10) {
            return Float.NaN;
        }
        while (i14 < d10 && !iVar.b(i14, i11) && d11[3] < i12) {
            d11[3] = d11[3] + 1;
            i14++;
        }
        return Float.NaN;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
        if (r8[1] <= r7) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0033, code lost:
        if (r5 < 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
        if (r0.b(r5, r6) == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003d, code lost:
        if (r8[0] > r7) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003f, code lost:
        r8[0] = r8[0] + 1;
        r5 = r5 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0049, code lost:
        if (r8[0] <= r7) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004d, code lost:
        if (com.huawei.hms.scankit.p.Ca.f14477d != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0051, code lost:
        if (com.huawei.hms.scankit.p.Ca.f14476c != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0053, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0054, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(int i10, int i11, int i12, int[] iArr) {
        C0595i iVar = this.f14479f;
        while (i10 >= 0 && iVar.b(i10, i11)) {
            iArr[2] = iArr[2] + 1;
            i10--;
        }
        if (i10 < 0) {
            return true;
        }
        while (i10 >= 0 && !iVar.b(i10, i11) && iArr[1] <= i12) {
            iArr[1] = iArr[1] + 1;
            i10--;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final boolean a(int[] iArr, int i10, int i11, boolean z10) {
        float b10;
        int i12;
        int i13;
        boolean z11 = false;
        int i14 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        if (f14476c) {
            i12 = iArr[1] + iArr[1] + iArr[2] + iArr[3];
            i13 = iArr[4];
        } else {
            if (f14477d) {
                i12 = iArr[0] + iArr[1] + iArr[2] + iArr[3];
                i13 = iArr[3];
            }
            int i15 = i14;
            int a10 = (int) a(iArr, i11);
            b10 = b(i10, a10, iArr[2], i15, z10);
            if (!Float.isNaN(b10)) {
                float f10 = i15 / 7.0f;
                int i16 = (int) b10;
                float a11 = a(a10, i16, iArr[2], i15, z10);
                if (!Float.isNaN(a11) && (a(i16, (int) a11) || (z10 && (f14477d || f14476c)))) {
                    if (z10) {
                        return a(false, b10, a11, f10);
                    }
                    int i17 = 0;
                    while (true) {
                        if (i17 >= this.f14480g.size()) {
                            break;
                        }
                        Aa aa2 = this.f14480g.get(i17);
                        if (aa2.a(f10, b10, a11)) {
                            this.f14480g.set(i17, aa2.a(b10, a11, f10, true));
                            z11 = true;
                            break;
                        }
                        i17++;
                    }
                    if (!z11) {
                        Aa aa3 = new Aa(a11, b10, f10, true);
                        this.f14480g.add(aa3);
                        A a12 = this.f14483j;
                        if (a12 != null) {
                            a12.a(aa3);
                        }
                    }
                    return true;
                }
            }
            return false;
        }
        i14 = i12 + i13;
        int i152 = i14;
        int a102 = (int) a(iArr, i11);
        b10 = b(i10, a102, iArr[2], i152, z10);
        if (!Float.isNaN(b10)) {
        }
        return false;
    }

    private static double a(Aa aa2, Aa aa3) {
        double b10 = aa2.b() - aa3.b();
        double c10 = aa2.c() - aa3.c();
        return (b10 * b10) + (c10 * c10);
    }

    private Aa[] a(boolean z10) throws C0550a {
        float f10;
        Collections.sort(this.f14480g, f14478e);
        float f11 = z10 ? 0.4f : 0.25f;
        double[] dArr = new double[3];
        Aa[] aaArr = new Aa[3];
        int i10 = 0;
        double d10 = Double.MAX_VALUE;
        while (true) {
            char c10 = 2;
            if (i10 >= this.f14480g.size() - 2) {
                break;
            }
            Aa aa2 = this.f14480g.get(i10);
            float e10 = aa2.e();
            i10++;
            int i11 = i10;
            while (i11 < this.f14480g.size() - 1) {
                Aa aa3 = this.f14480g.get(i11);
                double a10 = a(aa2, aa3);
                i11++;
                int i12 = i11;
                while (i12 < this.f14480g.size()) {
                    Aa aa4 = this.f14480g.get(i12);
                    if (aa4.e() <= 1.4f * e10) {
                        dArr[0] = a10;
                        dArr[1] = a(aa3, aa4);
                        dArr[c10] = a(aa2, aa4);
                        Arrays.sort(dArr);
                        double abs = (Math.abs(dArr[c10] - (dArr[1] * 2.0d)) + Math.abs(dArr[c10] - (dArr[0] * 2.0d))) / dArr[c10];
                        double sqrt = ((dArr[1] + dArr[0]) - dArr[c10]) / ((Math.sqrt(dArr[0]) * 2.0d) * Math.sqrt(dArr[1]));
                        if (abs < d10) {
                            f10 = e10;
                            if (Math.abs(sqrt) < f11) {
                                aaArr[0] = aa2;
                                aaArr[1] = aa3;
                                c10 = 2;
                                aaArr[2] = aa4;
                                d10 = abs;
                            } else {
                                c10 = 2;
                            }
                            i12++;
                            e10 = f10;
                        }
                    }
                    f10 = e10;
                    i12++;
                    e10 = f10;
                }
            }
        }
        if (Double.MAX_VALUE != d10) {
            return aaArr;
        }
        throw C0550a.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
        if (r2[1] <= r12) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
        if (r10 >= r1) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
        if (r0.b(r11, r10) == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
        r2[2] = r2[2] + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
        if (r10 != r1) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0046, code lost:
        if (r10 >= r1) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004c, code lost:
        if (r0.b(r11, r10) != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0050, code lost:
        if (r2[3] >= r12) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0052, code lost:
        r2[3] = r2[3] + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005a, code lost:
        if (r10 == r1) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005e, code lost:
        if (r2[3] < r12) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0062, code lost:
        if (r10 >= r1) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0068, code lost:
        if (r0.b(r11, r10) == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006c, code lost:
        if (r2[4] >= r12) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006e, code lost:
        r2[4] = r2[4] + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0078, code lost:
        if (r2[4] < r12) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007a, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0092, code lost:
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r2[4]) - r13) * 5) < (r13 * 2)) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0094, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0097, code lost:
        if (com.huawei.hms.scankit.p.Ka.f14566d == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x009d, code lost:
        if (a(r2, true) == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a3, code lost:
        return a(r2, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a8, code lost:
        if (a(r2, false) == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ae, code lost:
        return a(r2, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:?, code lost:
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private float a(int i10, int i11, int i12, int i13) {
        C0595i iVar = this.f14479f;
        int b10 = iVar.b();
        int[] d10 = d();
        if (c(i10, i11, i12, d10)) {
            return Float.NaN;
        }
        int i14 = i10 + 1;
        while (i14 < b10 && !iVar.b(i11, i14) && d10[1] <= i12) {
            d10[1] = d10[1] + 1;
            i14++;
        }
        return Float.NaN;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
        r11 = r19 * 1.5d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
        if (r6[1] <= r11) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
        if (r7 < 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:
        if (r3.b(r5, r7) == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0044, code lost:
        if (r6[0] > r19) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0046, code lost:
        r6[0] = r6[0] + 1;
        r7 = r7 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0052, code lost:
        if (r6[0] <= (r19 / 2)) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0055, code lost:
        r7 = r16 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0057, code lost:
        if (r7 >= r4) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005d, code lost:
        if (r3.b(r5, r7) != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0061, code lost:
        if (r6[1] > r19) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0063, code lost:
        r6[1] = r6[1] + 1;
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006b, code lost:
        if (r7 < 0) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0072, code lost:
        if (r6[1] <= r11) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0076, code lost:
        if (r7 >= r4) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007c, code lost:
        if (r3.b(r5, r7) == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x007e, code lost:
        r6[2] = r6[2] + 1;
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0098, code lost:
        if ((java.lang.Math.abs(((r6[0] + r6[1]) + r6[2]) - r20) * 5) < (r20 * 2)) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x009f, code lost:
        if (b(r6) == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a9, code lost:
        return (r7 - (r6[1] / 2)) - r6[2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00aa, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00aa, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00aa, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00aa, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00aa, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private float a(int i10, int i11, int i12, int i13, int i14) {
        C0595i iVar = this.f14479f;
        int b10 = iVar.b();
        int i15 = i11;
        while (i15 <= i12) {
            int[] d10 = d();
            int i16 = i10;
            while (i16 >= 0 && !iVar.b(i15, i16) && d10[1] <= i13) {
                d10[1] = d10[1] + 1;
                i16--;
            }
            i15 += i12 - i11;
        }
        return Float.NaN;
    }

    protected final boolean a(int[] iArr, int i10, int i11) {
        int i12 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        float a10 = a(iArr, i11);
        float b10 = b(i10, (int) a10, iArr[2], i12, false);
        if (Float.isNaN(b10)) {
            b10 = a(i10, (int) ((a10 - (iArr[2] / 2)) - (iArr[1] / 2)), (int) ((iArr[2] / 2) + a10 + (iArr[3] / 2)), iArr[1] + iArr[2] + iArr[3], i12);
        }
        if (!Float.isNaN(b10)) {
            return a(false, b10, a10, i12 / 7.0f);
        }
        return false;
    }

    private boolean a(boolean z10, float f10, float f11, float f12) {
        int i10 = 0;
        while (true) {
            if (i10 >= this.f14481h.size()) {
                break;
            }
            Aa aa2 = this.f14481h.get(i10);
            if (aa2.a(f12, f10, f11)) {
                this.f14481h.set(i10, aa2.a(f10, f11, f12, false));
                z10 = true;
                break;
            }
            i10++;
        }
        if (!z10) {
            Aa aa3 = new Aa(f11, f10, f12, false);
            this.f14481h.add(aa3);
            A a10 = this.f14483j;
            if (a10 != null) {
                a10.a(aa3);
            }
        }
        return true;
    }
}
