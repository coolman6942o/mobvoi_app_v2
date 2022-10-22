package i2;

import cn.com.fmsh.tsm.business.bean.BusinessOrder;
import cn.com.fmsh.tsm.business.bean.CardAppRecord;
import cn.com.fmsh.tsm.business.bean.c;
import cn.com.fmsh.tsm.business.bean.d;
import cn.com.fmsh.tsm.business.enums.EnumBusinessOrderType;
import cn.com.fmsh.tsm.business.enums.EnumCardAppStatus;
import cn.com.fmsh.tsm.business.enums.EnumCardAppType;
import cn.com.fmsh.tsm.business.enums.EnumOrderStatus;
import cn.com.fmsh.tsm.business.exception.BusinessException;
import java.util.List;
/* compiled from: NfcosClientManager.java */
/* loaded from: classes.dex */
public interface a {
    int a(byte[] bArr, byte[] bArr2) throws BusinessException;

    int b() throws BusinessException;

    Integer c(EnumCardAppType enumCardAppType) throws BusinessException;

    cn.com.fmsh.tsm.business.bean.a d(byte[] bArr, EnumCardAppType enumCardAppType, byte[] bArr2, String str) throws BusinessException;

    d e(byte[] bArr) throws BusinessException;

    String f(byte[] bArr) throws BusinessException;

    byte[] g(EnumCardAppType enumCardAppType) throws BusinessException;

    String h(EnumCardAppType enumCardAppType) throws BusinessException;

    List<CardAppRecord> i(EnumCardAppType enumCardAppType) throws BusinessException;

    List<BusinessOrder> j(int i10, int i11, EnumCardAppType enumCardAppType, EnumBusinessOrderType enumBusinessOrderType, List<EnumOrderStatus> list, byte[] bArr) throws BusinessException;

    void k(n2.a aVar);

    boolean l(byte[] bArr, String str, String str2, byte[] bArr2) throws BusinessException;

    c m(String str, String str2) throws BusinessException;

    d n(int i10, int i11, byte[] bArr, EnumCardAppType enumCardAppType) throws BusinessException;

    int o(String str, String str2) throws BusinessException;

    boolean p(byte[] bArr, byte[] bArr2) throws BusinessException;

    String q(EnumCardAppType enumCardAppType) throws BusinessException;

    boolean r(byte[] bArr, byte[] bArr2) throws BusinessException;

    d s(EnumCardAppType enumCardAppType, int i10, byte[] bArr, int i11, String str, byte[] bArr2) throws BusinessException;

    EnumCardAppStatus t(EnumCardAppType enumCardAppType) throws BusinessException;

    List<BusinessOrder> u(int i10, int i11, EnumCardAppType enumCardAppType, EnumBusinessOrderType enumBusinessOrderType, List<EnumOrderStatus> list) throws BusinessException;
}
