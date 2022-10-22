package bn;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Message;
import com.alipay.sdk.app.PayTask;
import com.yc.pedometer.dial.OnlineDialUtil;
import en.q;
/* loaded from: classes2.dex */
public class i {

    /* renamed from: d  reason: collision with root package name */
    private static i f5298d;

    /* renamed from: b  reason: collision with root package name */
    private Context f5300b;

    /* renamed from: c  reason: collision with root package name */
    private int f5301c = 0;

    /* renamed from: a  reason: collision with root package name */
    private a f5299a = new a(PayTask.f6879j, 1000);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends CountDownTimer {
        public a(long j10, long j11) {
            super(j10, j11);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            OnlineDialUtil.b("表盘计时器 超时了 commandType=" + i.this.f5301c + "，当做发送数据段OK，发下一段");
            OnlineDialUtil.b("");
            Message message = new Message();
            q.B(i.this.f5300b).getClass();
            message.what = 2;
            q.B(i.this.f5300b).f26208h.sendMessageDelayed(message, OnlineDialUtil.f24597c);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
        }
    }

    private i(Context context) {
        this.f5300b = context;
    }

    public static i d(Context context) {
        if (f5298d == null) {
            f5298d = new i(context);
        }
        return f5298d;
    }

    public void c() {
        OnlineDialUtil.b("表盘计时器 关闭 commandType=" + this.f5301c);
        a aVar = this.f5299a;
        if (aVar != null) {
            aVar.cancel();
        }
    }

    public void e(int i10) {
        OnlineDialUtil.b("表盘计时器 开启 commandType=" + i10);
        this.f5301c = i10;
        a aVar = this.f5299a;
        if (aVar != null) {
            aVar.start();
        }
    }
}
