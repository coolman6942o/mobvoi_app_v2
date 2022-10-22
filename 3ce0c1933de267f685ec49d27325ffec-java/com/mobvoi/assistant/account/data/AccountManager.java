package com.mobvoi.assistant.account.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.mobvoi.assistant.account.AccountConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes2.dex */
public class AccountManager {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    private static AccountManager f15621d;

    /* renamed from: a  reason: collision with root package name */
    private List<f> f15622a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private List<f> f15623b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private List<ra.d> f15624c = new ArrayList();

    /* loaded from: classes2.dex */
    public enum AccountChangeEvent {
        OnLogin,
        OnCleanUp,
        OnForceLogout,
        OnLogout
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends rx.i<sa.g> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f15625a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l f15626b;

        a(Context context, l lVar) {
            this.f15625a = context;
            this.f15626b = lVar;
        }

        /* renamed from: b */
        public void onNext(sa.g gVar) {
            if (gVar.b()) {
                sa.a a10 = sa.a.a(gVar.result);
                ta.a.E(a10);
                AccountManager.h().o(a10);
            } else if (gVar.a()) {
                AccountManager.k(this.f15625a, this.f15626b);
            }
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements yp.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f15627a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f15628b;

        b(l lVar, Context context) {
            this.f15627a = lVar;
            this.f15628b = context;
        }

        @Override // yp.a
        public void call() {
            l lVar = this.f15627a;
            if (lVar == null) {
                Toast.makeText(this.f15628b, pa.i.f32693c, 0).show();
            } else {
                lVar.a();
            }
        }
    }

    /* loaded from: classes2.dex */
    class c implements j {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.internal.util.i f15629a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ra.c f15630b;

        c(rx.internal.util.i iVar, ra.c cVar) {
            this.f15629a = iVar;
            this.f15630b = cVar;
        }

        @Override // com.mobvoi.assistant.account.data.AccountManager.j
        public void a() {
            this.f15629a.a(AccountManager.e(this.f15630b, AccountManager.h().f15622a));
        }
    }

    /* loaded from: classes2.dex */
    class d implements yp.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f15631a;

        d(k kVar) {
            this.f15631a = kVar;
        }

