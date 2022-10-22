package com.mobvoi.companion.map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.Handler;
import cd.d;
import cd.f;
import com.google.android.gms.maps.a;
import com.google.android.gms.maps.model.Dot;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.mobvoi.companion.map.g;
import com.mobvoi.companion.map.h;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import x6.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GoogleMapImpl.java */
/* loaded from: classes2.dex */
public class c implements h<a>, g.a {

    /* renamed from: a  reason: collision with root package name */
    private a f17261a;

    /* renamed from: b  reason: collision with root package name */
    private i f17262b;

    /* renamed from: c  reason: collision with root package name */
    private h.a f17263c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f17264d;

    /* renamed from: e  reason: collision with root package name */
    private Context f17265e;

    /* renamed from: f  reason: collision with root package name */
    private z6.c f17266f;

    /* renamed from: g  reason: collision with root package name */
    private g f17267g;

    /* renamed from: h  reason: collision with root package name */
    private Handler f17268h = new Handler();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(LatLngBounds latLngBounds) {
        if (this.f17264d) {
            int height = this.f17262b.getView().getHeight();
            this.f17261a.f(b.b(latLngBounds, this.f17262b.getView().getWidth(), height / 2, 50));
            this.f17261a.f(b.d(0.0f, height / 5));
            return;
        }
        this.f17261a.f(b.a(latLngBounds, 0));
    }

    private void s(LatLng latLng) {
        z6.c cVar = this.f17266f;
        if (cVar != null) {
            cVar.a();
            this.f17266f = null;
        }
        z6.c a10 = this.f17261a.a(new MarkerOptions().W0(latLng).G0(0.5f, 0.5f).S0(z6.b.a(BitmapFactory.decodeResource(this.f17265e.getResources(), dd.a.a_res_0x7f08013a))));
        this.f17266f = a10;
        a10.b(latLng);
    }

    private void u() {
        if (this.f17267g != null) {
            e(false);
            this.f17267g.b(this);
            this.f17267g = null;
        }
    }

    @Override // com.mobvoi.companion.map.g.a
    public boolean a(Location location) {
        return this.f17263c.a(location);
    }

    @Override // com.mobvoi.companion.map.g.a
    public void b(final j jVar) {
        this.f17268h.post(new Runnable() { // from class: com.mobvoi.companion.map.b
            @Override // java.lang.Runnable
            public final void run() {
                c.this.q(jVar);
            }
        });
    }

    @Override // com.mobvoi.companion.map.h
    public void clear() {
        this.f17261a.d();
    }

    @Override // com.mobvoi.companion.map.h
    @SuppressLint({"MissingPermission"})
    public void e(boolean z10) {
        this.f17261a.g(z10);
    }

    @Override // com.mobvoi.companion.map.h
    public void f(f fVar, Bitmap bitmap) {
        this.f17261a.a(new MarkerOptions().G0(0.5f, this.f17264d ? 1.0f : 0.5f).W0(new LatLng(fVar.f5722a, fVar.f5723b)).H0(false).S0(z6.b.a(bitmap)));
    }

    @Override // com.mobvoi.companion.map.h
    public void g(double[] dArr) {
        final LatLngBounds a10 = new LatLngBounds.a().b(new LatLng(dArr[0], dArr[2])).b(new LatLng(dArr[0], dArr[3])).b(new LatLng(dArr[1], dArr[2])).b(new LatLng(dArr[1], dArr[3])).a();
        this.f17261a.h(new a.AbstractC0115a() { // from class: com.mobvoi.companion.map.a
            @Override // com.google.android.gms.maps.a.AbstractC0115a
            public final void q() {
                c.this.p(a10);
            }
        });
    }

    @Override // com.mobvoi.companion.map.h
    public void h(f fVar, Bitmap bitmap) {
        this.f17261a.a(new MarkerOptions().G0(0.5f, this.f17264d ? 1.0f : 0.5f).W0(new LatLng(fVar.f5722a, fVar.f5723b)).H0(false).S0(z6.b.a(bitmap)));
    }

    @Override // com.mobvoi.companion.map.h
    public void i(List<d> list, int i10, int i11, int i12, boolean z10) {
        PolylineOptions U0 = new PolylineOptions().H0(i10).U0(i11);
        if (z10) {
            U0.T0(Collections.singletonList(new Dot()));
        }
        for (d dVar : list) {
            U0.G0(new LatLng(dVar.f5720b, dVar.f5719a));
        }
        this.f17261a.c(U0);
    }

    @Override // com.mobvoi.companion.map.h
    public void j(h.a aVar) {
        this.f17263c = aVar;
    }

    @Override // com.mobvoi.companion.map.h
    public void k(f fVar) {
        this.f17261a.a(new MarkerOptions().G0(0.5f, 0.5f).W0(new LatLng(fVar.f5722a, fVar.f5723b)).H0(false).S0(z6.b.a(fVar.a())));
    }

    @Override // com.mobvoi.companion.map.h
    public void l(int i10) {
        double d10 = -80.0f;
        double d11 = -170.0f;
        double d12 = 170.0f;
        double d13 = 80.0f;
        this.f17261a.b(new PolygonOptions().G0(Arrays.asList(new LatLng(90.0d, -180.0d), new LatLng(d10, d11), new LatLng(d10, 0.0d), new LatLng(d10, d12), new LatLng(0.0d, d12), new LatLng(d13, d12), new LatLng(d13, 0.0d), new LatLng(d13, d11), new LatLng(0.0d, d11))).H0(i10).S0(0.0f).T0(0.0f));
    }

    @Override // com.mobvoi.companion.map.h
    public void m(Context context) {
        o();
        this.f17264d = true;
        e(false);
        t();
    }

    public h<a> n(a aVar, i iVar) {
        this.f17261a = aVar;
        this.f17262b = iVar;
        this.f17265e = iVar.getView().getContext();
        return this;
    }

    public void o() {
        this.f17261a.e().d(true);
        this.f17261a.e().c(true);
        this.f17261a.e().a(false);
    }

    @Override // com.mobvoi.companion.map.h
    public void onDestroy() {
        u();
    }

    @Override // com.mobvoi.companion.map.h
    public void onStop() {
        u();
    }

    /* renamed from: r */
    public void q(j jVar) {
        i iVar = this.f17262b;
        if (iVar != null && iVar.getView() != null) {
            if (cd.a.b(jVar.f17284b, jVar.f17283a)) {
                e(true);
            } else {
                e(false);
                double[] a10 = cd.a.a(jVar.f17284b, jVar.f17283a);
                jVar.f17284b = a10[0];
                jVar.f17283a = a10[1];
                s(new LatLng(jVar.f17284b, jVar.f17283a));
            }
            this.f17261a.f(b.c(new LatLng(jVar.f17284b, jVar.f17283a), 18.0f));
            this.f17261a.f(b.d(0.0f, this.f17262b.getView().getHeight() / 4));
            if (this.f17263c.c()) {
                this.f17263c.b(jVar);
            }
        }
    }

    protected void t() {
        if (this.f17267g == null) {
            g b10 = cd.g.b().a().b();
            this.f17267g = b10;
            b10.a(this.f17265e, this);
        }
    }
}
