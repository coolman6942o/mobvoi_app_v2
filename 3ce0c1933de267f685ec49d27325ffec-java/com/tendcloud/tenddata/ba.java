package com.tendcloud.tenddata;

import android.content.Context;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* compiled from: td */
/* loaded from: classes2.dex */
public final class ba {

    /* renamed from: a  reason: collision with root package name */
    public static CountDownLatch f22720a = new CountDownLatch(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: td */
    /* loaded from: classes2.dex */
    public static class a {
        private static ba instance = new ba();

        private a() {
        }
    }

    private void a(final Context context) {
        if (context != null) {
            try {
                s.f22998a.execute(new Runnable() { // from class: com.tendcloud.tenddata.ba.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (bp.a()) {
                                bp.reflectMSA(context);
                                try {
                                    ba.f22720a.await(2L, TimeUnit.SECONDS);
                                    if (!u.b(co.a().c())) {
                                        return;
                                    }
                                } catch (Throwable unused) {
                                }
                            }
                            if (bv.a()) {
                                bv.reflectMiUi(context);
                            } else if (bm.a(context)) {
                                bm.bindHWServiceGetOAID(context);
                            } else if (bt.a(context)) {
                                bt.bindSECServiceGetOAID(context);
                            } else if (bs.a(context)) {
                                bs.bindOPPOServiceGetOAID(context);
                            } else if (br.a(context)) {
                                br.bindONEPLUSServiceGetOAID(context);
                            } else if (bu.a()) {
                                bu.reflectVIVO(context);
                            } else if (bl.a(context)) {
                                bl.bindASUSServiceGetOAID(context);
                            } else if (bo.a(context)) {
                                bo.reflectMEiZU(context);
                            } else if (bw.a(context)) {
                                bw.bindZTEServiceGetOAID(context);
                            } else if (bn.a(context)) {
                                bn.bindLENOVOServiceGetOAID(context);
                            } else if (bq.a(context)) {
                                bq.reflectNUBIA(context);
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    private ba() {
        a(ab.f22568h);
    }

    public static ba a() {
        return a.instance;
    }
}
