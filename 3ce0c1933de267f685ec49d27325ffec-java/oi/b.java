package oi;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import com.mobvoi.wear.contacts.ContactConstant;
import f1.f;
import f1.g;
import f1.k;
import f1.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: DeviceInfoDao_Impl.java */
/* loaded from: classes2.dex */
public final class b implements oi.a {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f31723a;

    /* renamed from: b  reason: collision with root package name */
    private final g<pi.a> f31724b;

    /* renamed from: c  reason: collision with root package name */
    private final f<pi.a> f31725c;

    /* renamed from: d  reason: collision with root package name */
    private final l f31726d;

    /* compiled from: DeviceInfoDao_Impl.java */
    /* loaded from: classes2.dex */
    class a extends g<pi.a> {
        a(b bVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "INSERT OR REPLACE INTO `device_info` (`id`,`macAddress`,`name`) VALUES (nullif(?, 0),?,?)";
        }

        /* renamed from: m */
        public void g(i1.f fVar, pi.a aVar) {
            fVar.K(1, aVar.f32775id);
            String str = aVar.macAddress;
            if (str == null) {
                fVar.l0(2);
            } else {
                fVar.m(2, str);
            }
            String str2 = aVar.name;
            if (str2 == null) {
                fVar.l0(3);
            } else {
                fVar.m(3, str2);
            }
        }
    }

    /* compiled from: DeviceInfoDao_Impl.java */
    /* renamed from: oi.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0423b extends f<pi.a> {
        C0423b(b bVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "UPDATE OR REPLACE `device_info` SET `id` = ?,`macAddress` = ?,`name` = ? WHERE `id` = ?";
        }

        /* renamed from: j */
        public void g(i1.f fVar, pi.a aVar) {
            fVar.K(1, aVar.f32775id);
            String str = aVar.macAddress;
            if (str == null) {
                fVar.l0(2);
            } else {
                fVar.m(2, str);
            }
            String str2 = aVar.name;
            if (str2 == null) {
                fVar.l0(3);
            } else {
                fVar.m(3, str2);
            }
            fVar.K(4, aVar.f32775id);
        }
    }

    /* compiled from: DeviceInfoDao_Impl.java */
    /* loaded from: classes2.dex */
    class c extends l {
        c(b bVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "delete from device_info where macAddress = ?";
        }
    }

    public b(RoomDatabase roomDatabase) {
        this.f31723a = roomDatabase;
        this.f31724b = new a(this, roomDatabase);
        this.f31725c = new C0423b(this, roomDatabase);
        this.f31726d = new c(this, roomDatabase);
    }

    public static List<Class<?>> c() {
        return Collections.emptyList();
    }

    @Override // oi.a
    public void a(pi.a aVar) {
        this.f31723a.d();
        this.f31723a.e();
        try {
            this.f31724b.i(aVar);
            this.f31723a.B();
        } finally {
            this.f31723a.i();
        }
    }

    @Override // oi.a
    public void b(pi.a aVar) {
        this.f31723a.d();
        this.f31723a.e();
        try {
            this.f31725c.h(aVar);
            this.f31723a.B();
        } finally {
            this.f31723a.i();
        }
    }

    @Override // oi.a
    public void deleteDevice(String str) {
        this.f31723a.d();
        i1.f a10 = this.f31726d.a();
        if (str == null) {
            a10.l0(1);
        } else {
            a10.m(1, str);
        }
        this.f31723a.e();
        try {
            a10.r();
            this.f31723a.B();
        } finally {
            this.f31723a.i();
            this.f31726d.f(a10);
        }
    }

    @Override // oi.a
    public pi.a queryDevice(String str) {
        k h10 = k.h("select * from device_info where macAddress = ?", 1);
        if (str == null) {
            h10.l0(1);
        } else {
            h10.m(1, str);
        }
        this.f31723a.d();
        pi.a aVar = null;
        Cursor b10 = h1.c.b(this.f31723a, h10, false, null);
        try {
            int e10 = h1.b.e(b10, "id");
            int e11 = h1.b.e(b10, "macAddress");
            int e12 = h1.b.e(b10, ContactConstant.CallsRecordKeys.NAME);
            if (b10.moveToFirst()) {
                pi.a aVar2 = new pi.a();
                aVar2.f32775id = b10.getLong(e10);
                if (b10.isNull(e11)) {
                    aVar2.macAddress = null;
                } else {
                    aVar2.macAddress = b10.getString(e11);
                }
                if (b10.isNull(e12)) {
                    aVar2.name = null;
                } else {
                    aVar2.name = b10.getString(e12);
                }
                aVar = aVar2;
            }
            return aVar;
        } finally {
            b10.close();
            h10.o();
        }
    }

    @Override // oi.a
    public List<pi.a> queryDevices() {
        k h10 = k.h("select * from device_info", 0);
        this.f31723a.d();
        Cursor b10 = h1.c.b(this.f31723a, h10, false, null);
        try {
            int e10 = h1.b.e(b10, "id");
            int e11 = h1.b.e(b10, "macAddress");
            int e12 = h1.b.e(b10, ContactConstant.CallsRecordKeys.NAME);
            ArrayList arrayList = new ArrayList(b10.getCount());
            while (b10.moveToNext()) {
                pi.a aVar = new pi.a();
                aVar.f32775id = b10.getLong(e10);
                if (b10.isNull(e11)) {
                    aVar.macAddress = null;
                } else {
                    aVar.macAddress = b10.getString(e11);
                }
                if (b10.isNull(e12)) {
                    aVar.name = null;
                } else {
                    aVar.name = b10.getString(e12);
                }
                arrayList.add(aVar);
            }
            return arrayList;
        } finally {
            b10.close();
            h10.o();
        }
    }
}
