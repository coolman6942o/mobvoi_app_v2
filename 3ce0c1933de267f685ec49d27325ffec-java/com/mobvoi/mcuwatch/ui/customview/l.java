package com.mobvoi.mcuwatch.ui.customview;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import sh.h;
import sh.i;
/* compiled from: CustomAutoQuitDialog.java */
/* loaded from: classes2.dex */
public class l extends Dialog {

    /* compiled from: CustomAutoQuitDialog.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Context f19665a;

        /* renamed from: b  reason: collision with root package name */
        private String f19666b;

        /* renamed from: c  reason: collision with root package name */
        private TextView f19667c;

        /* renamed from: d  reason: collision with root package name */
        private ImageView f19668d;

        /* renamed from: e  reason: collision with root package name */
        l f19669e;

        /* renamed from: f  reason: collision with root package name */
        private int f19670f = 1000;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: CustomAutoQuitDialog.java */
        /* renamed from: com.mobvoi.mcuwatch.ui.customview.l$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class animation.Animation$AnimationListenerC0225a implements Animation.AnimationListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ l f19671a;

            animation.Animation$AnimationListenerC0225a(a aVar, l lVar) {
                this.f19671a = lVar;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                this.f19671a.dismiss();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        }

        public a(Context context) {
            this.f19665a = context;
        }

        private Animation c(View view) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f19665a, sh.a.f34430c);
            loadAnimation.setInterpolator(new LinearInterpolator());
            loadAnimation.setDuration(this.f19670f);
            view.clearAnimation();
            view.startAnimation(loadAnimation);
            return loadAnimation;
        }

        public void a(View view, l lVar) {
            c(view).setAnimationListener(new animation.Animation$AnimationListenerC0225a(this, lVar));
        }

        public l b() {
            this.f19669e = new l(this.f19665a, sh.l.f34905c);
            View inflate = ((LayoutInflater) this.f19665a.getSystemService("layout_inflater")).inflate(i.N, (ViewGroup) null);
            this.f19669e.addContentView(inflate, new ViewGroup.LayoutParams(-1, -2));
            this.f19667c = (TextView) inflate.findViewById(h.f34653j2);
            this.f19668d = (ImageView) inflate.findViewById(h.f34644h1);
            String str = this.f19666b;
            if (str != null) {
                this.f19667c.setText(str);
            }
            this.f19669e.setCanceledOnTouchOutside(false);
            this.f19669e.setCancelable(false);
            this.f19669e.setContentView(inflate);
            a(inflate, this.f19669e);
            return this.f19669e;
        }

        public void d(int i10) {
            ImageView imageView = this.f19668d;
            if (imageView != null) {
                imageView.setImageResource(i10);
            }
        }

        public void e(String str) {
            TextView textView = this.f19667c;
            if (textView != null) {
                textView.setText(str);
            }
        }

        public void f(boolean z10) {
            if (z10) {
                TextView textView = this.f19667c;
                if (textView != null) {
                    textView.setVisibility(0);
                    return;
                }
                return;
            }
            TextView textView2 = this.f19667c;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        }
    }

    public l(Context context, int i10) {
        super(context, i10);
    }
}
