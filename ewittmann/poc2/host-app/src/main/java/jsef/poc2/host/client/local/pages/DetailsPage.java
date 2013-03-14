package jsef.poc2.host.client.local.pages;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import jsef.poc2.host.client.local.jsef.JsefRegistry;
import jsef.poc2.host.client.local.pages.details.TabBar;
import jsef.poc2.host.client.local.pages.details.TabPane;
import jsef.poc2.host.client.local.pages.details.TabPanel;

import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.nav.client.local.PageState;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.InlineLabel;

/**
 * The home/dashboard page.
 *
 * @author eric.wittmann@redhat.com
 */
@Templated("/jsef/poc2/host/client/local/site/details.html#all")
@Page(path="details")
@Dependent
public class DetailsPage extends Composite {

    @PageState
    private String artifactId;

    @Inject
    private JsefRegistry jsef;

    @Inject @DataField("tab-bar")
    TabBar tabBar;
    @Inject @DataField("tab-panel")
    TabPanel tabPanel;

    /**
     * Constructor.
     */
    public DetailsPage() {
    }

    /**
     * Called after this page is constructed.
     */
    @PostConstruct
    public void onConstruct() {
        tabBar.addTab("Overview", "overview");
        tabBar.addTab("Classifiers", "classifiers");
        TabPane overviewPane = tabPanel.createTab("overview");
        overviewPane.add(new InlineLabel("Overview goes here!"));
        TabPane relationshipsPane = tabPanel.createTab("classifiers");
        relationshipsPane.add(new InlineLabel("Classifiers go here!"));
        tabBar.addValueChangeHandler(new ValueChangeHandler<String>() {
            @Override
            public void onValueChange(ValueChangeEvent<String> event) {
                onTabChange(event);
            }
        });
    }

    /**
     * @param event
     */
    public void onTabChange(ValueChangeEvent<String> event) {
    }

}
