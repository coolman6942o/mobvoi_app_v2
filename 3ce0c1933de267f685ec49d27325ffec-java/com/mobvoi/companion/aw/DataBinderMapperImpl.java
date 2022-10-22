package com.mobvoi.companion.aw;

import android.util.SparseIntArray;
import androidx.databinding.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class DataBinderMapperImpl extends d {
    static {
        new SparseIntArray(0);
    }

    @Override // androidx.databinding.d
    public List<d> a() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }
}
