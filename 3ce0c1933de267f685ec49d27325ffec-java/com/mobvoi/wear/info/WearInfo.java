package com.mobvoi.wear.info;

import com.mobvoi.android.common.json.JsonBean;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class WearInfo implements JsonBean, Serializable {
    public String btAddress;
    public String btName;
    public String certModel;
    public boolean hasNfcFeature;
    public boolean isMfiSupported;
    public String region;
    public String skuColor;
    public String skuTheme;

    /* renamed from: sn  reason: collision with root package name */
    public String f20927sn;
    public String ticwatchChannel;
    public String wearCapability;
    public String wearChannel;
    public String wearDeviceId;
    public String wearType;
    public String wearVersion;
    public long wearVersionNumber;
    public String wearVersionRegion;

    public String toString() {
        return "WearInfo{wearDeviceId='" + this.wearDeviceId + "', isMfiSupported=" + this.isMfiSupported + ", wearVersion='" + this.wearVersion + "', wearVersionRegion='" + this.wearVersionRegion + "', wearVersionNumber='" + this.wearVersionNumber + "', wearType='" + this.wearType + "', wearChannel='" + this.wearChannel + "', hasNfcFeature='" + this.hasNfcFeature + "', ticwatchChannel='" + this.ticwatchChannel + "', wearCapability='" + this.wearCapability + "', region='" + this.region + "', skuColor='" + this.skuColor + "', skuTheme='" + this.skuTheme + "', btName='" + this.btName + "', btAddress='" + this.btAddress + "', sn='" + this.f20927sn + "', certModel='" + this.certModel + "'}";
    }
}
