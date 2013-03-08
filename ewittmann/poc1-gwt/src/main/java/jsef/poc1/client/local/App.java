package jsef.poc1.client.local;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.ioc.client.api.EntryPoint;
import org.jboss.errai.ui.nav.client.local.Navigation;

import com.google.gwt.user.client.ui.RootPanel;

/**
 * The main entry point into the POC app.
 */
@EntryPoint
public class App {

	@Inject
	private RootPanel rootPanel;
	@Inject
	private Navigation navigation;

	@PostConstruct
	public void buildUI() {
		rootPanel.add(navigation.getContentPanel());
	}

}
