package com.liulishuo.filedownloader.services;

import android.text.TextUtils;
import com.liulishuo.filedownloader.download.c;
import com.liulishuo.filedownloader.download.d;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import i9.f;
import java.util.List;
import k9.a;
import o9.b;
import r9.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileDownloadManager.java */
/* loaded from: classes2.dex */
public class d implements f {

    /* renamed from: a  reason: collision with root package name */
    private final a f15254a;

    /* renamed from: b  reason: collision with root package name */
    private final e f15255b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d() {
        c i10 = c.i();
        this.f15254a = i10.f();
        this.f15255b = new e(i10.j());
    }

    @Override // i9.f
    public boolean a(FileDownloadModel fileDownloadModel) {
        if (fileDownloadModel == null) {
            return false;
        }
        boolean g10 = this.f15255b.g(fileDownloadModel.e());
        if (b.a(fileDownloadModel.h())) {
            if (!g10) {
                return false;
            }
        } else if (!g10) {
            r9.c.b(this, "%d status is[%s](not finish) & but not in the pool", Integer.valueOf(fileDownloadModel.e()), Byte.valueOf(fileDownloadModel.h()));
            return false;
        }
        return true;
    }

    @Override // i9.f
    public int b(String str, int i10) {
        return this.f15255b.e(str, i10);
    }

    public void c() {
        this.f15254a.clear();
    }

    public boolean d(int i10) {
        if (i10 == 0) {
            r9.c.i(this, "The task[%d] id is invalid, can't clear it.", Integer.valueOf(i10));
            return false;
        } else if (h(i10)) {
            r9.c.i(this, "The task[%d] is downloading, can't clear it.", Integer.valueOf(i10));
            return false;
        } else {
            this.f15254a.remove(i10);
            this.f15254a.h(i10);
            return true;
        }
    }

    public long e(int i10) {
        FileDownloadModel o10 = this.f15254a.o(i10);
        if (o10 == null) {
            return 0L;
        }
        int a10 = o10.a();
        if (a10 <= 1) {
            return o10.g();
        }
        List<o9.a> n10 = this.f15254a.n(i10);
        if (n10 == null || n10.size() != a10) {
            return 0L;
        }
        return o9.a.f(n10);
    }

    public byte f(int i10) {
        FileDownloadModel o10 = this.f15254a.o(i10);
        if (o10 == null) {
            return (byte) 0;
        }
        return o10.h();
    }

    public long g(int i10) {
        FileDownloadModel o10 = this.f15254a.o(i10);
        if (o10 == null) {
            return 0L;
        }
        return o10.k();
    }

    public boolean h(int i10) {
        return a(this.f15254a.o(i10));
    }

    public boolean i(String str, String str2) {
        return h(e.q(str, str2));
    }

    public boolean j() {
        return this.f15255b.b() <= 0;
    }

    public boolean k(int i10) {
        if (r9.c.f33469a) {
            r9.c.a(this, "request pause the task %d", Integer.valueOf(i10));
        }
        FileDownloadModel o10 = this.f15254a.o(i10);
        if (o10 == null) {
            return false;
        }
        o10.B((byte) -2);
        this.f15255b.a(i10);
        return true;
    }

    public void l() {
        List<Integer> f10 = this.f15255b.f();
        if (r9.c.f33469a) {
            r9.c.a(this, "pause all tasks %d", Integer.valueOf(f10.size()));
        }
        for (Integer num : f10) {
            k(num.intValue());
        }
    }

