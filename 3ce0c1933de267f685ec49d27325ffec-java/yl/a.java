package yl;

import android.content.Context;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.params.QcConfig;
import em.c;
import hm.d;
import hm.e;
import hm.f;
import km.j;
import km.l;
import km.m;
import km.n;
import km.o;
import xl.b;
/* loaded from: classes2.dex */
public final class a {
    public static xl.a a(Context context, DfuConfig dfuConfig, QcConfig qcConfig, b bVar) {
        if (dfuConfig.A() == 16) {
            if (dfuConfig.v() == 16) {
                return new e(context, dfuConfig, bVar);
            }
            if (!(dfuConfig.v() == 23 || dfuConfig.v() == 22)) {
                return new d(context, dfuConfig, bVar);
            }
            return new f(context, dfuConfig, bVar);
        } else if (dfuConfig.A() == 20) {
            return dfuConfig.v() == 16 ? new fm.e(context, dfuConfig, bVar) : new fm.d(context, dfuConfig, bVar);
        } else {
            if (dfuConfig.A() == 17) {
                return dfuConfig.v() == 19 ? new m(context, dfuConfig, bVar) : dfuConfig.v() == 20 ? new l(context, dfuConfig, qcConfig, bVar) : dfuConfig.v() == 21 ? new n(context, dfuConfig, qcConfig, bVar) : dfuConfig.v() == 23 ? new o(context, dfuConfig, qcConfig, bVar) : new j(context, dfuConfig, qcConfig, bVar);
            }
            if (dfuConfig.A() == 18) {
                return dfuConfig.v() == 16 ? new dm.e(context, dfuConfig, bVar) : new dm.d(context, dfuConfig, bVar);
            }
            if (dfuConfig.A() == 19) {
                return dfuConfig.v() == 0 ? new c(context, dfuConfig, bVar) : dfuConfig.v() == 17 ? new em.e(context, dfuConfig, bVar) : dfuConfig.v() == 16 ? new em.d(context, dfuConfig, bVar) : dfuConfig.v() == 18 ? new em.f(context, dfuConfig, bVar) : new c(context, dfuConfig, bVar);
            }
            if (dfuConfig.c() == 0) {
                return dfuConfig.v() == 0 ? new gm.c(context, dfuConfig, bVar) : dfuConfig.v() == 17 ? new gm.e(context, dfuConfig, bVar) : dfuConfig.v() == 16 ? new gm.d(context, dfuConfig, bVar) : dfuConfig.v() == 18 ? new gm.f(context, dfuConfig, bVar) : new gm.c(context, dfuConfig, bVar);
            }
            if (dfuConfig.c() == 1) {
                return new jm.b(context, dfuConfig, bVar);
            }
            if (dfuConfig.c() == 2) {
                return new com.realsil.sdk.dfu.v.a(context, dfuConfig, bVar);
            }
            il.b.c("unknown channel:" + dfuConfig.c());
            return null;
        }
    }
}
