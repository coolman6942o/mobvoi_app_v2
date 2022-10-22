package com.bjleisen.iface.sdk.apdu;

import android.os.Handler;
import android.os.Message;
import com.bjleisen.iface.sdk.bean.Rapdu;
import java.util.List;
/* compiled from: ApduResponseHandler.java */
/* loaded from: classes.dex */
abstract class d {

    /* renamed from: a  reason: collision with root package name */
    private static final int f7748a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static final int f7749b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f7750c = 2;

    /* renamed from: d  reason: collision with root package name */
    private static final int f7751d = 3;

    /* renamed from: e  reason: collision with root package name */
    private a f7752e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7753f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ApduResponseHandler.java */
    /* loaded from: classes.dex */
    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final d f7754a;

        private a(d dVar) {
            this.f7754a = dVar;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            this.f7754a.a(message);
        }
    }

    public d() {
        if (this.f7752e != null) {
            this.f7752e = null;
        }
        this.f7753f = true;
    }

    private void a() {
        if (this.f7752e != null) {
            this.f7752e = null;
        }
        this.f7753f = true;
    }

    private boolean b() {
        return this.f7753f;
    }

    public abstract void a(List<Rapdu> list);

    public abstract void b(int i10, Error error);

    public abstract void b(int i10, List<Rapdu> list, Error error);

    public abstract void b(Rapdu rapdu);

    private void b(Message message) {
        if (this.f7753f || this.f7752e == null) {
            a(message);
        } else if (!Thread.currentThread().isInterrupted()) {
            this.f7752e.sendMessage(message);
        }
    }

    public final void a(Message message) {
        Object[] objArr;
        int i10 = message.what;
        if (i10 == 0) {
            Object[] objArr2 = (Object[]) message.obj;
            if (objArr2 != null && objArr2.length > 0) {
                b(objArr2[0] == null ? null : (Rapdu) objArr2[0]);
            }
        } else if (i10 == 1) {
            Object[] objArr3 = (Object[]) message.obj;
            if (objArr3 != null && objArr3.length >= 2) {
                Integer.parseInt(objArr3[0].toString());
                a((List) objArr3[1]);
            }
        } else if (i10 == 2) {
            Object[] objArr4 = (Object[]) message.obj;
            if (objArr4 != null && objArr4.length >= 2) {
                b(Integer.parseInt(objArr4[0].toString()), (Error) objArr4[1]);
            }
        } else if (i10 == 3 && (objArr = (Object[]) message.obj) != null && objArr.length >= 3) {
            b(Integer.parseInt(objArr[0].toString()), (List) objArr[1], (Error) objArr[2]);
        }
    }

    public final void a(Rapdu rapdu) {
        b(a(0, new Object[]{rapdu}));
    }

    public final void a(int i10, List<Rapdu> list) {
        b(a(1, new Object[]{Integer.valueOf(i10), list}));
    }

    public final void a(int i10, List<Rapdu> list, Error error) {
        b(a(3, new Object[]{Integer.valueOf(i10), list, error}));
    }

    public final void a(int i10, Error error) {
        b(a(2, new Object[]{Integer.valueOf(i10), error}));
    }

    public final void a(Runnable runnable, long j10) {
        this.f7752e.postDelayed(runnable, j10);
    }

    private Message a(int i10, Object obj) {
        a aVar = this.f7752e;
        if (aVar != null) {
            return Message.obtain(aVar, i10, obj);
        }
        Message obtain = Message.obtain();
        if (obtain == null) {
            return obtain;
        }
        obtain.what = i10;
        obtain.obj = obj;
        return obtain;
    }
}
