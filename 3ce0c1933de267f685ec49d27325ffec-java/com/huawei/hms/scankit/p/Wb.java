package com.huawei.hms.scankit.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: X12Encoder.java */
/* loaded from: classes2.dex */
public final class Wb extends Lb {
    @Override // com.huawei.hms.scankit.p.Lb
    public int a() {
        return 3;
    }

    @Override // com.huawei.hms.scankit.p.Lb, com.huawei.hms.scankit.p.Pb
    public void a(Qb qb2) {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            if (!qb2.h()) {
                break;
            }
            char c10 = qb2.c();
            qb2.f14627f++;
            a(c10, sb2);
            if (sb2.length() % 3 == 0) {
                Lb.b(qb2, sb2);
                if (Sb.a(qb2.d(), qb2.f14627f, a()) != a()) {
                    qb2.b(0);
                    break;
                }
            }
        }
        a(qb2, sb2);
    }

    @Override // com.huawei.hms.scankit.p.Lb
    int a(char c10, StringBuilder sb2) {
        if (c10 == '\r') {
            sb2.append((char) 0);
        } else if (c10 == ' ') {
            sb2.append((char) 3);
        } else if (c10 == '*') {
            sb2.append((char) 1);
        } else if (c10 == '>') {
            sb2.append((char) 2);
        } else if (c10 >= '0' && c10 <= '9') {
            sb2.append((char) ((c10 - '0') + 4));
        } else if (c10 < 'A' || c10 > 'Z') {
            Sb.a(c10);
            throw null;
        } else {
            sb2.append((char) ((c10 - 'A') + 14));
        }
        return 1;
    }

    @Override // com.huawei.hms.scankit.p.Lb
    void a(Qb qb2, StringBuilder sb2) {
        qb2.k();
        int a10 = qb2.g().a() - qb2.a();
        qb2.f14627f -= sb2.length();
        if (qb2.f() > 1 || a10 > 1 || qb2.f() != a10) {
            qb2.a((char) 254);
        }
        if (qb2.e() < 0) {
            qb2.b(0);
        }
    }
}
