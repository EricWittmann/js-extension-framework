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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Models an artifact.
 *
 * @author eric.wittmann@redhat.com
 */
public class ArtifactBean {

    private String type;
    private String uuid;
    private String name;
    private String createdBy;
    private String description;
    private List<String> classifiedBy = new ArrayList<String>();
    private Map<String, String> customProperties = new HashMap<String, String>();

    /**
     * Constructor.
     */
    public ArtifactBean() {
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the classifiedBy
     */
    public List<String> getClassifiedBy() {
        return classifiedBy;
    }

    /**
     * @param type the type to set
     */
    public ArtifactBean setType(String type) {
        this.type = type;
        return this;
    }

    /**
     * @param uuid the uuid to set
     */
    public ArtifactBean setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    /**
     * @param name the name to set
     */
    public ArtifactBean setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * @param description the description to set
     */
    public ArtifactBean setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * @param classifiedBy the classifiedBy to set
     */
    public ArtifactBean setClassifiedBy(List<String> classifiedBy) {
        this.classifiedBy = classifiedBy;
        return this;
    }

    /**
     * @param classification
     */
    public ArtifactBean addClassifiedBy(String classification) {
        classifiedBy.add(classification);
        return this;
    }

    /**
     * @return the customProperties
     */
    public Map<String, String> getCustomProperties() {
        return customProperties;
    }

    /**
     * @param customProperties the customProperties to set
     */
    public void setCustomProperties(Map<String, String> customProperties) {
        this.customProperties = customProperties;
    }

    /**
     * @param key
     * @param value
     */
    public ArtifactBean addCustomProperty(String key, String value) {
        this.customProperties.put(key, value);
        return this;
    }

    /**
     * @param key
     * @return
     */
    public String getCustomProperty(String key) {
        return this.customProperties.get(key);
    }

    /**
     * @return the createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy the createdBy to set
     */
    public ArtifactBean setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

}
