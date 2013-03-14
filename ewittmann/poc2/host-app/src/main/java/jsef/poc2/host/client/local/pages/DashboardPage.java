package jsef.poc2.host.client.local.pages;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import jsef.poc2.host.client.local.jsef.JsefRegistry;

import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.nav.client.local.TransitionTo;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.common.collect.ImmutableMultimap;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;

/**
 * The home/dashboard page.
 *
 * @author eric.wittmann@redhat.com
 */
@Templated("/jsef/poc2/host/client/local/site/dashboard.html#all")
@Page(startingPage=true, path="dash")
@Dependent
public class DashboardPage extends Composite {

    @Inject
    private JsefRegistry jsef;

    @Inject @DataField("wsdl-link")
    Anchor wsdlLink;
    @Inject @DataField("switchyard-link")
    Anchor switchyardLink;
    @Inject
    TransitionTo<DetailsPage> toDetails;

    /**
     * Constructor.
     */
    public DashboardPage() {
    }

    /**
     * Called after this page is constructed.
     */
    @PostConstruct
    public void onConstruct() {
    }

    @EventHandler("wsdl-link")
    public void onWsdlLinkClick(ClickEvent event) {
        toDetails.go(ImmutableMultimap.<String, String>of("artifactId", "1"));
        event.preventDefault();
    }

    @EventHandler("switchyard-link")
    public void onSwitchyardLinkClick(ClickEvent event) {
        toDetails.go(ImmutableMultimap.<String, String>of("artifactId", "2"));
        event.preventDefault();
    }
}
