package eu.sergiolopes.lls.lexer;

import eu.sergiolopes.lls.lexer.jcc.LuaParserTokenManager;
import eu.sergiolopes.lls.lexer.jcc.SimpleCharStream;
import eu.sergiolopes.lls.lexer.jcc.Token;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 *
 * @author sergio
 */
public class LuaLexer implements Lexer<LuaTokenId> {

    private LexerRestartInfo<LuaTokenId> info;
    private LuaParserTokenManager javaParserTokenManager;

    public LuaLexer(LexerRestartInfo<LuaTokenId> info) {
        this.info = info;
        SimpleCharStream stream = new SimpleCharStream(info.input());
        javaParserTokenManager = new LuaParserTokenManager(stream);
    }

    @Override
    public org.netbeans.api.lexer.Token<LuaTokenId> nextToken() {
        Token token = javaParserTokenManager.getNextToken();
        if (info.input().readLength() < 1) {
            return null;
        }
        return info.tokenFactory().createToken(LuaLanguageHierarchy.getToken(token.kind));
    }

    @Override
    public Object state() {
        return null;
    }

    @Override
    public void release() {
    }
}
