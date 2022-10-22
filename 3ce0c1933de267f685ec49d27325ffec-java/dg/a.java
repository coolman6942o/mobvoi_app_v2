package dg;

import android.os.SystemClock;
import android.view.View;
/* compiled from: OnSampleClickListener.java */
/* loaded from: classes2.dex */
public abstract class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private long f25611a = 2000;

    /* renamed from: b  reason: collision with root package name */
    private long f25612b = -1;

    public abstract void a(View view);

    @Override // android.view.View.OnClickListener
    @Deprecated
    public void onClick(View view) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - this.f25612b >= this.f25611a) {
            a(view);
            this.f25612b = elapsedRealtime;
        }
    }
}
