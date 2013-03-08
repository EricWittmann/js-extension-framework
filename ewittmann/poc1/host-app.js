/**
 * On load - do initial application initialization, register extension
 * points with JSEF.  This is the main entry point to the Host Application
 * (also known as the "Extensible Application" in our spec document).
 * This is intended to be a strawman implementation - clearly rich client
 * applications writen in JS would be more sophisticated. :)
 */
$(document).ready(function() {
	// Register the 'heading' extension-point.
	// 'data' format:
	//    title (required) - the title of the heading
	//    description (required) - the description of the heading
	jsef("heading").register(function(epo, data) {
		// When we are notified of a new contribution (extension) to the
		// 'heading' extension-point, we'll simply create a new Heading
		// in the UI.
		createHeading(data);
	});
	// Register the 'navigation-bar' extension-point
	// 'data' format:
	//    parentId (optional) - string ID of the parent menu (will use root if missing)
	//    id (required) - the unique menu item ID
	//    url (required) - the URL to follow when the menu item is clicked
	//    displayName (required) - the text to show on the menu item
	jsef("navigation-bar").register(function(epo, data) {
		// When we are notified of a new contribution (extension) to the
		// 'navigation-bar' extension-point, we'll create a new menu
		// item in the main navigation bar.
		createMenuItem(data);
	});
	
	createHeading({
		title: "Core Heading 1",
		description: "This is a heading that was added by the host application during startup/initialization of the app."
	});
});


/**
 * Called to create a single Heading in the UI.
 * @param data
 */
function createHeading(data) {
	var headingHtml = '<div class="span4"><h2>'+data.title+'</h2><p>'+data.description+'</p><p><a class="btn" href="#">View details &raquo;</a></p></div>';
	$("#heading-container").append(headingHtml);
};


/**
 * Called to create an entry in the main navigation bar.
 * @param data
 */
function createMenuItem(data) {
	var parent;
	if (data.parentId) {
		parent = $("#main-nav-bar ." + data.parentId);
	} else {
		parent = $("#main-nav-bar");
	}
	if (parent.get(0).tagName == 'LI') {
		parent = parent.children("ul").first();
	}
	var menuItemHtml = '<li class="'+data.id+'"><a href="'+data.url+'">'+data.displayName+'</a></li>';
	parent.append(menuItemHtml);
};

/*

*/