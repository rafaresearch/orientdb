/* Generated By:JJTree: Do not edit this line. OIndexMatchCondition.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.orientechnologies.orient.core.sql.parser;

import com.orientechnologies.orient.core.command.OCommandContext;
import com.orientechnologies.orient.core.db.record.OIdentifiable;

import java.util.List;
import java.util.Map;

public class OIndexMatchCondition extends OBooleanExpression {

  protected OBinaryCompareOperator  operator;
  protected Boolean           between;

  protected List<OExpression> leftExpressions;
  protected List<OExpression> rightExpressions;

  public OIndexMatchCondition(int id) {
    super(id);
  }

  public OIndexMatchCondition(OrientSql p, int id) {
    super(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(OrientSqlVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

  @Override
  public boolean evaluate(OIdentifiable currentRecord, OCommandContext ctx) {
    return false;
  }

  @Override
  public void replaceParameters(Map<Object, Object> params) {
    if (leftExpressions != null) {
      for (OExpression x : leftExpressions) {
        x.replaceParameters(params);
      }
    }
    if (rightExpressions != null) {
      for (OExpression x : rightExpressions) {
        x.replaceParameters(params);
      }
    }
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    result.append("KEY ");
    if (operator != null) {
      result.append(operator.toString());
      result.append(" [");
      boolean first = true;
      for (OExpression x : leftExpressions) {
        if (!first) {
          result.append(", ");
        }
        result.append(x.toString());
        first = false;
      }
      result.append("]");
    } else if (Boolean.TRUE.equals(between)) {
      result.append(" BETWEEN [");
      boolean first = true;
      for (OExpression x : leftExpressions) {
        if (!first) {
          result.append(", ");
        }
        result.append(x.toString());
        first = false;
      }
      result.append("] AND [");
      first = true;
      for (OExpression x : rightExpressions) {
        if (!first) {
          result.append(", ");
        }
        result.append(x.toString());
        first = false;
      }
      result.append("]");
    }
    return result.toString();
  }
}
/* JavaCC - OriginalChecksum=702e9ab959e87b043b519844a7d31224 (do not edit this line) */
