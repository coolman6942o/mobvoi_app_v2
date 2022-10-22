package androidx.loader.content;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* compiled from: Loader.java */
/* loaded from: classes.dex */
public class c<D> {

    /* renamed from: a  reason: collision with root package name */
    int f3400a;

    /* renamed from: b  reason: collision with root package name */
    AbstractC0037c<D> f3401b;

    /* renamed from: c  reason: collision with root package name */
    b<D> f3402c;

    /* renamed from: d  reason: collision with root package name */
    Context f3403d;

    /* renamed from: e  reason: collision with root package name */
    boolean f3404e = false;

    /* renamed from: f  reason: collision with root package name */
    boolean f3405f = false;

    /* renamed from: g  reason: collision with root package name */
    boolean f3406g = true;

    /* renamed from: h  reason: collision with root package name */
    boolean f3407h = false;

    /* renamed from: i  reason: collision with root package name */
    boolean f3408i = false;

    /* compiled from: Loader.java */
    /* loaded from: classes.dex */
    public final class a extends ContentObserver {
        public a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            c.this.o();
        }
    }

    /* compiled from: Loader.java */
    /* loaded from: classes.dex */
    public interface b<D> {
        void a(c<D> cVar);
    }

    /* compiled from: Loader.java */
    /* renamed from: androidx.loader.content.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface AbstractC0037c<D> {
        void a(c<D> cVar, D d10);
    }

    public c(Context context) {
        this.f3403d = context.getApplicationContext();
    }

    public void a() {
        this.f3405f = true;
        m();
    }

    public boolean b() {
        return n();
    }

    public void c() {
        this.f3408i = false;
    }

    public String d(D d10) {
        StringBuilder sb2 = new StringBuilder(64);
        j0.b.a(d10, sb2);
        sb2.append("}");
        return sb2.toString();
    }

    public void e() {
        b<D> bVar = this.f3402c;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public void f(D d10) {
        AbstractC0037c<D> cVar = this.f3401b;
        if (cVar != null) {
            cVar.a(this, d10);
        }
    }

    @Deprecated
    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f3400a);
        printWriter.print(" mListener=");
        printWriter.println(this.f3401b);
        if (this.f3404e || this.f3407h || this.f3408i) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f3404e);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f3407h);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f3408i);
        }
        if (this.f3405f || this.f3406g) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f3405f);
            printWriter.print(" mReset=");
            printWriter.println(this.f3406g);
        }
    }

    public void h() {
        p();
    }

    public Context i() {
        return this.f3403d;
    }

    public boolean j() {
        return this.f3405f;
    }

    public boolean k() {
        return this.f3406g;
    }

    public boolean l() {
        return this.f3404e;
    }

    protected void m() {
    }

    protected boolean n() {
        throw null;
    }

    public void o() {
        if (this.f3404e) {
            h();
        } else {
            this.f3407h = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q() {
    }

    protected void r() {
        throw null;
    }

    protected void s() {
    }

    public void t(int i10, AbstractC0037c<D> cVar) {
        if (this.f3401b == null) {
            this.f3401b = cVar;
            this.f3400a = i10;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(64);
        j0.b.a(this, sb2);
        sb2.append(" id=");
        sb2.append(this.f3400a);
        sb2.append("}");
        return sb2.toString();
    }

    public void u() {
        q();
        this.f3406g = true;
        this.f3404e = false;
        this.f3405f = false;
        this.f3407h = false;
        this.f3408i = false;
    }

    public void v() {
        if (this.f3408i) {
            o();
        }
    }

    public final void w() {
        this.f3404e = true;
        this.f3406g = false;
        this.f3405f = false;
        r();
    }

    public void x() {
        this.f3404e = false;
        s();
    }

    public boolean y() {
        boolean z10 = this.f3407h;
        this.f3407h = false;
        this.f3408i |= z10;
        return z10;
    }

    public void z(AbstractC0037c<D> cVar) {
        AbstractC0037c<D> cVar2 = this.f3401b;
        if (cVar2 == null) {
            throw new IllegalStateException("No listener register");
        } else if (cVar2 == cVar) {
            this.f3401b = null;
        } else {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
    }
}
