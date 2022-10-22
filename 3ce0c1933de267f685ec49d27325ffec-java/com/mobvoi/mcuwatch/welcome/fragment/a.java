package com.mobvoi.mcuwatch.welcome.fragment;

import android.content.Context;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.mobvoi.mcuwatch.welcome.InitialQuestionsActivity;
import kotlin.jvm.internal.i;
/* compiled from: QuestionBaseFragment.kt */
/* loaded from: classes2.dex */
public class a extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private InitialQuestionsActivity f20292a;

    public final InitialQuestionsActivity Y() {
        return this.f20292a;
    }

    public final boolean Z(Context context) {
        i.f(context, "context");
        return !com.mobvoi.companion.base.settings.a.isUnitMetric(context);
    }

    public final void a0(int i10) {
        InitialQuestionsActivity initialQuestionsActivity = this.f20292a;
        if (initialQuestionsActivity != null) {
            Toast.makeText(initialQuestionsActivity, getString(i10), 0).show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        i.f(context, "context");
        super.onAttach(context);
        if (context instanceof com.mobvoi.companion.base.m3.a) {
            this.f20292a = (InitialQuestionsActivity) context;
        }
    }
}
