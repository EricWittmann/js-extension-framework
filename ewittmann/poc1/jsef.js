(function(window, undefined) {
    var extensionPointRegistry = {};

    window.jsef = function(extensionPointName) {
        return new jsefObject(extensionPointName);
    };

    /**
     * Root level object for JSEF.
     * @param extensionPointName name of an extension point
     * @returns {jsefObject}
     */
    jsefObject = function(extensionPointName) {
    	/**
    	 * Called (by the Extensible Application) to register this extension point.  This 
    	 * can only be done once.  Perhaps a QName is needed here to avoid collisions?
    	 * @param callback a function that will be called when a contribution is made to the extension-point
    	 * @returns an extensionPointObject instance
    	 */
        this.register = function(callback) {
        	var epo = extensionPointRegistry[extensionPointName];
        	if (!epo) {
        		epo = new extensionPointObject(extensionPointName);
        		epo.setCallback(callback);
        		extensionPointRegistry[extensionPointName] = epo;
        	} else {
        		throw "Extension-Point " + extensionPointName + " already registered.";
        	}
        	return epo;
        };
        /**
         * Called (by an Application Extension) to contribute functionality to the named
         * extension point (previously registered by the Extensible Application).
         * @param data the data sent to the Extensible Application when making the contribution
         */
        this.contribute = function(data) {
        	var epo = extensionPointRegistry[extensionPointName];
        	if (!epo) {
        		throw "Extension-Point " + extensionPointName + " not yet registered.";
        	}
        	epo.addContribution(data);
        };
    };

    /**
     * One of these is created whenever an extension point is registered.
     * @param extensionPointName
     * @returns {extensionPointObject}
     */
    extensionPointObject = function(extensionPointName) {
    	this.callback;
    	this.contributions = new Array();

    	/**
    	 * Sets the callback provided by the Extensible Application when it
    	 * registered the extension-point.
    	 * @param callback
    	 */
    	this.setCallback = function(callback) {
    		this.callback = callback;
    	};

    	/**
    	 * Adds a single contribution to the extension-point - called when
    	 * an Application Extension contributes to the extension-point.
    	 * @param data
    	 */
    	this.addContribution = function(data) {
    		this.contributions.push(data);
    		this.callback(this, data);
    	};
    };
})(window);
