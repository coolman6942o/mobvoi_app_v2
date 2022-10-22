package com.huawei.hms.framework.network.grs.d.b;

import android.content.Context;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes.dex */
public class a {
    public static SSLSocketFactory a(Context context) {
        try {
            return c.a(context, "grs_sp.bks");
        } catch (IOException e10) {
            throw new AssertionError(e10);
        } catch (IllegalAccessException e11) {
            throw new AssertionError(e11);
        } catch (KeyManagementException e12) {
            throw new AssertionError(e12);
        } catch (KeyStoreException e13) {
            throw new AssertionError(e13);
        } catch (NoSuchAlgorithmException e14) {
            throw new AssertionError(e14);
        } catch (CertificateException e15) {
            throw new AssertionError(e15);
        }
    }
}
