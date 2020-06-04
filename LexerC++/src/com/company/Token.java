package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Token {

    CONNECT_LIBR("#include"),

    LIBR_VEC("<vector.h>"),
    LIBR("<" + "\\w+" + ".h" + ">"),

    FUNC_VOID("void" + " " + "\\w+" + "\\(" + "\\)"),
    FUNC_MAIN("\\w+" + " " + "main" + "\\(" + "\\)"),
    FUNC("\\w+" + " " + "\\w+" + "\\(" + "\\)"),


    CYCLE_FOR("for" + "\\(" + "\\w+" + " " + "\\w+" + "\\W+" + "\\d+" + ";" + "\\w+" + "\\W+" + "\\d+" + ";" + "\\w+" + "\\++" + "\\)"),
    CYCLE_WHILE("while" + "\\(" + "\\w+" + "\\W+" + "\\d+" + "\\)"),

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

    TK_CLASS("class " + "\\w+"),

    TK_OUTPUT("cout<<"),
    TK_INPUT("cin>>"),

    TK_KEY_IF("if" + "\\(" + "\\w+" + "\\W+" + "\\w+" + "\\)"),
    TK_KEY_ELSE("else"),
    TK_KEY_THEN("then"),

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


//    TK_AND("&"),
//

//    TK_CLOSE("\\)"),
//


//

//    TK_KEY_AS("as"),
//    TK_KEY_DEFINE("define"),

//    TK_KEY_ENDIF("endif"),
//
//

//

//

//
//    TK_NOT("~"),
//
//    TK_OPEN("\\("),
//    //TK_OR("\\|"),





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