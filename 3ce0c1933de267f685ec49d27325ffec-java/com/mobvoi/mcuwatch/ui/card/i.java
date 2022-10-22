package com.mobvoi.mcuwatch.ui.card;

import com.mobvoi.assistant.account.data.AccountManager;
import com.mobvoi.companion.setting.CompanionSetting;
import fi.a;
import qi.w;
import rx.c;
import rx.d;
import sa.b;
import yp.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WatchLiteCardViewModel.java */
/* loaded from: classes2.dex */
public class i extends w {

    /* renamed from: e  reason: collision with root package name */
    private androidx.lifecycle.w<Boolean> f19503e = new androidx.lifecycle.w<>();

    /* compiled from: WatchLiteCardViewModel.java */
    /* loaded from: classes2.dex */
    class a implements d<b> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f19504a;

        a(boolean z10) {
            this.f19504a = z10;
        }

        /* renamed from: b */
        public void onNext(b bVar) {
            if (bVar.errorCode == 0) {
                CompanionSetting.setArtyAuthorizeStatus(this.f19504a);
                i.this.f19503e.m(Boolean.TRUE);
                return;
            }
            i.this.f19503e.m(Boolean.FALSE);
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            i.this.f19503e.m(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean K(Object obj) {
        return Boolean.valueOf(obj instanceof fi.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ fi.a L(Object obj) {
        return (fi.a) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean M(String str, fi.a aVar) {
        boolean z10 = true;
        if (aVar.c() != 1 || !aVar.d(str)) {
            z10 = false;
        }
        return Boolean.valueOf(z10);
    }

    public void H(boolean z10) {
        com.mobvoi.assistant.account.data.a.v().t(AccountManager.h().g().sessionId, z10).Z(cq.a.c()).H(xp.a.b()).U(new a(z10));
    }

    public androidx.lifecycle.w<Boolean> I() {
        return this.f19503e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c<Boolean> J(final String str) {
        return ci.a.b().c().u(g.f19501a).D(h.f19502a).D(new g() { // from class: com.mobvoi.mcuwatch.ui.card.f
            @Override // yp.g
            public final Object call(Object obj) {
                Boolean M;
                M = i.M(str, (a) obj);
                return M;
            }
        });
    }
}
