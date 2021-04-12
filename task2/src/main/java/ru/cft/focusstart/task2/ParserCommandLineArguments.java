package ru.cft.focusstart.task2;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParserCommandLineArguments {
    private static final Logger log = LoggerFactory.getLogger(ParserCommandLineArguments.class.getName());
    @Option(name = "-i", required = true)
    private String inputFileName;
    @Option(name = "-o")
    private String outputFileName;

    public ParserCommandLineArguments(String[] args) {
        parseLineArguments(args);
        log.info("Создали экземпляр класса: {}", ParserCommandLineArguments.class.getName());
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public String getInputFileName() {
        return inputFileName;
    }

    private void parseLineArguments(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            log.error(e.getMessage(), e);
            System.exit(0);
        }

    }
}