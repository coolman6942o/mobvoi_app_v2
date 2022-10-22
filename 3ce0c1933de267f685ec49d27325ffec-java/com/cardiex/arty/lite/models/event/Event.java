package com.cardiex.arty.lite.models.event;

import kotlin.jvm.internal.i;
/* compiled from: Event.kt */
/* loaded from: classes.dex */
public final class Event {
    private Object data;
    private String name;

    public Event(String str, Object obj) {
        this.name = str;
        this.data = obj;
    }

    public static /* synthetic */ Event copy$default(Event event, String str, Object obj, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            str = event.name;
        }
        if ((i10 & 2) != 0) {
            obj = event.data;
        }
        return event.copy(str, obj);
    }

    public final String component1() {
        return this.name;
    }

    public final Object component2() {
        return this.data;
    }

    public final Event copy(String str, Object obj) {
        return new Event(str, obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Event)) {
            return false;
        }
        Event event = (Event) obj;
        return i.b(this.name, event.name) && i.b(this.data, event.data);
    }

    public final Object getData() {
        return this.data;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.name;
        int i10 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Object obj = this.data;
        if (obj != null) {
            i10 = obj.hashCode();
        }
        return hashCode + i10;
    }

    public final void setData(Object obj) {
        this.data = obj;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "Event(name=" + ((Object) this.name) + ", data=" + this.data + ')';
    }
}
