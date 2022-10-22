package h4;

import android.content.Context;
import c4.a;
import com.alipay.android.phone.mrpc.core.aa;
import com.alipay.android.phone.mrpc.core.h;
import com.alipay.android.phone.mrpc.core.w;
import com.alipay.tscenter.biz.rpc.deviceFp.BugTrackMessageService;
import com.alipay.tscenter.biz.rpc.report.general.DataReportService;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import com.unionpay.tsmservice.data.Constant;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c implements a {

    /* renamed from: d  reason: collision with root package name */
    public static c f27731d;

    /* renamed from: e  reason: collision with root package name */
    public static DataReportResult f27732e;

    /* renamed from: a  reason: collision with root package name */
    public w f27733a;

    /* renamed from: b  reason: collision with root package name */
    public BugTrackMessageService f27734b;

    /* renamed from: c  reason: collision with root package name */
    public DataReportService f27735c;

    public c(Context context, String str) {
        this.f27733a = null;
        this.f27734b = null;
        this.f27735c = null;
        aa aaVar = new aa();
        aaVar.a(str);
        h hVar = new h(context);
        this.f27733a = hVar;
        this.f27734b = (BugTrackMessageService) hVar.a(BugTrackMessageService.class, aaVar);
        this.f27735c = (DataReportService) this.f27733a.a(DataReportService.class, aaVar);
    }

    public static synchronized c e(Context context, String str) {
        c cVar;
        synchronized (c.class) {
            if (f27731d == null) {
                f27731d = new c(context, str);
            }
            cVar = f27731d;
        }
        return cVar;
    }

    @Override // h4.a
    public DataReportResult a(DataReportRequest dataReportRequest) {
        if (dataReportRequest == null) {
            return null;
        }
        if (this.f27735c != null) {
            f27732e = null;
            new Thread(new b(this, dataReportRequest)).start();
            for (int i10 = 300000; f27732e == null && i10 >= 0; i10 -= 50) {
                Thread.sleep(50L);
            }
        }
        return f27732e;
    }

    @Override // h4.a
    public boolean logCollect(String str) {
        BugTrackMessageService bugTrackMessageService;
        if (a.d(str) || (bugTrackMessageService = this.f27734b) == null) {
            return false;
        }
        String str2 = null;
        try {
            str2 = bugTrackMessageService.logCollect(a.k(str));
        } catch (Throwable unused) {
        }
        if (!a.d(str2)) {
            return ((Boolean) new JSONObject(str2).get(Constant.CASH_LOAD_SUCCESS)).booleanValue();
        }
        return false;
    }
}
