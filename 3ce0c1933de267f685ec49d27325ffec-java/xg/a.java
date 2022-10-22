package xg;

import com.mobvoi.health.companion.system.b;
import com.mobvoi.wear.common.base.WearPath;
/* compiled from: SportsMessageListener.java */
/* loaded from: classes2.dex */
public class a implements b.c {
    @Override // com.mobvoi.health.companion.system.b.c
    public void a(b.C0221b bVar) {
        String str = bVar.f19015b;
        byte[] bArr = bVar.f19016c;
        if (str.startsWith(WearPath.Sports.SPORTS)) {
            eg.a.e().g(str, bArr);
        }
    }
}
