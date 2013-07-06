/* Generated By:JavaCC: Do not edit this line. LuaParser.java */
package eu.sergiolopes.lls.parser.jcc;

public class LuaParser implements LuaParserConstants {

  public static void main(String args[]) throws ParseException {
    LuaParser parser = new LuaParser(System.in);
    parser.Chunk();
  }

  public static final int VAR  = 0;
  public static final int CALL = 1;

/** Root production. */
  final public void Chunk() throws ParseException {
    Block();
    jj_consume_token(0);
  }

  final public void Block() throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DO:
      case FOR:
      case FUNCTION:
      case IF:
      case LOCAL:
      case REPEAT:
      case WHILE:
      case NAME:
      case 69:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      Stat();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 64:
        jj_consume_token(64);
        break;
      default:
        jj_la1[1] = jj_gen;
        ;
      }
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case BREAK:
    case RETURN:
      LastStat();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 64:
        jj_consume_token(64);
        break;
      default:
        jj_la1[2] = jj_gen;
        ;
      }
      break;
    default:
      jj_la1[3] = jj_gen;
      ;
    }
  }

  final public void Stat() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DO:
      jj_consume_token(DO);
      Block();
      jj_consume_token(END);
      break;
    case WHILE:
      jj_consume_token(WHILE);
      Exp();
      jj_consume_token(DO);
      Block();
      jj_consume_token(END);
      break;
    case REPEAT:
      jj_consume_token(REPEAT);
      Block();
      jj_consume_token(UNTIL);
      Exp();
      break;
    case IF:
      jj_consume_token(IF);
      Exp();
      jj_consume_token(THEN);
      Block();
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case ELSEIF:
          ;
          break;
        default:
          jj_la1[4] = jj_gen;
          break label_2;
        }
        jj_consume_token(ELSEIF);
        Exp();
        jj_consume_token(THEN);
        Block();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ELSE:
        jj_consume_token(ELSE);
        Block();
        break;
      default:
        jj_la1[5] = jj_gen;
        ;
      }
      jj_consume_token(END);
      break;
    default:
      jj_la1[8] = jj_gen;
      if (jj_2_1(3)) {
        jj_consume_token(FOR);
        jj_consume_token(NAME);
        jj_consume_token(65);
        Exp();
        jj_consume_token(66);
        Exp();
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 66:
          jj_consume_token(66);
          Exp();
          break;
        default:
          jj_la1[6] = jj_gen;
          ;
        }
        jj_consume_token(DO);
        Block();
        jj_consume_token(END);
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case FOR:
          jj_consume_token(FOR);
          NameList();
          jj_consume_token(IN);
          ExpList();
          jj_consume_token(DO);
          Block();
          jj_consume_token(END);
          break;
        case FUNCTION:
          jj_consume_token(FUNCTION);
          FuncName();
          FuncBody();
          break;
        default:
          jj_la1[9] = jj_gen;
          if (jj_2_2(2)) {
            jj_consume_token(LOCAL);
            jj_consume_token(FUNCTION);
            jj_consume_token(NAME);
            FuncBody();
          } else {
            switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
            case LOCAL:
              jj_consume_token(LOCAL);
              NameList();
              switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
              case 65:
                jj_consume_token(65);
                ExpList();
                break;
              default:
                jj_la1[7] = jj_gen;
                ;
              }
              break;
            case NAME:
            case 69:
              ExprStat();
              break;
            default:
              jj_la1[10] = jj_gen;
              jj_consume_token(-1);
              throw new ParseException();
            }
          }
        }
      }
    }
  }

  final public void LastStat() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case BREAK:
      jj_consume_token(BREAK);
      break;
    case RETURN:
      jj_consume_token(RETURN);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LONGSTRING0:
      case LONGSTRING1:
      case LONGSTRING2:
      case LONGSTRING3:
      case LONGSTRINGN:
      case FALSE:
      case FUNCTION:
      case NIL:
      case NOT:
      case TRUE:
      case NAME:
      case NUMBER:
      case STRING:
      case CHARSTRING:
      case 69:
      case 73:
      case 74:
      case 77:
      case 89:
        ExpList();
        break;
      default:
        jj_la1[11] = jj_gen;
        ;
      }
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void ExprStat() throws ParseException {
        int type,need=CALL;
    type = PrimaryExp();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 65:
    case 66:
      Assign();
                                       need=VAR;
      break;
    default:
      jj_la1[13] = jj_gen;
      ;
    }
          if ( type!=need ) {if (true) throw new ParseException("expected function call or assignment");}
  }

  final public void Assign() throws ParseException {
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 66:
        ;
        break;
      default:
        jj_la1[14] = jj_gen;
        break label_3;
      }
      jj_consume_token(66);
      VarExp();
    }
    jj_consume_token(65);
    ExpList();
  }

  final public void VarExp() throws ParseException {
        int type;
    type = PrimaryExp();
          if ( type!=VAR ) {if (true) throw new ParseException("expected variable expression");}
  }

  final public void FuncName() throws ParseException {
    jj_consume_token(NAME);
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 67:
        ;
        break;
      default:
        jj_la1[15] = jj_gen;
        break label_4;
      }
      jj_consume_token(67);
      jj_consume_token(NAME);
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 68:
      jj_consume_token(68);
      jj_consume_token(NAME);
      break;
    default:
      jj_la1[16] = jj_gen;
      ;
    }
  }

  final public void PrefixExp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NAME:
      jj_consume_token(NAME);
      break;
    case 69:
      ParenExp();
      break;
    default:
      jj_la1[17] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void ParenExp() throws ParseException {
    jj_consume_token(69);
    Exp();
    jj_consume_token(70);
  }

  final public int PrimaryExp() throws ParseException {
        int type=VAR;
    PrefixExp();
    label_5:
    while (true) {
      if (jj_2_3(2)) {
        ;
      } else {
        break label_5;
      }
      type = PostfixOp();
    }
                                                         {if (true) return type;}
    throw new Error("Missing return statement in function");
  }

  final public int PostfixOp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 67:
    case 71:
      FieldOp();
                    {if (true) return VAR;}
      break;
    case LONGSTRING0:
    case LONGSTRING1:
    case LONGSTRING2:
    case LONGSTRING3:
    case LONGSTRINGN:
    case STRING:
    case CHARSTRING:
    case 68:
    case 69:
    case 74:
      FuncOp();
                    {if (true) return CALL;}
      break;
    default:
      jj_la1[18] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public void FieldOp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 67:
      jj_consume_token(67);
      jj_consume_token(NAME);
      break;
    case 71:
      jj_consume_token(71);
      Exp();
      jj_consume_token(72);
      break;
    default:
      jj_la1[19] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void FuncOp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 68:
      jj_consume_token(68);
      jj_consume_token(NAME);
      FuncArgs();
      break;
    case LONGSTRING0:
    case LONGSTRING1:
    case LONGSTRING2:
    case LONGSTRING3:
    case LONGSTRINGN:
    case STRING:
    case CHARSTRING:
    case 69:
    case 74:
      FuncArgs();
      break;
    default:
      jj_la1[20] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void FuncArgs() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 69:
      jj_consume_token(69);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LONGSTRING0:
      case LONGSTRING1:
      case LONGSTRING2:
      case LONGSTRING3:
      case LONGSTRINGN:
      case FALSE:
      case FUNCTION:
      case NIL:
      case NOT:
      case TRUE:
      case NAME:
      case NUMBER:
      case STRING:
      case CHARSTRING:
      case 69:
      case 73:
      case 74:
      case 77:
      case 89:
        ExpList();
        break;
      default:
        jj_la1[21] = jj_gen;
        ;
      }
      jj_consume_token(70);
      break;
    case 74:
      TableConstructor();
      break;
    case LONGSTRING0:
    case LONGSTRING1:
    case LONGSTRING2:
    case LONGSTRING3:
    case LONGSTRINGN:
    case STRING:
    case CHARSTRING:
      Str();
      break;
    default:
      jj_la1[22] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void NameList() throws ParseException {
    jj_consume_token(NAME);
    label_6:
    while (true) {
      if (jj_2_4(2)) {
        ;
      } else {
        break label_6;
      }
      jj_consume_token(66);
      jj_consume_token(NAME);
    }
  }

  final public void ExpList() throws ParseException {
    Exp();
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 66:
        ;
        break;
      default:
        jj_la1[23] = jj_gen;
        break label_7;
      }
      jj_consume_token(66);
      Exp();
    }
  }

  final public void SimpleExp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NIL:
      jj_consume_token(NIL);
      break;
    case TRUE:
      jj_consume_token(TRUE);
      break;
    case FALSE:
      jj_consume_token(FALSE);
      break;
    case NUMBER:
      jj_consume_token(NUMBER);
      break;
    case LONGSTRING0:
    case LONGSTRING1:
    case LONGSTRING2:
    case LONGSTRING3:
    case LONGSTRINGN:
    case STRING:
    case CHARSTRING:
      Str();
      break;
    case 73:
      jj_consume_token(73);
      break;
    case 74:
      TableConstructor();
      break;
    case FUNCTION:
      Function();
      break;
    case NAME:
    case 69:
      PrimaryExp();
      break;
    default:
      jj_la1[24] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void Str() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case STRING:
      jj_consume_token(STRING);
      break;
    case CHARSTRING:
      jj_consume_token(CHARSTRING);
      break;
    case LONGSTRING0:
      jj_consume_token(LONGSTRING0);
      break;
    case LONGSTRING1:
      jj_consume_token(LONGSTRING1);
      break;
    case LONGSTRING2:
      jj_consume_token(LONGSTRING2);
      break;
    case LONGSTRING3:
      jj_consume_token(LONGSTRING3);
      break;
    case LONGSTRINGN:
      jj_consume_token(LONGSTRINGN);
      break;
    default:
      jj_la1[25] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void Exp() throws ParseException {
    SubExp();
  }

  final public void SubExp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LONGSTRING0:
    case LONGSTRING1:
    case LONGSTRING2:
    case LONGSTRING3:
    case LONGSTRINGN:
    case FALSE:
    case FUNCTION:
    case NIL:
    case TRUE:
    case NAME:
    case NUMBER:
    case STRING:
    case CHARSTRING:
    case 69:
    case 73:
    case 74:
      SimpleExp();
      break;
    case NOT:
    case 77:
    case 89:
      Unop();
      SubExp();
      break;
    default:
      jj_la1[26] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    label_8:
    while (true) {
      if (jj_2_5(2)) {
        ;
      } else {
        break label_8;
      }
      Binop();
      SubExp();
    }
  }

  final public void Function() throws ParseException {
    jj_consume_token(FUNCTION);
    FuncBody();
  }

  final public void FuncBody() throws ParseException {
    jj_consume_token(69);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NAME:
    case 73:
      ParList();
      break;
    default:
      jj_la1[27] = jj_gen;
      ;
    }
    jj_consume_token(70);
    Block();
    jj_consume_token(END);
  }

  final public void ParList() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NAME:
      NameList();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 66:
        jj_consume_token(66);
        jj_consume_token(73);
        break;
      default:
        jj_la1[28] = jj_gen;
        ;
      }
      break;
    case 73:
      jj_consume_token(73);
      break;
    default:
      jj_la1[29] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void TableConstructor() throws ParseException {
    jj_consume_token(74);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LONGSTRING0:
    case LONGSTRING1:
    case LONGSTRING2:
    case LONGSTRING3:
    case LONGSTRINGN:
    case FALSE:
    case FUNCTION:
    case NIL:
    case NOT:
    case TRUE:
    case NAME:
    case NUMBER:
    case STRING:
    case CHARSTRING:
    case 69:
    case 71:
    case 73:
    case 74:
    case 77:
    case 89:
      FieldList();
      break;
    default:
      jj_la1[30] = jj_gen;
      ;
    }
    jj_consume_token(75);
  }

  final public void FieldList() throws ParseException {
    Field();
    label_9:
    while (true) {
      if (jj_2_6(2)) {
        ;
      } else {
        break label_9;
      }
      FieldSep();
      Field();
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 64:
    case 66:
      FieldSep();
      break;
    default:
      jj_la1[31] = jj_gen;
      ;
    }
  }

  final public void Field() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 71:
      jj_consume_token(71);
      Exp();
      jj_consume_token(72);
      jj_consume_token(65);
      Exp();
      break;
    default:
      jj_la1[32] = jj_gen;
      if (jj_2_7(2)) {
        jj_consume_token(NAME);
        jj_consume_token(65);
        Exp();
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LONGSTRING0:
        case LONGSTRING1:
        case LONGSTRING2:
        case LONGSTRING3:
        case LONGSTRINGN:
        case FALSE:
        case FUNCTION:
        case NIL:
        case NOT:
        case TRUE:
        case NAME:
        case NUMBER:
        case STRING:
        case CHARSTRING:
        case 69:
        case 73:
        case 74:
        case 77:
        case 89:
          Exp();
          break;
        default:
          jj_la1[33] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
  }

  final public void FieldSep() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 66:
      jj_consume_token(66);
      break;
    case 64:
      jj_consume_token(64);
      break;
    default:
      jj_la1[34] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void Binop() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 76:
      jj_consume_token(76);
      break;
    case 77:
      jj_consume_token(77);
      break;
    case 78:
      jj_consume_token(78);
      break;
    case 79:
      jj_consume_token(79);
      break;
    case 80:
      jj_consume_token(80);
      break;
    case 81:
      jj_consume_token(81);
      break;
    case 82:
      jj_consume_token(82);
      break;
    case 83:
      jj_consume_token(83);
      break;
    case 84:
      jj_consume_token(84);
      break;
    case 85:
      jj_consume_token(85);
      break;
    case 86:
      jj_consume_token(86);
      break;
    case 87:
      jj_consume_token(87);
      break;
    case 88:
      jj_consume_token(88);
      break;
    case AND:
      jj_consume_token(AND);
      break;
    case OR:
      jj_consume_token(OR);
      break;
    default:
      jj_la1[35] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void Unop() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 77:
      jj_consume_token(77);
      break;
    case NOT:
      jj_consume_token(NOT);
      break;
    case 89:
      jj_consume_token(89);
      break;
    default:
      jj_la1[36] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  private boolean jj_2_4(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  private boolean jj_2_5(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_5(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(4, xla); }
  }

  private boolean jj_2_6(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_6(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(5, xla); }
  }

  private boolean jj_2_7(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_7(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(6, xla); }
  }

  private boolean jj_3R_35() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(57)) {
    jj_scanpos = xsp;
    if (jj_scan_token(58)) {
    jj_scanpos = xsp;
    if (jj_scan_token(23)) {
    jj_scanpos = xsp;
    if (jj_scan_token(24)) {
    jj_scanpos = xsp;
    if (jj_scan_token(25)) {
    jj_scanpos = xsp;
    if (jj_scan_token(26)) {
    jj_scanpos = xsp;
    if (jj_scan_token(27)) return true;
    }
    }
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3R_33() {
    if (jj_3R_38()) return true;
    return false;
  }

  private boolean jj_3R_32() {
    if (jj_3R_37()) return true;
    return false;
  }

  private boolean jj_3R_31() {
    if (jj_3R_36()) return true;
    return false;
  }

  private boolean jj_3R_30() {
    if (jj_3R_35()) return true;
    return false;
  }

  private boolean jj_3R_23() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(41)) {
    jj_scanpos = xsp;
    if (jj_scan_token(47)) {
    jj_scanpos = xsp;
    if (jj_scan_token(35)) {
    jj_scanpos = xsp;
    if (jj_scan_token(51)) {
    jj_scanpos = xsp;
    if (jj_3R_30()) {
    jj_scanpos = xsp;
    if (jj_scan_token(73)) {
    jj_scanpos = xsp;
    if (jj_3R_31()) {
    jj_scanpos = xsp;
    if (jj_3R_32()) {
    jj_scanpos = xsp;
    if (jj_3R_33()) return true;
    }
    }
    }
    }
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3_4() {
    if (jj_scan_token(66)) return true;
    if (jj_scan_token(NAME)) return true;
    return false;
  }

  private boolean jj_3_2() {
    if (jj_scan_token(LOCAL)) return true;
    if (jj_scan_token(FUNCTION)) return true;
    return false;
  }

  private boolean jj_3R_45() {
    if (jj_3R_25()) return true;
    return false;
  }

  private boolean jj_3R_24() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(77)) {
    jj_scanpos = xsp;
    if (jj_scan_token(42)) {
    jj_scanpos = xsp;
    if (jj_scan_token(89)) return true;
    }
    }
    return false;
  }

  private boolean jj_3_1() {
    if (jj_scan_token(FOR)) return true;
    if (jj_scan_token(NAME)) return true;
    if (jj_scan_token(65)) return true;
    return false;
  }

  private boolean jj_3R_43() {
    if (jj_3R_45()) return true;
    return false;
  }

  private boolean jj_3R_41() {
    if (jj_3R_35()) return true;
    return false;
  }

  private boolean jj_3R_11() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(76)) {
    jj_scanpos = xsp;
    if (jj_scan_token(77)) {
    jj_scanpos = xsp;
    if (jj_scan_token(78)) {
    jj_scanpos = xsp;
    if (jj_scan_token(79)) {
    jj_scanpos = xsp;
    if (jj_scan_token(80)) {
    jj_scanpos = xsp;
    if (jj_scan_token(81)) {
    jj_scanpos = xsp;
    if (jj_scan_token(82)) {
    jj_scanpos = xsp;
    if (jj_scan_token(83)) {
    jj_scanpos = xsp;
    if (jj_scan_token(84)) {
    jj_scanpos = xsp;
    if (jj_scan_token(85)) {
    jj_scanpos = xsp;
    if (jj_scan_token(86)) {
    jj_scanpos = xsp;
    if (jj_scan_token(87)) {
    jj_scanpos = xsp;
    if (jj_scan_token(88)) {
    jj_scanpos = xsp;
    if (jj_scan_token(29)) {
    jj_scanpos = xsp;
    if (jj_scan_token(43)) return true;
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3R_40() {
    if (jj_3R_36()) return true;
    return false;
  }

  private boolean jj_3R_13() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(66)) {
    jj_scanpos = xsp;
    if (jj_scan_token(64)) return true;
    }
    return false;
  }

  private boolean jj_3R_39() {
    if (jj_scan_token(69)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_43()) jj_scanpos = xsp;
    if (jj_scan_token(70)) return true;
    return false;
  }

  private boolean jj_3R_34() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_39()) {
    jj_scanpos = xsp;
    if (jj_3R_40()) {
    jj_scanpos = xsp;
    if (jj_3R_41()) return true;
    }
    }
    return false;
  }

  private boolean jj_3_6() {
    if (jj_3R_13()) return true;
    if (jj_3R_14()) return true;
    return false;
  }

  private boolean jj_3R_20() {
    if (jj_3R_25()) return true;
    return false;
  }

  private boolean jj_3R_29() {
    if (jj_3R_34()) return true;
    return false;
  }

  private boolean jj_3_7() {
    if (jj_scan_token(NAME)) return true;
    if (jj_scan_token(65)) return true;
    return false;
  }

  private boolean jj_3R_22() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_28()) {
    jj_scanpos = xsp;
    if (jj_3R_29()) return true;
    }
    return false;
  }

  private boolean jj_3R_28() {
    if (jj_scan_token(68)) return true;
    if (jj_scan_token(NAME)) return true;
    return false;
  }

  private boolean jj_3R_19() {
    if (jj_scan_token(71)) return true;
    return false;
  }

  private boolean jj_3R_14() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_19()) {
    jj_scanpos = xsp;
    if (jj_3_7()) {
    jj_scanpos = xsp;
    if (jj_3R_20()) return true;
    }
    }
    return false;
  }

  private boolean jj_3_5() {
    if (jj_3R_11()) return true;
    if (jj_3R_12()) return true;
    return false;
  }

  private boolean jj_3R_48() {
    if (jj_3R_14()) return true;
    return false;
  }

  private boolean jj_3R_46() {
    if (jj_3R_48()) return true;
    return false;
  }

  private boolean jj_3_3() {
    if (jj_3R_10()) return true;
    return false;
  }

  private boolean jj_3R_27() {
    if (jj_scan_token(71)) return true;
    if (jj_3R_25()) return true;
    return false;
  }

  private boolean jj_3R_21() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_26()) {
    jj_scanpos = xsp;
    if (jj_3R_27()) return true;
    }
    return false;
  }

  private boolean jj_3R_26() {
    if (jj_scan_token(67)) return true;
    if (jj_scan_token(NAME)) return true;
    return false;
  }

  private boolean jj_3R_36() {
    if (jj_scan_token(74)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_46()) jj_scanpos = xsp;
    if (jj_scan_token(75)) return true;
    return false;
  }

  private boolean jj_3R_16() {
    if (jj_3R_22()) return true;
    return false;
  }

  private boolean jj_3R_15() {
    if (jj_3R_21()) return true;
    return false;
  }

  private boolean jj_3R_10() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_15()) {
    jj_scanpos = xsp;
    if (jj_3R_16()) return true;
    }
    return false;
  }

  private boolean jj_3R_38() {
    if (jj_3R_42()) return true;
    return false;
  }

  private boolean jj_3R_18() {
    if (jj_3R_24()) return true;
    return false;
  }

  private boolean jj_3R_47() {
    if (jj_scan_token(69)) return true;
    return false;
  }

  private boolean jj_3R_37() {
    if (jj_scan_token(FUNCTION)) return true;
    return false;
  }

  private boolean jj_3R_44() {
    if (jj_3R_47()) return true;
    return false;
  }

  private boolean jj_3R_42() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(50)) {
    jj_scanpos = xsp;
    if (jj_3R_44()) return true;
    }
    return false;
  }

  private boolean jj_3R_17() {
    if (jj_3R_23()) return true;
    return false;
  }

  private boolean jj_3R_12() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_17()) {
    jj_scanpos = xsp;
    if (jj_3R_18()) return true;
    }
    return false;
  }

  private boolean jj_3R_25() {
    if (jj_3R_12()) return true;
    return false;
  }

  /** Generated Token Manager. */
  public LuaParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[37];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static private int[] jj_la1_2;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
      jj_la1_init_2();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x80000000,0x0,0x0,0x40000000,0x0,0x0,0x0,0x0,0x80000000,0x0,0x0,0xf800000,0x40000000,0x0,0x0,0x0,0x0,0x0,0xf800000,0x0,0xf800000,0xf800000,0xf800000,0x0,0xf800000,0xf800000,0xf800000,0x0,0x0,0x0,0xf800000,0x0,0x0,0xf800000,0x0,0x20000000,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x62170,0x0,0x0,0x1000,0x2,0x1,0x0,0x0,0x22040,0x30,0x40100,0x60c8628,0x1000,0x0,0x0,0x0,0x0,0x40000,0x6000000,0x0,0x6000000,0x60c8628,0x6000000,0x0,0x60c8228,0x6000000,0x60c8628,0x40000,0x0,0x40000,0x60c8628,0x0,0x0,0x60c8628,0x0,0x800,0x400,};
   }
   private static void jj_la1_init_2() {
      jj_la1_2 = new int[] {0x20,0x1,0x1,0x0,0x0,0x0,0x4,0x2,0x0,0x0,0x20,0x2002620,0x0,0x6,0x4,0x8,0x10,0x20,0x4b8,0x88,0x430,0x2002620,0x420,0x4,0x620,0x0,0x2002620,0x200,0x4,0x200,0x20026a0,0x5,0x80,0x2002620,0x5,0x1fff000,0x2002000,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[7];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public LuaParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public LuaParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new LuaParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 37; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 37; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public LuaParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new LuaParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 37; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 37; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public LuaParser(LuaParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 37; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(LuaParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 37; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[90];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 37; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
          if ((jj_la1_2[i] & (1<<j)) != 0) {
            la1tokens[64+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 90; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 7; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
            case 3: jj_3_4(); break;
            case 4: jj_3_5(); break;
            case 5: jj_3_6(); break;
            case 6: jj_3_7(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}