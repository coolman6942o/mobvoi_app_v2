package com.mobvoi.companion.map;

import android.view.View;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.a;
import com.mobvoi.companion.map.f;
import com.mobvoi.companion.map.i;
import x6.d;
/* compiled from: GoogleMapViewImpl.java */
/* loaded from: classes2.dex */
public class f implements i {

    /* renamed from: a  reason: collision with root package name */
    private MapView f17280a;

    /* renamed from: b  reason: collision with root package name */
    private h<a> f17281b;

    /* renamed from: c  reason: collision with root package name */
    private i.a f17282c;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void e(a aVar) {
        aVar.e().d(false);
        aVar.e().c(false);
        aVar.e().b(false);
        h<a> n10 = new c().n(aVar, this);
        this.f17281b = n10;
        i.a aVar2 = this.f17282c;
        if (aVar2 != null) {
            aVar2.d(n10);
        }
    }

    @Override // com.mobvoi.companion.map.i
    public void a(i.a aVar) {
        this.f17282c = aVar;
        h<a> hVar = this.f17281b;
        if (hVar != null) {
            aVar.d(hVar);
        }
    }

    public i d(View view, int i10) {
        MapView mapView = (MapView) view.findViewById(i10);
        this.f17280a = mapView;
        mapView.b(null);
        this.f17280a.setClickable(false);
        this.f17280a.a(new d() { // from class: cd.c
            @Override // x6.d
            public final void a(a aVar) {
                f.this.e(aVar);
            }
        });
        return this;
    }

    @Override // com.mobvoi.companion.map.i
    public View getView() {
        return this.f17280a;
    }

    @Override // com.mobvoi.companion.map.i
    public void onDestroy() {
        this.f17280a.c();
    }

    @Override // com.mobvoi.companion.map.i
    public void onPause() {
        this.f17280a.d();
    }

    @Override // com.mobvoi.companion.map.i
    public void onResume() {
        this.f17280a.e();
    }

    @Override // com.mobvoi.companion.map.i
    public void release() {
        this.f17280a = null;
    }
}
