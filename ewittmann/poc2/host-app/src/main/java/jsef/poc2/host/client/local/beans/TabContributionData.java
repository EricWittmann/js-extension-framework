package jsef.poc2.host.client.local.beans;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Wrapper around the data for a tab contribution.
 *
 * @author eric.wittmann@redhat.com
 */
public class TabContributionData extends JavaScriptObject {

    /**
     * Constructor.
     */
    protected TabContributionData() {}

    /**
     * @return the title
     */
    public final native String getDisplayName()/*-{
        return this.displayName;
    }-*/;

    /**
     * @return the title
     */
    public final native String getId()/*-{
        return this.id;
    }-*/;

}
