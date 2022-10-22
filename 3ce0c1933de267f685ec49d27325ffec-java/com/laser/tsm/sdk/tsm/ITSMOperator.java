package com.laser.tsm.sdk.tsm;

import com.laser.tsm.sdk.business.BaseResponse;
import com.laser.tsm.sdk.business.SsdAppStatusQueryForResp;
/* loaded from: classes2.dex */
public interface ITSMOperator {
    int addGPAC(String str);

    int applyPAMID();

    int cascadingDeleteSSD(String str);

    int createSSD(String str, String str2, String str3);

    int deleteApplet(String str, String str2);

    int deleteGPAC(String str);

    int deleteSSD(String str);

    String getCIN();

    String getCPLC();

    String getIIN();

    String getSEID();

    int installApplet(String str, String str2);

    int keyUpdate(String str);

    int keyUpdateISD(String str);

    int lockApplet(String str, String str2);

    int lockISD(String str);

    int lockSE();

    int lockSSD(String str);

    int notifyEseInfoSync();

    int notifyInfoInit();

    int personalApplet(String str, String str2);

    boolean selectApplet(String str);

    BaseResponse<SsdAppStatusQueryForResp> ssdOrAppStatusQuery();

    int stopSE();

    int unlockApplet(String str, String str2);

    int unlockISD(String str);

    int unlockISD_Q(String str);

    int unlockSE();

    int unlockSSD(String str);
}
