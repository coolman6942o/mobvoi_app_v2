package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.util.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: C40Encoder.java */
/* loaded from: classes2.dex */
public class Lb implements Pb {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Qb qb2, StringBuilder sb2) {
        qb2.a(a(sb2, 0));
        sb2.delete(0, 3);
    }

    public int a() {
        return 1;
    }

    @Override // com.huawei.hms.scankit.p.Pb
    public void a(Qb qb2) {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            if (!qb2.h()) {
                break;
            }
            char c10 = qb2.c();
            qb2.f14627f++;
            int a10 = a(c10, sb2);
            int a11 = qb2.a() + ((sb2.length() / 3) * 2);
            qb2.c(a11);
            int a12 = qb2.g().a() - a11;
            if (qb2.h()) {
                if (sb2.length() % 3 == 0 && Sb.a(qb2.d(), qb2.f14627f, a()) != a()) {
                    qb2.b(0);
                    break;
                }
            } else {
                StringBuilder sb3 = new StringBuilder();
                if (sb2.length() % 3 == 2 && (a12 < 2 || a12 > 2)) {
                    a10 = a(qb2, sb2, sb3, a10);
                }
                while (sb2.length() % 3 == 1 && ((a10 <= 3 && a12 != 1) || a10 > 3)) {
                    a10 = a(qb2, sb2, sb3, a10);
                }
            }
        }
        a(qb2, sb2);
    }

    private int a(Qb qb2, StringBuilder sb2, StringBuilder sb3, int i10) {
        int length = sb2.length();
        sb2.delete(length - i10, length);
        qb2.f14627f--;
        int a10 = a(qb2.c(), sb3);
        qb2.j();
        return a10;
    }

    void a(Qb qb2, StringBuilder sb2) {
        int length = sb2.length() % 3;
        int a10 = qb2.a() + ((sb2.length() / 3) * 2);
        qb2.c(a10);
        int a11 = qb2.g().a() - a10;
        if (length == 2) {
            sb2.append((char) 0);
            while (sb2.length() >= 3) {
                b(qb2, sb2);
            }
            if (qb2.h()) {
                qb2.a((char) 254);
            }
        } else if (a11 == 1 && length == 1) {
            while (sb2.length() >= 3) {
                b(qb2, sb2);
            }
            if (qb2.h()) {
                qb2.a((char) 254);
            }
            qb2.f14627f--;
        } else if (length == 0) {
            while (sb2.length() >= 3) {
                b(qb2, sb2);
            }
            if (a11 > 0 || qb2.h()) {
                qb2.a((char) 254);
            }
        } else {
            try {
                throw new IllegalStateException("Unexpected case. Please report!");
            } catch (Exception unused) {
                a.b("exception", "Exception");
            }
        }
        qb2.b(0);
    }

    int a(char c10, StringBuilder sb2) {
        if (c10 == ' ') {
            sb2.append((char) 3);
            return 1;
        } else if (c10 >= '0' && c10 <= '9') {
            sb2.append((char) ((c10 - '0') + 4));
            return 1;
        } else if (c10 >= 'A' && c10 <= 'Z') {
            sb2.append((char) ((c10 - 'A') + 14));
            return 1;
        } else if (c10 < ' ') {
            sb2.append((char) 0);
            sb2.append(c10);
            return 2;
        } else if (c10 >= '!' && c10 <= '/') {
            sb2.append((char) 1);
            sb2.append((char) (c10 - '!'));
            return 2;
        } else if (c10 >= ':' && c10 <= '@') {
            sb2.append((char) 1);
            sb2.append((char) ((c10 - ':') + 15));
            return 2;
        } else if (c10 >= '[' && c10 <= '_') {
            sb2.append((char) 1);
            sb2.append((char) ((c10 - '[') + 22));
            return 2;
        } else if (c10 < '`' || c10 > 127) {
            sb2.append("\u0001\u001e");
            return a((char) (c10 - 128), sb2) + 2;
        } else {
            sb2.append((char) 2);
            sb2.append((char) (c10 - '`'));
            return 2;
        }
    }

    private static String a(CharSequence charSequence, int i10) {
        int charAt = (charSequence.charAt(i10) * 1600) + (charSequence.charAt(i10 + 1) * '(') + charSequence.charAt(i10 + 2) + 1;
        return new String(new char[]{(char) (charAt / 256), (char) (charAt % 256)});
    }
}
