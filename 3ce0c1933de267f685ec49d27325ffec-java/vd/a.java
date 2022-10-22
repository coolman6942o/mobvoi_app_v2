package vd;

import com.alibaba.fastjson.annotation.JSONField;
import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.wear.permission.PermissionConstant;
import com.mobvoi.wear.util.TelephonyUtil;
import java.util.HashMap;
/* compiled from: CardInfo.java */
/* loaded from: classes2.dex */
public class a implements JsonBean {
    @JSONField(name = "card_number")
    public String cardNumber;
    @JSONField(name = "cplc")
    public String cplc;
    @JSONField(name = "enable_time")
    public long enableTime;
    @JSONField(name = "extras")
    public HashMap<String, String> extras = new HashMap<>();
    @JSONField(name = TelephonyUtil.CARD_ID)

    /* renamed from: id  reason: collision with root package name */
    public String f35731id;
    @JSONField(name = PermissionConstant.Columns.STATUS)
    public String status;
    @JSONField(name = TelephonyUtil.KEY_SIM_ACTIVITIED_CHANNLE)
    public String subtype;
    @JSONField(name = "type")
    public String type;
    @JSONField(name = "watch_device_id")
    public String watchDeviceId;
    @JSONField(name = "wwid")
    public String wwid;
}
