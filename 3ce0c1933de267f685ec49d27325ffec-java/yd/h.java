package yd;

import java.util.ArrayList;
import java.util.Iterator;
import yd.e;
/* compiled from: PinYinUtil.java */
/* loaded from: classes2.dex */
public class h {
    public static String a(String str) {
        ArrayList<e.a> b10 = e.c().b(str);
        StringBuilder sb2 = new StringBuilder();
        if (b10 != null && b10.size() > 0) {
            Iterator<e.a> it = b10.iterator();
            while (it.hasNext()) {
                e.a next = it.next();
                if (2 == next.f37009a) {
                    sb2.append(next.f37011c);
                } else {
                    sb2.append(next.f37010b);
                }
            }
        }
        return sb2.toString().toLowerCase();
    }
}
