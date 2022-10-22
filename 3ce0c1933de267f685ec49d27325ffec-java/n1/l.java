package n1;

import android.view.ViewGroup;
/* compiled from: Scene.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private ViewGroup f30937a;

    /* renamed from: b  reason: collision with root package name */
    private Runnable f30938b;

    public static l b(ViewGroup viewGroup) {
        return (l) viewGroup.getTag(j.f30917c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(ViewGroup viewGroup, l lVar) {
        viewGroup.setTag(j.f30917c, lVar);
    }

    public void a() {
        Runnable runnable;
        if (b(this.f30937a) == this && (runnable = this.f30938b) != null) {
            runnable.run();
        }
    }
}
