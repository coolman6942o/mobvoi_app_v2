package h4;

import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
/* loaded from: classes.dex */
public interface a {
    DataReportResult a(DataReportRequest dataReportRequest);

    boolean logCollect(String str);
}
