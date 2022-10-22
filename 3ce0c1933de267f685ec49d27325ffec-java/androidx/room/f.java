package androidx.room;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.SQLException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.room.f;
import f1.d;
import i1.b;
import i1.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoClosingRoomOpenHelper.java */
/* loaded from: classes.dex */
public final class f implements i1.c, j {

    /* renamed from: a  reason: collision with root package name */
    private final i1.c f4204a;

    /* renamed from: b  reason: collision with root package name */
    private final a f4205b;

    /* renamed from: c  reason: collision with root package name */
    private final androidx.room.a f4206c;

    /* compiled from: AutoClosingRoomOpenHelper.java */
    /* loaded from: classes.dex */
    static final class a implements i1.b {

        /* renamed from: a  reason: collision with root package name */
        private final androidx.room.a f4207a;

        a(androidx.room.a aVar) {
            this.f4207a = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Boolean q(i1.b bVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                return Boolean.valueOf(bVar.x0());
            }
            return Boolean.FALSE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Object u(i1.b bVar) {
            return null;
        }

        @Override // i1.b
        public Cursor D(e eVar, CancellationSignal cancellationSignal) {
            try {
                return new c(this.f4207a.e().D(eVar, cancellationSignal), this.f4207a);
            } catch (Throwable th2) {
                this.f4207a.b();
                throw th2;
            }
        }

        @Override // i1.b
        public void L() {
            i1.b d10 = this.f4207a.d();
            if (d10 != null) {
                d10.L();
                return;
            }
            throw new IllegalStateException("setTransactionSuccessful called but delegateDb is null");
        }

        @Override // i1.b
        public void M(final String str, final Object[] objArr) throws SQLException {
            this.f4207a.c(new m.a() { // from class: androidx.room.c
                @Override // m.a
                public final Object apply(Object obj) {
                    Object M;
                    M = ((b) obj).M(str, objArr);
                    return M;
                }
            });
        }

        @Override // i1.b
        public void N() {
            try {
                this.f4207a.e().N();
            } catch (Throwable th2) {
                this.f4207a.b();
                throw th2;
            }
        }

        @Override // i1.b
        public Cursor U(String str) {
            try {
                return new c(this.f4207a.e().U(str), this.f4207a);
            } catch (Throwable th2) {
                this.f4207a.b();
                throw th2;
            }
        }

        @Override // i1.b
        public void Y() {
            if (this.f4207a.d() != null) {
                try {
                    this.f4207a.d().Y();
                } finally {
                    this.f4207a.b();
                }
            } else {
                throw new IllegalStateException("End transaction called but delegateDb is null");
            }
        }

        @Override // i1.b
        public String a() {
            return (String) this.f4207a.c(f1.b.f26320a);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f4207a.a();
        }

        @Override // i1.b
        public Cursor f0(e eVar) {
            try {
                return new c(this.f4207a.e().f0(eVar), this.f4207a);
            } catch (Throwable th2) {
                this.f4207a.b();
                throw th2;
            }
        }

        @Override // i1.b
        public void g() {
            try {
                this.f4207a.e().g();
            } catch (Throwable th2) {
                this.f4207a.b();
                throw th2;
            }
        }

        @Override // i1.b
        public boolean isOpen() {
            i1.b d10 = this.f4207a.d();
            if (d10 == null) {
                return false;
            }
            return d10.isOpen();
        }

        @Override // i1.b
        public List<Pair<String, String>> j() {
            return (List) this.f4207a.c(f1.a.f26319a);
        }

        @Override // i1.b
        public void l(final String str) throws SQLException {
            this.f4207a.c(new m.a() { // from class: androidx.room.b
                @Override // m.a
                public final Object apply(Object obj) {
                    Object l10;
                    l10 = ((i1.b) obj).l(str);
                    return l10;
                }
            });
        }

        @Override // i1.b
        public boolean q0() {
            if (this.f4207a.d() == null) {
                return false;
            }
            return ((Boolean) this.f4207a.c(f1.c.f26321a)).booleanValue();
        }

        @Override // i1.b
        public i1.f s(String str) {
            return new b(str, this.f4207a);
        }

        void v() {
            this.f4207a.c(e.f4202a);
        }

        @Override // i1.b
        @SuppressLint({"UnsafeNewApiCall"})
        public boolean x0() {
            return ((Boolean) this.f4207a.c(d.f4200a)).booleanValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AutoClosingRoomOpenHelper.java */
    /* loaded from: classes.dex */
    public static class b implements i1.f {

        /* renamed from: a  reason: collision with root package name */
        private final String f4208a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<Object> f4209b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        private final androidx.room.a f4210c;

        b(String str, androidx.room.a aVar) {
            this.f4208a = str;
            this.f4210c = aVar;
        }

        private void d(i1.f fVar) {
            int i10 = 0;
            while (i10 < this.f4209b.size()) {
                int i11 = i10 + 1;
                Object obj = this.f4209b.get(i10);
                if (obj == null) {
                    fVar.l0(i11);
                } else if (obj instanceof Long) {
                    fVar.K(i11, ((Long) obj).longValue());
                } else if (obj instanceof Double) {
                    fVar.y(i11, ((Double) obj).doubleValue());
                } else if (obj instanceof String) {
                    fVar.m(i11, (String) obj);
                } else if (obj instanceof byte[]) {
                    fVar.P(i11, (byte[]) obj);
                }
                i10 = i11;
            }
        }

        private <T> T h(final m.a<i1.f, T> aVar) {
            return (T) this.f4210c.c(new m.a() { // from class: androidx.room.g
                @Override // m.a
                public final Object apply(Object obj) {
                    Object i10;
                    i10 = f.b.this.i(aVar, (b) obj);
                    return i10;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object i(m.a aVar, i1.b bVar) {
            i1.f s10 = bVar.s(this.f4208a);
            d(s10);
            return aVar.apply(s10);
        }

        private void n(int i10, Object obj) {
            int i11 = i10 - 1;
            if (i11 >= this.f4209b.size()) {
                for (int size = this.f4209b.size(); size <= i11; size++) {
                    this.f4209b.add(null);
                }
            }
            this.f4209b.set(i11, obj);
        }

        @Override // i1.f
        public long D0() {
            return ((Long) h(f1.e.f26323a)).longValue();
        }

        @Override // i1.d
        public void K(int i10, long j10) {
            n(i10, Long.valueOf(j10));
        }

        @Override // i1.d
        public void P(int i10, byte[] bArr) {
            n(i10, bArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // i1.d
        public void l0(int i10) {
            n(i10, null);
        }

        @Override // i1.d
        public void m(int i10, String str) {
            n(i10, str);
        }

        @Override // i1.f
        public int r() {
            return ((Integer) h(d.f26322a)).intValue();
        }

        @Override // i1.d
        public void y(int i10, double d10) {
            n(i10, Double.valueOf(d10));
        }
    }

    /* compiled from: AutoClosingRoomOpenHelper.java */
    /* loaded from: classes.dex */
    private static final class c implements Cursor {

        /* renamed from: a  reason: collision with root package name */
        private final Cursor f4211a;

        /* renamed from: b  reason: collision with root package name */
        private final androidx.room.a f4212b;

        c(Cursor cursor, androidx.room.a aVar) {
            this.f4211a = cursor;
            this.f4212b = aVar;
        }

        @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f4211a.close();
            this.f4212b.b();
        }

        @Override // android.database.Cursor
        public void copyStringToBuffer(int i10, CharArrayBuffer charArrayBuffer) {
            this.f4211a.copyStringToBuffer(i10, charArrayBuffer);
        }

        @Override // android.database.Cursor
        @Deprecated
        public void deactivate() {
            this.f4211a.deactivate();
        }

        @Override // android.database.Cursor
        public byte[] getBlob(int i10) {
            return this.f4211a.getBlob(i10);
        }

        @Override // android.database.Cursor
        public int getColumnCount() {
            return this.f4211a.getColumnCount();
        }

        @Override // android.database.Cursor
        public int getColumnIndex(String str) {
            return this.f4211a.getColumnIndex(str);
        }

        @Override // android.database.Cursor
        public int getColumnIndexOrThrow(String str) throws IllegalArgumentException {
            return this.f4211a.getColumnIndexOrThrow(str);
        }

        @Override // android.database.Cursor
        public String getColumnName(int i10) {
            return this.f4211a.getColumnName(i10);
        }

        @Override // android.database.Cursor
        public String[] getColumnNames() {
            return this.f4211a.getColumnNames();
        }

        @Override // android.database.Cursor
        public int getCount() {
            return this.f4211a.getCount();
        }

        @Override // android.database.Cursor
        public double getDouble(int i10) {
            return this.f4211a.getDouble(i10);
        }

        @Override // android.database.Cursor
        public Bundle getExtras() {
            return this.f4211a.getExtras();
        }

        @Override // android.database.Cursor
        public float getFloat(int i10) {
            return this.f4211a.getFloat(i10);
        }

        @Override // android.database.Cursor
        public int getInt(int i10) {
            return this.f4211a.getInt(i10);
        }

        @Override // android.database.Cursor
        public long getLong(int i10) {
            return this.f4211a.getLong(i10);
        }

        @Override // android.database.Cursor
        @SuppressLint({"UnsafeNewApiCall"})
        public Uri getNotificationUri() {
            return this.f4211a.getNotificationUri();
        }

        @Override // android.database.Cursor
        @SuppressLint({"UnsafeNewApiCall"})
        public List<Uri> getNotificationUris() {
            return this.f4211a.getNotificationUris();
        }

        @Override // android.database.Cursor
        public int getPosition() {
            return this.f4211a.getPosition();
        }

        @Override // android.database.Cursor
        public short getShort(int i10) {
            return this.f4211a.getShort(i10);
        }

        @Override // android.database.Cursor
        public String getString(int i10) {
            return this.f4211a.getString(i10);
        }

        @Override // android.database.Cursor
        public int getType(int i10) {
            return this.f4211a.getType(i10);
        }

        @Override // android.database.Cursor
        public boolean getWantsAllOnMoveCalls() {
            return this.f4211a.getWantsAllOnMoveCalls();
        }

        @Override // android.database.Cursor
        public boolean isAfterLast() {
            return this.f4211a.isAfterLast();
        }

        @Override // android.database.Cursor
        public boolean isBeforeFirst() {
            return this.f4211a.isBeforeFirst();
        }

        @Override // android.database.Cursor
        public boolean isClosed() {
            return this.f4211a.isClosed();
        }

        @Override // android.database.Cursor
        public boolean isFirst() {
            return this.f4211a.isFirst();
        }

        @Override // android.database.Cursor
        public boolean isLast() {
            return this.f4211a.isLast();
        }

        @Override // android.database.Cursor
        public boolean isNull(int i10) {
            return this.f4211a.isNull(i10);
        }

        @Override // android.database.Cursor
        public boolean move(int i10) {
            return this.f4211a.move(i10);
        }

        @Override // android.database.Cursor
        public boolean moveToFirst() {
            return this.f4211a.moveToFirst();
        }

        @Override // android.database.Cursor
        public boolean moveToLast() {
            return this.f4211a.moveToLast();
        }

        @Override // android.database.Cursor
        public boolean moveToNext() {
            return this.f4211a.moveToNext();
        }

        @Override // android.database.Cursor
        public boolean moveToPosition(int i10) {
            return this.f4211a.moveToPosition(i10);
        }

        @Override // android.database.Cursor
        public boolean moveToPrevious() {
            return this.f4211a.moveToPrevious();
        }

        @Override // android.database.Cursor
        public void registerContentObserver(ContentObserver contentObserver) {
            this.f4211a.registerContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.f4211a.registerDataSetObserver(dataSetObserver);
        }

        @Override // android.database.Cursor
        @Deprecated
        public boolean requery() {
            return this.f4211a.requery();
        }

        @Override // android.database.Cursor
        public Bundle respond(Bundle bundle) {
            return this.f4211a.respond(bundle);
        }

        @Override // android.database.Cursor
        @SuppressLint({"UnsafeNewApiCall"})
        public void setExtras(Bundle bundle) {
            this.f4211a.setExtras(bundle);
        }

        @Override // android.database.Cursor
        public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
            this.f4211a.setNotificationUri(contentResolver, uri);
        }

        @Override // android.database.Cursor
        @SuppressLint({"UnsafeNewApiCall"})
        public void setNotificationUris(ContentResolver contentResolver, List<Uri> list) {
            this.f4211a.setNotificationUris(contentResolver, list);
        }

        @Override // android.database.Cursor
        public void unregisterContentObserver(ContentObserver contentObserver) {
            this.f4211a.unregisterContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.f4211a.unregisterDataSetObserver(dataSetObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(i1.c cVar, androidx.room.a aVar) {
        this.f4204a = cVar;
        this.f4206c = aVar;
        aVar.f(cVar);
        this.f4205b = new a(aVar);
    }

    @Override // i1.c
    public i1.b S() {
        this.f4205b.v();
        return this.f4205b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.room.a c() {
        return this.f4206c;
    }

    @Override // i1.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.f4205b.close();
        } catch (IOException e10) {
            h1.e.a(e10);
        }
    }

    @Override // i1.c
    public String getDatabaseName() {
        return this.f4204a.getDatabaseName();
    }

    @Override // androidx.room.j
    public i1.c getDelegate() {
        return this.f4204a;
    }

    @Override // i1.c
    public void setWriteAheadLoggingEnabled(boolean z10) {
        this.f4204a.setWriteAheadLoggingEnabled(z10);
    }
}
