package eu.sergiolopes.lls.lexer;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.netbeans.api.lexer.TokenId;
import org.netbeans.spi.lexer.LanguageHierarchy;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 *
 * @author sergio
 */
public class LuaLanguageHierarchy extends LanguageHierarchy<LuaTokenId> {

    private static List<LuaTokenId> tokens;
    private static Map<Integer, LuaTokenId> idToToken;

    private static void init() {
        tokens = Arrays.<LuaTokenId>asList(new LuaTokenId[]{
            new LuaTokenId("EOF", 0, "whitespace"),
            new LuaTokenId("COMMENT", 17, "comment"),
            new LuaTokenId("LONGCOMMENT0", 18, "comment"),
            new LuaTokenId("LONGCOMMENT1", 19, "comment"),
            new LuaTokenId("LONGCOMMENT2", 20, "comment"),
            new LuaTokenId("LONGCOMMENT3", 21, "comment"),
            new LuaTokenId("LONGCOMMENTN", 22, "comment"),
            new LuaTokenId("LONGSTRING0", 23, "comment"),
            new LuaTokenId("LONGSTRING1", 24, "comment"),
            new LuaTokenId("LONGSTRING2", 25, "comment"),
            new LuaTokenId("LONGSTRING3", 26, "comment"),
            new LuaTokenId("LONGSTRINGN", 27, "comment"),
            new LuaTokenId("AND", 29, "keyword"),
            new LuaTokenId("BREAK", 30, "keyword"),
            new LuaTokenId("DO", 31, "keyword"),
            new LuaTokenId("ELSE", 32, "keyword"),
            new LuaTokenId("ELSEIF", 33, "keyword"),
            new LuaTokenId("END", 34, "keyword"),
            new LuaTokenId("FALSE", 35, "keyword"),
            new LuaTokenId("FOR", 36, "keyword"),
            new LuaTokenId("FUNCTION", 37, "keyword"),
            new LuaTokenId("IF", 38, "keyword"),
            new LuaTokenId("IN", 39, "keyword"),
            new LuaTokenId("LOCAL", 40, "keyword"),
            new LuaTokenId("NIL", 41, "keyword"),
            new LuaTokenId("NOT", 42, "keyword"),
            new LuaTokenId("OR", 43, "keyword"),
            new LuaTokenId("RETURN", 44, "keyword"),
            new LuaTokenId("REPEAT", 45, "keyword"),
            new LuaTokenId("THEN", 46, "keyword"),
            new LuaTokenId("TRUE", 47, "keyword"),
            new LuaTokenId("UNTIL", 48, "keyword"),
            new LuaTokenId("WHILE", 49, "keyword"),
            new LuaTokenId("NAME", 50, "identifier"),
            new LuaTokenId("NUMBER", 51, "literal"),
            new LuaTokenId("FLOAT", 52, "literal"),
            new LuaTokenId("DIGIT", 53, "literal"),
            new LuaTokenId("EXP", 54, ""),
            new LuaTokenId("HEX", 55, "literal"),
            new LuaTokenId("HEXDIGIT", 56, "literal"),
            new LuaTokenId("STRING", 57, "literal"),
            new LuaTokenId("CHARSTRING", 58, "literal"),
            new LuaTokenId("QUOTED", 59, "literal"),
            new LuaTokenId("DECIMAL", 60, "literal"),
            new LuaTokenId("UNICODE", 61, "literal"),
            new LuaTokenId("CHAR", 62, "literal")
        });
        idToToken = new HashMap<Integer, LuaTokenId>();
        for (LuaTokenId token : tokens) {
            idToToken.put(token.ordinal(), token);
        }
    }

    public static synchronized LuaTokenId getToken(int id) {
        if (idToToken == null) {
            init();
        }
        return idToToken.get(id);
    }

    @Override
    protected Collection<LuaTokenId> createTokenIds() {
        if (tokens == null) {
            init();
        }
        return tokens;
    }

    @Override
    protected Lexer<LuaTokenId> createLexer(LexerRestartInfo<LuaTokenId> info) {
        return new LuaLexer(info);
    }

    @Override
    protected String mimeType() {
        return "text/x-lua";
    }
}
