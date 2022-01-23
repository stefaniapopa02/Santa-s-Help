package main;

import checker.Checker;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

/**
 * Class used to run the code
 */
public final class Main {

    private final static int NO_TESTS = 30;

    private Main() {
        ///constructor for checkstyle
    }

    /**
     * This method is used to call the checker which calculates the score
     *
     * @param args the arguments used to call the main method
     */
    public static void main(final String[] args) throws IOException {

        for (int iter = 1; iter <= NO_TESTS; iter++) {
            ObjectMapper objectMapper = new ObjectMapper();
            Input input = objectMapper.readValue(new File("tests/test" + iter + ".json"),
                    Input.class);

            Solver problem = Solver.getInstance(); // Singleton Pattern

            AllRounds childrenList = problem.solve(input);

            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            DefaultPrettyPrinter prettyPrinter = new DefaultPrettyPrinter();
            prettyPrinter.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE);
            objectMapper.writeValue(new File("output/out_" + iter + ".json"), childrenList);

        }
        Checker.calculateScore();
    }
}
