package com.cardiex.arty.lite.models.social;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: Message.kt */
/* loaded from: classes.dex */
public final class Message {
    private String body;
    private String userId;

    public Message(String str, String str2) {
        this.userId = str;
        this.body = str2;
    }

    public static /* synthetic */ Message copy$default(Message message, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = message.userId;
        }
        if ((i10 & 2) != 0) {
            str2 = message.body;
        }
        return message.copy(str, str2);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.body;
    }

    public final Message copy(String str, String str2) {
        return new Message(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Message)) {
            return false;
        }
        Message message = (Message) obj;
        return i.b(this.userId, message.userId) && i.b(this.body, message.body);
    }

    public final String getBody() {
        return this.body;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String str = this.userId;
        int i10 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.body;
        if (str2 != null) {
            i10 = str2.hashCode();
        }
        return hashCode + i10;
    }

    public final void setBody(String str) {
        this.body = str;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public String toString() {
        return "Message(userId=" + ((Object) this.userId) + ", body=" + ((Object) this.body) + ')';
    }

    public /* synthetic */ Message(String str, String str2, int i10, f fVar) {
        this(str, (i10 & 2) != 0 ? null : str2);
    }
}
