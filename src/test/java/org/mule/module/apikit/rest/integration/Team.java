/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.module.apikit.rest.integration;

import org.mule.module.apikit.rest.integration.swagger.Developers;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Team
{

    private String id;
    private String name;
    private Developers teamMembers;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Developers getTeamMembers()
    {
        return teamMembers;
    }

    public void setTeamMembers(Developers teamMembers)
    {
        this.teamMembers = teamMembers;
    }
}
