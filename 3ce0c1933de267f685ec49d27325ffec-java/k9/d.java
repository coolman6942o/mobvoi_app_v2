package k9;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.SparseArray;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import com.mobvoi.wear.permission.PermissionConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k9.a;
import r9.c;
import r9.e;
/* compiled from: SqliteDatabaseImpl.java */
/* loaded from: classes2.dex */
public class d implements k9.a {

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteDatabase f29818a = new e(r9.b.a()).getWritableDatabase();

    /* compiled from: SqliteDatabaseImpl.java */
    /* loaded from: classes2.dex */
    public class a implements a.AbstractC0365a {

        /* renamed from: a  reason: collision with root package name */
        private final SparseArray<FileDownloadModel> f29819a;

        /* renamed from: b  reason: collision with root package name */
        private b f29820b;

        /* renamed from: c  reason: collision with root package name */
        private final SparseArray<FileDownloadModel> f29821c;

        /* renamed from: d  reason: collision with root package name */
        private final SparseArray<List<o9.a>> f29822d;

        a(d dVar) {
            this(null, null);
        }

        @Override // k9.a.AbstractC0365a
        public void E(FileDownloadModel fileDownloadModel) {
            SparseArray<FileDownloadModel> sparseArray = this.f29821c;
            if (sparseArray != null) {
                sparseArray.put(fileDownloadModel.e(), fileDownloadModel);
            }
        }

        @Override // k9.a.AbstractC0365a
        public void I(int i10, FileDownloadModel fileDownloadModel) {
            this.f29819a.put(i10, fileDownloadModel);
        }

        @Override // java.lang.Iterable
        public Iterator<FileDownloadModel> iterator() {
            b bVar = new b();
            this.f29820b = bVar;
            return bVar;
        }

        @Override // k9.a.AbstractC0365a
        public void t0() {
            b bVar = this.f29820b;
            if (bVar != null) {
                bVar.b();
            }
            int size = this.f29819a.size();
            if (size >= 0) {
                d.this.f29818a.beginTransaction();
                for (int i10 = 0; i10 < size; i10++) {
                    try {
                        int keyAt = this.f29819a.keyAt(i10);
                        FileDownloadModel fileDownloadModel = this.f29819a.get(keyAt);
                        d.this.f29818a.delete("filedownloader", "_id = ?", new String[]{String.valueOf(keyAt)});
                        d.this.f29818a.insert("filedownloader", null, fileDownloadModel.E());
                        if (fileDownloadModel.a() > 1) {
                            List<o9.a> n10 = d.this.n(keyAt);
                            if (n10.size() > 0) {
                                d.this.f29818a.delete("filedownloaderConnection", "id = ?", new String[]{String.valueOf(keyAt)});
                                for (o9.a aVar : n10) {
                                    aVar.i(fileDownloadModel.e());
                                    d.this.f29818a.insert("filedownloaderConnection", null, aVar.l());
                                }
                            }
                        }
                    } finally {
                        d.this.f29818a.endTransaction();
                    }
                }
                SparseArray<FileDownloadModel> sparseArray = this.f29821c;
                if (!(sparseArray == null || this.f29822d == null)) {
                    int size2 = sparseArray.size();
                    for (int i11 = 0; i11 < size2; i11++) {
                        int e10 = this.f29821c.valueAt(i11).e();
                        List<o9.a> n11 = d.this.n(e10);
                        if (n11 != null && n11.size() > 0) {
                            this.f29822d.put(e10, n11);
                        }
                    }
                }
                d.this.f29818a.setTransactionSuccessful();
            }
        }

        @Override // k9.a.AbstractC0365a
        public void x(FileDownloadModel fileDownloadModel) {
        }

        a(SparseArray<FileDownloadModel> sparseArray, SparseArray<List<o9.a>> sparseArray2) {
            this.f29819a = new SparseArray<>();
            this.f29821c = sparseArray;
            this.f29822d = sparseArray2;
        }
    }

