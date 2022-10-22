package j9;

import com.liulishuo.filedownloader.download.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import r9.e;
/* compiled from: RedirectHandler.java */
/* loaded from: classes2.dex */
public class d {
    private static b a(Map<String, List<String>> map, String str) throws IOException {
        b a10 = c.i().a(str);
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value != null) {
                for (String str2 : value) {
                    a10.e(key, str2);
                }
            }
        }
        return a10;
    }

    private static boolean b(int i10) {
        return i10 == 301 || i10 == 302 || i10 == 303 || i10 == 300 || i10 == 307 || i10 == 308;
    }

    public static b c(Map<String, List<String>> map, b bVar, List<String> list) throws IOException, IllegalAccessException {
        int d10 = bVar.d();
        String f10 = bVar.f("Location");
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (b(d10)) {
            if (f10 != null) {
                if (r9.c.f33469a) {
                    r9.c.a(d.class, "redirect to %s with %d, %s", f10, Integer.valueOf(d10), arrayList);
                }
                bVar.g();
                bVar = a(map, f10);
                arrayList.add(f10);
                bVar.execute();
                d10 = bVar.d();
                f10 = bVar.f("Location");
                i10++;
                if (i10 >= 10) {
                    throw new IllegalAccessException(e.n("redirect too many times! %s", arrayList));
                }
            } else {
                throw new IllegalAccessException(e.n("receive %d (redirect) but the location is null with response [%s]", Integer.valueOf(d10), bVar.b()));
            }
        }
        if (list != null) {
            list.addAll(arrayList);
        }
        return bVar;
    }
}
