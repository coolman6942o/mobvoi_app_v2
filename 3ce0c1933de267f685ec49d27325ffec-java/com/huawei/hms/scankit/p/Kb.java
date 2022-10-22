package com.huawei.hms.scankit.p;

import androidx.recyclerview.widget.g;
import com.bjleisen.iface.sdk.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Base256Encoder.java */
/* loaded from: classes2.dex */
public final class Kb implements Pb {
    public int a() {
        return 5;
    }

    @Override // com.huawei.hms.scankit.p.Pb
    public void a(Qb qb2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append((char) 0);
        while (true) {
            if (!qb2.h()) {
                break;
            }
            sb2.append(qb2.c());
            qb2.f14627f++;
            if (Sb.a(qb2.d(), qb2.f14627f, a()) != a()) {
                qb2.b(0);
                break;
            }
        }
        int length = sb2.length() - 1;
        int a10 = qb2.a() + length + 1;
        qb2.c(a10);
        boolean z10 = qb2.g().a() - a10 > 0;
        if (qb2.h() || z10) {
            if (length <= 249) {
                sb2.setCharAt(0, (char) length);
            } else if (length <= 1555) {
                sb2.setCharAt(0, (char) ((length / g.f.DEFAULT_SWIPE_ANIMATION_DURATION) + 249));
                sb2.insert(1, (char) (length % g.f.DEFAULT_SWIPE_ANIMATION_DURATION));
            } else {
                try {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Message length not in valid ranges: ");
                    sb3.append(length);
                    throw new IllegalStateException(sb3.toString());
                } catch (Exception e10) {
                    throw e10;
                }
            }
        }
        int length2 = sb2.length();
        for (int i10 = 0; i10 < length2; i10++) {
            qb2.a(a(sb2.charAt(i10), qb2.a() + 1));
        }
    }

    private static char a(char c10, int i10) {
        int i11 = c10 + ((i10 * a.f7612e) % 255) + 1;
        return i11 <= 255 ? (char) i11 : (char) (i11 - 256);
    }
}
