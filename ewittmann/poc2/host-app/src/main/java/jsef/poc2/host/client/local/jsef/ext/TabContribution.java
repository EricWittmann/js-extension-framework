package jsef.poc2.host.client.local.jsef.ext;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * Wrapper around the data for a tab contribution.
 *
 * @author eric.wittmann@redhat.com
 */
public class TabContribution extends JavaScriptObject {

    /**
     * Constructor.
     */
    protected TabContribution() {
    }

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

    /**
     * @param artifact
     * @param tab
     */
    public final native void render(Object artifact, Element tab)/*-{
		this.render(artifact, tab);
    }-*/;

}
