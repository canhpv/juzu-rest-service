@juzu.plugin.asset.Assets(
                          scripts = {
                            @juzu.plugin.asset.Script(
                              id = "jquery",  
                              src = "jquery-1.7.1.min.js", location = juzu.asset.AssetLocation.CLASSPATH)                             
                          },stylesheets = {
                              @Stylesheet(
                                          src = "cs/bootstrap.css",
                                          location = juzu.asset.AssetLocation.CLASSPATH)
                                        }
                        )

@Application
@Portlet package org.exo.cross.typesafe;

import juzu.Application;
import juzu.plugin.portlet.Portlet;
import juzu.plugin.asset.Stylesheet;