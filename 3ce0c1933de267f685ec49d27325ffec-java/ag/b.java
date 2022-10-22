package ag;

import yf.c;
/* compiled from: DataSessionIdentify.java */
/* loaded from: classes2.dex */
public class b extends c {
    public String sid;

    public static b a(d dVar) {
        b bVar = new b();
        bVar.device_id = dVar.device_id;
        bVar.wwid = dVar.wwid;
        bVar.sid = dVar.sid;
        return bVar;
    }
}
