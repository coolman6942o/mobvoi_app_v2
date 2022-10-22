package com.liulishuo.filedownloader.download;

import android.text.TextUtils;
import com.liulishuo.filedownloader.download.b;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import j9.d;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import r9.c;
import r9.e;
/* compiled from: ConnectTask.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    final int f15090a;

    /* renamed from: b  reason: collision with root package name */
    final String f15091b;

    /* renamed from: c  reason: collision with root package name */
    final FileDownloadHeader f15092c;

    /* renamed from: d  reason: collision with root package name */
    private com.liulishuo.filedownloader.download.b f15093d;

    /* renamed from: e  reason: collision with root package name */
    private String f15094e;

    /* renamed from: f  reason: collision with root package name */
    private Map<String, List<String>> f15095f;

    /* renamed from: g  reason: collision with root package name */
    private List<String> f15096g;

    /* compiled from: ConnectTask.java */
    /* loaded from: classes2.dex */
    static class b {

        /* renamed from: a  reason: collision with root package name */
        private Integer f15097a;

        /* renamed from: b  reason: collision with root package name */
        private String f15098b;

        /* renamed from: c  reason: collision with root package name */
        private String f15099c;

        /* renamed from: d  reason: collision with root package name */
        private FileDownloadHeader f15100d;

        /* renamed from: e  reason: collision with root package name */
        private com.liulishuo.filedownloader.download.b f15101e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a() {
            com.liulishuo.filedownloader.download.b bVar;
            Integer num = this.f15097a;
            if (num != null && (bVar = this.f15101e) != null && this.f15098b != null) {
                return new a(bVar, num.intValue(), this.f15098b, this.f15099c, this.f15100d);
            }
            throw new IllegalArgumentException();
        }

        public b b(com.liulishuo.filedownloader.download.b bVar) {
            this.f15101e = bVar;
            return this;
        }

        public b c(int i10) {
            this.f15097a = Integer.valueOf(i10);
            return this;
        }

        public b d(String str) {
            this.f15099c = str;
            return this;
        }

        public b e(FileDownloadHeader fileDownloadHeader) {
            this.f15100d = fileDownloadHeader;
            return this;
        }

        public b f(String str) {
            this.f15098b = str;
            return this;
        }
    }

    private void a(j9.b bVar) throws ProtocolException {
        if (!bVar.c(this.f15094e, this.f15093d.f15102a)) {
            if (!TextUtils.isEmpty(this.f15094e)) {
                bVar.e("If-Match", this.f15094e);
            }
            this.f15093d.a(bVar);
        }
    }

    private void b(j9.b bVar) {
        HashMap<String, List<String>> a10;
        FileDownloadHeader fileDownloadHeader = this.f15092c;
        if (!(fileDownloadHeader == null || (a10 = fileDownloadHeader.a()) == null)) {
            if (c.f33469a) {
                c.h(this, "%d add outside header: %s", Integer.valueOf(this.f15090a), a10);
            }
            for (Map.Entry<String, List<String>> entry : a10.entrySet()) {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                if (value != null) {
                    for (String str : value) {
                        bVar.e(key, str);
                    }
                }
            }
        }
    }

    private void d(j9.b bVar) {
        FileDownloadHeader fileDownloadHeader = this.f15092c;
        if (fileDownloadHeader == null || fileDownloadHeader.a().get("User-Agent") == null) {
            bVar.e("User-Agent", e.d());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j9.b c() throws IOException, IllegalAccessException {
        j9.b a10 = c.i().a(this.f15091b);
        b(a10);
        a(a10);
        d(a10);
        this.f15095f = a10.i();
        if (c.f33469a) {
            c.a(this, "<---- %s request header %s", Integer.valueOf(this.f15090a), this.f15095f);
        }
        a10.execute();
        ArrayList arrayList = new ArrayList();
        this.f15096g = arrayList;
        j9.b c10 = d.c(this.f15095f, a10, arrayList);
        if (c.f33469a) {
            c.a(this, "----> %s response header %s", Integer.valueOf(this.f15090a), c10.b());
        }
        return c10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String e() {
        List<String> list = this.f15096g;
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<String> list2 = this.f15096g;
        return list2.get(list2.size() - 1);
    }

    public com.liulishuo.filedownloader.download.b f() {
        return this.f15093d;
    }

    public Map<String, List<String>> g() {
        return this.f15095f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h() {
        return this.f15093d.f15103b > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(long j10) {
        com.liulishuo.filedownloader.download.b bVar = this.f15093d;
        long j11 = bVar.f15103b;
        if (j10 == j11) {
            c.i(this, "no data download, no need to update", new Object[0]);
            return;
        }
        com.liulishuo.filedownloader.download.b b10 = b.C0183b.b(bVar.f15102a, j10, bVar.f15104c, bVar.f15105d - (j10 - j11));
        this.f15093d = b10;
        if (c.f33469a) {
            c.e(this, "after update profile:%s", b10);
        }
    }

    private a(com.liulishuo.filedownloader.download.b bVar, int i10, String str, String str2, FileDownloadHeader fileDownloadHeader) {
        this.f15090a = i10;
        this.f15091b = str;
        this.f15094e = str2;
        this.f15092c = fileDownloadHeader;
        this.f15093d = bVar;
    }
}
