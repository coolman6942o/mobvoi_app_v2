package w2;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import cn.com.fmsh.script.ApduHandler;
import cn.com.fmsh.script.exception.FMScriptHandleException;
import cn.com.fmsh.tsm.business.enums.EnumAppManageOperateType;
import cn.com.fmsh.tsm.business.enums.EnumCardAppType;
import cn.com.fmsh.tsm.business.enums.EnumIssueProcess;
import cn.com.fmsh.tsm.business.exception.BusinessException;
import com.realsil.sdk.dfu.DfuException;
import f2.e;
import java.util.Arrays;
import java.util.List;
import r2.c;
import r2.e;
import x2.f;
import x2.g;
import x2.h;
import z2.a;
import z2.b;
/* loaded from: classes.dex */
public class d implements c {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ byte[] f35951a;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ a f35953c;

    /* renamed from: e  reason: collision with root package name */
    private /* synthetic */ f f35955e;

    /* renamed from: f  reason: collision with root package name */
    private /* synthetic */ boolean f35956f;

    /* renamed from: g  reason: collision with root package name */
    private /* synthetic */ e f35957g;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ int f35952b = 0;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ String f35954d = d.class.getName();

    public d(f fVar) {
        this.f35953c = null;
        this.f35955e = fVar;
        this.f35953c = b.a().b();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:35|(1:37)|38|(4:127|39|40|(9:133|41|42|131|43|(1:45)|46|129|47))|(1:60)(1:61)|(1:63)(1:64)|(2:137|65)|125|77|78|(3:91|(1:93)(1:94)|95)|96|(2:98|(12:101|(1:103)(1:104)|105|(2:135|108)(1:110)|109|111|112|118|(1:120)|121|(2:123|140)(1:141)|124))|106|(0)(0)|109|111|112|118|(0)|121|(0)(0)|124|31) */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0200, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0201, code lost:
        r3 = r18.f35953c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0203, code lost:
        if (r3 != null) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0205, code lost:
        r3.c(r18.f35954d, cn.com.fmsh.FM_Exception.insert(5, 21, "??????????????????????????????????????????5") + x2.h.f(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0228, code lost:
        if (cn.com.fmsh.script.exception.FMScriptHandleException.ScriptHandleExceptionType.STOPED == r0.getType()) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x022a, code lost:
        r0 = r18.f35955e;
        r3 = x2.g.a(5, 102, "?????????????????????");
        r5 = cn.com.fmsh.tsm.business.exception.BusinessException.ErrorMessage.local_business_cancel;
        r7 = true;
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0238, code lost:
        r7 = true;
        r0 = r18.f35955e;
        r3 = x2.f.a("????????????????????????", 5);
        r5 = cn.com.fmsh.tsm.business.exception.BusinessException.ErrorMessage.local_message_apdu_execute_exception;
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0243, code lost:
        r0.t(r3, r5, r7);
        r7 = r7;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02af A[Catch: FMCommunicationMessageException -> 0x02bc, TryCatch #7 {FMCommunicationMessageException -> 0x02bc, blocks: (B:108:0x02a7, B:109:0x02ab, B:110:0x02af, B:111:0x02b4), top: B:135:0x02a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0315 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0274  */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final /* bridge */ /* synthetic */ byte[] c(byte[] bArr, String str, f2.b bVar, String str2) throws BusinessException {
        f2.c cVar;
        f2.c cVar2;
        f2.a aVar;
        f2.c c10;
        char c11;
        int i10;
        byte[] bArr2;
        a aVar2;
        a aVar3;
        a aVar4;
        int i11;
        String str3;
        f fVar;
        FMCommunicationMessageException e10;
        f2.b bVar2 = bVar;
        char c12 = 0;
        this.f35956f = false;
        f fVar2 = this.f35955e;
        int i12 = 1;
        if (fVar2 == null) {
            a aVar5 = this.f35953c;
            if (aVar5 != null) {
                aVar5.c(this.f35954d, String.valueOf(str) + x2.b.b(1, "???????????????????????????"));
            }
            throw new BusinessException(String.valueOf(str) + x2.d.c("?????????????????????????????????", 2), BusinessException.ErrorMessage.local_business_init_fail);
        }
        fVar2.e(str, str2);
        ApduHandler i13 = this.f35955e.i();
        int i14 = 6;
        if (i13 == null) {
            a aVar6 = this.f35953c;
            if (aVar6 != null) {
                aVar6.b(this.f35954d, FM_Exception.insert(6, 86, "??????????????????O\u0014^E???????????????"));
            }
            this.f35955e.t(x2.b.b(3, "???????????????????????????????????????????????????????????????\u007fM@Y,@_\u0007f"), BusinessException.ErrorMessage.local_business_apdu_handler_null, false);
        }
        if (i13.c()) {
            a aVar7 = this.f35953c;
            if (aVar7 != null) {
                aVar7.b(this.f35954d, x2.d.c("???????????????\uff00\\^\u001b\u0005???????????????", 4));
            }
            this.f35955e.t(f.a("?????????????????????????????????\n\u0018\u0001\u0017???????????????", 4), BusinessException.ErrorMessage.local_business_apdu_handler_busying, false);
        } else {
            i13.b();
        }
        byte[] n10 = this.f35955e.n(bArr, str, true, str2);
        if (n10 == null || n10.length < 1) {
            a aVar8 = this.f35953c;
            if (aVar8 != null) {
                aVar8.c(this.f35954d, x2.b.b(252, "??????????????????????????????"));
            }
            this.f35955e.t(x2.d.c("?????????????????????????????????????????????", 1), BusinessException.ErrorMessage.local_communication_no_response, true);
        }
        byte[] copyOf = Arrays.copyOf(n10, 2);
        int i15 = 0;
        boolean z10 = false;
        p2.a aVar9 = null;
        f2.a aVar10 = null;
        while (Arrays.equals(v2.b.f35578b, copyOf)) {
            if (this.f35956f) {
                this.f35955e.t(h.e("???????????????????????????????????????", i14, 29), BusinessException.ErrorMessage.local_business_cancel, i12);
            }
            p2.c cVar3 = new p2.c();
            try {
                f2.a d10 = bVar2.d(n10);
                cVar = d10.b(-96);
                try {
                    cVar2 = d10.b(-95);
                    try {
                        f2.c b10 = d10.b(-90);
                        f2.c b11 = d10.b(-89);
                        if (b11 != null) {
                            byte[] bArr3 = new byte[i12];
                            bArr3[c12] = b11.h()[c12];
                            i15 = x2.d.a(bArr3);
                        }
                        aVar = bVar2.e(9001);
                        try {
                            aVar.c(b10);
                            aVar.c(b11);
                        } catch (FMCommunicationMessageException e11) {
                            e10 = e11;
                            aVar10 = aVar;
                            a aVar11 = this.f35953c;
                            if (aVar11 != null) {
                                aVar11.c(x2.d.c("4&=\u001f}j", 5), String.valueOf(str) + g.a(5, 117, "????????????????????????????????????k") + h.f(e10));
                            }
                            this.f35955e.t(h.e("??????????????????????????????", 2, 88), BusinessException.ErrorMessage.local_message_command_data_invaild, true);
                            aVar = aVar10;
                            if (cVar == null) {
                            }
                            if (cVar2 == null) {
                            }
                            cVar3.d(cVar2);
                            aVar9 = this.f35955e.l().b(cVar3);
                            int i16 = 1;
                            if (aVar9 != null) {
                            }
                            aVar4 = this.f35953c;
                            if (aVar4 == null) {
                            }
                            this.f35955e.t(x2.e.a(i11, "????????????????????????"), BusinessException.ErrorMessage.local_message_apdu_execute_exception, true);
                            if (this.f35952b == 0) {
                            }
                            if (!z10) {
                            }
                            aVar.c(c10);
                            bArr2 = aVar.a();
                            i10 = 1;
                            c11 = 252;
                            aVar2 = this.f35953c;
                            if (aVar2 != null) {
                            }
                            aVar3 = this.f35953c;
                            if (aVar3 != null) {
                            }
                            n10 = this.f35955e.n(bArr2, str, true, str2);
                            copyOf = Arrays.copyOf(n10, 2);
                            i12 = 1;
                            aVar10 = aVar;
                            c12 = 0;
                            i14 = 6;
                            bVar2 = bVar;
                        }
                    } catch (FMCommunicationMessageException e12) {
                        e10 = e12;
                    }
                } catch (FMCommunicationMessageException e13) {
                    e10 = e13;
                    cVar2 = null;
                }
            } catch (FMCommunicationMessageException e14) {
                e10 = e14;
                cVar2 = null;
                cVar = null;
            }
            if (cVar == null) {
                z10 = false;
            } else {
                cVar = null;
            }
            if (cVar2 == null) {
                z10 = true;
            } else {
                cVar2 = cVar;
            }
            try {
                cVar3.d(cVar2);
            } catch (FMCommunicationMessageException e15) {
                if (this.f35953c != null) {
                    this.f35953c.c(this.f35954d, f.a("??????????????????????????????????????????????????????", 196) + h.f(e15));
                }
                fVar = this.f35955e;
                str3 = x2.b.b(DfuException.ERROR_USER_NOT_ACTIVE_IMAGE_ERROR, "?????????????????????????????????");
                fVar.t(str3, BusinessException.ErrorMessage.local_communication_invalid_response, true);
                aVar9 = this.f35955e.l().b(cVar3);
                int i162 = 1;
                if (aVar9 != null) {
                }
                aVar4 = this.f35953c;
                if (aVar4 == null) {
                }
                this.f35955e.t(x2.e.a(i11, "????????????????????????"), BusinessException.ErrorMessage.local_message_apdu_execute_exception, true);
                if (this.f35952b == 0) {
                }
                if (!z10) {
                }
                aVar.c(c10);
                bArr2 = aVar.a();
                i10 = 1;
                c11 = 252;
                aVar2 = this.f35953c;
                if (aVar2 != null) {
                }
                aVar3 = this.f35953c;
                if (aVar3 != null) {
                }
                n10 = this.f35955e.n(bArr2, str, true, str2);
                copyOf = Arrays.copyOf(n10, 2);
                i12 = 1;
                aVar10 = aVar;
                c12 = 0;
                i14 = 6;
                bVar2 = bVar;
            } catch (FMScriptHandleException e16) {
                if (this.f35953c != null) {
                    this.f35953c.c(this.f35954d, FM_Exception.insert(2, 22, "???????????????????????????????????????????????????") + h.f(e16));
                }
                fVar = this.f35955e;
                str3 = x2.c.i("?????????????????????????????????", 4, 63);
                fVar.t(str3, BusinessException.ErrorMessage.local_communication_invalid_response, true);
                aVar9 = this.f35955e.l().b(cVar3);
                int i1622 = 1;
                if (aVar9 != null) {
                }
                aVar4 = this.f35953c;
                if (aVar4 == null) {
                }
                this.f35955e.t(x2.e.a(i11, "????????????????????????"), BusinessException.ErrorMessage.local_message_apdu_execute_exception, true);
                if (this.f35952b == 0) {
                }
                if (!z10) {
                }
                aVar.c(c10);
                bArr2 = aVar.a();
                i10 = 1;
                c11 = 252;
                aVar2 = this.f35953c;
                if (aVar2 != null) {
                }
                aVar3 = this.f35953c;
                if (aVar3 != null) {
                }
                n10 = this.f35955e.n(bArr2, str, true, str2);
                copyOf = Arrays.copyOf(n10, 2);
                i12 = 1;
                aVar10 = aVar;
                c12 = 0;
                i14 = 6;
                bVar2 = bVar;
            }
            aVar9 = this.f35955e.l().b(cVar3);
            int i16222 = 1;
            if (aVar9 != null || aVar9.b() < i16222) {
                aVar4 = this.f35953c;
                if (aVar4 == null) {
                    i11 = 4;
                    aVar4.c(this.f35954d, FM_Exception.insert(4, 98, "????????????????????????????????????"));
                } else {
                    i11 = 4;
                }
                this.f35955e.t(x2.e.a(i11, "????????????????????????"), BusinessException.ErrorMessage.local_message_apdu_execute_exception, true);
            }
            if (this.f35952b == 0) {
                EnumIssueProcess instance = EnumIssueProcess.instance(i15);
                if (!(this.f35957g == null || instance == null)) {
                    a aVar12 = this.f35953c;
                    if (aVar12 != null) {
                        aVar12.a(this.f35954d, h.e("????????????9?????????", 4, 13) + i15);
                    }
                    this.f35957g.a(instance);
                    if (!z10) {
                        try {
                            c10 = aVar9.c();
                        } catch (FMCommunicationMessageException unused) {
                            a aVar13 = this.f35953c;
                            if (aVar13 != null) {
                                c11 = 252;
                                aVar13.c(this.f35954d, FM_Exception.insert(252, 47, "??????????????????????????????????????????????????????"));
                            } else {
                                c11 = 252;
                            }
                            i10 = 1;
                            this.f35955e.t(f.a("??????????????????????????????", 160), BusinessException.ErrorMessage.local_message_message_handle_exception, true);
                            bArr2 = null;
                        }
                    } else {
                        c10 = aVar9.d();
                    }
                    aVar.c(c10);
                    bArr2 = aVar.a();
                    i10 = 1;
                    c11 = 252;
                    aVar2 = this.f35953c;
                    if (aVar2 != null) {
                        aVar2.a(this.f35954d, h.e("????????????i8.<\" *#k", 104, i10) + x2.c.c(bArr2));
                    }
                    aVar3 = this.f35953c;
                    if (aVar3 != null) {
                        aVar3.a(this.f35954d, x2.d.c("????????????????????????????????????????????????!.?", 300));
                    }
                    n10 = this.f35955e.n(bArr2, str, true, str2);
                    copyOf = Arrays.copyOf(n10, 2);
                    i12 = 1;
                    aVar10 = aVar;
                    c12 = 0;
                    i14 = 6;
                    bVar2 = bVar;
                }
            }
            if (!z10) {
            }
            aVar.c(c10);
            bArr2 = aVar.a();
            i10 = 1;
            c11 = 252;
            aVar2 = this.f35953c;
            if (aVar2 != null) {
            }
            aVar3 = this.f35953c;
            if (aVar3 != null) {
            }
            n10 = this.f35955e.n(bArr2, str, true, str2);
            copyOf = Arrays.copyOf(n10, 2);
            i12 = 1;
            aVar10 = aVar;
            c12 = 0;
            i14 = 6;
            bVar2 = bVar;
        }
        this.f35955e.d(i12);
        return n10;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(30:83|(3:85|(1:87)|88)|89|186|90|91|182|92|93|(5:194|94|(4:96|97|190|98)(1:99)|100|101)|(1:115)(1:116)|(1:118)(1:119)|120|(3:198|121|122)|192|135|136|(3:150|(1:152)(1:153)|154)(1:149)|155|(2:157|(3:160|(1:162)|163))|(2:196|165)(1:167)|166|168|169|175|(1:177)|178|(2:180|201)(1:202)|181|62) */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x042a, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x042b, code lost:
        r2 = r18.f35953c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x042d, code lost:
        if (r2 != null) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x042f, code lost:
        r2.c(r18.f35954d, x2.g.a(4, 33, "??????????????????????????????????????????x") + x2.h.f(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0453, code lost:
        if (cn.com.fmsh.script.exception.FMScriptHandleException.ScriptHandleExceptionType.STOPED == r0.getType()) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0455, code lost:
        r0 = r18.f35955e;
        r2 = x2.g.a(4, 107, "?????????????????????");
        r3 = cn.com.fmsh.tsm.business.exception.BusinessException.ErrorMessage.local_business_cancel;
        r8 = true;
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0462, code lost:
        r8 = true;
        r0 = r18.f35955e;
        r2 = x2.a.b("????????????????????????", 206, 100);
        r3 = cn.com.fmsh.tsm.business.exception.BusinessException.ErrorMessage.local_message_apdu_execute_exception;
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0472, code lost:
        r0.t(r2, r3, r8);
        r3 = r19;
        r8 = r8;
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0493  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x04a8  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x04e0 A[Catch: FMCommunicationMessageException -> 0x04eb, TryCatch #9 {FMCommunicationMessageException -> 0x04eb, blocks: (B:165:0x04d8, B:166:0x04dc, B:167:0x04e0, B:168:0x04e5), top: B:196:0x04d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0523  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0544  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x04d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0553 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final /* bridge */ /* synthetic */ boolean e(int i10, byte[] bArr, byte[] bArr2, byte[] bArr3, String str) throws BusinessException {
        byte[] bArr4;
        p2.a aVar;
        boolean z10;
        f2.c cVar;
        f2.c cVar2;
        f2.c c10;
        byte[] bArr5;
        a aVar2;
        a aVar3;
        a aVar4;
        boolean z11;
        BusinessException.ErrorMessage errorMessage;
        String str2;
        f fVar;
        FMCommunicationMessageException e10;
        byte[] bArr6 = bArr2;
        this.f35956f = false;
        f fVar2 = this.f35955e;
        if (fVar2 == null) {
            a aVar5 = this.f35953c;
            if (aVar5 != null) {
                aVar5.c(this.f35954d, String.valueOf(str) + x2.e.a(162, "???????????????????????????"));
            }
            throw new BusinessException(String.valueOf(str) + x2.a.b("?????????????????????????????????", 5, 10), BusinessException.ErrorMessage.local_business_init_fail);
        }
        f2.b k10 = fVar2.k();
        if (k10 == null) {
            a aVar6 = this.f35953c;
            if (aVar6 != null) {
                aVar6.c(this.f35954d, String.valueOf(str) + FM_Exception.insert(154, 41, "?????????????????????????????????????????????????????????"));
            }
            throw new BusinessException(String.valueOf(str) + f.a("?????????U_\\????????????????????????", 162), BusinessException.ErrorMessage.local_message_load_config_fail);
        }
        String m10 = this.f35955e.m(8812);
        if (m10 == null) {
            a aVar7 = this.f35953c;
            if (aVar7 != null) {
                aVar7.c(this.f35954d, String.valueOf(str) + g.a(5, 113, "?????????????????????????????????"));
            }
            throw new BusinessException(String.valueOf(str) + x2.a.b("?????????????????????????????????", 198, 14), BusinessException.ErrorMessage.local_app_query_server_fail);
        }
        this.f35955e.e(str, m10);
        ApduHandler i11 = this.f35955e.i();
        int i12 = 2;
        if (i11 == null) {
            a aVar8 = this.f35953c;
            if (aVar8 != null) {
                aVar8.b(this.f35954d, x2.d.c("?????????????????????????????????\u0011\u0011VV???????????????", 2));
            }
            this.f35955e.t(g.a(5, 70, "???????????????????????????????????????????????????????????????;\u0016RDd_\u0011^j"), BusinessException.ErrorMessage.local_business_apdu_handler_null, false);
        }
        int i13 = 4;
        int i14 = 3;
        if (i11.c()) {
            a aVar9 = this.f35953c;
            if (aVar9 != null) {
                aVar9.b(this.f35954d, x2.a.b("?????????????????????????????????I\u0014DI???????????????", 4, 60));
            }
            this.f35955e.t(f.a("?????????????????????????????????\u000b\u0017\u0000\u0014???????????????", 3), BusinessException.ErrorMessage.local_business_apdu_handler_busying, false);
        } else {
            i11.b();
        }
        boolean z12 = true;
        if (bArr6 == null || bArr6.length < 1) {
            bArr6 = new byte[0];
        }
        byte[] bArr7 = new byte[0];
        f2.a e11 = k10.e(8812);
        int i15 = -76;
        try {
            f2.c c11 = k10.c((byte) -79);
            c11.e(bArr6);
            e11.c(c11);
            f2.c c12 = k10.c((byte) -78);
            c12.c(i10);
            e11.c(c12);
            f2.c c13 = k10.c((byte) -77);
            c13.e(bArr7);
            e11.c(c13);
            f2.c c14 = k10.c((byte) 17);
            c14.e(bArr);
            e11.c(c14);
            if (bArr3 != null && bArr3.length > 0) {
                f2.c c15 = k10.c((byte) -76);
                c15.e(bArr);
                e11.c(c15);
            }
            bArr4 = e11.a();
        } catch (FMCommunicationMessageException e12) {
            a aVar10 = this.f35953c;
            if (aVar10 != null) {
                aVar10.c(this.f35954d, x2.b.b(3, "???????????????????????????????????????????????????????????????") + h.f(e12));
            }
            this.f35955e.t(x2.e.a(3, "????????????????????????????????????????????????????????????"), BusinessException.ErrorMessage.local_message_message_handle_exception, true);
            bArr4 = null;
        }
        byte[] n10 = this.f35955e.n(bArr4, str, true, m10);
        if (n10 == null || n10.length < 1) {
            a aVar11 = this.f35953c;
            if (aVar11 != null) {
                aVar11.c(this.f35954d, x2.c.i("??????????????????????????????", 2, 15));
            }
            this.f35955e.t(x2.a.b("?????????????????????????????????????????????", 4, 15), BusinessException.ErrorMessage.local_communication_no_response, true);
        }
        byte[] copyOf = Arrays.copyOf(n10, 2);
        p2.a aVar12 = null;
        f2.a aVar13 = null;
        int i16 = 0;
        boolean z13 = false;
        while (Arrays.equals(v2.b.f35578b, copyOf)) {
            if (this.f35956f) {
                a aVar14 = this.f35953c;
                if (aVar14 != null) {
                    aVar14.a(this.f35954d, x2.b.b(5, "???????????????????????????????????????"));
                }
                this.f35955e.t(f.a("???????????????????????????????????????", i14), BusinessException.ErrorMessage.local_business_cancel, z12);
            }
            p2.c cVar3 = new p2.c();
            try {
                f2.a d10 = k10.d(n10);
                cVar2 = d10.b(-96);
                try {
                    cVar = d10.b(-95);
                    try {
                        f2.c b10 = d10.b(-90);
                        f2.c b11 = d10.b(-89);
                        if (b11 != null) {
                            z10 = false;
                            try {
                                i16 = b11.h()[0] & 255;
                            } catch (FMCommunicationMessageException e13) {
                                e10 = e13;
                                a aVar15 = this.f35953c;
                                if (aVar15 != null) {
                                    int i17 = z12 ? 1 : 0;
                                    int i18 = z12 ? 1 : 0;
                                    String e14 = h.e("2uq\u0006/m", i17, 28);
                                    StringBuilder sb2 = new StringBuilder(String.valueOf(str));
                                    aVar = aVar12;
                                    sb2.append(x2.d.c("????????????????????????????????????{", 2));
                                    sb2.append(h.f(e10));
                                    aVar15.c(e14, sb2.toString());
                                } else {
                                    aVar = aVar12;
                                }
                                this.f35955e.t(g.a(5, 75, "??????????????????????????????"), BusinessException.ErrorMessage.local_message_command_data_invaild, true);
                                if (cVar2 == null) {
                                }
                                if (cVar == null) {
                                }
                                cVar3.d(cVar);
                                aVar12 = this.f35955e.l().b(cVar3);
                                int i19 = 1;
                                if (aVar12 != null) {
                                }
                                aVar4 = this.f35953c;
                                if (aVar4 == null) {
                                }
                                this.f35955e.t(x2.e.a(116, "????????????????????????"), BusinessException.ErrorMessage.local_message_apdu_execute_exception, true);
                                if (this.f35952b == 0) {
                                }
                                if (z13) {
                                }
                                aVar13.c(c10);
                                bArr5 = aVar13.a();
                                aVar2 = this.f35953c;
                                if (aVar2 != null) {
                                }
                                aVar3 = this.f35953c;
                                if (aVar3 == null) {
                                }
                                z12 = true;
                                n10 = this.f35955e.n(bArr5, str, true, m10);
                                copyOf = Arrays.copyOf(n10, 2);
                                i12 = 2;
                                i15 = -76;
                                i13 = 4;
                                i14 = 3;
                            }
                        } else {
                            z10 = false;
                        }
                        aVar13 = k10.e(9001);
                        aVar13.c(b10);
                        aVar13.c(b11);
                        aVar = aVar12;
                    } catch (FMCommunicationMessageException e15) {
                        e10 = e15;
                        z10 = false;
                    }
                } catch (FMCommunicationMessageException e16) {
                    e10 = e16;
                    z10 = false;
                    cVar = null;
                }
            } catch (FMCommunicationMessageException e17) {
                e10 = e17;
                z10 = false;
                cVar2 = null;
                cVar = null;
            }
            if (cVar2 == null) {
                z13 = z10;
            } else {
                cVar2 = null;
            }
            if (cVar == null) {
                z13 = true;
            } else {
                cVar = cVar2;
            }
            try {
                cVar3.d(cVar);
            } catch (FMCommunicationMessageException e18) {
                if (this.f35953c != null) {
                    this.f35953c.c(this.f35954d, h.e("??????????????????????????????????????????????????????", 6, 107) + h.f(e18));
                }
                fVar = this.f35955e;
                str2 = x2.d.c("?????????????????????????????????", 2);
                errorMessage = BusinessException.ErrorMessage.local_communication_invalid_response;
                z11 = true;
                fVar.t(str2, errorMessage, z11);
                aVar12 = this.f35955e.l().b(cVar3);
                int i192 = 1;
                if (aVar12 != null) {
                }
                aVar4 = this.f35953c;
                if (aVar4 == null) {
                }
                this.f35955e.t(x2.e.a(116, "????????????????????????"), BusinessException.ErrorMessage.local_message_apdu_execute_exception, true);
                if (this.f35952b == 0) {
                }
                if (z13) {
                }
                aVar13.c(c10);
                bArr5 = aVar13.a();
                aVar2 = this.f35953c;
                if (aVar2 != null) {
                }
                aVar3 = this.f35953c;
                if (aVar3 == null) {
                }
                z12 = true;
                n10 = this.f35955e.n(bArr5, str, true, m10);
                copyOf = Arrays.copyOf(n10, 2);
                i12 = 2;
                i15 = -76;
                i13 = 4;
                i14 = 3;
            } catch (FMScriptHandleException e19) {
                if (this.f35953c != null) {
                    this.f35953c.c(this.f35954d, g.a(2, 17, "???????????????????????????????????????????????????") + h.f(e19));
                }
                fVar = this.f35955e;
                z11 = true;
                str2 = g.a(1, 80, "?????????????????????????????????");
                errorMessage = BusinessException.ErrorMessage.local_communication_invalid_response;
                fVar.t(str2, errorMessage, z11);
                aVar12 = this.f35955e.l().b(cVar3);
                int i1922 = 1;
                if (aVar12 != null) {
                }
                aVar4 = this.f35953c;
                if (aVar4 == null) {
                }
                this.f35955e.t(x2.e.a(116, "????????????????????????"), BusinessException.ErrorMessage.local_message_apdu_execute_exception, true);
                if (this.f35952b == 0) {
                }
                if (z13) {
                }
                aVar13.c(c10);
                bArr5 = aVar13.a();
                aVar2 = this.f35953c;
                if (aVar2 != null) {
                }
                aVar3 = this.f35953c;
                if (aVar3 == null) {
                }
                z12 = true;
                n10 = this.f35955e.n(bArr5, str, true, m10);
                copyOf = Arrays.copyOf(n10, 2);
                i12 = 2;
                i15 = -76;
                i13 = 4;
                i14 = 3;
            }
            aVar12 = this.f35955e.l().b(cVar3);
            int i19222 = 1;
            if (aVar12 != null || aVar12.b() < i19222) {
                aVar4 = this.f35953c;
                if (aVar4 == null) {
                    aVar4.c(this.f35954d, x2.b.b(3, "????????????????????????????????????"));
                }
                this.f35955e.t(x2.e.a(116, "????????????????????????"), BusinessException.ErrorMessage.local_message_apdu_execute_exception, true);
            }
            if (this.f35952b == 0) {
                EnumIssueProcess instance = EnumIssueProcess.instance(i16);
                if (!(this.f35957g == null || instance == null)) {
                    a aVar16 = this.f35953c;
                    if (aVar16 != null) {
                        aVar16.a(this.f35954d, h.e("????????????s?????????", 166, 47) + i16);
                    }
                    this.f35957g.a(instance);
                }
            }
            if (z13) {
                try {
                    c10 = aVar12.c();
                } catch (FMCommunicationMessageException e20) {
                    a aVar17 = this.f35953c;
                    if (aVar17 != null) {
                        aVar17.c(this.f35954d, x2.c.i("??????????????????????????????????????????????????????#", 2, 32) + h.f(e20));
                    }
                    this.f35955e.t(x2.e.a(5, "??????????????????????????????"), BusinessException.ErrorMessage.local_message_message_handle_exception, true);
                    bArr5 = null;
                }
            } else {
                c10 = aVar12.d();
            }
            aVar13.c(c10);
            bArr5 = aVar13.a();
            aVar2 = this.f35953c;
            if (aVar2 != null) {
                aVar2.a(this.f35954d, x2.e.a(176, "????????????1frjr.&5s") + x2.c.c(bArr5));
            }
            aVar3 = this.f35953c;
            if (aVar3 == null) {
                aVar3.a(this.f35954d, x2.c.i("????????????????????????????????????????????????/29", 122, 123));
            }
            z12 = true;
            n10 = this.f35955e.n(bArr5, str, true, m10);
            copyOf = Arrays.copyOf(n10, 2);
            i12 = 2;
            i15 = -76;
            i13 = 4;
            i14 = 3;
        }
        this.f35951a = n10;
        this.f35955e.d(z12);
        if (Arrays.equals(v2.b.f35577a, copyOf)) {
            return z12;
        }
        if (n10.length <= i12) {
            a aVar18 = this.f35953c;
            if (aVar18 != null) {
                aVar18.c(this.f35954d, String.valueOf(str) + f.a("\uff00????????????????????????????????????????????????", i13) + x2.c.c(n10));
            }
            this.f35955e.t(String.valueOf(str) + x2.a.b("?????????????????????", i13, 95), BusinessException.ErrorMessage.instance(x2.c.c(n10)), false);
            return false;
        }
        try {
            f2.c b12 = k10.b(8812, Arrays.copyOfRange(n10, i12, n10.length)).b(i15);
            if (b12 != null) {
                this.f35951a = b12.h();
                this.f35953c.c(this.f35954d, String.valueOf(str) + x2.d.c("????????????????????????????????????h", 5) + new String(this.f35951a));
            }
            return false;
        } catch (FMCommunicationMessageException e21) {
            a aVar19 = this.f35953c;
            if (aVar19 != null) {
                aVar19.c(this.f35954d, String.valueOf(str) + x2.b.b(i14, "?????????????????????????????????") + h.f(e21));
            }
            this.f35955e.t(String.valueOf(str) + f.a("??????????????????????????????", i14), BusinessException.ErrorMessage.local_message_message_handle_exception, false);
            return false;
        }
    }

    @Override // r2.c
    public boolean a(String str, byte[] bArr, String str2, byte[] bArr2) throws BusinessException {
        String str3;
        f2.c b10;
        String i10 = x2.c.i("?????????????????????", 112, 106);
        f fVar = this.f35955e;
        if (fVar == null) {
            a aVar = this.f35953c;
            if (aVar != null) {
                aVar.c(this.f35954d, String.valueOf(i10) + g.a(24, 114, "???????????????????????????"));
            }
            throw new BusinessException(String.valueOf(i10) + x2.e.a(5, "?????????????????????????????????"), BusinessException.ErrorMessage.local_business_init_fail);
        }
        f2.b k10 = fVar.k();
        if (k10 == null) {
            a aVar2 = this.f35953c;
            if (aVar2 != null) {
                aVar2.c(this.f35954d, String.valueOf(i10) + g.a(3, 20, "?????????????????????????????????????????????????????????"));
            }
            throw new BusinessException(String.valueOf(i10) + x2.e.a(232, "?????????\u0012\b\u000b????????????????????????"), BusinessException.ErrorMessage.local_message_load_config_fail);
        }
        i j10 = this.f35955e.j();
        byte[] bArr3 = null;
        if (j10 != null) {
            str3 = j10.g();
        } else {
            a aVar3 = this.f35953c;
            if (aVar3 != null) {
                aVar3.c(this.f35954d, String.valueOf(i10) + x2.e.a(2, "??????\u001eom``k}saqtp!??????"));
            }
            str3 = null;
        }
        if (str3 == null) {
            a aVar4 = this.f35953c;
            if (aVar4 != null) {
                aVar4.c(this.f35954d, String.valueOf(i10) + x2.a.b("????????????????????????", 286, 2));
            }
            throw new BusinessException(String.valueOf(i10) + g.a(2, 107, "????????????????????????"), BusinessException.ErrorMessage.local_business_para_error);
        }
        f2.a e10 = k10.e(8852);
        try {
            f2.c c10 = k10.c((byte) -119);
            c10.f(str3);
            e10.c(c10);
            if (str != null) {
                f2.c c11 = k10.c((byte) 79);
                c11.f(str);
                e10.c(c11);
            }
            if (str2 != null && str2.length() > 0) {
                f2.c c12 = k10.c((byte) 104);
                c12.f(str2);
                e10.c(c12);
            }
            if (bArr != null && bArr.length > 0) {
                f2.c c13 = k10.c((byte) -79);
                c13.e(bArr);
                e10.c(c13);
            }
            if (bArr2 != null && bArr2.length > 0) {
                f2.c c14 = k10.c((byte) 71);
                c14.e(bArr2);
                e10.c(c14);
            }
            bArr3 = e10.a();
        } catch (FMCommunicationMessageException e11) {
            a aVar5 = this.f35953c;
            if (aVar5 != null) {
                aVar5.c(this.f35954d, String.valueOf(i10) + FM_Exception.insert(6, 42, "?????????????????????????????????") + h.f(e11));
            }
            this.f35955e.t(String.valueOf(i10) + f.a("??????????????????????????????", 5), BusinessException.ErrorMessage.local_message_message_handle_exception, false);
        }
        String m10 = this.f35955e.m(8852);
        if (m10 == null) {
            a aVar6 = this.f35953c;
            if (aVar6 != null) {
                aVar6.c(this.f35954d, String.valueOf(i10) + x2.e.a(4, "?????????????????????????????????"));
            }
            throw new BusinessException(String.valueOf(i10) + x2.c.i("?????????????????????????????????", 5, 103), BusinessException.ErrorMessage.local_app_query_server_fail);
        }
        byte[] c15 = c(bArr3, i10, k10, m10);
        if (x2.c.q(c15)) {
            a aVar7 = this.f35953c;
            if (aVar7 == null) {
                return true;
            }
            aVar7.a(this.f35954d, x2.d.c("???????????????????????????", 2));
            return true;
        }
        if (c15.length <= 2) {
            a aVar8 = this.f35953c;
            if (aVar8 != null) {
                aVar8.c(this.f35954d, String.valueOf(i10) + x2.d.c("???????????????????????????????????????????????????", 2) + x2.c.c(c15));
            }
            this.f35955e.t(String.valueOf(i10) + x2.a.b("?????????????????????", 4, 23), BusinessException.ErrorMessage.instance(x2.c.c(c15)), false);
        } else {
            try {
                if (k10.b(8812, Arrays.copyOfRange(c15, 2, c15.length)).b(-76) != null) {
                    this.f35953c.c(this.f35954d, String.valueOf(i10) + FM_Exception.insert(3, 11, "????????????????????????????????????'") + b10.g());
                }
            } catch (FMCommunicationMessageException e12) {
                a aVar9 = this.f35953c;
                if (aVar9 != null) {
                    aVar9.c(this.f35954d, String.valueOf(i10) + x2.a.b("????????????????????????????????????????????????????????????", DfuException.ERROR_SEND_COMMAND_REACH_MAX_RETRY_TIMES, 110) + h.f(e12));
                }
                this.f35955e.t(String.valueOf(i10) + x2.e.a(4, "?????????????????????????????????????????????????????????"), BusinessException.ErrorMessage.local_message_message_handle_exception, false);
            }
        }
        return false;
    }

    @Override // r2.c
    public boolean b(byte[] bArr, int i10, byte[] bArr2, byte[] bArr3) throws BusinessException {
        if (this.f35953c == null) {
            this.f35953c = b.a().b();
        }
        this.f35952b = 0;
        return e(i10, bArr, bArr2, bArr3, x2.a.b("???????????????????????????", 5, 51));
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0344  */
    @Override // r2.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public cn.com.fmsh.tsm.business.bean.a d(byte[] bArr, EnumCardAppType enumCardAppType, byte[] bArr2, String str) throws BusinessException {
        byte[] bArr3;
        a aVar;
        String str2;
        StringBuilder sb2;
        f fVar;
        List<e.a> b10;
        String b11 = x2.b.b(5, "??????????????????");
        if (this.f35953c == null) {
            this.f35953c = b.a().b();
        }
        a aVar2 = this.f35953c;
        if (aVar2 != null) {
            aVar2.e(this.f35954d, x2.d.c("??????????????????3 q", 4));
        }
        cn.com.fmsh.tsm.business.bean.a aVar3 = new cn.com.fmsh.tsm.business.bean.a();
        f fVar2 = this.f35955e;
        if (fVar2 == null) {
            a aVar4 = this.f35953c;
            if (aVar4 != null) {
                String str3 = this.f35954d;
                aVar4.c(str3, String.valueOf(b11) + x2.b.b(3, "???????????????????????????"));
            }
            throw new BusinessException(String.valueOf(b11) + h.e("?????????????????????????????????", 5, 104), BusinessException.ErrorMessage.local_business_init_fail);
        }
        f2.b k10 = fVar2.k();
        if (k10 == null) {
            a aVar5 = this.f35953c;
            if (aVar5 != null) {
                String str4 = this.f35954d;
                aVar5.c(str4, String.valueOf(b11) + x2.c.i("?????????????????????????????????????????????????????????", 208, 95));
            }
            throw new BusinessException(String.valueOf(b11) + FM_Exception.insert(3, 85, "?????????R\u001aW????????????????????????"), BusinessException.ErrorMessage.local_message_load_config_fail);
        }
        f2.a e10 = k10.e(8842);
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    f2.c c10 = k10.c((byte) 71);
                    c10.e(bArr);
                    e10.c(c10);
                }
            } catch (FMCommunicationMessageException e11) {
                a aVar6 = this.f35953c;
                if (aVar6 != null) {
                    String str5 = this.f35954d;
                    aVar6.c(str5, String.valueOf(b11) + x2.c.i("?????????????????????????????????", 5, 72) + h.f(e11));
                }
                f fVar3 = this.f35955e;
                fVar3.t(String.valueOf(b11) + x2.b.b(1, "??????????????????????????????"), BusinessException.ErrorMessage.local_message_message_handle_exception, false);
                bArr3 = null;
            }
        }
        if (enumCardAppType != null) {
            f2.c c11 = k10.c((byte) 14);
            c11.c(enumCardAppType.getId());
            e10.c(c11);
        }
        if (str != null && str.length() > 0) {
            f2.c c12 = k10.c((byte) 104);
            c12.f(str);
            e10.c(c12);
        }
        if (bArr2 != null && bArr2.length > 0) {
            f2.c c13 = k10.c((byte) -79);
            c13.e(bArr2);
            e10.c(c13);
        }
        f2.c c14 = k10.c((byte) -69);
        c14.c(EnumAppManageOperateType.APP_DELETE.getId());
        e10.c(c14);
        bArr3 = e10.a();
        String m10 = this.f35955e.m(8842);
        if (m10 == null) {
            a aVar7 = this.f35953c;
            if (aVar7 != null) {
                aVar7.c(this.f35954d, x2.d.c("??????????????????????????????????????????????????????", 2));
            }
            throw new BusinessException(x2.d.c("??????????????????????????????????????????????????????", 164), BusinessException.ErrorMessage.local_app_query_server_fail);
        }
        byte[] c15 = c(bArr3, b11, k10, m10);
        if (!x2.c.q(c15)) {
            if (c15.length <= 2) {
                a aVar8 = this.f35953c;
                if (aVar8 != null) {
                    String str6 = this.f35954d;
                    aVar8.c(str6, String.valueOf(b11) + f.a("???????????????????????????????????????????????????", 5) + x2.c.c(c15));
                }
                f fVar4 = this.f35955e;
                fVar4.t(String.valueOf(b11) + g.a(1, 12, "?????????????????????"), BusinessException.ErrorMessage.instance(x2.c.c(c15)), false);
            } else {
                try {
                    f2.c b12 = k10.b(8812, Arrays.copyOfRange(c15, 2, c15.length)).b(-76);
                    if (b12 != null) {
                        a aVar9 = this.f35953c;
                        String str7 = this.f35954d;
                        aVar9.c(str7, String.valueOf(b11) + x2.b.b(3, "????????????????????????????????????8") + b12.g());
                    }
                } catch (FMCommunicationMessageException e12) {
                    a aVar10 = this.f35953c;
                    if (aVar10 != null) {
                        String str8 = this.f35954d;
                        aVar10.c(str8, String.valueOf(b11) + FM_Exception.insert(3, 120, "????????????????????????????????????????????????????????????") + h.f(e12));
                    }
                    fVar = this.f35955e;
                    sb2 = new StringBuilder(String.valueOf(b11));
                    str2 = x2.b.b(DfuException.ERROR_REQUEST_MTU_NO_CALLBACK, "?????????????????????????????????????????????????????????");
                }
            }
            aVar = this.f35953c;
            if (aVar != null) {
                aVar.e(this.f35954d, x2.a.b("????????????????????????", 4, 64));
            }
            return aVar3;
        } else if (c15.length == 2) {
            a aVar11 = this.f35953c;
            if (aVar11 != null) {
                aVar11.c(this.f35954d, x2.b.b(4, "????????????????????????e?????????????????????????????????????????????"));
            }
            return aVar3;
        } else {
            try {
                f2.c b13 = k10.d(c15).b(-76);
                if (!(b13 == null || b13.h() == null || b13.h().length <= 0 || (b10 = f2.e.a().b(b13.h(), 1)) == null || b10.size() <= 0)) {
                    for (e.a aVar12 : b10) {
                        if (aVar12 != null) {
                            if (15 == aVar12.b()[0]) {
                                aVar3.b(aVar12.a());
                            }
                            if (40 == aVar12.b()[0]) {
                                aVar3.a(Integer.valueOf(x2.c.e(aVar12.a())));
                            }
                            if (95 == aVar12.b()[0]) {
                                aVar3.c(x2.c.c(aVar12.a()));
                            }
                        }
                    }
                }
                return aVar3;
            } catch (FMCommunicationMessageException e13) {
                a aVar13 = this.f35953c;
                if (aVar13 != null) {
                    String str9 = this.f35954d;
                    aVar13.c(str9, String.valueOf(b11) + f.a("????????????????????????????????????????????????????????????", 192) + h.f(e13));
                }
                fVar = this.f35955e;
                sb2 = new StringBuilder(String.valueOf(b11));
                str2 = x2.c.i("?????????????????????????????????????????????????????????", 6, 19);
            }
        }
        sb2.append(str2);
        fVar.t(sb2.toString(), BusinessException.ErrorMessage.local_message_message_handle_exception, false);
        aVar = this.f35953c;
        if (aVar != null) {
        }
        return aVar3;
    }
}
