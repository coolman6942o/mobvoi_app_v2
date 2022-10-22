package com.huawei.hms.scankit.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EdifactEncoder.java */
/* loaded from: classes2.dex */
public final class Ob implements Pb {
    public int a() {
        return 4;
    }

    @Override // com.huawei.hms.scankit.p.Pb
    public void a(Qb qb2) {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            if (!qb2.h()) {
                break;
            }
            a(qb2.c(), sb2);
            qb2.f14627f++;
            if (sb2.length() >= 4) {
                qb2.a(a(sb2, 0));
                sb2.delete(0, 4);
                if (Sb.a(qb2.d(), qb2.f14627f, a()) != a()) {
                    qb2.b(0);
                    break;
                }
            }
        }
        sb2.append((char) 31);
        a(qb2, sb2);
    }

    private static void a(Qb qb2, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length != 0) {
                boolean z10 = true;
                if (length == 1) {
                    qb2.k();
                    int a10 = qb2.g().a() - qb2.a();
                    int f10 = qb2.f();
                    if (f10 > a10) {
                        qb2.c(qb2.a() + 1);
                        a10 = qb2.g().a() - qb2.a();
                    }
                    if (f10 <= a10 && a10 <= 2) {
                        return;
                    }
                }
                if (length <= 4) {
                    int i10 = length - 1;
                    String a11 = a(charSequence, 0);
                    if (!(!qb2.h()) || i10 > 2) {
                        z10 = false;
                    }
                    if (i10 <= 2) {
                        qb2.c(qb2.a() + i10);
                        if (qb2.g().a() - qb2.a() >= 3) {
                            qb2.c(qb2.a() + a11.length());
                            z10 = false;
                        }
                    }
                    if (z10) {
                        qb2.j();
                        qb2.f14627f -= i10;
                    } else {
                        qb2.a(a11);
                    }
                    return;
                }
                throw new IllegalStateException("Count must not exceed 4");
            }
        } finally {
            qb2.b(0);
        }
    }

    private static void a(char c10, StringBuilder sb2) {
        if (c10 >= ' ' && c10 <= '?') {
            sb2.append(c10);
        } else if (c10 < '@' || c10 > '^') {
            Sb.a(c10);
            throw null;
        } else {
            sb2.append((char) (c10 - '@'));
        }
    }

    private static String a(CharSequence charSequence, int i10) {
        int length = charSequence.length() - i10;
        if (length != 0) {
            char charAt = charSequence.charAt(i10);
            char c10 = 0;
            char charAt2 = length >= 2 ? charSequence.charAt(i10 + 1) : (char) 0;
            char charAt3 = length >= 3 ? charSequence.charAt(i10 + 2) : (char) 0;
            if (length >= 4) {
                c10 = charSequence.charAt(i10 + 3);
            }
            int i11 = (charAt << 18) + (charAt2 << '\f') + (charAt3 << 6) + c10;
            char c11 = (char) ((i11 >> 8) & 255);
            char c12 = (char) (i11 & 255);
            StringBuilder sb2 = new StringBuilder(3);
            sb2.append((char) ((i11 >> 16) & 255));
            if (length >= 2) {
                sb2.append(c11);
            }
            if (length >= 3) {
                sb2.append(c12);
            }
            return sb2.toString();
        }
        try {
            throw new IllegalStateException("StringBuilder must not be empty");
        } catch (Exception e10) {
            throw e10;
        }
    }
}
