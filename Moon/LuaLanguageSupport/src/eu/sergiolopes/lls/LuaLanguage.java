package eu.sergiolopes.lls;

import eu.sergiolopes.lls.lexer.LuaTokenId;
import eu.sergiolopes.lls.parser.LParser;
import org.netbeans.api.lexer.Language;
import org.netbeans.modules.csl.spi.DefaultLanguageConfig;
import org.netbeans.modules.csl.spi.LanguageRegistration;
import org.netbeans.modules.parsing.spi.Parser;

/**
 *
 * @author sergio
 */
@LanguageRegistration(mimeType = "text/x-lua")
public class LuaLanguage extends DefaultLanguageConfig {

    @Override
    public Language<LuaTokenId> getLexerLanguage() {
        return LuaTokenId.getLanguage();
    }

    @Override
    public String getDisplayName() {
        return "Lua";
    }

    @Override
    public Parser getParser() {
        return new LParser();
    }
}
