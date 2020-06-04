package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Token {

    CONNECT_LIBR("#include"),

    LIBR_VEC("<vector.h>"),
    LIBR("<" + "\\w+" + ".h" + ">"),

    KEYWORD_ALIGNAS("alignas"),
    KEYWORD_ALIGNOF("alignof"),
    KEYWORD_AND("and"),
    KEYWORD_AND_EQ("and_eq"),
    KEYWORD_ASM("asm"),
    KEYWORD_AUTO("auto"),
    KEYWORD_BITAND("bitand"),
    KEYWORD_BITOR("bitor"),
    KEYWORD_DEFAULT("default"),
    KEYWORD_USING("using"),
    KEYWORD_NAMESPACE("namespace " + "\\w+"),
    KEYWORD_NEW("new"),
    KEYWORD_RETURN("return"),


    FUNC_VOID("void" + " " + "\\w+" + "\\(" + "\\)"),
    FUNC_MAIN("\\w+" + " " + "main" + "\\(" + "\\)"),
    FUNC_WITH_IDENTIFIER("\\w+" + " " + "\\w+" + "\\(" + "\\)"),


    CYCLE_FOR("for" + "\\(" + "\\w+" + " " + "\\w+" + "\\W+" + "\\d+" + ";" + "\\w+" + "\\W+" + "\\d+" + ";" + "\\w+" + "\\++" + "\\)"),
    CYCLE_WHILE_1("while" + "\\(" + "\\w+" + "\\W+" + "\\d+" + "\\)"),
    CYCLE_WHILE_2("while" + "\\(" + "\\w+" + "\\W+" + "'" + "\\w+" + "'" + "\\|" + "\\|" + "\\w+" + "\\W+" + "'" + "\\w+" + "'" + "\\)"),

    TYPE_DOUBLE("double"),
    TYPE_INTEGER("int"),
    TYPE_STRING("string"),
    TYPE_BOOLEAN("bool"),
    TYPE_VOID("void"),

    NULL("NULL"),

    OPEN_BRACKET("\\{"),
    CLOSE_BRACKET("\\}"),

    REAL("(\\d*)\\.\\d+"),
    INTEGER("\\d+"),

    STRING("\"[^\"]+\""),
    COMMENTS("/" + "/" + " " + "\"[^\"]+\""),

    TK_CLASS_WITH_IDENTIFIER("class " + "\\w+"),

    TK_OUTPUT("cout<<"),
    TK_INPUT("cin>>"),
    TK_ENDL("endl"),

    TK_KEY_IF("if" + "\\(" + "\\w+" + "\\W+" + "\\w+" + "\\)"),
    TK_KEY_ELSE("else"),
    TK_KEY_THEN("then"),

    TK_SWITCH("switch " + "\\(" + "\\w+" + "\\)"),
    TK_CASE("case" + "\\'" + "\\W+" + "\\'" + ":"),
    TK_BREAK("break" + ";"),

    VARIABLE("\\w+"),

    TK_EQ("=="),
    TK_GEQ(">="),
    TK_GT(">"),
    TK_LESS("<"),
    TK_LEG("<="),

    TK_ASSIGN("="),
    TK_MINUS("-"),
    TK_MUL("\\*"),
    TK_PLUS("\\+"),
    TK_DIV("/"),

    TK_COMMA(","),
    TK_COMMA_AND_POINT(";"),

    TK_POINT(".");

////////////////////////////////////////////


    private final Pattern pattern;

    Token(String regex) {
        pattern = Pattern.compile("^" + regex);
    }

    int endOfMatch(String s) {
        Matcher m = pattern.matcher(s);

        if (m.find()) {
            return m.end();
        }
        return -1;
    }
}