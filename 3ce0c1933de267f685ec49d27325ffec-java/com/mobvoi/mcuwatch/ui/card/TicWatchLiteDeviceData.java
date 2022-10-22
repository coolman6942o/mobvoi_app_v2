package com.mobvoi.mcuwatch.ui.card;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.fragment.app.f;
import androidx.lifecycle.o;
import androidx.lifecycle.p;
import com.mobvoi.mcuwatch.ui.bledialog.BleOpenHandler;
import java.lang.ref.WeakReference;
import pc.d;
import pi.a;
import qi.w;
import sh.k;
/* loaded from: classes2.dex */
public class TicWatchLiteDeviceData implements d, BleOpenHandler.c, o {

    /* renamed from: a  reason: collision with root package name */
    private a f19465a;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Activity> f19466b;

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<w> f19467c;

    /* renamed from: d  reason: collision with root package name */
    private SparseIntArray f19468d = new SparseIntArray();

    /* renamed from: e  reason: collision with root package name */
    private BleOpenHandler f19469e;

    /* renamed from: f  reason: collision with root package name */
    private p f19470f;

    public TicWatchLiteDeviceData(a aVar, Activity activity, w wVar, p pVar) {
        this.f19465a = aVar;
        this.f19466b = new WeakReference<>(activity);
        this.f19467c = new WeakReference<>(wVar);
        this.f19470f = pVar;
        k();
    }

    private void k() {
        this.f19468d.put(1, 1);
        this.f19468d.put(2, 5);
        this.f19468d.put(0, 3);
        this.f19468d.put(3, -1);
    }

    private void m(Activity activity) {
        if (this.f19469e == null) {
            this.f19469e = new BleOpenHandler(activity, this, this.f19470f.getLifecycle());
        }
        this.f19469e.n();
    }

    @Override // com.mobvoi.mcuwatch.ui.bledialog.BleOpenHandler.c
    public void A() {
        d();
    }

    @Override // pc.d
    public void d() {
        Activity activity;
        w wVar;
        if (this.f19465a != null && !ci.a.b().f(this.f19465a.macAddress) && (activity = this.f19466b.get()) != null && (activity instanceof f) && (wVar = this.f19467c.get()) != null) {
            if (wVar.n()) {
                wVar.z((f) activity, this.f19465a.macAddress);
            } else {
                m(activity);
            }
        }
    }

    @Override // pc.d
    @SuppressLint({"SwitchIntDef"})
    public String h() {
        Activity activity = this.f19466b.get();
        if (activity == null) {
            return null;
        }
        a aVar = this.f19465a;
        if (aVar == null || aVar.macAddress == null) {
            return activity.getString(k.R);
        }
        fi.a a10 = ci.a.b().a(this.f19465a.macAddress);
        if (a10 == null) {
            return activity.getString(k.R);
        }
        int c10 = a10.c();
        if (c10 == 1) {
            return activity.getString(k.T);
        }
        if (c10 != 2) {
            return activity.getString(k.R);
        }
        return activity.getString(k.U);
    }

    @Override // pc.d
    public int j() {
        fi.a a10;
        if (this.f19465a == null || (a10 = ci.a.b().a(this.f19465a.macAddress)) == null) {
            return 0;
        }
        return this.f19468d.get(a10.c());
    }

    public void l(a aVar) {
        this.f19465a = aVar;
        if (aVar != null && !TextUtils.isEmpty(aVar.macAddress)) {
            d();
        }
    }
}
