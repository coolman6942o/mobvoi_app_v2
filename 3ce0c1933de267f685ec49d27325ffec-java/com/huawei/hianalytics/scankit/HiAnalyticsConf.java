package com.huawei.hianalytics.scankit;

import android.content.Context;
import com.huawei.hianalytics.mn.no.b.rs;
import com.huawei.hianalytics.mn.no.op.mn.op;
import com.huawei.hianalytics.mn.no.qr.mn;
import com.huawei.hianalytics.mn.rs.no;
/* loaded from: classes.dex */
public class HiAnalyticsConf {

    /* loaded from: classes.dex */
    public static class Builder {
        String appid;
        Context mContext;
        op maintData;
        op operData;

        public Builder(Context context) {
            if (context != null) {
                this.mContext = context.getApplicationContext();
            }
            this.operData = new op();
            this.maintData = new op();
        }

        public void create() {
            if (this.mContext == null) {
                mn.pq("hmsSdk", "analyticsConf create(): context is null,create failed!");
                return;
            }
            mn.no("hmsSdk", "Builder.create() is execute.");
            com.huawei.hianalytics.mn.rs.op opVar = new com.huawei.hianalytics.mn.rs.op("_hms_config_tag");
            opVar.op(new op(this.operData));
            opVar.mn(new op(this.maintData));
            com.huawei.hianalytics.mn.rs.mn.mn().mn(this.mContext);
            no.mn().mn(this.mContext);
            mn.mn().mn(opVar);
            com.huawei.hianalytics.mn.rs.mn.mn().no(this.appid);
        }

        public void refresh(boolean z10) {
            mn.no("hmsSdk", "Builder.refresh() is execute.");
            op opVar = new op(this.maintData);
            op opVar2 = new op(this.operData);
            com.huawei.hianalytics.mn.rs.op no2 = mn.mn().no();
            if (no2 == null) {
                mn.op("hmsSdk", "HiAnalyticsInstance.Builder.Refresh(): calling refresh before create. TAG: _hms_config_tag has no instance. ");
                return;
            }
            no2.mn(1, opVar);
            no2.mn(0, opVar2);
            if (this.appid != null) {
                com.huawei.hianalytics.mn.rs.mn.mn().no(this.appid);
            }
            if (z10) {
                com.huawei.hianalytics.mn.rs.mn.mn().mn("_hms_config_tag");
            }
        }

        public Builder setAndroidId(String str) {
            mn.no("hmsSdk", "setAndroidId(String androidId) is execute.");
            if (!com.huawei.hianalytics.mn.no.b.op.mn("androidId", str, 4096)) {
                str = "";
            }
            this.operData.no().op(str);
            this.maintData.no().op(str);
            return this;
        }

        public Builder setAppID(String str) {
            mn.no("hmsSdk", "Builder.setAppID is execute");
            this.appid = str;
            return this;
        }

        public Builder setChannel(String str) {
            mn.no("hmsSdk", "Builder.setChannel(String channel) is execute.");
            if (!com.huawei.hianalytics.mn.no.b.op.mn("channel", str, 256)) {
                str = "";
            }
            this.operData.mn(str);
            this.maintData.mn(str);
            return this;
        }

        public Builder setCollectURL(int i10, String str) {
            op opVar;
            mn.no("hmsSdk", "Builder.setCollectURL(int type,String collectURL) is execute.TYPE : ".concat(String.valueOf(i10)));
            if (!rs.mn(str)) {
                str = "";
            }
            if (i10 == 0) {
                opVar = this.operData;
            } else if (i10 != 1) {
                mn.op("hmsSdk", "Builder.setCollectURL(int type,String collectURL): invalid type!");
                return this;
            } else {
                opVar = this.maintData;
            }
            opVar.no(str);
            return this;
        }

        @Deprecated
        public Builder setEnableAndroidID(boolean z10) {
            mn.no("hmsSdk", "Builder.setEnableAndroidID(boolean reportAndroidID) is execute.");
            this.operData.no().pq(z10);
            this.maintData.no().pq(z10);
            return this;
        }

        @Deprecated
        public Builder setEnableImei(boolean z10) {
            mn.no("hmsSdk", "Builder.setEnableImei(boolean isReportAndroidImei) is execute.");
            this.operData.no().mn(z10);
            this.maintData.no().mn(z10);
            return this;
        }

        public Builder setEnableMccMnc(boolean z10) {
            mn.no("hmsSdk", "Builder.setEnableMccMnc(boolean enableMccMnc) is execute.");
            this.operData.no(z10);
            this.maintData.no(z10);
            return this;
        }

        @Deprecated
        public Builder setEnableSN(boolean z10) {
            mn.no("hmsSdk", "Builder.setEnableSN(boolean isReportSN) is execute.");
            this.operData.no().no(z10);
            this.maintData.no().no(z10);
            return this;
        }

        @Deprecated
        public Builder setEnableUDID(boolean z10) {
            mn.no("hmsSdk", "Builder.setEnableUDID(boolean isReportUDID) is execute.");
            this.operData.no().op(z10);
            this.maintData.no().op(z10);
            return this;
        }

        public Builder setEnableUUID(boolean z10) {
            mn.mn("hmsSdk", "Builder.setEnableUUID() is executed.");
            this.operData.op(z10);
            this.maintData.op(z10);
            return this;
        }

        public Builder setIMEI(String str) {
            mn.no("hmsSdk", "setIMEI(String imei) is execute.");
            if (!com.huawei.hianalytics.mn.no.b.op.mn("imei", str, 4096)) {
                str = "";
            }
            this.operData.no().mn(str);
            this.maintData.no().mn(str);
            return this;
        }

        public Builder setSDKPkgName(String str) {
            mn.mn("hmsSdk", "Builder.setSDKPkgName is executed");
            if (com.huawei.hianalytics.mn.no.b.op.mn("sdkPkgName", str, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}")) {
                this.operData.st(str);
                this.maintData.st(str);
            }
            return this;
        }

        public Builder setSN(String str) {
            mn.no("hmsSdk", "setSN(String sn) is execute.");
            if (!com.huawei.hianalytics.mn.no.b.op.mn("sn", str, 4096)) {
                str = "";
            }
            this.operData.no().pq(str);
            this.maintData.no().pq(str);
            return this;
        }

        public Builder setUDID(String str) {
            mn.no("hmsSdk", "setUDID(String udid) is execute.");
            if (!com.huawei.hianalytics.mn.no.b.op.mn("udid", str, 4096)) {
                str = "";
            }
            this.operData.no().no(str);
            this.maintData.no().no(str);
            return this;
        }
    }
}
