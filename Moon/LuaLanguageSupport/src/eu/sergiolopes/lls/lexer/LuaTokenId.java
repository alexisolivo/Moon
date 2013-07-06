package eu.sergiolopes.lls.lexer;

import org.netbeans.api.lexer.Language;
import org.netbeans.api.lexer.TokenId;

/**
 *
 * @author sergio
 */
public final class LuaTokenId implements TokenId {

    private final String name;
    private final int ordinal;
    private final String category;

    public LuaTokenId(String name, int ordinal, String category) {
        this.name = name;
        this.ordinal = ordinal;
        this.category = category;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int ordinal() {
        return ordinal;
    }

    @Override
    public String primaryCategory() {
        return category;
    }

    public static Language<LuaTokenId> getLanguage() {
        return new LuaLanguageHierarchy().language();
    }
}