    /* compiled from: SqliteDatabaseImpl.java */
    /* loaded from: classes2.dex */
    class b implements Iterator<FileDownloadModel> {

        /* renamed from: a  reason: collision with root package name */
        private final Cursor f29824a;

        /* renamed from: b  reason: collision with root package name */
        private final List<Integer> f29825b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private int f29826c;

        b() {
            this.f29824a = d.this.f29818a.rawQuery("SELECT * FROM filedownloader", null);
        }

        /* renamed from: a */
        public FileDownloadModel next() {
            FileDownloadModel t10 = d.t(this.f29824a);
            this.f29826c = t10.e();
            return t10;
        }

        void b() {
            this.f29824a.close();
            if (!this.f29825b.isEmpty()) {
                String join = TextUtils.join(", ", this.f29825b);
                if (c.f33469a) {
                    c.a(this, "delete %s", join);
                }
                d.this.f29818a.execSQL(e.n("DELETE FROM %s WHERE %s IN (%s);", "filedownloader", "_id", join));
                d.this.f29818a.execSQL(e.n("DELETE FROM %s WHERE %s IN (%s);", "filedownloaderConnection", "id", join));
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f29824a.moveToNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f29825b.add(Integer.valueOf(this.f29826c));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static FileDownloadModel t(Cursor cursor) {
        FileDownloadModel fileDownloadModel = new FileDownloadModel();
        fileDownloadModel.y(cursor.getInt(cursor.getColumnIndex("_id")));
        fileDownloadModel.D(cursor.getString(cursor.getColumnIndex("url")));
        String string = cursor.getString(cursor.getColumnIndex("path"));
        boolean z10 = true;
        if (cursor.getShort(cursor.getColumnIndex("pathAsDirectory")) != 1) {
            z10 = false;
        }
        fileDownloadModel.z(string, z10);
        fileDownloadModel.B((byte) cursor.getShort(cursor.getColumnIndex(PermissionConstant.Columns.STATUS)));
        fileDownloadModel.A(cursor.getLong(cursor.getColumnIndex("sofar")));
        fileDownloadModel.C(cursor.getLong(cursor.getColumnIndex("total")));
        fileDownloadModel.v(cursor.getString(cursor.getColumnIndex("errMsg")));
        fileDownloadModel.u(cursor.getString(cursor.getColumnIndex("etag")));
        fileDownloadModel.x(cursor.getString(cursor.getColumnIndex("filename")));
        fileDownloadModel.t(cursor.getInt(cursor.getColumnIndex("connectionCount")));
        return fileDownloadModel;
    }

    private void w(int i10, ContentValues contentValues) {
        this.f29818a.update("filedownloader", contentValues, "_id = ? ", new String[]{String.valueOf(i10)});
    }

    @Override // k9.a
    public void a(int i10) {
    }

    @Override // k9.a
    public void b(o9.a aVar) {
        this.f29818a.insert("filedownloaderConnection", null, aVar.l());
    }

    @Override // k9.a
    public a.AbstractC0365a c() {
        return new a(this);
    }

    @Override // k9.a
    public void clear() {
        this.f29818a.delete("filedownloader", null, null);
        this.f29818a.delete("filedownloaderConnection", null, null);
    }

    @Override // k9.a
    public void d(int i10, Throwable th2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th2.toString());
        contentValues.put(PermissionConstant.Columns.STATUS, (Byte) (byte) 5);
        w(i10, contentValues);
    }

    @Override // k9.a
    public void e(int i10, long j10) {
        remove(i10);
    }

    @Override // k9.a
    public void f(int i10, String str, long j10, long j11, int i11) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sofar", Long.valueOf(j10));
        contentValues.put("total", Long.valueOf(j11));
        contentValues.put("etag", str);
        contentValues.put("connectionCount", Integer.valueOf(i11));
        w(i10, contentValues);
    }

    @Override // k9.a
    public void g(int i10, int i11, long j10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("currentOffset", Long.valueOf(j10));
        this.f29818a.update("filedownloaderConnection", contentValues, "id = ? AND connectionIndex = ?", new String[]{Integer.toString(i10), Integer.toString(i11)});
    }

