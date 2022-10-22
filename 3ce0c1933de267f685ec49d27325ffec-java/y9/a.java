package y9;

import android.os.SystemClock;
import android.view.View;
/* compiled from: MultiTapOnClickListener.java */
/* loaded from: classes2.dex */
public abstract class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final int f36800a;

    /* renamed from: b  reason: collision with root package name */
    private final long f36801b;

    /* renamed from: c  reason: collision with root package name */
    private int f36802c;

    /* renamed from: d  reason: collision with root package name */
    private long f36803d;

    public a(int i10) {
        this(i10, 800L);
    }

    public abstract void a(View view);

    public void b() {
        this.f36802c = 0;
        this.f36803d = 0L;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j10 = this.f36803d;
        if (j10 == 0 || uptimeMillis - j10 > this.f36801b) {
            this.f36802c = 1;
        } else {
            this.f36802c++;
        }
        this.f36803d = uptimeMillis;
        if (this.f36802c >= this.f36800a) {
            b();
            a(view);
        }
    }

    public a(int i10, long j10) {
        this.f36800a = i10;
        this.f36801b = j10;
        b();
    }
}
