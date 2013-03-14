package jsef.poc2.host.client.local.jsef;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The callback interface - this is called back when a contribution is made to
 * an extension-point.
 *
 * @author eric.wittmann@redhat.com
 */
public interface IExtensionPointCallback {

    /**
     * Callback method.
     * @param data
     */
    public void contributionMade(JavaScriptObject data);

}
