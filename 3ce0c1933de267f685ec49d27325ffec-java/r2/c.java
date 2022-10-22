package r2;

import cn.com.fmsh.tsm.business.bean.a;
import cn.com.fmsh.tsm.business.enums.EnumCardAppType;
import cn.com.fmsh.tsm.business.exception.BusinessException;
/* loaded from: classes.dex */
public interface c {
    boolean a(String str, byte[] bArr, String str2, byte[] bArr2) throws BusinessException;

    boolean b(byte[] bArr, int i10, byte[] bArr2, byte[] bArr3) throws BusinessException;

    a d(byte[] bArr, EnumCardAppType enumCardAppType, byte[] bArr2, String str) throws BusinessException;
}
