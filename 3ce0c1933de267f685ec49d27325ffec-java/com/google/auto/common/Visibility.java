package com.google.auto.common;

import com.google.common.base.f;
import com.google.common.base.p;
import com.google.common.collect.q6;
import java.util.Set;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
/* loaded from: classes.dex */
public enum Visibility {
    PRIVATE,
    DEFAULT,
    PROTECTED,
    PUBLIC;
    
    private static final ElementKind MODULE = (ElementKind) f.b(ElementKind.class, "MODULE").orNull();

    public static Visibility effectiveVisibilityOfElement(Element element) {
        p.o(element);
        Visibility visibility = PUBLIC;
        while (element != null) {
            visibility = (Visibility) q6.g().d(visibility, ofElement(element));
            element = element.getEnclosingElement();
        }
        return visibility;
    }

    public static Visibility ofElement(Element element) {
        p.o(element);
        if (element.getKind().equals(ElementKind.PACKAGE) || element.getKind().equals(MODULE)) {
            return PUBLIC;
        }
        Set modifiers = element.getModifiers();
        if (modifiers.contains(Modifier.PRIVATE)) {
            return PRIVATE;
        }
        if (modifiers.contains(Modifier.PROTECTED)) {
            return PROTECTED;
        }
        if (modifiers.contains(Modifier.PUBLIC)) {
            return PUBLIC;
        }
        return DEFAULT;
    }
}
