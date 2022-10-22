package t2;

import cn.com.fmsh.script.ApduHandler;
import cn.com.fmsh.tsm.business.bean.CardAppRecord;
import cn.com.fmsh.tsm.business.enums.EnumCardAppStatus;
import cn.com.fmsh.tsm.business.exception.BusinessException;
import java.util.List;
/* loaded from: classes.dex */
public interface a {
    void a(ApduHandler apduHandler);

    int b() throws BusinessException;

    String c() throws BusinessException;

    byte[] d() throws BusinessException;

    List<CardAppRecord> e() throws BusinessException;

    String f() throws BusinessException;

    EnumCardAppStatus getStatus() throws BusinessException;
}
