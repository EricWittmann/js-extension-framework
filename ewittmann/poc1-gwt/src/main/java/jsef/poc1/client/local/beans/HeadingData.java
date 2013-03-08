package jsef.poc1.client.local.beans;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Wrapper around the data for a heading contribution.
 *
 * @author eric.wittmann@redhat.com
 */
public class HeadingData extends JavaScriptObject {

    /**
     * Constructor.
     */
    protected HeadingData() {}

    /**
     * @return the title
     */
    public final native String getTitle()/*-{
        return this.title;
    }-*/;

    /**
     * @return the title
     */
    public final native String getDescription()/*-{
        return this.description;
    }-*/;

}
