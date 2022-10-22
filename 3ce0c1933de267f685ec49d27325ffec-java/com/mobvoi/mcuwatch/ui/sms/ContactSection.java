package com.mobvoi.mcuwatch.ui.sms;

import com.chad.library.adapter.base.entity.SectionEntity;
import com.mobvoi.apollo.protocol.model.Contact;
import kotlin.jvm.internal.i;
/* compiled from: SmsViewModel.kt */
/* loaded from: classes2.dex */
public final class ContactSection extends SectionEntity<Contact> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactSection(String header) {
        super(true, header);
        i.f(header, "header");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactSection(Contact contact) {
        super(contact);
        i.f(contact, "contact");
    }
}
