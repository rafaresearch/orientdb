/* Generated By:JJTree: Do not edit this line. OLevelZeroIdentifier.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.orientechnologies.orient.core.sql.parser;

import com.orientechnologies.orient.core.command.OCommandContext;
import com.orientechnologies.orient.core.db.record.OIdentifiable;

import java.util.Map;

public class OLevelZeroIdentifier extends SimpleNode {
  protected OFunctionCall functionCall;
  protected Boolean       self;
  protected OCollection   collection;

  public OLevelZeroIdentifier(int id) {
    super(id);
  }

  public OLevelZeroIdentifier(OrientSql p, int id) {
    super(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(OrientSqlVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

  @Override
  public String toString() {
    if (functionCall != null) {
      return functionCall.toString();
    } else if (Boolean.TRUE.equals(self)) {
      return "@this";
    } else if (collection != null) {
      return collection.toString();
    }

    return super.toString();
  }

  public void replaceParameters(Map<Object, Object> params) {
    if(functionCall!=null){
      functionCall.replaceParameters(params);
    }
    if(collection!=null){
      collection.replaceParameters(params);
    }
  }

  public Object execute(OIdentifiable iCurrentRecord, OCommandContext ctx) {
    throw new UnsupportedOperationException();
  }
}
/* JavaCC - OriginalChecksum=0305fcf120ba9395b4c975f85cdade72 (do not edit this line) */
