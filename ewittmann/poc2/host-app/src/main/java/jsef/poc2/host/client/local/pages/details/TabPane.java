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

import com.google.gwt.user.client.ui.FlowPanel;

/**
 *
 * @author eric.wittmann@redhat.com
 */
public class TabPane extends FlowPanel {

    /**
     * Constructor.
     * @param tabId
     */
    public TabPane(String tabId) {
        getElement().addClassName("tab-pane");
        getElement().addClassName("fade");
        getElement().setId(tabId);
    }

    public void activate() {
        getElement().removeClassName("active");
    }

    public void deactivate() {
        getElement().removeClassName("active");
    }
}
