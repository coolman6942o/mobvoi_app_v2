package com.tendcloud.tenddata;

import android.content.BroadcastReceiver;
/*  JADX ERROR: NullPointerException in pass: ProcessKotlinInternals
    java.lang.NullPointerException
    */
/* compiled from: td */
/* loaded from: classes2.dex */
public class TalkingDataReferralReceiver extends BroadcastReceiver {
    /*  JADX ERROR: JadxRuntimeException in pass: AttachTryCatchVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Null type added to not empty exception handler: Exception -> 0x0085
        	at jadx.core.dex.trycatch.ExceptionHandler.addCatchType(ExceptionHandler.java:54)
        	at jadx.core.dex.visitors.AttachTryCatchVisitor.createHandler(AttachTryCatchVisitor.java:136)
        	at jadx.core.dex.visitors.AttachTryCatchVisitor.convertToHandlers(AttachTryCatchVisitor.java:123)
        	at jadx.core.dex.visitors.AttachTryCatchVisitor.initTryCatches(AttachTryCatchVisitor.java:59)
        	at jadx.core.dex.visitors.AttachTryCatchVisitor.visit(AttachTryCatchVisitor.java:47)
        */
    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context r4, android.content.Intent r5) {
        /*
            r3 = this;
            r5.getExtras()     // Catch: java.lang.Exception -> L85
            r0 = move-result     // Catch: java.lang.Exception -> L85
            if (r0 == 0) goto La     // Catch: java.lang.Exception -> L85
            r1 = 0     // Catch: java.lang.Exception -> L85
            r0.containsKey(r1)     // Catch: java.lang.Exception -> L85
            r5.getAction()
            r0 = move-result
            java.lang.String r1 = "com.android.vending.INSTALL_REFERRER"
            r1.equals(r0)
            r0 = move-result
            if (r0 != 0) goto L17
            return
            java.lang.String r0 = "referrer"
            r5.getStringExtra(r0)
            r5 = move-result
            if (r5 == 0) goto L85
            r5.length()
            r0 = move-result
            if (r0 != 0) goto L26
            goto L85
            java.lang.String r0 = "install_referer"
            android.util.Log.d(r0, r5)
            java.lang.String r0 = "UTF-8"
            java.net.URLDecoder.decode(r5, r0)
            r5 = move-result
            android.content.Context r0 = com.tendcloud.tenddata.ab.f22568h
            if (r0 != 0) goto L3b
            r4.getApplicationContext()
            r4 = move-result
            com.tendcloud.tenddata.ab.f22568h = r4
            com.tendcloud.tenddata.zz$a r4 = new com.tendcloud.tenddata.zz$a
            r4.<init>()
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r4.paraMap
            java.lang.String r1 = "domain"
            java.lang.String r2 = "app"
            r0.put(r1, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r4.paraMap
            java.lang.String r1 = "apiType"
            r2 = 1
            java.lang.Integer.valueOf(r2)
            r2 = move-result
            r0.put(r1, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r4.paraMap
            java.lang.String r1 = "action"
            java.lang.String r2 = "install"
            r0.put(r1, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r4.paraMap
            java.lang.String r1 = "service"
            com.tendcloud.tenddata.a r2 = com.tendcloud.tenddata.a.UNIVERSAL
            r0.put(r1, r2)
            java.util.TreeMap r0 = new java.util.TreeMap
            r0.<init>()
            java.lang.String r1 = "referer"
            r0.put(r1, r5)
            java.util.HashMap<java.lang.String, java.lang.Object> r5 = r4.paraMap
            java.lang.String r1 = "data"
            r5.put(r1, r0)
            com.tendcloud.tenddata.zz.c()
            r5 = move-result
            r0 = 102(0x66, float:1.43E-43)
            r5.obtainMessage(r0, r4)
            r4 = move-result
            r4.sendToTarget()
        L85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tendcloud.tenddata.TalkingDataReferralReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }
}
