package hu.fnf.devel.wishbox.model.test;


import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromRelativeFile;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.parsers.gherkin.GherkinStoryParser;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.runner.RunWith;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collections;
import java.util.List;

@RunWith(JUnitReportingRunner.class)
public class DatabaseCRUDModuleRunner extends JUnitStories {

    public DatabaseCRUDModuleRunner() {
        JUnitReportingRunner.recommendedControls(configuredEmbedder());
    }

    @Override
    protected List<String> storyPaths() {
        return Collections.singletonList("modules/DatabaseCRUD.story");
    }

    @Override
    public Configuration configuration() {
        URL storyURL = null;
        try {
            // This requires you to start Maven from the project directory
            storyURL = new URL("file://" + System.getProperty("user.dir")
                    + "/src/main/resources/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return new MostUsefulConfiguration()
                .useStoryParser(new GherkinStoryParser())
                .useStoryLoader(new LoadFromRelativeFile(storyURL))
                .useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats()
                );
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        ClassLoader cl = ClassLoader.getSystemClassLoader();

        URL[] urls = ((URLClassLoader) cl).getURLs();

        for (URL url : urls) {
            System.out.println(url.getFile());
        }

        return new InstanceStepsFactory(configuration(), new DatabaseCRUDSteps());
    }

}
