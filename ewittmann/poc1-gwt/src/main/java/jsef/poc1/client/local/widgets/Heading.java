package jsef.poc1.client.local.widgets;

import javax.enterprise.context.Dependent;

import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Composite;

/**
 *
 * @author eric.wittmann@redhat.com
 */
@Templated("/jsef/poc1/client/local/site/host-app.html#heading")
@Dependent
public class Heading extends Composite {

    @DataField
    Element title = DOM.createElement("h2");
    @DataField
    Element description = DOM.createElement("p");

    /**
     * Constructor.
     */
    public Heading() {
    }

    /**
     * @param title
     */
    @Override
    public void setTitle(String title) {
        this.title.setInnerText(title);
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description.setInnerText(description);
    }

}
