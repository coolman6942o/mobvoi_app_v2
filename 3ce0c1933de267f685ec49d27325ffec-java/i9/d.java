package i9;

import android.os.IBinder;
import android.os.RemoteException;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import com.liulishuo.filedownloader.services.FileDownloadService;
import m9.a;
import m9.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileDownloadServiceUIGuard.java */
/* loaded from: classes2.dex */
public class d extends com.liulishuo.filedownloader.services.a<a, b> {

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: FileDownloadServiceUIGuard.java */
    /* loaded from: classes2.dex */
    public static class a extends a.AbstractBinderC0397a {
        protected a() {
        }

        @Override // m9.a
        public void e1(MessageSnapshot messageSnapshot) throws RemoteException {
            n9.b.a().b(messageSnapshot);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d() {
        super(FileDownloadService.SeparateProcessService.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public b a(IBinder iBinder) {
        return b.a.A2(iBinder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public a b() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public void c(b bVar, a aVar) throws RemoteException {
        bVar.s0(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i */
    public void e(b bVar, a aVar) throws RemoteException {
        bVar.O1(aVar);
    }
}
