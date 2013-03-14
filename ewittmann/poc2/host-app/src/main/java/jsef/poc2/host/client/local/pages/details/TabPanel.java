/*
 * Copyright 2013 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jsef.poc2.host.client.local.pages.details;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.user.client.ui.FlowPanel;

/**
 * @author eric.wittmann@redhat.com
 */
public class TabPanel extends FlowPanel {

    private Map<String, TabPane> tabMap = new HashMap<String, TabPane>();

    /**
     * Constructor.
     */
    public TabPanel() {
    }

    /**
     * Creates an empty tab pane and returns it.  The assumption is that
     * consumers will populate the tab pane with their content.
     * @param tabId
     */
    public TabPane createTab(String tabId) {
        TabPane pane = new TabPane(tabId);
        pane.getElement().setId(tabId);
        if (tabMap.size() == 0) {
            pane.getElement().addClassName("in");
            pane.getElement().addClassName("active");
        }
        tabMap.put(tabId, pane);
        add(pane);
        return pane;
    }

}
