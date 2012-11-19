package hu.meza.vcsheatmap.features;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(strict = true, format = {"pretty", "html:target/cucumber", "json:target/cucumber.json"}, monochrome = true, tags = {"~@WIP"})
public class RunCukeTests {

}