    @Override // k9.a
    public void h(int i10) {
        SQLiteDatabase sQLiteDatabase = this.f29818a;
        sQLiteDatabase.execSQL("DELETE FROM filedownloaderConnection WHERE id = " + i10);
    }

    @Override // k9.a
    public void i(int i10) {
    }

    @Override // k9.a
    public void j(FileDownloadModel fileDownloadModel) {
        if (fileDownloadModel == null) {
            c.i(this, "update but model == null!", new Object[0]);
        } else if (o(fileDownloadModel.e()) != null) {
            this.f29818a.update("filedownloader", fileDownloadModel.E(), "_id = ? ", new String[]{String.valueOf(fileDownloadModel.e())});
        } else {
            u(fileDownloadModel);
        }
    }

    @Override // k9.a
    public void k(int i10, Throwable th2, long j10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th2.toString());
        contentValues.put(PermissionConstant.Columns.STATUS, (Byte) (byte) -1);
        contentValues.put("sofar", Long.valueOf(j10));
        w(i10, contentValues);
    }

    @Override // k9.a
    public void l(int i10, long j10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(PermissionConstant.Columns.STATUS, (Byte) (byte) 3);
        contentValues.put("sofar", Long.valueOf(j10));
        w(i10, contentValues);
    }

    @Override // k9.a
    public void m(int i10, long j10, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(PermissionConstant.Columns.STATUS, (Byte) (byte) 2);
        contentValues.put("total", Long.valueOf(j10));
        contentValues.put("etag", str);
        contentValues.put("filename", str2);
        w(i10, contentValues);
    }

    @Override // k9.a
    public List<o9.a> n(int i10) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.f29818a.rawQuery(e.n("SELECT * FROM %s WHERE %s = ?", "filedownloaderConnection", "id"), new String[]{Integer.toString(i10)});
            while (cursor.moveToNext()) {
                o9.a aVar = new o9.a();
                aVar.i(i10);
                aVar.j(cursor.getInt(cursor.getColumnIndex("connectionIndex")));
                aVar.k(cursor.getLong(cursor.getColumnIndex("startOffset")));
                aVar.g(cursor.getLong(cursor.getColumnIndex("currentOffset")));
                aVar.h(cursor.getLong(cursor.getColumnIndex("endOffset")));
                arrayList.add(aVar);
            }
            cursor.close();
            return arrayList;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    @Override // k9.a
    public FileDownloadModel o(int i10) {
        Cursor cursor;
        Throwable th2;
        try {
            cursor = this.f29818a.rawQuery(e.n("SELECT * FROM %s WHERE %s = ?", "filedownloader", "_id"), new String[]{Integer.toString(i10)});
            try {
                if (cursor.moveToNext()) {
                    FileDownloadModel t10 = t(cursor);
                    cursor.close();
                    return t10;
                }
                cursor.close();
                return null;
            } catch (Throwable th3) {
                th2 = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            cursor = null;
        }
    }

    @Override // k9.a
    public void p(int i10, int i11) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("connectionCount", Integer.valueOf(i11));
        this.f29818a.update("filedownloader", contentValues, "_id = ? ", new String[]{Integer.toString(i10)});
    }

    @Override // k9.a
    public void q(int i10, long j10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(PermissionConstant.Columns.STATUS, (Byte) (byte) -2);
        contentValues.put("sofar", Long.valueOf(j10));
        w(i10, contentValues);
    }

    @Override // k9.a
    public boolean remove(int i10) {
        return this.f29818a.delete("filedownloader", "_id = ?", new String[]{String.valueOf(i10)}) != 0;
    }

    public void u(FileDownloadModel fileDownloadModel) {
        this.f29818a.insert("filedownloader", null, fileDownloadModel.E());
    }

    public a.AbstractC0365a v(SparseArray<FileDownloadModel> sparseArray, SparseArray<List<o9.a>> sparseArray2) {
        return new a(sparseArray, sparseArray2);
    }
}
