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

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import jsef.poc2.host.client.local.beans.Artifact;

import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;

/**
 *
 * @author eric.wittmann@redhat.com
 */
@Templated("/jsef/poc2/host/client/local/site/details.html#overview-form")
@Dependent
public class OverviewForm extends Composite {

    @Inject @DataField
    TextBox uuid;
    @Inject @DataField
    TextBox type;
    @Inject @DataField
    TextBox createdBy;

    /**
     * Constructor.
     */
    public OverviewForm() {
    }

    /**
     * @param artifact
     */
    public void update(Artifact artifact) {
        uuid.setValue(artifact.getUuid());
        type.setValue(artifact.getType());
        createdBy.setValue(artifact.getCreatedBy());
    }

}