        @Override // yp.a
        public void call() {
            k kVar = this.f15631a;
            if (kVar != null) {
                kVar.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e extends rx.i<sa.c> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ra.c f15632a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f15633b;

        e(ra.c cVar, List list) {
            this.f15632a = cVar;
            this.f15633b = list;
        }

        /* renamed from: b */
        public void onNext(sa.c cVar) {
            if (cVar.b()) {
                ta.a.c();
                new g(this.f15633b, null).a(AccountChangeEvent.OnLogout);
                ra.c cVar2 = this.f15632a;
                if (cVar2 != null) {
                    cVar2.a();
                    return;
                }
                return;
            }
            ra.c cVar3 = this.f15632a;
            if (cVar3 != null) {
                cVar3.b(cVar.errorMsg);
            }
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            com.mobvoi.android.common.utils.k.a("AccountManager", "logout fail:" + th2.getMessage());
            ra.c cVar = this.f15632a;
            if (cVar != null) {
                cVar.b(th2.getMessage());
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
        void onCancel();

        void onEvent(AccountChangeEvent accountChangeEvent, h hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class g implements k {

        /* renamed from: a  reason: collision with root package name */
        private final List<f> f15634a;

        /* renamed from: b  reason: collision with root package name */
        private h f15635b;

        /* synthetic */ g(List list, a aVar) {
            this(list);
        }

        @Override // com.mobvoi.assistant.account.data.AccountManager.k
        public k a(AccountChangeEvent accountChangeEvent) {
            com.mobvoi.android.common.utils.k.i("AccountManager", "Send %s to %d listeners, sender %s", accountChangeEvent, Integer.valueOf(this.f15634a.size()), this);
            for (f fVar : this.f15634a) {
                fVar.onEvent(accountChangeEvent, this.f15635b);
            }
            return this;
        }

        public k b(h hVar) {
            this.f15635b = hVar;
            return this;
        }

        @Override // com.mobvoi.assistant.account.data.AccountManager.k
        public void cancel() {
            com.mobvoi.android.common.utils.k.i("AccountManager", "Cancel current event, sender %s", this);
            for (f fVar : this.f15634a) {
                fVar.onCancel();
            }
        }

        private g(List<f> list) {
            this.f15634a = new ArrayList(list);
        }
    }

    /* loaded from: classes2.dex */
    public interface h {
        void a(f fVar, boolean z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class i implements h {

        /* renamed from: a  reason: collision with root package name */
        private boolean f15636a;

        /* renamed from: b  reason: collision with root package name */
        private final Queue<f> f15637b;

        /* renamed from: c  reason: collision with root package name */
        private j f15638c;

        /* synthetic */ i(List list, j jVar, a aVar) {
            this(list, jVar);
        }

        private void b() {
            if (this.f15637b.isEmpty()) {
                c();
                j jVar = this.f15638c;
                if (jVar != null) {
                    jVar.a();
                }
            }
        }

        private void c() {
            this.f15636a = false;
            this.f15637b.clear();
        }

        @Override // com.mobvoi.assistant.account.data.AccountManager.h
        public void a(f fVar, boolean z10) {
            if (this.f15636a) {
                this.f15637b.remove(fVar);
                com.mobvoi.android.common.utils.k.c("AccountManager", "Get a result from %s with success? %s, remain task %d", fVar, Boolean.valueOf(z10), Integer.valueOf(this.f15637b.size()));
                b();
            }
        }

        private i(List<f> list, j jVar) {
            ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
            this.f15637b = concurrentLinkedQueue;
            this.f15636a = true;
            concurrentLinkedQueue.addAll(list);
            this.f15638c = jVar;
            b();
        }
    }

    /* loaded from: classes2.dex */
    public interface j {
        void a();
    }

    /* loaded from: classes2.dex */
    public interface k {
        k a(AccountChangeEvent accountChangeEvent);

        void cancel();
    }

    /* loaded from: classes2.dex */
    public interface l {
        void a();
    }

    private AccountManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static rx.j e(ra.c cVar, List<f> list) {
        com.mobvoi.android.common.utils.k.a("AccountManager", "doLogoutAccount()");
        ua.a a10 = ra.h.a();
        return ra.h.b().c(ta.a.s()).Z(a10.b()).H(a10.a()).V(new e(cVar, list));
    }

    public static AccountManager h() {
        if (f15621d == null) {
            synchronized (AccountManager.class) {
                if (f15621d == null) {
                    f15621d = new AccountManager();
                }
            }
        }
        return f15621d;
    }

    public static rx.j i(Context context) {
        return j(context, null);
    }

    public static rx.j j(Context context, l lVar) {
        String s10 = ta.a.s();
        if (TextUtils.isEmpty(s10)) {
            return null;
        }
        return ra.h.b().j(s10, com.mobvoi.android.common.utils.e.e(context), AccountConstant.a()).Z(ra.h.a().b()).V(new a(context, lVar));
    }

    public static void k(Context context, l lVar) {
        ta.a.c();
        h().f();
        rx.c.s().H(ra.h.a().a()).o(new b(lVar, context)).T();
    }

    public static rx.j n(ra.c cVar) {
        com.mobvoi.android.common.utils.k.a("AccountManager", "logoutAccount()");
        rx.internal.util.i iVar = new rx.internal.util.i();
        iVar.a(dq.e.a(new d(h().m(new c(iVar, cVar)))));
        return iVar;
    }

    public void c(f fVar) {
        d(fVar, false);
    }

    public void d(f fVar, boolean z10) {
        this.f15622a.add(fVar);
        if (z10) {
            this.f15623b.add(fVar);
        }
    }

    public k f() {
        return new g(this.f15622a, null).a(AccountChangeEvent.OnForceLogout);
    }

    public sa.a g() {
        return ta.a.e();
    }

    public k l() {
        return new g(this.f15622a, null).b(null).a(AccountChangeEvent.OnLogin);
    }

    public k m(j jVar) {
        return new g(this.f15622a, null).b(new i(this.f15623b, jVar, null)).a(AccountChangeEvent.OnCleanUp);
    }

    public void o(sa.a aVar) {
        if (aVar != null) {
            synchronized (this.f15624c) {
                if (this.f15624c.size() > 0) {
                    for (int i10 = 0; i10 < this.f15624c.size(); i10++) {
                        ra.d dVar = this.f15624c.get(i10);
                        if (dVar != null) {
                            dVar.a(aVar);
                        }
                    }
                }
            }
        }
    }

    public void p(f fVar) {
        this.f15622a.remove(fVar);
        this.f15623b.remove(fVar);
    }

    public void q(boolean z10) {
    }
}
