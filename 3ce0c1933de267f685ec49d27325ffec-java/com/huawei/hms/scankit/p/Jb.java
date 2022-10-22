package com.huawei.hms.scankit.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ASCIIEncoder.java */
/* loaded from: classes2.dex */
public final class Jb implements Pb {
    public int a() {
        return 0;
    }

    @Override // com.huawei.hms.scankit.p.Pb
    public void a(Qb qb2) {
        if (Sb.a(qb2.d(), qb2.f14627f) >= 2) {
            qb2.a(a(qb2.d().charAt(qb2.f14627f), qb2.d().charAt(qb2.f14627f + 1)));
            qb2.f14627f += 2;
            return;
        }
        char c10 = qb2.c();
        int a10 = Sb.a(qb2.d(), qb2.f14627f, a());
        if (a10 != a()) {
            if (a10 == 1) {
                qb2.a((char) 230);
                qb2.b(1);
            } else if (a10 == 2) {
                qb2.a((char) 239);
                qb2.b(2);
            } else if (a10 == 3) {
                qb2.a((char) 238);
                qb2.b(3);
            } else if (a10 == 4) {
                qb2.a((char) 240);
                qb2.b(4);
            } else if (a10 == 5) {
                qb2.a((char) 231);
                qb2.b(5);
            } else {
                try {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Illegal mode: ");
                    sb2.append(a10);
                    throw new IllegalStateException(sb2.toString());
                } catch (Exception e10) {
                    throw e10;
                }
            }
        } else if (Sb.c(c10)) {
            qb2.a((char) 235);
            qb2.a((char) ((c10 - 128) + 1));
            qb2.f14627f++;
        } else {
            qb2.a((char) (c10 + 1));
            qb2.f14627f++;
        }
    }

    private static char a(char c10, char c11) {
        if (Sb.b(c10) && Sb.b(c11)) {
            return (char) (((c10 - '0') * 10) + (c11 - '0') + 130);
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("not digits: ");
            sb2.append(c10);
            sb2.append(c11);
            throw new IllegalArgumentException(sb2.toString());
        } catch (Exception e10) {
            throw e10;
        }
    }
}
