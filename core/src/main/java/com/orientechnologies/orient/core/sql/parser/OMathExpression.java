/* Generated By:JJTree: Do not edit this line. OMathExpression.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.orientechnologies.orient.core.sql.parser;

import com.orientechnologies.orient.core.command.OCommandContext;
import com.orientechnologies.orient.core.db.record.OIdentifiable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OMathExpression extends SimpleNode {

  public enum Operator {
    PLUS, MINUS, STAR, SLASH, REM
  }

  protected List<OMathExpression> childExpressions = new ArrayList<OMathExpression>();
  protected List<Operator>        operators        = new ArrayList<Operator>();

  public OMathExpression(int id) {
    super(id);
  }

  public OMathExpression(OrientSql p, int id) {
    super(p, id);
  }

  public void replaceParameters(Map<Object, Object> params) {
    if (childExpressions != null) {
      for (OMathExpression expr : childExpressions) {
        expr.replaceParameters(params);
      }
    }
  }

  public Object execute(OIdentifiable iCurrentRecord, OCommandContext ctx) {
    if (childExpressions.size() == 0) {
      return null;
    }

    OMathExpression nextExpression = childExpressions.get(0);
    Object nextValue = nextExpression.execute(iCurrentRecord, ctx);
    return null;
  }

  /** Accept the visitor. **/
  public Object jjtAccept(OrientSqlVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

  public List<OMathExpression> getChildExpressions() {
    return childExpressions;
  }

  public void setChildExpressions(List<OMathExpression> childExpressions) {
    this.childExpressions = childExpressions;
  }

  public Object createExecutorFilter() {
    // TODO
    return null;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < childExpressions.size(); i++) {
      if (i > 0) {
        result.append(" ");
        switch (operators.get(i - 1)) {
        case PLUS:
          result.append("+");
          break;
        case MINUS:
          result.append("-");
          break;
        case STAR:
          result.append("*");
          break;
        case SLASH:
          result.append("/");
          break;
        case REM:
          result.append("%");
          break;
        }
        result.append(" ");
      }
      result.append(childExpressions.get(i).toString());
    }
    return result.toString();
  }
}
/* JavaCC - OriginalChecksum=c255bea24e12493e1005ba2a4d1dbb9d (do not edit this line) */
