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
package jsef.poc2.host.client.local.services;

import javax.enterprise.context.ApplicationScoped;

import jsef.poc2.host.client.local.beans.ArtifactBean;

/**
 * @author eric.wittmann@redhat.com
 */
@ApplicationScoped
public class ArtifactService {

    /**
     * Constructor.
     */
    public ArtifactService() {
    }

    /**
     * @param artifactId
     */
    public ArtifactBean getArtifact(String artifactId) {
        if (artifactId.equals("1")) {
            return createWsdlDocumentArtifact();
        } else if (artifactId.equals("2")) {
            return createSwitchyardDocumentArtifact();
        } else {
            throw new RuntimeException("No artifact found.");
        }
    }

    private ArtifactBean createWsdlDocumentArtifact() {
        ArtifactBean bean = new ArtifactBean();
        bean.setName("WSDL Document")
            .setDescription("This is a WSDL Document!")
            .setType("WsdlDocument")
            .setUuid("1")
            .setCreatedBy("ewittman")
            .addClassifiedBy("http://www.example.com/regions.owl#China")
            .addClassifiedBy("http://www.example.com/regions.owl#Japan");
        return bean;
    }

    private ArtifactBean createSwitchyardDocumentArtifact() {
        ArtifactBean bean = new ArtifactBean();
        bean.setName("Switchyard Document")
            .setDescription("This is a (switchyard.xml) Switchyard Document.")
            .setType("SwitchyardDocument")
            .setUuid("2")
            .setCreatedBy("kbabo")
            .addClassifiedBy("http://www.example.com/regions.owl#Maine")
            .addClassifiedBy("http://www.example.com/regions.owl#Florida")
            .addClassifiedBy("http://www.example.com/regions.owl#Hawaii")
            .addClassifiedBy("http://www.example.com/regions.owl#Vermont")
            .addCustomProperty("switchyard-transactions", "enabled")
            .addCustomProperty("switchyard-backlink", "http://www.google.com/#q=switchyard")
            ;
        return bean;
    }

}

