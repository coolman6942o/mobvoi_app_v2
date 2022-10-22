package com.huawei.hms.scankit.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextEncoder.java */
/* loaded from: classes2.dex */
public final class Vb extends Lb {
    @Override // com.huawei.hms.scankit.p.Lb
    public int a() {
        return 2;
    }

    @Override // com.huawei.hms.scankit.p.Lb
    int a(char c10, StringBuilder sb2) {
        if (c10 == ' ') {
            sb2.append((char) 3);
            return 1;
        } else if (c10 >= '0' && c10 <= '9') {
            sb2.append((char) ((c10 - '0') + 4));
            return 1;
        } else if (c10 >= 'a' && c10 <= 'z') {
            sb2.append((char) ((c10 - 'a') + 14));
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
        } else if (c10 == '`') {
            sb2.append((char) 2);
            sb2.append((char) (c10 - '`'));
            return 2;
        } else if (c10 >= 'A' && c10 <= 'Z') {
            sb2.append((char) 2);
            sb2.append((char) ((c10 - 'A') + 1));
            return 2;
        } else if (c10 < '{' || c10 > 127) {
            sb2.append("\u0001\u001e");
            return a((char) (c10 - 128), sb2) + 2;
        } else {
            sb2.append((char) 2);
            sb2.append((char) ((c10 - '{') + 27));
            return 2;
        }
    }
}
