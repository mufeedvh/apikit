/*
 * $Id: RssNamespaceHandler.java 21236 2011-02-10 05:12:40Z dirk.olmes $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.module.wsapi.rest.config;

import org.mule.config.spring.handlers.MuleNamespaceHandler;
import org.mule.module.wsapi.config.WebServiceDefinitionParser;
import org.mule.module.wsapi.config.WebServiceInterfaceDefinitionParser;
import org.mule.module.wsapi.rest.RestWebService;
import org.mule.module.wsapi.rest.RestWebServiceInterface;
import org.mule.module.wsapi.rest.action.RestCreateAction;
import org.mule.module.wsapi.rest.action.RestExistsAction;
import org.mule.module.wsapi.rest.action.RestRetrieveAction;
import org.mule.module.wsapi.rest.action.RestUpdateAction;
import org.mule.module.wsapi.rest.resource.CollectionResource;
import org.mule.module.wsapi.rest.resource.DocumentResource;

public class RestAPINamespaceHandler extends MuleNamespaceHandler
{
    public void init()
    {
        registerBeanDefinitionParser("interface", new WebServiceInterfaceDefinitionParser(
            RestWebServiceInterface.class));
        registerBeanDefinitionParser("service", new WebServiceDefinitionParser(RestWebService.class));

        registerBeanDefinitionParser("document-resource", new RestResourceDefinitionParser(
            DocumentResource.class));
        registerBeanDefinitionParser("collection-resource", new RestResourceDefinitionParser(
            CollectionResource.class));

        registerMuleBeanDefinitionParser("create", new RestActionDefinitionParser(RestCreateAction.class));
        registerMuleBeanDefinitionParser("update", new RestActionDefinitionParser(RestUpdateAction.class));
        registerMuleBeanDefinitionParser("retrieve", new RestActionDefinitionParser(RestRetrieveAction.class));
        registerMuleBeanDefinitionParser("exists", new RestActionDefinitionParser(RestExistsAction.class));
    }

}
