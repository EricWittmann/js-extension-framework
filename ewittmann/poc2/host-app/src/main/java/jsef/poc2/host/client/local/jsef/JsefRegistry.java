package jsef.poc2.host.client.local.jsef;

import javax.enterprise.context.ApplicationScoped;

import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Integration with the native JSEF system.
 *
 * @author eric.wittmann@redhat.com
 */
@ApplicationScoped
public class JsefRegistry {

    /**
     * Constructor.
     */
    public JsefRegistry() {
    }

    /**
     * Register a new extension point.
     * @param extensionPointName
     * @param callback
     */
    public native void registerExtensionPoint(final String extensionPointName, final IExtensionPointCallback callback)
            throws JavaScriptException /*-{
		$wnd.jsef(extensionPointName).register(function(epo, data) {
		    callback.@jsef.poc2.host.client.local.jsef.IExtensionPointCallback::contributionMade(Lcom/google/gwt/core/client/JavaScriptObject;)(data);
		});
    }-*/;

    /**
     * Contributes an extension to a previously registered extension point.
     * @param extensionPointName
     * @param data
     * @throws JavaScriptException
     */
    public native void contributeToExtensionPoint(final String extensionPointName, JavaScriptObject data)
            throws JavaScriptException /*-{
		return $wnd.jsef(extensionPointName).contribute(data);
    }-*/;

}
