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

import java.util.List;

import javax.enterprise.context.Dependent;

import jsef.poc2.host.client.local.beans.ArtifactBean;

import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TableCellElement;
import com.google.gwt.dom.client.TableRowElement;
import com.google.gwt.user.client.ui.Composite;

/**
 * @author eric.wittmann@redhat.com
 */
@Templated("/jsef/poc2/host/client/local/site/details.html#classifiers-table")
@Dependent
public class ClassifiersTable extends Composite {

    @DataField
    Element tbody = Document.get().createTBodyElement();

    /**
     * Constructor.
     */
    public ClassifiersTable() {
    }

    /**
     * @param artifact
     */
    public void update(ArtifactBean artifact) {
        // Clear all old children.
        tbody.setInnerHTML("");
        // Add new children
        List<String> classifiedBy = artifact.getClassifiedBy();
        int index = 1;
        for (String cb : classifiedBy) {
            TableRowElement tr = Document.get().createTRElement();
            tbody.appendChild(tr);
            TableCellElement col1TD = Document.get().createTDElement();
            TableCellElement col2TD = Document.get().createTDElement();
            tr.appendChild(col1TD);
            tr.appendChild(col2TD);
            col1TD.setInnerText("" + index++);
            col2TD.setInnerText(cb);
        }
    }

}
