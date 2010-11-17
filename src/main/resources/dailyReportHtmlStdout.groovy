import org.xwiki.tools.reporter.internal.Reporter;
import org.xwiki.tools.reporter.*;
import org.xwiki.tools.reporter.reports.*;
import org.xwiki.tools.reporter.publishers.*;

// Where to scrape the data from.
hudsonURL = "http://hudson.xwiki.org/";

// Run a detaled failure report and print to /dev/stdout 
// but only run on jobs who's URLs match a regular expression.

new Reporter(hudsonURL) {{
    runReport(new DetailedFailureReport(new StdoutPublisher(), Format.HTML));
    //runJobsMatching("/.*xwiki-product-enterprise-tests/");
}}.run();
