package n1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewGroupOverlayApi14.java */
/* loaded from: classes.dex */
public class u extends z implements w {
    /* JADX INFO: Access modifiers changed from: package-private */
    public u(Context context, ViewGroup viewGroup, View view) {
        super(context, viewGroup, view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static u g(ViewGroup viewGroup) {
        return (u) z.e(viewGroup);
    }

    @Override // n1.w
    public void c(View view) {
        this.f31000a.b(view);
    }

    @Override // n1.w
    public void d(View view) {
        this.f31000a.g(view);
    }
}
