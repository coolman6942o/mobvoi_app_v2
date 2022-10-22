package androidx.loader.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.core.content.a;
import androidx.core.os.OperationCanceledException;
import androidx.loader.content.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;
/* compiled from: CursorLoader.java */
/* loaded from: classes.dex */
public class b extends a<Cursor> {

    /* renamed from: p  reason: collision with root package name */
    final c<Cursor>.a f3392p = new c.a();

    /* renamed from: q  reason: collision with root package name */
    Uri f3393q;

    /* renamed from: r  reason: collision with root package name */
    String[] f3394r;

    /* renamed from: s  reason: collision with root package name */
    String f3395s;

    /* renamed from: t  reason: collision with root package name */
    String[] f3396t;

    /* renamed from: u  reason: collision with root package name */
    String f3397u;

    /* renamed from: v  reason: collision with root package name */
    Cursor f3398v;

    /* renamed from: w  reason: collision with root package name */
    g0.c f3399w;

    public b(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        super(context);
        this.f3393q = uri;
        this.f3394r = strArr;
        this.f3395s = str;
        this.f3396t = strArr2;
        this.f3397u = str2;
    }

    @Override // androidx.loader.content.a
    public void A() {
        super.A();
        synchronized (this) {
            g0.c cVar = this.f3399w;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    /* renamed from: I */
    public void f(Cursor cursor) {
        if (!k()) {
            Cursor cursor2 = this.f3398v;
            this.f3398v = cursor;
            if (l()) {
                super.f(cursor);
            }
            if (cursor2 != null && cursor2 != cursor && !cursor2.isClosed()) {
                cursor2.close();
            }
        } else if (cursor != null) {
            cursor.close();
        }
    }

    /* renamed from: J */
    public Cursor F() {
        synchronized (this) {
            if (!E()) {
                this.f3399w = new g0.c();
            } else {
                throw new OperationCanceledException();
            }
        }
        try {
            Cursor a10 = a.a(i().getContentResolver(), this.f3393q, this.f3394r, this.f3395s, this.f3396t, this.f3397u, this.f3399w);
            if (a10 != null) {
                try {
                    a10.getCount();
                    a10.registerContentObserver(this.f3392p);
                } catch (RuntimeException e10) {
                    a10.close();
                    throw e10;
                }
            }
            synchronized (this) {
                this.f3399w = null;
            }
            return a10;
        } catch (Throwable th2) {
            synchronized (this) {
                this.f3399w = null;
                throw th2;
            }
        }
    }

    /* renamed from: K */
    public void G(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    @Override // androidx.loader.content.a, androidx.loader.content.c
    @Deprecated
    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.g(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.f3393q);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.f3394r));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.f3395s);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.f3396t));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.f3397u);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.f3398v);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.f3407h);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.loader.content.c
    public void q() {
        super.q();
        s();
        Cursor cursor = this.f3398v;
        if (cursor != null && !cursor.isClosed()) {
            this.f3398v.close();
        }
        this.f3398v = null;
    }

    @Override // androidx.loader.content.c
    protected void r() {
        Cursor cursor = this.f3398v;
        if (cursor != null) {
            f(cursor);
        }
        if (y() || this.f3398v == null) {
            h();
        }
    }

    @Override // androidx.loader.content.c
    protected void s() {
        b();
    }
}
