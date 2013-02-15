
package org.mule.module.wsapi.api;

import org.mule.api.NamedObject;

import java.util.List;

public interface WebServiceInterface extends WebServiceRoute, NamedObject
{

    List<? extends WebServiceRoute> getRoutes();

}
