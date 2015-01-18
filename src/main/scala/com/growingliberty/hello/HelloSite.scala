package com.growingliberty.hello

import com.outr.net.http.jetty.JettyApplication
import com.outr.net.http.session.MapSession
import org.hyperscala.web.{BasicWebsite, StaticWebsite}

object HelloSite extends BasicWebsite with StaticWebsite[MapSession] with JettyApplication {
  def index = new HelloPage
  def dynamicContentExample = new DynamicContentExample
  def dynamicPageExample = new DynamicPageExample[MapSession](this)
}

