package h0;

import android.graphics.Typeface;
import android.os.Handler;
import h0.e;
import h0.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CallbackWithHandler.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final f.c f27638a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f27639b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CallbackWithHandler.java */
    /* renamed from: h0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0295a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f.c f27640a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Typeface f27641b;

        RunnableC0295a(a aVar, f.c cVar, Typeface typeface) {
            this.f27640a = cVar;
            this.f27641b = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f27640a.b(this.f27641b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CallbackWithHandler.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f.c f27642a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f27643b;

        b(a aVar, f.c cVar, int i10) {
            this.f27642a = cVar;
            this.f27643b = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f27642a.a(this.f27643b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(f.c cVar, Handler handler) {
        this.f27638a = cVar;
        this.f27639b = handler;
    }

    private void a(int i10) {
        this.f27639b.post(new b(this, this.f27638a, i10));
    }

    private void c(Typeface typeface) {
        this.f27639b.post(new RunnableC0295a(this, this.f27638a, typeface));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(e.C0296e eVar) {
        if (eVar.a()) {
            c(eVar.f27665a);
        } else {
            a(eVar.f27666b);
        }
    }
}
