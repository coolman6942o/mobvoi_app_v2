package com.mobvoi.companion.map;

import android.view.View;
/* compiled from: IMapView.java */
/* loaded from: classes2.dex */
public interface i {

    /* compiled from: IMapView.java */
    /* loaded from: classes2.dex */
    public interface a {
        void d(h hVar);
    }

    void a(a aVar);

    View getView();

    void onDestroy();

    void onPause();

    void onResume();

    void release();
}
