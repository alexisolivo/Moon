package eu.sergiolopes.lls.parser;

import eu.sergiolopes.lls.parser.jcc.LuaParser;
import eu.sergiolopes.lls.parser.jcc.ParseException;
import java.io.Reader;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
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
