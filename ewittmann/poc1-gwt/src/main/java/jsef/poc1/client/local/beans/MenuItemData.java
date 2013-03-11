package jsef.poc1.client.local.beans;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Wrapper around the data for a menu item contribution.
 *
 * @author eric.wittmann@redhat.com
 */
public class MenuItemData extends JavaScriptObject {

    /**
     * Constructor.
     */
    protected MenuItemData() {}

    /**
     * @return the id
     */
    public final native String getId()/*-{
        return this.id;
    }-*/;

    /**
     * @return the parent ID
     */
    public final native String getParentId()/*-{
        if (!this.parentId) {
            return null;
        }
        return this.parentId;
    }-*/;

    /**
     * @return the url
     */
    public final native String getUrl()/*-{
        return this.url;
    }-*/;

    /**
     * @return the display name
     */
    public final native String getDisplayName()/*-{
        return this.displayName;
    }-*/;

}
