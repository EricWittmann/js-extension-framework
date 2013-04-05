/**
 * The on-load function - used here to register contributions to the
 * extension-point(s) exposed by the host application.
 */
$(document).ready(function() {
	// Contribute to the 'artifact-details-tab' extension-point.
	jsef("artifact-details-tab").contribute({
		id: "ext_tab_1",
		displayName: "ExtTab1",
		render: function(artifact, tab) {
			tab.innerHTML = "<div>Custom tab content for artifact with UUID: " + artifact.uuid + "</div>";
		}
	});
});
