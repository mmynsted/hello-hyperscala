package com.growingliberty.hello

class DynamicPageExample[S <: com.outr.net.http.session.Session](site: org.hyperscala.web.Website[S])
  extends org.hyperscala.ui.dynamic.DynamicWebpage(site) {

  def dynamicTag = {
    org.hyperscala.ui.dynamic.DynamicTag.file(getClass().getName,
      new java.io.File("./src/main/resources/dynamic_page.html"))
  }

  val message = getById[org.hyperscala.html.tag.Strong]("message")
  message.contents.replaceWith("Dynamically updated content from an existing HTML page!")
}
