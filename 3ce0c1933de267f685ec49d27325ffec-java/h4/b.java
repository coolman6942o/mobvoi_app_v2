package h4;

import c4.a;
import com.alipay.tscenter.biz.rpc.report.general.DataReportService;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DataReportRequest f27729a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f27730b;

    public b(c cVar, DataReportRequest dataReportRequest) {
        this.f27730b = cVar;
        this.f27729a = dataReportRequest;
    }

    @Override // java.lang.Runnable
    public void run() {
        DataReportResult dataReportResult;
        DataReportResult dataReportResult2;
        DataReportService dataReportService;
        try {
            dataReportService = this.f27730b.f27735c;
            DataReportResult unused = c.f27732e = dataReportService.reportData(this.f27729a);
        } catch (Throwable th2) {
            DataReportResult unused2 = c.f27732e = new DataReportResult();
            dataReportResult = c.f27732e;
            dataReportResult.success = false;
            dataReportResult2 = c.f27732e;
            dataReportResult2.resultCode = "static data rpc upload error, " + a.b(th2);
            a.b(th2);
        }
    }
}
