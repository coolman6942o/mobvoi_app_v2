package com.bjleisen.iface.sdk.apdu;

import android.content.Context;
import com.bjleisen.iface.sdk.bean.Capdu;
import com.bjleisen.iface.sdk.bean.Rapdu;
import java.util.ArrayList;
import java.util.List;
/* compiled from: ApduRequest.java */
/* loaded from: classes.dex */
public abstract class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    protected static final int f7738a = 0;

    /* renamed from: b  reason: collision with root package name */
    protected static final int f7739b = 1;

    /* renamed from: c  reason: collision with root package name */
    protected Context f7740c;

    /* renamed from: d  reason: collision with root package name */
    protected List<Capdu> f7741d;

    /* renamed from: e  reason: collision with root package name */
    protected List<Rapdu> f7742e;

    /* renamed from: f  reason: collision with root package name */
    protected d f7743f;

    /* renamed from: h  reason: collision with root package name */
    protected Capdu f7745h;

    /* renamed from: g  reason: collision with root package name */
    protected int f7744g = 0;

    /* renamed from: i  reason: collision with root package name */
    protected boolean f7746i = false;

    /* renamed from: j  reason: collision with root package name */
    protected boolean f7747j = false;

    public c(Context context, d dVar) {
        this.f7740c = context;
        this.f7743f = dVar;
    }

    private void d() {
        this.f7745h = null;
        this.f7744g = 0;
        this.f7746i = false;
        this.f7747j = false;
    }

    protected abstract void a();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i10, String str, String str2) {
        this.f7742e.add(new Rapdu(i10, str, str2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        this.f7746i = true;
    }

    public final void c() {
        this.f7747j = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
    }

    private void b(int i10, Error error) {
        d();
        d dVar = this.f7743f;
        if (dVar != null) {
            dVar.a(i10, this.f7742e, error);
        }
    }

    public final void a(List<Capdu> list) {
        List<Capdu> list2 = this.f7741d;
        if (list2 == null) {
            this.f7741d = new ArrayList();
        } else {
            list2.clear();
        }
        this.f7741d.addAll(list);
        List<Rapdu> list3 = this.f7742e;
        if (list3 == null) {
            this.f7742e = new ArrayList();
        } else {
            list3.clear();
        }
    }

    public final void a(Capdu capdu) {
        List<Capdu> list = this.f7741d;
        if (list == null) {
            this.f7741d = new ArrayList();
        } else {
            list.clear();
        }
        this.f7741d.add(capdu);
        List<Rapdu> list2 = this.f7742e;
        if (list2 == null) {
            this.f7742e = new ArrayList();
        } else {
            list2.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i10) {
        d();
        d dVar = this.f7743f;
        if (dVar != null) {
            dVar.a(i10, this.f7742e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Rapdu rapdu) {
        d();
        d dVar = this.f7743f;
        if (dVar != null) {
            dVar.a(rapdu);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i10, Error error) {
        d();
        d dVar = this.f7743f;
        if (dVar != null) {
            dVar.a(i10, error);
        }
    }

    private void a(Runnable runnable, long j10) {
        d dVar = this.f7743f;
        if (dVar != null) {
            dVar.a(runnable, j10);
        }
    }
}
