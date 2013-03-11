/**
 * The on-load function - used here to register contributions to the
 * extension-point(s) exposed by the host application.
 */
$(document).ready(function() {
	// Contribute to the 'heading' extension-point.
	jsef("heading").contribute({
		title: "Ext Heading 2-1",
		description: "I was contributed by the 'app-extension-2' application extension!  You should see my sibling 'Ext Heading 2-2' next to me (or below me)."
	});
	jsef("heading").contribute({
		title: "Ext Heading 2-2",
		description: "As you probably expected (if you read 'Ext Heading 2-1's' message), I was also contributed by the 'app-extension-2' application extension."
	});
	jsef("navigation-bar").contribute({
		parentId: "menu-core-dropdown",
		id: "app-ext-menu-item-2",
		url: "#extitem2-1",
		displayName: "Ext Item 2-1"
	});
	jsef("navigation-bar").contribute({
		parentId: "menu-core-dropdown",
		id: "app-ext-menu-item-2",
		url: "#extitem2-1",
		displayName: "Ext Item 2-1"
	});
});
