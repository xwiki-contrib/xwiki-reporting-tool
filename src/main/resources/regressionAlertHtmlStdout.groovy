import org.xwiki.tools.reporter.internal.Reporter;
import org.xwiki.tools.reporter.*;
import org.xwiki.tools.reporter.reports.*;
import org.xwiki.tools.reporter.publishers.*;

// Where to scrape the data from.
hudsonURL = "http://hudson.xwiki.org/";

new Reporter(hudsonURL) {{
    runReport(new RegressionAlertReport(new StdoutPublisher() {
        public void publish(final String subject, final String content)
        {
            super.publish(subject, content);
            // Best way I can think of to prevent sending of empty emails every time there are no regressions.
            throw new RuntimeException("This exception is needed to trigger hudson to publish the email.");
        }
    }, Format.HTML));
}}.run();

