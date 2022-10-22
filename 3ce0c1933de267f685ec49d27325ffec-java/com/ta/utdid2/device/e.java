package com.ta.utdid2.device;

import com.ta.utdid2.a.a.a;
import com.ta.utdid2.a.a.b;
import com.ta.utdid2.a.a.g;
/* loaded from: classes2.dex */
public class e {
    public String d(String str) {
        return a.b(str);
    }

    public String e(String str) {
        String b10 = a.b(str);
        if (!g.m22a(b10)) {
            try {
                return new String(b.decode(b10, 0));
            } catch (IllegalArgumentException unused) {
            }
        }
        return null;
    }
}
