package z1;

import androidx.work.WorkerParameters;
import r1.i;
/* compiled from: StartWorkRunnable.java */
/* loaded from: classes.dex */
public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private i f37228a;

    /* renamed from: b  reason: collision with root package name */
    private String f37229b;

    /* renamed from: c  reason: collision with root package name */
    private WorkerParameters.a f37230c;

    public h(i iVar, String str, WorkerParameters.a aVar) {
        this.f37228a = iVar;
        this.f37229b = str;
        this.f37230c = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f37228a.l().k(this.f37229b, this.f37230c);
    }
}
