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
package eu.sergiolopes.lls.parser;

import eu.sergiolopes.lls.parser.jcc.LuaParser;
import java.io.Reader;
import java.io.StringReader;
import javax.swing.event.ChangeListener;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.api.Task;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.parsing.spi.SourceModificationEvent;

/**
 *
 * @author sergio
 */
public class LParser extends Parser {

    private Snapshot snapshot;
    private LuaParser luaParser;

    @Override
    public void parse(Snapshot snapshot, Task task, SourceModificationEvent event) {
        this.snapshot = snapshot;
        Reader reader = new StringReader(snapshot.getText().toString());
        luaParser = new LuaParser(reader);
        //try {
        //    luaParser.CompilationUnit();
        //} catch (ParseException ex) {
        //    Logger.getLogger(LParser.class.getName()).log(Level.WARNING, null, ex);
        //}
    }

    @Override
    public Result getResult(Task task) {
        return new LuaParserResult(snapshot, luaParser);
    }

    @Override
    public void cancel() {
    }

    @Override
    public void addChangeListener(ChangeListener changeListener) {
    }

    @Override
    public void removeChangeListener(ChangeListener changeListener) {
    }

    public static class LuaParserResult extends Result {

        private LuaParser luaParser;
        private boolean valid = true;

        LuaParserResult(Snapshot snapshot, LuaParser luaParser) {
            super(snapshot);
            this.luaParser = luaParser;
        }

        public LuaParser getJavaParser() throws org.netbeans.modules.parsing.spi.ParseException {
            if (!valid) {
                throw new org.netbeans.modules.parsing.spi.ParseException();
            }
            return luaParser;
        }

        @Override
        protected void invalidate() {
            valid = false;
        }
    }
}
