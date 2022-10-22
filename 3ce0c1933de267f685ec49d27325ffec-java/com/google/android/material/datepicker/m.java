package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;
/* compiled from: PickerFragment.java */
/* loaded from: classes.dex */
abstract class m<S> extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    protected final LinkedHashSet<l<S>> f10854a = new LinkedHashSet<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Y(l<S> lVar) {
        return this.f10854a.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z() {
        this.f10854a.clear();
    }
}
