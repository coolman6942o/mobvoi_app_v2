package com.google.firebase.auth;

import b6.i;
import com.google.firebase.FirebaseException;
/* loaded from: classes.dex */
public class FirebaseAuthException extends FirebaseException {
    private final String zzy;

    public FirebaseAuthException(String str, String str2) {
        super(str2);
        this.zzy = i.g(str);
    }

    public String getErrorCode() {
        return this.zzy;
    }
}
