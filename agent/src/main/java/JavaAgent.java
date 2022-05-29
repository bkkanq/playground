import java.lang.instrument.Instrumentation;
import java.util.logging.Logger;

/**
 * <a href="https://dzone.com/articles/java-agent-1">Original Docs</a>
 * Getting hands-on with Java Agent
 *
 * Download the sample application and Java Agent from the link pointed out.
 * Build both the repo using going into the path and execute the command mvn clean install
 * Now, you will get the jar files in the target. Copy the path of the .jar file in Example Application and copy the path of the -dependencies.jar file in JavaAgent.
 * First, run the application only with the Example Application using the command $ java -jar <path of the packaged jar> and observe the output. Hi I am main. will be printed in the console.
 * Then, run the application attached with the java agent using the command $ java -javaagent:<path of agent jar file> -jar <path of the packaged jar
 * file you want to intercept> and observe the output. Logging using Agent will be printed additionally in the console. This ensures that the java agent has been intercepted and added to the body of the main method.
 */
public class JavaAgent {
    private static final Logger log = Logger.getLogger(JavaAgent.class.getName());

    /**
     * As soon as the JVM initializes, Ths method will be called.
     * Configs for intercepting will be read and added to Transformer so that Transformer will intercept when the
     * corresponding Java Class and Method is loaded.
     *
     * @param agentArgs                 This list of agent arguments
     * @param instrumentation           The instrumentation object
     * @throws InstantiationException   While an instantiation of object case an error.
     **/
    public static void premain(String agentArgs, Instrumentation instrumentation) throws InstantiationException {
       log.info("Starting java Agent......");
       InterceptingClassTransformer interceptingClassTransformer = new InterceptingClassTransformer();
       interceptingClassTransformer.init();
       instrumentation.addTransformer(interceptingClassTransformer);
    }
}
