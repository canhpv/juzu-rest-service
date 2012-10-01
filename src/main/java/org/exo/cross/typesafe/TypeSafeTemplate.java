/*
 * Copyright (C) 2003-2012 eXo Platform SAS.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.exo.cross.typesafe;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.portlet.PortletPreferences;

import juzu.Action;
import juzu.Path;
import juzu.Response;
import juzu.View;
import juzu.template.Template;

/**
 * Created by The eXo Platform SAS
 * Author : Canh Pham Van
 *          canhpv@exoplatform.com
 * Oct 1, 2012  
 */
public class TypeSafeTemplate {
  static Set<String> locations = new HashSet<String>();
   
  
  @Inject
  WeatherService weatherService;
  
  @Inject
  PortletPreferences preferences;
  
  @Inject
  @Path("index.gtmpl")
  org.exo.cross.typesafe.templates.index index;   

  @View
  public void index(){
    index("hanoi");
  }
  
  @View
  public void index(String location) {
    String grade = preferences.getValue("grade", "c");
    index.with().location(location).
      temperature(weatherService.getTemperature(location,grade)).
      grade(grade).
      locations(locations).
      render();
  }
  
  @Action
  public Response add(String location) {
    locations.add(location);
    return TypeSafeTemplate_.index(location);
  }  
  
  @Action
  public void updateGrade(String grade) throws java.io.IOException,
    javax.portlet.PortletException {
    preferences.setValue("grade", grade);
    preferences.store();
  }  
}
