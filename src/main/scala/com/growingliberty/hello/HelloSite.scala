package com.growingliberty.hello

import org.hyperscala.web.{StaticWebsite, BasicWebsite}
import com.outr.net.http.jetty.JettyApplication
import com.outr.net.http.session.MapSession

object HelloSite extends BasicWebsite with StaticWebsite[MapSession] with JettyApplication {
  def index = new HelloPage
  def dynamicContentExample = new DynamicContentExample
}

