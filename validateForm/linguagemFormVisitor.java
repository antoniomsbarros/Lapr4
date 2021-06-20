package eapli.validateForm;// Generated from C:/lei20_21_s4_2dg_04/grammar\linguagemForm.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link linguagemFormParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface linguagemFormVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by .
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(linguagemFormParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link linguagemFormParser#statement_verification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_verification(linguagemFormParser.Statement_verificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link linguagemFormParser#statement_configuration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_configuration(linguagemFormParser.Statement_configurationContext ctx);
	/**
	 * Visit a parse tree produced by {@link linguagemFormParser#if_func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_func(linguagemFormParser.If_funcContext ctx);
	/**
	 * Visit a parse tree produced by .
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContent(linguagemFormParser.ContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link linguagemFormParser#gap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGap(linguagemFormParser.GapContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valSize}
	 * labeled alternative in {@link linguagemFormParser#config}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValSize(linguagemFormParser.ValSizeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valBetween}
	 * labeled alternative in {@link linguagemFormParser#config}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValBetween(linguagemFormParser.ValBetweenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valObligatory}
	 * labeled alternative in {@link linguagemFormParser#config}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValObligatory(linguagemFormParser.ValObligatoryContext ctx);
	/**
	 * Visit a parse tree produced by {@link linguagemFormParser#ctntconditions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtntconditions(linguagemFormParser.CtntconditionsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionsNoOp}
	 * labeled alternative in .
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionsNoOp(linguagemFormParser.ConditionsNoOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionsOp}
	 * labeled alternative in .
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionsOp(linguagemFormParser.ConditionsOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valueVerifyVerifyOrEqualOrNot}
	 * labeled alternative in {@link linguagemFormParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueVerifyVerifyOrEqualOrNot(linguagemFormParser.ValueVerifyVerifyOrEqualOrNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valState}
	 * labeled alternative in {@link linguagemFormParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValState(linguagemFormParser.ValStateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valEqualString}
	 * labeled alternative in {@link linguagemFormParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValEqualString(linguagemFormParser.ValEqualStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valIsBoolean}
	 * labeled alternative in {@link linguagemFormParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValIsBoolean(linguagemFormParser.ValIsBooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanIsVal}
	 * labeled alternative in {@link linguagemFormParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanIsVal(linguagemFormParser.BooleanIsValContext ctx);
	/**
	 * Visit a parse tree produced by {@link linguagemFormParser#stringCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringCondition(linguagemFormParser.StringConditionContext ctx);
	/**
	 * Visit a parse tree produced by .
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntExpression(linguagemFormParser.IntExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link linguagemFormParser#stringValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringValue(linguagemFormParser.StringValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link linguagemFormParser#stringWithQuoteMarks}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringWithQuoteMarks(linguagemFormParser.StringWithQuoteMarksContext ctx);
	/**
	 * Visit a parse tree produced by {@link linguagemFormParser#intValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntValue(linguagemFormParser.IntValueContext ctx);
}