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

import jsef.poc2.host.client.local.widgets.UnorderedListPanel;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Anchor;

/**
 *
 * @author eric.wittmann@redhat.com
 */
public class TabBar extends UnorderedListPanel implements HasValueChangeHandlers<String> {

    private String selectedTabId;

    /**
     * Constructor.
     */
    public TabBar() {
    }

    /**
     * Adds a tab to the tab bar.
     * @param displayName
     * @param tabId
     */
    public void addTab(String displayName, final String tabId) {
        String cname = null;
        if (this.getWidgetCount() == 0) {
            cname = "active";
            this.selectedTabId = tabId;
        }
        Anchor a = new Anchor(displayName);
        a.setHref("#" + tabId);
        a.getElement().setAttribute("data-toggle", "tab");
        this.add(a);
        if (cname != null) {
            setLiClass(a, cname);
        }
        a.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                String oldTabId = selectedTabId;
                selectedTabId = tabId;
                ValueChangeEvent.fireIfNotEqual(TabBar.this, oldTabId, selectedTabId);
            }
        });
    }

    /**
     * @see com.google.gwt.event.logical.shared.HasValueChangeHandlers#addValueChangeHandler(com.google.gwt.event.logical.shared.ValueChangeHandler)
     */
    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<String> handler) {
        return addHandler(handler, ValueChangeEvent.getType());
    }
}
