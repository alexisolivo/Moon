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
 * http://www.sergiolopes.eu/moon
 */
package eu.sergiolopes.moon.lua;

import eu.sergiolopes.moon.lua.lexer.LuaTokenId;
import eu.sergiolopes.moon.lua.parser.LParser;
import org.netbeans.api.lexer.Language;
import org.netbeans.modules.csl.spi.DefaultLanguageConfig;
import org.netbeans.modules.csl.spi.LanguageRegistration;
import org.netbeans.modules.parsing.spi.Parser;

/**
 *
 * @author Sérgio Lopes
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
