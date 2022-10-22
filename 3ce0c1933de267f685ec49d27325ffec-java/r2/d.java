package r2;

import cn.com.fmsh.tsm.business.bean.BusinessOrder;
import cn.com.fmsh.tsm.business.bean.CardAppRecord;
import cn.com.fmsh.tsm.business.bean.UserInfo;
import cn.com.fmsh.tsm.business.bean.c;
import cn.com.fmsh.tsm.business.enums.EnumBusinessOrderType;
import cn.com.fmsh.tsm.business.enums.EnumCardAppType;
import cn.com.fmsh.tsm.business.enums.EnumOrderStatus;
import cn.com.fmsh.tsm.business.exception.BusinessException;
import java.util.List;
/* loaded from: classes.dex */
public interface d {
    int a(byte[] bArr, byte[] bArr2) throws BusinessException;

    int b() throws BusinessException;

    Integer c(EnumCardAppType enumCardAppType) throws BusinessException;

    cn.com.fmsh.tsm.business.bean.d d(byte[] bArr, EnumCardAppType enumCardAppType, byte[] bArr2) throws BusinessException;

    cn.com.fmsh.tsm.business.bean.d e(byte[] bArr) throws BusinessException;

    String f(byte[] bArr) throws BusinessException;

    byte[] g(EnumCardAppType enumCardAppType) throws BusinessException;

    String h(EnumCardAppType enumCardAppType) throws BusinessException;

    List<CardAppRecord> i(EnumCardAppType enumCardAppType) throws BusinessException;

    String j(EnumCardAppType enumCardAppType) throws BusinessException;

    int k(UserInfo userInfo) throws BusinessException;

    boolean l(byte[] bArr, byte[] bArr2) throws BusinessException;

    cn.com.fmsh.tsm.business.bean.d m(int i10, int i11, byte[] bArr, EnumCardAppType enumCardAppType) throws BusinessException;

    List<BusinessOrder> n(int i10, int i11, EnumCardAppType enumCardAppType, EnumBusinessOrderType enumBusinessOrderType, List<EnumOrderStatus> list, byte[] bArr) throws BusinessException;

    c o(String str, String str2) throws BusinessException;
}
