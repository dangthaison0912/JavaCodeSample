package front_end.AST.FunctionDecl;

import front_end.AST.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import front_end.symbol_table.TYPE;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tsd15 on 09/11/16.
 */
public class ParamlistAST extends Node {
    List<ParamAST> parameters;

    public ParamlistAST(ParserRuleContext ctx, List<ParamAST> parameters) {
        super(ctx);
        this.parameters = parameters;
    }

    public List<ParamAST> getExpressions() {
        return parameters;
    }


    public List<TYPE> getParamTypes() {
        List<TYPE> paramTypes = new ArrayList<>();
        for(ParamAST n : parameters) {
            paramTypes.add(n.getType());
        }

        return paramTypes;
    }

    public List<ParamAST> getParams() {
        return parameters;
    }

    @Override
    public void check() {
        for(ParamAST n : parameters) {
            n.check();
        }
    }

    @Override
    public void translate() {
        for (ParamAST p: parameters) {
            p.translate();
        }
    }
}
