/**
 * The on-load function - used here to register contributions to the
 * extension-point(s) exposed by the host application.
 */
$(document).ready(function() {
	// Contribute to the 'heading' extension-point.
	jsef("heading").contribute({
		title: "Contributed Heading 1",
		description: "Hi!  I was contributed by the 'app-extension-1' application extension!.  If you see me then this shit be workin'!"
	});
//	jsef("navigation-bar").contribute({
//		id: "app-ext-menu-item-1",
//		url: "#appext1",
//		displayName: "Contributed 1"
//	});
});
