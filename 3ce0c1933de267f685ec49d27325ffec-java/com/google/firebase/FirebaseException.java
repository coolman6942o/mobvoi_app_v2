package com.google.firebase;

import b6.i;
/* loaded from: classes.dex */
public class FirebaseException extends Exception {
    @Deprecated
    protected FirebaseException() {
    }

    public FirebaseException(String str) {
        super(i.h(str, "Detail message must not be empty"));
    }

    public FirebaseException(String str, Throwable th2) {
        super(i.h(str, "Detail message must not be empty"), th2);
    }
}
