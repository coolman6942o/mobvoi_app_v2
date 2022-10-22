package com.mobvoi.companion.health;

import com.mobvoi.android.common.utils.k;
import com.mobvoi.assistant.account.data.AccountManager;
import hf.o;
import yg.f;
/* compiled from: SportAccountChangeListener.java */
/* loaded from: classes2.dex */
public class m3 implements AccountManager.f {

    /* renamed from: a  reason: collision with root package name */
    private boolean f16886a = false;

    /* compiled from: SportAccountChangeListener.java */
    /* loaded from: classes2.dex */
    class a implements o<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountManager.h f16887a;

        a(AccountManager.h hVar) {
            this.f16887a = hVar;
        }

        /* renamed from: b */
        public void a(Boolean bool, Throwable th2) {
            if (!m3.this.f16886a) {
                boolean z10 = bool != null && bool.booleanValue();
                if (z10) {
                    k.h("fit.AccountChange", "Logout sync success, clear all records");
                    f.X().k();
                } else {
                    k.h("fit.AccountChange", "Logout sync failed.");
                }
                AccountManager.h hVar = this.f16887a;
                if (hVar != null) {
                    hVar.a(m3.this, z10);
                }
            }
        }
    }

    /* compiled from: SportAccountChangeListener.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f16889a;

        static {
            int[] iArr = new int[AccountManager.AccountChangeEvent.values().length];
            f16889a = iArr;
            try {
                iArr[AccountManager.AccountChangeEvent.OnLogin.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16889a[AccountManager.AccountChangeEvent.OnLogout.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16889a[AccountManager.AccountChangeEvent.OnCleanUp.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.mobvoi.assistant.account.data.AccountManager.f
    public void onCancel() {
        this.f16886a = true;
    }

    @Override // com.mobvoi.assistant.account.data.AccountManager.f
    public void onEvent(AccountManager.AccountChangeEvent accountChangeEvent, AccountManager.h hVar) {
        this.f16886a = false;
        int i10 = b.f16889a[accountChangeEvent.ordinal()];
        if (i10 == 2 || i10 == 3) {
            k.h("fit.AccountChange", "Logout, request a new sync.");
            f.X().L(new a(hVar));
        }
    }
}
