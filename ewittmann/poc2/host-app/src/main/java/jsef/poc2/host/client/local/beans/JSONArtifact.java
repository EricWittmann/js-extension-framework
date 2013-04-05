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
package jsef.poc2.host.client.local.beans;

import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Models an artifact as JSON.
 *
 * @author eric.wittmann@redhat.com
 */
public class JSONArtifact extends JavaScriptObject {

    /**
     * Constructor.
     */
    protected JSONArtifact() {
    }

    /**
     * @param artifact
     */
    public static final JSONArtifact create(Artifact artifact) {
        JSONArtifact rval = create();
        rval.setName(artifact.getName());
        rval.setDescription(artifact.getDescription());
        rval.setType(artifact.getType());
        rval.setUuid(artifact.getUuid());
        rval.setClassifiedBy(artifact.getClassifiedBy());
        rval.setCustomProperties(artifact.getCustomProperties());
        return rval;
    }

    /**
     * @return an empty {@link JSONArtifact}.
     */
    private static final native JSONArtifact create()/*-{
        return {};
    }-*/;

    /**
     * @param type the type to set
     */
    public native final void setType(String type)/*-{
        this.type = type;
    }-*/;

    /**
     * @param uuid the uuid to set
     */
    public native final void setUuid(String uuid)/*-{
        this.uuid = uuid;
    }-*/;

    /**
     * @param name the name to set
     */
    public native final void setName(String name)/*-{
        this.name = name;
    }-*/;

    /**
     * @param description the description to set
     */
    public native final void setDescription(String description)/*-{
        this.description = description;
    }-*/;

    /**
     * @param createdBy the createdBy to set
     */
    public native final void setCreatedBy(String createdBy)/*-{
        this.createdBy = createdBy;
    }-*/;

    /**
     * @param classifiedBy the classifiedBy to set
     */
    public final void setClassifiedBy(List<String> classifiedBy) {
    }

    /**
     * @param customProperties the customProperties to set
     */
    public final void setCustomProperties(Map<String, String> customProperties) {
    }

}
