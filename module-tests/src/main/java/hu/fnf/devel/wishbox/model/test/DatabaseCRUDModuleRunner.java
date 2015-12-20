package hu.fnf.devel.wishbox.model.test;


import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.parsers.gherkin.GherkinStoryParser;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

@RunWith(JUnitReportingRunner.class)
public class DatabaseCRUDModuleRunner extends JUnitStories {

    public DatabaseCRUDModuleRunner() {
        JUnitReportingRunner.recommandedControls(configuredEmbedder());
    }

    @Override
    protected List<String> storyPaths() {
        return Arrays.asList("hu/fnf/devel/wishbox/model/test/DatabaseCRUD.story");
    }

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryParser(new GherkinStoryParser());
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new DatabaseCRUDSteps());
    }

}
