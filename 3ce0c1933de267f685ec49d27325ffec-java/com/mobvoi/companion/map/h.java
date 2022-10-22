package com.mobvoi.companion.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import cd.d;
import cd.f;
import java.util.List;
/* compiled from: IMap.java */
/* loaded from: classes2.dex */
public interface h<T> {

    /* compiled from: IMap.java */
    /* loaded from: classes2.dex */
    public interface a {
        boolean a(Location location);

        void b(j jVar);

        boolean c();
    }

    void clear();

    void e(boolean z10);

    void f(f fVar, Bitmap bitmap);

    void g(double[] dArr);

    void h(f fVar, Bitmap bitmap);

    void i(List<d> list, int i10, int i11, int i12, boolean z10);

    void j(a aVar);

    void k(f fVar);

    void l(int i10);

    void m(Context context);

    void onDestroy();

    void onStop();
}
