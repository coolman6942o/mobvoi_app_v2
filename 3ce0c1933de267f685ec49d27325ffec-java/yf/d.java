package yf;

import java.util.List;
import yf.c;
/* compiled from: SyncClient.java */
/* loaded from: classes2.dex */
public interface d<Request extends c, Reply extends c> {
    void a(b<Reply> bVar);

    void b(List<Request> list);

    boolean isConnected();
}