    public synchronized boolean m(int i10) {
        return this.f15255b.h(i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x0181 A[Catch: all -> 0x01cc, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x0010, B:7:0x0022, B:10:0x0031, B:12:0x0041, B:14:0x004b, B:16:0x004f, B:17:0x0062, B:21:0x006f, B:23:0x0075, B:25:0x0079, B:29:0x008a, B:30:0x008f, B:31:0x0093, B:33:0x009c, B:35:0x00a0, B:40:0x00b3, B:43:0x00bc, B:44:0x00c1, B:45:0x00c5, B:47:0x00d4, B:49:0x00d8, B:51:0x00e9, B:55:0x00f7, B:57:0x00fe, B:59:0x0105, B:61:0x010b, B:63:0x0112, B:65:0x0118, B:67:0x011e, B:69:0x0138, B:70:0x013c, B:72:0x0142, B:73:0x0151, B:75:0x015b, B:77:0x0161, B:78:0x0167, B:81:0x0181, B:82:0x0186), top: B:87:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void n(String str, String str2, boolean z10, int i10, int i11, int i12, boolean z11, FileDownloadHeader fileDownloadHeader, boolean z12) {
        List<o9.a> list;
        FileDownloadModel fileDownloadModel;
        String str3;
        String str4;
        boolean z13 = false;
        if (r9.c.f33469a) {
            r9.c.a(this, "request start the task with url(%s) path(%s) isDirectory(%B)", str, str2, Boolean.valueOf(z10));
        }
        int r10 = e.r(str, str2, z10);
        FileDownloadModel o10 = this.f15254a.o(r10);
        if (z10 || o10 != null) {
            fileDownloadModel = o10;
            list = null;
        } else {
            int r11 = e.r(str, e.x(str2), true);
            FileDownloadModel o11 = this.f15254a.o(r11);
            if (o11 == null || !str2.equals(o11.i())) {
                list = null;
            } else {
                if (r9.c.f33469a) {
                    r9.c.a(this, "task[%d] find model by dirCaseId[%d]", Integer.valueOf(r10), Integer.valueOf(r11));
                }
                list = this.f15254a.n(r11);
            }
            fileDownloadModel = o11;
        }
        if (r9.b.e(r10, fileDownloadModel, this, true)) {
            if (r9.c.f33469a) {
                r9.c.a(this, "has already started download %d", Integer.valueOf(r10));
            }
            return;
        }
        if (fileDownloadModel != null) {
            str3 = fileDownloadModel.i();
        } else {
            str3 = e.y(str2, z10, null);
        }
        String str5 = str3;
        if (r9.b.d(r10, str5, z11, true)) {
            if (r9.c.f33469a) {
                r9.c.a(this, "has already completed downloading %d", Integer.valueOf(r10));
            }
            return;
        }
        long j10 = 0;
        if (fileDownloadModel != null) {
            j10 = fileDownloadModel.g();
        }
        if (fileDownloadModel != null) {
            str4 = fileDownloadModel.j();
        } else {
            str4 = e.z(str5);
        }
        if (r9.b.c(r10, j10, str4, str5, this)) {
            if (r9.c.f33469a) {
                r9.c.a(this, "there is an another task with the same target-file-path %d %s", Integer.valueOf(r10), str5);
            }
            if (fileDownloadModel != null) {
                this.f15254a.remove(r10);
                this.f15254a.h(r10);
            }
            return;
        }
        if (fileDownloadModel == null || !(fileDownloadModel.h() == -2 || fileDownloadModel.h() == -1 || fileDownloadModel.h() == 1 || fileDownloadModel.h() == 6 || fileDownloadModel.h() == 2)) {
            if (fileDownloadModel == null) {
                fileDownloadModel = new FileDownloadModel();
            }
            fileDownloadModel.D(str);
            fileDownloadModel.z(str2, z10);
            fileDownloadModel.y(r10);
            fileDownloadModel.A(0L);
            fileDownloadModel.C(0L);
            fileDownloadModel.B((byte) 1);
            fileDownloadModel.t(1);
        } else if (fileDownloadModel.e() != r10) {
            this.f15254a.remove(fileDownloadModel.e());
            this.f15254a.h(fileDownloadModel.e());
            fileDownloadModel.y(r10);
            fileDownloadModel.z(str2, z10);
            if (list != null) {
                for (o9.a aVar : list) {
                    aVar.i(r10);
                    this.f15254a.b(aVar);
                }
            }
        } else {
            if (!TextUtils.equals(str, fileDownloadModel.l())) {
                fileDownloadModel.D(str);
            }
            if (z13) {
                this.f15254a.j(fileDownloadModel);
            }
            this.f15255b.c(new d.b().g(fileDownloadModel).d(fileDownloadHeader).h(this).f(Integer.valueOf(i11)).b(Integer.valueOf(i10)).c(Boolean.valueOf(z11)).i(Boolean.valueOf(z12)).e(Integer.valueOf(i12)).a());
        }
        z13 = true;
        if (z13) {
        }
        this.f15255b.c(new d.b().g(fileDownloadModel).d(fileDownloadHeader).h(this).f(Integer.valueOf(i11)).b(Integer.valueOf(i10)).c(Boolean.valueOf(z11)).i(Boolean.valueOf(z12)).e(Integer.valueOf(i12)).a());
    }
}
