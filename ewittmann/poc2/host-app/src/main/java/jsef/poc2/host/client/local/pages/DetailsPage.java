package jsef.poc2.host.client.local.pages;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import jsef.poc2.host.client.local.beans.ArtifactBean;
import jsef.poc2.host.client.local.jsef.JsefRegistry;
import jsef.poc2.host.client.local.pages.details.ClassifiersTable;
import jsef.poc2.host.client.local.pages.details.OverviewForm;
import jsef.poc2.host.client.local.pages.details.TabBar;
import jsef.poc2.host.client.local.pages.details.TabPane;
import jsef.poc2.host.client.local.pages.details.TabPanel;
import jsef.poc2.host.client.local.services.ArtifactService;

import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.nav.client.local.PageShowing;
import org.jboss.errai.ui.nav.client.local.PageState;
import org.jboss.errai.ui.nav.client.local.TransitionAnchor;
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
    private transient ArtifactBean artifact;

    @Inject
    private ArtifactService artifactService;
    @Inject
    private JsefRegistry jsef;

    @Inject @DataField("artifact-name")
    InlineLabel artifactName;

    @Inject @DataField("go-back")
    TransitionAnchor<DashboardPage> goBackLink;

    @Inject @DataField("tab-bar")
    TabBar tabBar;
    @Inject @DataField("tab-panel")
    TabPanel tabPanel;

    @Inject
    OverviewForm overviewForm;
    @Inject
    ClassifiersTable classifiersTable;

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
        overviewPane.add(overviewForm);
        TabPane classifiersPane = tabPanel.createTab("classifiers");
        classifiersPane.add(classifiersTable);
        tabBar.addValueChangeHandler(new ValueChangeHandler<String>() {
            @Override
            public void onValueChange(ValueChangeEvent<String> event) {
                String newTabId = event.getValue();
                onTabChange(newTabId);
            }
        });
    }

    @PageShowing
    public void onPageShowing() {
        artifact = artifactService.getArtifact(artifactId);
        artifactName.setText(artifact.getName());
        onTabChange("overview");
    }

    /**
     * @param event
     */
    public void onTabChange(String newTabId) {
        if (newTabId.equals("overview")) {
            renderOverview();
        } else if (newTabId.equals("classifiers")) {
            renderClassifiers();
        } else {
            renderExtensionTab(newTabId);
        }
    }

    /**
     * Overview tab.
     */
    private void renderOverview() {
        overviewForm.update(artifact);
    }

    /**
     * Classifiers tab.
     */
    private void renderClassifiers() {
        classifiersTable.update(artifact);
    }

    /**
     * Extension tab.
     * @param newTabId
     */
    private void renderExtensionTab(String newTabId) {
    }

}
