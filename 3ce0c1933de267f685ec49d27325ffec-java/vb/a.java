package vb;

import com.mobvoi.assistant.account.data.AccountManager;
import java.lang.ref.WeakReference;
import ra.c;
/* compiled from: LogOutUtils.java */
/* loaded from: classes2.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LogOutUtils.java */
    /* renamed from: vb.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0514a implements c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WeakReference f35708a;

        C0514a(WeakReference weakReference) {
            this.f35708a = weakReference;
        }

        @Override // ra.c
        public void a() {
            b bVar = (b) this.f35708a.get();
            if (bVar != null) {
                bVar.onLogoutSuccess();
            }
        }

        @Override // ra.c
        public void b(String str) {
            b bVar = (b) this.f35708a.get();
            if (bVar != null) {
                bVar.onLogoutFailure();
            }
        }
    }

    /* compiled from: LogOutUtils.java */
    /* loaded from: classes2.dex */
    public interface b {
        void onLogOutIng();

        void onLogoutFailure();

        void onLogoutSuccess();
    }

    public static void a(b bVar) {
        WeakReference weakReference = new WeakReference(bVar);
        bVar.onLogOutIng();
        AccountManager.n(new C0514a(weakReference));
    }
}
