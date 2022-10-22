package yd;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
/* compiled from: AnimatorUtil.java */
/* loaded from: classes2.dex */
public class a {
    public static void a(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "rotation", 0.0f, 360.0f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(1000L);
        ofFloat.start();
    }

    public static void b(ImageView imageView) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator duration = ObjectAnimator.ofFloat(imageView, "alpha", 0.0f, 1.0f).setDuration(1500L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, 1.08f).setDuration(5000L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, 1.08f).setDuration(5000L);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(imageView, "alpha", 1.0f, 0.0f).setDuration(3500L);
        animatorSet.playTogether(duration2, duration3);
        animatorSet.playSequentially(duration, duration4);
        animatorSet.start();
    }
}
