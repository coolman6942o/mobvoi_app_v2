package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Map;
import n1.m;
import n1.s;
/* compiled from: TextScale.java */
/* loaded from: classes.dex */
public class i extends m {

    /* compiled from: TextScale.java */
    /* loaded from: classes.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f11094a;

        a(i iVar, TextView textView) {
            this.f11094a = textView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f11094a.setScaleX(floatValue);
            this.f11094a.setScaleY(floatValue);
        }
    }

    private void c0(s sVar) {
        View view = sVar.f30987b;
        if (view instanceof TextView) {
            sVar.f30986a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // n1.m
    public void f(s sVar) {
        c0(sVar);
    }

    @Override // n1.m
    public void j(s sVar) {
        c0(sVar);
    }

    @Override // n1.m
    public Animator n(ViewGroup viewGroup, s sVar, s sVar2) {
        if (sVar == null || sVar2 == null || !(sVar.f30987b instanceof TextView)) {
            return null;
        }
        View view = sVar2.f30987b;
        if (!(view instanceof TextView)) {
            return null;
        }
        TextView textView = (TextView) view;
        Map<String, Object> map = sVar.f30986a;
        Map<String, Object> map2 = sVar2.f30986a;
        float f10 = 1.0f;
        float floatValue = map.get("android:textscale:scale") != null ? ((Float) map.get("android:textscale:scale")).floatValue() : 1.0f;
        if (map2.get("android:textscale:scale") != null) {
            f10 = ((Float) map2.get("android:textscale:scale")).floatValue();
        }
        if (floatValue == f10) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(floatValue, f10);
        ofFloat.addUpdateListener(new a(this, textView));
        return ofFloat;
    }
}
