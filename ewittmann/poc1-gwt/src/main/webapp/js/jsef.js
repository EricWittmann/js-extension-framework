(function() {
    var window = this;
    var extensionPointRegistry = {};
    window;//suppress a "never read" warning for 'window'

    jsef = window.jsef = function(extensionPointName) {
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
        		extensionPointRegistry[extensionPointName] = epo;
        	} else {
        		if (epo.isRegistered()) {
        			throw "Extension-Point " + extensionPointName + " already registered.";
        		}
        	}
        	// Functionally registers the extension-point
    		epo.setCallback(callback);
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
        		// Create an unregistered extension-point and save the contribution
        		// for later.  If no one comes around and registers the extension-point,
        		// then the contribution will be for naught.
        		epo = new extensionPointObject(extensionPointName);
        		extensionPointRegistry[extensionPointName] = epo;
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
    	this.registered = false;
    	this.callback;
    	this.contributions = new Array();
    	
    	/**
    	 * Returns true if the extension-point has been registered.
    	 * @returns {Boolean}
    	 */
    	this.isRegistered = function() {
    		return this.registered;
    	};

    	/**
    	 * Sets the callback provided by the Extensible Application when it
    	 * registered the extension-point.
    	 * @param callback
    	 */
    	this.setCallback = function(callback) {
    		this.callback = callback;
    		this.registered = true;
    		// When registering the extension point for the first time,
    		// dispatch any pre-registered contributions.
    		for (var i = 0; i < this.contributions.length; i++) {
    			this.callback(this, this.contributions[i]);
    		}
    	};

    	/**
    	 * Adds a single contribution to the extension-point - called when
    	 * an Application Extension contributes to the extension-point.
    	 * @param data
    	 */
    	this.addContribution = function(data) {
    		this.contributions.push(data);
    		if (this.registered) {
        		this.callback(this, data);
    		}
    	};
    };
})();
