import org.xwiki.tools.reporter.internal.Reporter;
import org.xwiki.tools.reporter.*;
import org.xwiki.tools.reporter.reports.*;
import org.xwiki.tools.reporter.publishers.*;

// Where to scrape the data from.
hudsonURL = "http://hudson.xwiki.org/";

final HtmlMailPublisher emailPub = new HtmlMailPublisher();
emailPub.addRecipient(System.getProperty("sendMailTo"));
emailPub.setMailConfig(new HashMap<String, String>() {{
    put("from", "build.noreply@xwiki.org");
    put("port", System.getProperty("mailPort"));
    put("host", System.getProperty("mailHost"));
    put("javamailExtraProperties", System.getProperty("mailProps"));
}});

new Reporter(hudsonURL) {{
    runReport(new DetailedFailureReport(emailPub, Format.HTML));
}}.run();


