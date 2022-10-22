package com.mobvoi.companion.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
/* compiled from: BaseWearableFragment.java */
@Deprecated
/* loaded from: classes2.dex */
public abstract class a extends Fragment {
    public abstract int Y();

    protected void Z(View view) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(Y(), viewGroup, false);
        Z(inflate);
        return inflate;
    }
}
