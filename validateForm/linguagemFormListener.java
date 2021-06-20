// Generated from C:/lei20_21_s4_2dg_04/grammar\linguagemForm.g4 by ANTLR 4.9.1
package eapli.validateForm;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link linguagemFormParser}.
 */
public interface linguagemFormListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by .
	 * @param ctx the parse tree
	 */
	void enterStart(linguagemFormParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by .
	 * @param ctx the parse tree
	 */
	void exitStart(linguagemFormParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link linguagemFormParser#statement_verification}.
	 * @param ctx the parse tree
	 */
	void enterStatement_verification(linguagemFormParser.Statement_verificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link linguagemFormParser#statement_verification}.
	 * @param ctx the parse tree
	 */
	void exitStatement_verification(linguagemFormParser.Statement_verificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link linguagemFormParser#statement_configuration}.
	 * @param ctx the parse tree
	 */
	void enterStatement_configuration(linguagemFormParser.Statement_configurationContext ctx);
	/**
	 * Exit a parse tree produced by {@link linguagemFormParser#statement_configuration}.
	 * @param ctx the parse tree
	 */
	void exitStatement_configuration(linguagemFormParser.Statement_configurationContext ctx);
	/**
	 * Enter a parse tree produced by {@link linguagemFormParser#if_func}.
	 * @param ctx the parse tree
	 */
	void enterIf_func(linguagemFormParser.If_funcContext ctx);
	/**
	 * Exit a parse tree produced by {@link linguagemFormParser#if_func}.
	 * @param ctx the parse tree
	 */
	void exitIf_func(linguagemFormParser.If_funcContext ctx);
	/**
	 * Enter a parse tree produced by .
	 * @param ctx the parse tree
	 */
	void enterContent(linguagemFormParser.ContentContext ctx);
	/**
	 * Exit a parse tree produced by .
	 * @param ctx the parse tree
	 */
	void exitContent(linguagemFormParser.ContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link linguagemFormParser#gap}.
	 * @param ctx the parse tree
	 */
	void enterGap(linguagemFormParser.GapContext ctx);
	/**
	 * Exit a parse tree produced by {@link linguagemFormParser#gap}.
	 * @param ctx the parse tree
	 */
	void exitGap(linguagemFormParser.GapContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valSize}
	 * labeled alternative in {@link linguagemFormParser#config}.
	 * @param ctx the parse tree
	 */
	void enterValSize(linguagemFormParser.ValSizeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valSize}
	 * labeled alternative in {@link linguagemFormParser#config}.
	 * @param ctx the parse tree
	 */
	void exitValSize(linguagemFormParser.ValSizeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valBetween}
	 * labeled alternative in {@link linguagemFormParser#config}.
	 * @param ctx the parse tree
	 */
	void enterValBetween(linguagemFormParser.ValBetweenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valBetween}
	 * labeled alternative in {@link linguagemFormParser#config}.
	 * @param ctx the parse tree
	 */
	void exitValBetween(linguagemFormParser.ValBetweenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valObligatory}
	 * labeled alternative in {@link linguagemFormParser#config}.
	 * @param ctx the parse tree
	 */
	void enterValObligatory(linguagemFormParser.ValObligatoryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valObligatory}
	 * labeled alternative in {@link linguagemFormParser#config}.
	 * @param ctx the parse tree
	 */
	void exitValObligatory(linguagemFormParser.ValObligatoryContext ctx);
	/**
	 * Enter a parse tree produced by {@link linguagemFormParser#ctntconditions}.
	 * @param ctx the parse tree
	 */
	void enterCtntconditions(linguagemFormParser.CtntconditionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link linguagemFormParser#ctntconditions}.
	 * @param ctx the parse tree
	 */
	void exitCtntconditions(linguagemFormParser.CtntconditionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionsNoOp}
	 * labeled alternative in .
	 * @param ctx the parse tree
	 */
	void enterConditionsNoOp(linguagemFormParser.ConditionsNoOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionsNoOp}
	 * labeled alternative in .
	 * @param ctx the parse tree
	 */
	void exitConditionsNoOp(linguagemFormParser.ConditionsNoOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionsOp}
	 * labeled alternative in .
	 * @param ctx the parse tree
	 */
	void enterConditionsOp(linguagemFormParser.ConditionsOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionsOp}
	 * labeled alternative in .
	 * @param ctx the parse tree
	 */
	void exitConditionsOp(linguagemFormParser.ConditionsOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valueVerifyVerifyOrEqualOrNot}
	 * labeled alternative in {@link linguagemFormParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterValueVerifyVerifyOrEqualOrNot(linguagemFormParser.ValueVerifyVerifyOrEqualOrNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valueVerifyVerifyOrEqualOrNot}
	 * labeled alternative in {@link linguagemFormParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitValueVerifyVerifyOrEqualOrNot(linguagemFormParser.ValueVerifyVerifyOrEqualOrNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valState}
	 * labeled alternative in {@link linguagemFormParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterValState(linguagemFormParser.ValStateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valState}
	 * labeled alternative in {@link linguagemFormParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitValState(linguagemFormParser.ValStateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valEqualString}
	 * labeled alternative in {@link linguagemFormParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterValEqualString(linguagemFormParser.ValEqualStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valEqualString}
	 * labeled alternative in {@link linguagemFormParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitValEqualString(linguagemFormParser.ValEqualStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valIsBoolean}
	 * labeled alternative in {@link linguagemFormParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterValIsBoolean(linguagemFormParser.ValIsBooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valIsBoolean}
	 * labeled alternative in {@link linguagemFormParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitValIsBoolean(linguagemFormParser.ValIsBooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanIsVal}
	 * labeled alternative in {@link linguagemFormParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterBooleanIsVal(linguagemFormParser.BooleanIsValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanIsVal}
	 * labeled alternative in {@link linguagemFormParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitBooleanIsVal(linguagemFormParser.BooleanIsValContext ctx);
	/**
	 * Enter a parse tree produced by {@link linguagemFormParser#stringCondition}.
	 * @param ctx the parse tree
	 */
	void enterStringCondition(linguagemFormParser.StringConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link linguagemFormParser#stringCondition}.
	 * @param ctx the parse tree
	 */
	void exitStringCondition(linguagemFormParser.StringConditionContext ctx);
	/**
	 * Enter a parse tree produced by .
	 * @param ctx the parse tree
	 */
	void enterIntExpression(linguagemFormParser.IntExpressionContext ctx);
	/**
	 * Exit a parse tree produced by .
	 * @param ctx the parse tree
	 */
	void exitIntExpression(linguagemFormParser.IntExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link linguagemFormParser#stringValue}.
	 * @param ctx the parse tree
	 */
	void enterStringValue(linguagemFormParser.StringValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link linguagemFormParser#stringValue}.
	 * @param ctx the parse tree
	 */
	void exitStringValue(linguagemFormParser.StringValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link linguagemFormParser#stringWithQuoteMarks}.
	 * @param ctx the parse tree
	 */
	void enterStringWithQuoteMarks(linguagemFormParser.StringWithQuoteMarksContext ctx);
	/**
	 * Exit a parse tree produced by {@link linguagemFormParser#stringWithQuoteMarks}.
	 * @param ctx the parse tree
	 */
	void exitStringWithQuoteMarks(linguagemFormParser.StringWithQuoteMarksContext ctx);
	/**
	 * Enter a parse tree produced by {@link linguagemFormParser#intValue}.
	 * @param ctx the parse tree
	 */
	void enterIntValue(linguagemFormParser.IntValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link linguagemFormParser#intValue}.
	 * @param ctx the parse tree
	 */
	void exitIntValue(linguagemFormParser.IntValueContext ctx);
}