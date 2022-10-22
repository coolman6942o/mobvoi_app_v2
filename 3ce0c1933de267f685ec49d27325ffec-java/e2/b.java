package e2;

import d2.c;
import d2.d;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class b implements d {

    /* renamed from: a  reason: collision with root package name */
    private volatile /* synthetic */ Map<String, c> f25720a = new HashMap();

    @Override // d2.d
    public c a(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        c cVar = this.f25720a.get(str);
        if (cVar != null) {
            return cVar;
        }
        cn.com.fmsh.communication.core.c cVar2 = new cn.com.fmsh.communication.core.c();
        this.f25720a.put(str, cVar2);
        return cVar2;
    }
}
