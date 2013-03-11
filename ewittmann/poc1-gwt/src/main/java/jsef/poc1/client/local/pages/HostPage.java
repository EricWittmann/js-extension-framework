package jsef.poc1.client.local.pages;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import jsef.poc1.client.local.beans.HeadingData;
import jsef.poc1.client.local.beans.MenuItemData;
import jsef.poc1.client.local.jsef.IExtensionPointCallback;
import jsef.poc1.client.local.jsef.JsefRegistry;
import jsef.poc1.client.local.widgets.Heading;
import jsef.poc1.client.local.widgets.MenuBar;

import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

/**
 * The only page in the app.
 *
 * @author eric.wittmann@redhat.com
 */
@Templated("/jsef/poc1/client/local/site/host-app.html#all")
@Page(startingPage=true, path="home")
@Dependent
public class HostPage extends Composite {

    @Inject
    private JsefRegistry jsef;

    @Inject @DataField("main-nav-bar")
    MenuBar menuBar;

    @Inject @DataField("heading-container")
    FlowPanel headings;
    @Inject
    Instance<Heading> headingFactory;

    /**
     * Constructor.
     */
    public HostPage() {
    }

    /**
     * Called after this page is constructed.
     */
    @PostConstruct
    public void onConstruct() {
        addHeading("Core Heading 1", "This is a heading that was added by the host application during startup/initialization of the app.");
        menuBar.addMenuItem(null, "#", "Home", true);
        menuBar.addMenuItem(null, "#", "Core Item 1", false);
        menuBar.addSubMenu("menu-core-dropdown", "Core Dropdown");
        menuBar.addMenuItem("menu-core-dropdown", "#", "Core Action 1", false);
        menuBar.addMenuItem("menu-core-dropdown", "#", "Core Action 2", false);

        jsef.registerExtensionPoint("heading", new IExtensionPointCallback() {
            @Override
            public void contributionMade(JavaScriptObject data) {
                HeadingData hd = (HeadingData) data.cast();
                addHeading(hd.getTitle(), hd.getDescription());
            }
        });
        jsef.registerExtensionPoint("navigation-bar", new IExtensionPointCallback() {
            @Override
            public void contributionMade(JavaScriptObject data) {
                MenuItemData menuItem = (MenuItemData) data.cast();
                addMenuItem(menuItem);
            }
        });
    }

    /**
     * Adds a single Header to the app.
     * @param title
     * @param description
     */
    private void addHeading(String title, String description) {
        Heading heading = headingFactory.get();
        heading.setTitle(title);
        heading.setDescription(description);
        headings.add(heading);
    }

    /**
     * Creates a single menu item in the main navigation bar.
     * @param menuItem
     */
    protected void addMenuItem(MenuItemData menuItem) {
        this.menuBar.addMenuItem(menuItem.getParentId(), menuItem.getUrl(), menuItem.getDisplayName(), false);
    }

}
