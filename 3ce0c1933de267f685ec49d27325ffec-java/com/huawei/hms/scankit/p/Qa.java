package com.huawei.hms.scankit.p;

import android.os.Bundle;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.util.a;
import java.util.UUID;
/* compiled from: HaLog60000.java */
/* loaded from: classes2.dex */
public final class Qa extends Za {

    /* renamed from: h  reason: collision with root package name */
    private int f14619h = -1001;

    /* renamed from: i  reason: collision with root package name */
    protected String f14620i = Za.f14722a;

    /* renamed from: j  reason: collision with root package name */
    protected String f14621j = Za.f14723b;

    public Qa(Bundle bundle, String str) {
        super(bundle, DynamicModuleInitializer.getContext().getApplicationContext());
        this.f14727f.put("callTime", new Oa(this, "yyyyMMddHHmmss.SSS").format(Long.valueOf(System.currentTimeMillis())));
        this.f14727f.put("transId", UUID.randomUUID().toString());
        this.f14727f.put("apiName", str);
    }

    private void f() {
        this.f14619h = -1001;
        this.f14620i = Za.f14722a;
        this.f14621j = Za.f14723b;
    }

    public void a(HmsScan[] hmsScanArr) {
        if (hmsScanArr != null) {
            this.f14619h = hmsScanArr.length;
            for (HmsScan hmsScan : hmsScanArr) {
                this.f14620i = Za.a(hmsScan.scanType);
                this.f14621j = Za.b(hmsScan.scanTypeForm);
            }
        }
    }

    public void b() {
        this.f14728g = System.currentTimeMillis();
    }

    public void c() {
        try {
            if (a()) {
                Pa pa2 = new Pa(this);
                pa2.put("result", String.valueOf(this.f14619h));
                pa2.put("costTime", String.valueOf(System.currentTimeMillis() - this.f14728g));
                pa2.put("scanType", this.f14620i);
                pa2.put("sceneType", this.f14621j);
                C0569bb.a().a("60000", pa2);
                f();
            }
        } catch (NullPointerException unused) {
            a.b("HaLog60000", "nullPoint");
        } catch (Exception unused2) {
            a.b("HaLog60000", "logEnd Exception");
        }
    }

    public void c(int i10) {
        this.f14619h = i10;
    }
}
