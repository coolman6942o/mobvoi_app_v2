package y1;

import androidx.room.RoomDatabase;
import androidx.work.d;
import f1.g;
import f1.l;
import i1.f;
/* compiled from: WorkProgressDao_Impl.java */
/* loaded from: classes.dex */
public final class o implements n {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f36686a;

    /* renamed from: b  reason: collision with root package name */
    private final l f36687b;

    /* renamed from: c  reason: collision with root package name */
    private final l f36688c;

    /* compiled from: WorkProgressDao_Impl.java */
    /* loaded from: classes.dex */
    class a extends g<m> {
        a(o oVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
        }

        /* renamed from: m */
        public void g(f fVar, m mVar) {
            String str = mVar.f36684a;
            if (str == null) {
                fVar.l0(1);
            } else {
                fVar.m(1, str);
            }
            byte[] k10 = d.k(mVar.f36685b);
            if (k10 == null) {
                fVar.l0(2);
            } else {
                fVar.P(2, k10);
            }
        }
    }

    /* compiled from: WorkProgressDao_Impl.java */
    /* loaded from: classes.dex */
    class b extends l {
        b(o oVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "DELETE from WorkProgress where work_spec_id=?";
        }
    }

    /* compiled from: WorkProgressDao_Impl.java */
    /* loaded from: classes.dex */
    class c extends l {
        c(o oVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "DELETE FROM WorkProgress";
        }
    }

    public o(RoomDatabase roomDatabase) {
        this.f36686a = roomDatabase;
        new a(this, roomDatabase);
        this.f36687b = new b(this, roomDatabase);
        this.f36688c = new c(this, roomDatabase);
    }

    @Override // y1.n
    public void a(String str) {
        this.f36686a.d();
        f a10 = this.f36687b.a();
        if (str == null) {
            a10.l0(1);
        } else {
            a10.m(1, str);
        }
        this.f36686a.e();
        try {
            a10.r();
            this.f36686a.B();
        } finally {
            this.f36686a.i();
            this.f36687b.f(a10);
        }
    }

    @Override // y1.n
    public void b() {
        this.f36686a.d();
        f a10 = this.f36688c.a();
        this.f36686a.e();
        try {
            a10.r();
            this.f36686a.B();
        } finally {
            this.f36686a.i();
            this.f36688c.f(a10);
        }
    }
}
