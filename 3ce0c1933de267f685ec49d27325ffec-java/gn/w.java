package gn;

import android.os.CountDownTimer;
import com.alipay.sdk.app.PayTask;
import com.mobvoi.wear.lpa.LpaConstants;
import dn.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class w {

    /* renamed from: e  reason: collision with root package name */
    private static w f27602e;

    /* renamed from: d  reason: collision with root package name */
    private f f27606d;

    /* renamed from: a  reason: collision with root package name */
    public List<Integer> f27603a = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private int f27605c = 0;

    /* renamed from: b  reason: collision with root package name */
    private a f27604b = new a(PayTask.f6879j, 1000);

    /* loaded from: classes2.dex */
    private class a extends CountDownTimer {
        public a(long j10, long j11) {
            super(j10, j11);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            w.g("通知命令超时了 commandType=" + w.this.f27605c);
            w.this.f27606d.a(w.this.f27605c);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
        }
    }

    private w() {
    }

    public static w e() {
        if (f27602e == null) {
            f27602e = new w();
        }
        return f27602e;
    }

    public static void g(Object obj) {
        u.d("BluetoothLeService", obj == null ? LpaConstants.VALUE_NULL : obj.toString());
    }

    public List<Integer> b() {
        for (int i10 = 0; i10 < this.f27603a.size(); i10++) {
            g("需要执行的通知命令 = " + this.f27603a.get(i10));
        }
        return this.f27603a;
    }

    public void d() {
        g("关闭通知命令 commandType=" + this.f27605c);
        a aVar = this.f27604b;
        if (aVar != null) {
            aVar.cancel();
        }
    }

    public List<Integer> f() {
        return this.f27603a;
    }

    public int h() {
        List<Integer> list = this.f27603a;
        if (list == null || list.size() <= 0) {
            g("没有通知命令可以移除");
            return -1;
        }
        int intValue = this.f27603a.remove(0).intValue();
        g("移除的通知命令 = " + intValue + ",还剩 =" + this.f27603a.size() + "个命令");
        return intValue;
    }

    public void i() {
        this.f27603a = new ArrayList();
    }

    public void j(int i10) {
        g("开启通知命令 commandType=" + i10);
        this.f27605c = i10;
        a aVar = this.f27604b;
        if (aVar != null) {
            aVar.start();
        }
    }

    public void k(f fVar) {
        this.f27606d = fVar;
    }
}
