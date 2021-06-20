package eapli.base.AutomaticTaskExecution;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author marly
 */
public class AutomaticTaskExecution{

    public void execute(String scriptName) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File(scriptName));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e);
        }/*
        linguagemLexer lexer = null;
        try {
            lexer = new linguagemLexer(new ANTLRInputStream(fis));
        } catch (IOException e) {
            System.out.println("ERROR: " + e);
        }
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        linguagemParser parser = new linguagemParser(tokens);
        linguagemParser.StartContext tree = parser.start(); // parse
        Visitor visitor = new Visitor();
        visitor.visit(tree);*/
    }
}
