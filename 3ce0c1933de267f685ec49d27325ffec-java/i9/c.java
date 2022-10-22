package i9;

import com.liulishuo.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.liulishuo.filedownloader.services.FileDownloadService;
import com.liulishuo.filedownloader.services.c;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileDownloadServiceSharedTransmit.java */
/* loaded from: classes2.dex */
public class c implements e, c.a {

    /* renamed from: b  reason: collision with root package name */
    private static final Class<?> f28209b = FileDownloadService.SharedMainProcessService.class;

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Runnable> f28210a = new ArrayList<>();

    @Override // com.liulishuo.filedownloader.services.c.a
    public void a() {
        a.d().a(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.disconnected, f28209b));
    }

    @Override // com.liulishuo.filedownloader.services.c.a
    public void b(com.liulishuo.filedownloader.services.c cVar) {
        this.f28210a.clear();
        for (Runnable runnable : (List) this.f28210a.clone()) {
            runnable.run();
        }
        a.d().a(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, f28209b));
    }
}
