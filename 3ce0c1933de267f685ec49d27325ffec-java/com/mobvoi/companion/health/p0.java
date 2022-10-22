package com.mobvoi.companion.health;

import android.content.Context;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.assistant.account.data.AccountManager;
import com.unionpay.tsmservice.data.Constant;
import ig.b;
import nf.j;
import nf.l;
/* compiled from: HealthAccountChangeListener.java */
/* loaded from: classes2.dex */
public class p0 implements AccountManager.f {

    /* renamed from: a  reason: collision with root package name */
    private l f16917a;

    /* compiled from: HealthAccountChangeListener.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f16918a;

        static {
            int[] iArr = new int[AccountManager.AccountChangeEvent.values().length];
            f16918a = iArr;
            try {
                iArr[AccountManager.AccountChangeEvent.OnLogin.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16918a[AccountManager.AccountChangeEvent.OnLogout.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16918a[AccountManager.AccountChangeEvent.OnCleanUp.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public p0(Context context) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(AccountManager.h hVar, Boolean bool) {
        Object[] objArr = new Object[1];
        objArr[0] = bool.booleanValue() ? Constant.CASH_LOAD_SUCCESS : "failed";
        k.i("health.AccountChange", "Logout sync %s", objArr);
        if (hVar != null) {
            hVar.a(this, bool.booleanValue());
        }
    }

    private void c(final AccountManager.h hVar) {
        this.f16917a = j.b(b.J().A(), new j.a() { // from class: com.mobvoi.companion.health.o0
            @Override // nf.j.a
            public final void call(Object obj) {
                p0.this.b(hVar, (Boolean) obj);
            }
        });
    }

    @Override // com.mobvoi.assistant.account.data.AccountManager.f
    public void onCancel() {
        l lVar = this.f16917a;
        if (lVar != null) {
            lVar.clear();
        }
    }

    @Override // com.mobvoi.assistant.account.data.AccountManager.f
    public void onEvent(AccountManager.AccountChangeEvent accountChangeEvent, AccountManager.h hVar) {
        int i10 = a.f16918a[accountChangeEvent.ordinal()];
        if (i10 == 2 || i10 == 3) {
            c(hVar);
        }
    }
}
