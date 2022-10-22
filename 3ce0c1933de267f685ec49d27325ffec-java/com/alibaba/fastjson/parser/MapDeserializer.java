package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MapDeserializer implements ObjectDeserializer {
    public static MapDeserializer instance = new MapDeserializer();

    MapDeserializer() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0127, code lost:
        return r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map parseMap(DefaultJSONParser defaultJSONParser, Map<String, Object> map, Type type, Object obj) {
        String str;
        Object obj2;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token == 12) {
            ParseContext parseContext = defaultJSONParser.contex;
            while (true) {
                try {
                    jSONLexer.skipWhitespace();
                    char c10 = jSONLexer.f6710ch;
                    while (c10 == ',') {
                        jSONLexer.next();
                        jSONLexer.skipWhitespace();
                        c10 = jSONLexer.f6710ch;
                    }
                    if (c10 == '\"') {
                        str = jSONLexer.scanSymbol(defaultJSONParser.symbolTable, '\"');
                        jSONLexer.skipWhitespace();
                        if (jSONLexer.f6710ch != ':') {
                            throw new JSONException("syntax error, " + jSONLexer.info());
                        }
                    } else if (c10 == '}') {
                        jSONLexer.next();
                        jSONLexer.f6712sp = 0;
                        jSONLexer.nextToken(16);
                        return map;
                    } else if (c10 == '\'') {
                        str = jSONLexer.scanSymbol(defaultJSONParser.symbolTable, '\'');
                        jSONLexer.skipWhitespace();
                        if (jSONLexer.f6710ch != ':') {
                            throw new JSONException("syntax error, " + jSONLexer.info());
                        }
                    } else {
                        str = jSONLexer.scanSymbolUnQuoted(defaultJSONParser.symbolTable);
                        jSONLexer.skipWhitespace();
                        char c11 = jSONLexer.f6710ch;
                        if (c11 != ':') {
                            throw new JSONException("expect ':' at " + jSONLexer.pos + ", actual " + c11);
                        }
                    }
                    jSONLexer.next();
                    jSONLexer.skipWhitespace();
                    jSONLexer.f6712sp = 0;
                    if (str != JSON.DEFAULT_TYPE_KEY || jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                        jSONLexer.nextToken();
                        defaultJSONParser.setContext(parseContext);
                        if (jSONLexer.token == 8) {
                            obj2 = null;
                            jSONLexer.nextToken();
                        } else {
                            obj2 = defaultJSONParser.parseObject(type, str);
                        }
                        map.put(str, obj2);
                        if (defaultJSONParser.resolveStatus == 1) {
                            defaultJSONParser.checkMapResolve(map, str);
                        }
                        defaultJSONParser.setContext(parseContext, obj2, str);
                        int i10 = jSONLexer.token;
                        if (i10 == 20 || i10 == 15) {
                            break;
                        } else if (i10 == 13) {
                            jSONLexer.nextToken();
                            return map;
                        }
                    } else {
                        Class<?> loadClass = TypeUtils.loadClass(jSONLexer.scanSymbol(defaultJSONParser.symbolTable, '\"'), defaultJSONParser.config.defaultClassLoader);
                        if (loadClass == map.getClass()) {
                            jSONLexer.nextToken(16);
                            if (jSONLexer.token == 13) {
                                jSONLexer.nextToken(16);
                                return map;
                            }
                        } else {
                            ObjectDeserializer deserializer = defaultJSONParser.config.getDeserializer(loadClass);
                            jSONLexer.nextToken(16);
                            defaultJSONParser.resolveStatus = 2;
                            if (parseContext != null && !(obj instanceof Integer)) {
                                defaultJSONParser.popContext();
                            }
                            return (Map) deserializer.deserialze(defaultJSONParser, loadClass, obj);
                        }
                    }
                } finally {
                    defaultJSONParser.setContext(parseContext);
                }
            }
        } else {
            throw new JSONException("syntax error, expect {, actual " + jSONLexer.token);
        }
    }

    protected Map<?, ?> createMap(Type type) {
        if (type == Properties.class) {
            return new Properties();
        }
        if (type == Hashtable.class) {
            return new Hashtable();
        }
        if (type == IdentityHashMap.class) {
            return new IdentityHashMap();
        }
        if (type == SortedMap.class || type == TreeMap.class) {
            return new TreeMap();
        }
        if (type == ConcurrentMap.class || type == ConcurrentHashMap.class) {
            return new ConcurrentHashMap();
        }
        if (type == Map.class || type == HashMap.class) {
            return new HashMap();
        }
        if (type == LinkedHashMap.class) {
            return new LinkedHashMap();
        }
        if (type == JSONObject.class) {
            return new JSONObject();
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            if (EnumMap.class.equals(rawType)) {
                return new EnumMap((Class) parameterizedType.getActualTypeArguments()[0]);
            }
            return createMap(rawType);
        }
        Class cls = (Class) type;
        if (!cls.isInterface()) {
            try {
                return (Map) cls.newInstance();
            } catch (Exception e10) {
                throw new JSONException("unsupport type " + type, e10);
            }
        } else {
            throw new JSONException("unsupport type " + type);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        if (type == JSONObject.class && defaultJSONParser.fieldTypeResolver == null) {
            return (T) defaultJSONParser.parseObject();
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token == 8) {
            jSONLexer.nextToken(16);
            return null;
        }
        Map<?, ?> createMap = createMap(type);
        ParseContext parseContext = defaultJSONParser.contex;
        try {
            defaultJSONParser.setContext(parseContext, createMap, obj);
            if (!(type instanceof ParameterizedType)) {
                return (T) defaultJSONParser.parseObject(createMap, obj);
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            Type type3 = parameterizedType.getActualTypeArguments()[1];
            if (String.class == type2) {
                return (T) parseMap(defaultJSONParser, createMap, type3, obj);
            }
            return (T) parseMap(defaultJSONParser, createMap, type2, type3, obj);
        } finally {
            defaultJSONParser.setContext(parseContext);
        }
    }

    public static Object parseMap(DefaultJSONParser defaultJSONParser, Map<Object, Object> map, Type type, Type type2, Object obj) {
        Object obj2;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i10 = jSONLexer.token;
        int i11 = 16;
        if (i10 == 12 || i10 == 16) {
            ObjectDeserializer deserializer = defaultJSONParser.config.getDeserializer(type);
            ObjectDeserializer deserializer2 = defaultJSONParser.config.getDeserializer(type2);
            jSONLexer.nextToken();
            ParseContext parseContext = defaultJSONParser.contex;
            while (true) {
                try {
                    int i12 = jSONLexer.token;
                    if (i12 == 13) {
                        jSONLexer.nextToken(i11);
                        return map;
                    } else if (i12 != 4 || jSONLexer.f6712sp != 4 || !jSONLexer.text.startsWith("$ref", jSONLexer.f6711np + 1) || jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                        if (map.size() == 0 && i12 == 4 && JSON.DEFAULT_TYPE_KEY.equals(jSONLexer.stringVal()) && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                            jSONLexer.nextTokenWithChar(':');
                            jSONLexer.nextToken(16);
                            if (jSONLexer.token == 13) {
                                jSONLexer.nextToken();
                                return map;
                            }
                            jSONLexer.nextToken();
                        }
                        Object deserialze = deserializer.deserialze(defaultJSONParser, type, null);
                        if (jSONLexer.token == 17) {
                            jSONLexer.nextToken();
                            Object deserialze2 = deserializer2.deserialze(defaultJSONParser, type2, deserialze);
                            if (defaultJSONParser.resolveStatus == 1) {
                                defaultJSONParser.checkMapResolve(map, deserialze);
                            }
                            map.put(deserialze, deserialze2);
                            if (jSONLexer.token == 16) {
                                jSONLexer.nextToken();
                            }
                            i11 = 16;
                        } else {
                            throw new JSONException("syntax error, expect :, actual " + jSONLexer.token);
                        }
                    } else {
                        jSONLexer.nextTokenWithChar(':');
                        if (jSONLexer.token == 4) {
                            String stringVal = jSONLexer.stringVal();
                            if ("..".equals(stringVal)) {
                                obj2 = parseContext.parent.object;
                            } else if ("$".equals(stringVal)) {
                                ParseContext parseContext2 = parseContext;
                                while (true) {
                                    ParseContext parseContext3 = parseContext2.parent;
                                    if (parseContext3 == null) {
                                        break;
                                    }
                                    parseContext2 = parseContext3;
                                }
                                obj2 = parseContext2.object;
                            } else {
                                defaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(parseContext, stringVal));
                                defaultJSONParser.resolveStatus = 1;
                                obj2 = null;
                            }
                            jSONLexer.nextToken(13);
                            if (jSONLexer.token == 13) {
                                jSONLexer.nextToken(16);
                                return obj2;
                            }
                            throw new JSONException("illegal ref");
                        }
                        throw new JSONException("illegal ref, " + JSONToken.name(i12));
                    }
                } finally {
                    defaultJSONParser.setContext(parseContext);
                }
            }
        } else {
            throw new JSONException("syntax error, expect {, actual " + JSONToken.name(i10));
        }
    }
}
