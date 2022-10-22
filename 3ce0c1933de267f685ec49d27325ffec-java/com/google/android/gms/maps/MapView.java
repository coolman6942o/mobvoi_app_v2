package com.google.android.gms.maps;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import b6.i;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;
import k6.c;
import k6.e;
import x6.d;
import y6.l;
import y6.m;
/* loaded from: classes.dex */
public class MapView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final b f9992a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements c {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f9993a;

        /* renamed from: b  reason: collision with root package name */
        private final y6.c f9994b;

        /* renamed from: c  reason: collision with root package name */
        private View f9995c;

        public a(ViewGroup viewGroup, y6.c cVar) {
            this.f9994b = (y6.c) i.k(cVar);
            this.f9993a = (ViewGroup) i.k(viewGroup);
        }

        public final void a(d dVar) {
            try {
                this.f9994b.G0(new d(this, dVar));
            } catch (RemoteException e10) {
                throw new RuntimeRemoteException(e10);
            }
        }

        @Override // k6.c
        public final void onCreate(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                l.b(bundle, bundle2);
                this.f9994b.onCreate(bundle2);
                l.b(bundle2, bundle);
                this.f9995c = (View) k6.d.U1(this.f9994b.getView());
                this.f9993a.removeAllViews();
                this.f9993a.addView(this.f9995c);
            } catch (RemoteException e10) {
                throw new RuntimeRemoteException(e10);
            }
        }

        @Override // k6.c
        public final void onDestroy() {
            try {
                this.f9994b.onDestroy();
            } catch (RemoteException e10) {
                throw new RuntimeRemoteException(e10);
            }
        }

        @Override // k6.c
        public final void onPause() {
            try {
                this.f9994b.onPause();
            } catch (RemoteException e10) {
                throw new RuntimeRemoteException(e10);
            }
        }

        @Override // k6.c
        public final void onResume() {
            try {
                this.f9994b.onResume();
            } catch (RemoteException e10) {
                throw new RuntimeRemoteException(e10);
            }
        }
    }

    /* loaded from: classes.dex */
    static class b extends k6.a<a> {

        /* renamed from: e  reason: collision with root package name */
        private final ViewGroup f9996e;

        /* renamed from: f  reason: collision with root package name */
        private final Context f9997f;

        /* renamed from: g  reason: collision with root package name */
        private e<a> f9998g;

        /* renamed from: h  reason: collision with root package name */
        private final GoogleMapOptions f9999h;

        /* renamed from: i  reason: collision with root package name */
        private final List<d> f10000i = new ArrayList();

        b(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
            this.f9996e = viewGroup;
            this.f9997f = context;
            this.f9999h = googleMapOptions;
        }

        @Override // k6.a
        protected final void a(e<a> eVar) {
            this.f9998g = eVar;
            if (eVar != null && b() == null) {
                try {
                    x6.c.a(this.f9997f);
                    y6.c X = m.c(this.f9997f).X(k6.d.A2(this.f9997f), this.f9999h);
                    if (X != null) {
                        this.f9998g.a(new a(this.f9996e, X));
                        for (d dVar : this.f10000i) {
                            b().a(dVar);
                        }
                        this.f10000i.clear();
                    }
                } catch (RemoteException e10) {
                    throw new RuntimeRemoteException(e10);
                } catch (GooglePlayServicesNotAvailableException unused) {
                }
            }
        }

        public final void n(d dVar) {
            if (b() != null) {
                b().a(dVar);
            } else {
                this.f10000i.add(dVar);
            }
        }
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9992a = new b(this, context, GoogleMapOptions.J0(context, attributeSet));
        setClickable(true);
    }

    public void a(d dVar) {
        i.f("getMapAsync() must be called on the main thread");
        this.f9992a.n(dVar);
    }

    public final void b(Bundle bundle) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            this.f9992a.c(bundle);
            if (this.f9992a.b() == null) {
                k6.a.g(this);
            }
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public final void c() {
        this.f9992a.d();
    }

    public final void d() {
        this.f9992a.e();
    }

    public final void e() {
        this.f9992a.f();
    }
}
