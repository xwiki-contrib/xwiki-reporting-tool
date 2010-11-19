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
            // Best method I could think of to trigger hudson to send mail if and only if there are regressions.
            final File tr = new File(new File(System.getProperty("java.io.tmpdir")), "regressionAlertTrigger.mt");
            if (content.length() > 0) {
                super.publish(subject, content);
                tr.createNewFile();
            } else if (tr.exists()) {
                tr.delete();
            }
        }
    }, Format.HTML));
}}.run();

