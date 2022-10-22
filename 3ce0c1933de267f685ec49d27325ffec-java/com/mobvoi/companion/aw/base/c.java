package com.mobvoi.companion.aw.base;

import com.mobvoi.companion.aw.base.App;
import java.io.File;
import java.util.Comparator;
/* loaded from: classes2.dex */
public final /* synthetic */ class c implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ c f16166a = new c();

    private /* synthetic */ c() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int d10;
        d10 = App.b.a.d((File) obj, (File) obj2);
        return d10;
    }
}
