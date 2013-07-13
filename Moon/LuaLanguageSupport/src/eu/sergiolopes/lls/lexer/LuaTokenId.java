/* 
 * This file is part of Moon, a Lua/Corona SDK group of modules for the 
 * NetBeans IDE.
 * 
 * Copyright (c) 2013, Sérgio Lopes
 * 
 * Moon is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Moon is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * https://github.com/Knitter/Moon
 */
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
