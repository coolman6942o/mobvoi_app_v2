package n0;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import n0.b;
/* compiled from: CursorAdapter.java */
/* loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable, b.a {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f30847a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f30848b;

    /* renamed from: c  reason: collision with root package name */
    protected Cursor f30849c;

    /* renamed from: d  reason: collision with root package name */
    protected Context f30850d;

    /* renamed from: e  reason: collision with root package name */
    protected int f30851e;

    /* renamed from: f  reason: collision with root package name */
    protected C0403a f30852f;

    /* renamed from: g  reason: collision with root package name */
    protected DataSetObserver f30853g;

    /* renamed from: h  reason: collision with root package name */
    protected n0.b f30854h;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CursorAdapter.java */
    /* renamed from: n0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0403a extends ContentObserver {
        C0403a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            a.this.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CursorAdapter.java */
    /* loaded from: classes.dex */
    public class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a aVar = a.this;
            aVar.f30847a = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a aVar = a.this;
            aVar.f30847a = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z10) {
        f(context, cursor, z10 ? 1 : 2);
    }

    public void a(Cursor cursor) {
        Cursor j10 = j(cursor);
        if (j10 != null) {
            j10.close();
        }
    }

    @Override // n0.b.a
    public Cursor b() {
        return this.f30849c;
    }

    public abstract CharSequence c(Cursor cursor);

    public abstract void e(View view, Context context, Cursor cursor);

    void f(Context context, Cursor cursor, int i10) {
        boolean z10 = false;
        if ((i10 & 1) == 1) {
            i10 |= 2;
            this.f30848b = true;
        } else {
            this.f30848b = false;
        }
        if (cursor != null) {
            z10 = true;
        }
        this.f30849c = cursor;
        this.f30847a = z10;
        this.f30850d = context;
        this.f30851e = z10 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i10 & 2) == 2) {
            this.f30852f = new C0403a();
            this.f30853g = new b();
        } else {
            this.f30852f = null;
            this.f30853g = null;
        }
        if (z10) {
            C0403a aVar = this.f30852f;
            if (aVar != null) {
                cursor.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f30853g;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f30847a || (cursor = this.f30849c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
        if (!this.f30847a) {
            return null;
        }
        this.f30849c.moveToPosition(i10);
        if (view == null) {
            view = g(this.f30850d, this.f30849c, viewGroup);
        }
        e(view, this.f30850d, this.f30849c);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f30854h == null) {
            this.f30854h = new n0.b(this);
        }
        return this.f30854h;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        Cursor cursor;
        if (!this.f30847a || (cursor = this.f30849c) == null) {
            return null;
        }
        cursor.moveToPosition(i10);
        return this.f30849c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        Cursor cursor;
        if (!this.f30847a || (cursor = this.f30849c) == null || !cursor.moveToPosition(i10)) {
            return 0L;
        }
        return this.f30849c.getLong(this.f30851e);
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        if (!this.f30847a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f30849c.moveToPosition(i10)) {
            if (view == null) {
                view = h(this.f30850d, this.f30849c, viewGroup);
            }
            e(view, this.f30850d, this.f30849c);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i10);
        }
    }

    public abstract View h(Context context, Cursor cursor, ViewGroup viewGroup);

    protected void i() {
        Cursor cursor;
        if (this.f30848b && (cursor = this.f30849c) != null && !cursor.isClosed()) {
            this.f30847a = this.f30849c.requery();
        }
    }

    public Cursor j(Cursor cursor) {
        Cursor cursor2 = this.f30849c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0403a aVar = this.f30852f;
            if (aVar != null) {
                cursor2.unregisterContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f30853g;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f30849c = cursor;
        if (cursor != null) {
            C0403a aVar2 = this.f30852f;
            if (aVar2 != null) {
                cursor.registerContentObserver(aVar2);
            }
            DataSetObserver dataSetObserver2 = this.f30853g;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f30851e = cursor.getColumnIndexOrThrow("_id");
            this.f30847a = true;
            notifyDataSetChanged();
        } else {
            this.f30851e = -1;
            this.f30847a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }
}
