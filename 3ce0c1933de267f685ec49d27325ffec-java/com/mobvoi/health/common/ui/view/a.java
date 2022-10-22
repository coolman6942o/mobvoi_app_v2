package com.mobvoi.health.common.ui.view;

import android.content.Context;
import android.util.SparseArray;
import com.mobvoi.health.common.ui.view.HistogramView;
import com.mobvoi.health.common.ui.view.ProgressView;
import java.util.ArrayList;
import java.util.List;
import mf.b;
import mf.d;
/* compiled from: StyleFactory.java */
/* loaded from: classes2.dex */
public class a {
    public static List<HistogramView.b> a(int i10) {
        return b(i10, false);
    }

    public static List<HistogramView.b> b(int i10, boolean z10) {
        return c(i10, i10 / 4, i10 / 24, z10);
    }

    private static List<HistogramView.b> c(int i10, int i11, int i12, boolean z10) {
        ArrayList arrayList = new ArrayList();
        int i13 = 0;
        while (i13 < i10) {
            HistogramView.b bVar = new HistogramView.b();
            int i14 = i13 + 1;
            if (i14 % i11 == 0) {
                bVar.f18014c = String.valueOf(i14 / i12);
                if (i13 != i10 - 1) {
                    bVar.f18013b = true;
                }
            } else if (i13 == 0) {
                bVar.f18014c = String.valueOf(i13);
            }
            arrayList.add(bVar);
            i13 = i14;
        }
        return arrayList;
    }

    public static SparseArray<ProgressView.d> d(Context context) {
        SparseArray<ProgressView.d> sparseArray = new SparseArray<>();
        ProgressView.d dVar = new ProgressView.d();
        dVar.f18066d = context.getResources().getColor(b.f30665c);
        dVar.f18068f = context.getString(d.f30718o1);
        sparseArray.append(0, dVar);
        ProgressView.d dVar2 = new ProgressView.d();
        dVar2.f18066d = context.getResources().getColor(b.f30666d);
        dVar2.f18068f = context.getString(d.f30721p1);
        sparseArray.append(1, dVar2);
        ProgressView.d dVar3 = new ProgressView.d();
        dVar3.f18066d = context.getResources().getColor(b.f30663a);
        dVar3.f18068f = context.getString(d.f30715n1);
        sparseArray.append(2, dVar3);
        return sparseArray;
    }
}
