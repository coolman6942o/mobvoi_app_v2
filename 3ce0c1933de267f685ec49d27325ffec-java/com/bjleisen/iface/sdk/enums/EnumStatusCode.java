package com.bjleisen.iface.sdk.enums;

import com.amap.api.services.core.AMapException;
import com.unionpay.tsmservice.data.Constant;
/* loaded from: classes.dex */
public enum EnumStatusCode {
    STATUS_SUCCESS(0, Constant.CASH_LOAD_SUCCESS),
    STATUS_REQUEST_FAILURE(1000, "服务器请求失败"),
    STATUS_DATA_PARSE_FAILURE(1001, "数据解析失败"),
    STATUS_SMARTCARD_OPER_FAILURE(1002, "指令执行失败"),
    STATUS_BIND_BLUETOOTHSERVICE_ERROR(1003, "蓝牙接口异常"),
    STATUS_CONNECTION_DEVICE_FAILURE(AMapException.CODE_AMAP_DAILY_QUERY_OVER_LIMIT, "connect bluetooth device failure"),
    STATUS_CPLC_IS_NULL(AMapException.CODE_AMAP_ACCESS_TOO_FREQUENT, "CPLC为空"),
    STATUS_GET_DEVICEINFO_FAILURE(AMapException.CODE_AMAP_INVALID_USER_IP, "蓝牙接口设备信息获取失败"),
    STATUS_NULL_PARAMS(AMapException.CODE_AMAP_INVALID_USER_DOMAIN, "请求参数为空"),
    STATUS_USER_CANCEL(AMapException.CODE_AMAP_INVALID_USER_SCODE, "execute apdu interrupt"),
    STATUS_SMARTCARD_READER_NOT_EXIST(AMapException.CODE_AMAP_USERKEY_PLAT_NOMATCH, "Choose reader not exist"),
    STATUS_SMARTCARD_OPEN_CHANNEL_FAIL(AMapException.CODE_AMAP_IP_QUERY_OVER_LIMIT, "Choose reader can not use"),
    STATUS_UNINITIALIZED(AMapException.CODE_AMAP_NOT_SUPPORT_HTTPS, "SDK未初始化"),
    STATUS_CARD_TEMPLATE_ERROR(AMapException.CODE_AMAP_INSUFFICIENT_PRIVILEGES, "卡信息模板错误");
    
    private String msg;
    private int status;

    EnumStatusCode(int i10, String str) {
        this.status = i10;
        this.msg = str;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setMsg(String str) {
        this.msg = str;
    }

    public final void setStatus(int i10) {
        this.status = i10;
    }
}
