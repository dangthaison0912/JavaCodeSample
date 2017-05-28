package front_end.AST.FunctionDecl;

import front_end.AST.ExpressionAST.ExpressionAST;
import front_end.AST.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import front_end.symbol_table.TYPE;

import java.util.List;


public class ArglistAST extends Node {
    private List<ExpressionAST> expressions;

    public ArglistAST(ParserRuleContext ctx, List<ExpressionAST> expressionNodes) {
        super(ctx);
        expressions = expressionNodes;
    }

    public List<ExpressionAST> getExpressions() {
        return expressions;
    }

    /* getType takes an index, and return the type of the expression at that index in
    * List<ExpressionAST> expressions
    */
    public TYPE getType(int x) {
        return expressions.get(x).getType();
    }

    public ExpressionAST getExpression(int i) {
        return expressions.get(i);
    }

    public int size() {
        return expressions.size();
    }

    @Override
    public void check() {
        for(Node e : expressions) {
            e.checkNode();
        }
    }

    @Override
    public void translate() {
        for (ExpressionAST e: expressions) {
            e.translate();
        }
    }
}
