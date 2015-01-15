package com.growingliberty.hello

import org.hyperscala.html.tag
import org.hyperscala.web.{Website,Webpage}
import org.powerscala.Version
import org.hyperscala.module._



object jQuery182 extends Module {

  import com.outr.net.http.session.Session

  def name = "jQuery182"
  def version = Version(1,8,2)

  //override val dependencies = List(org.hyperscala.jquery.jQuery)
  //override def implements = List(org.hyperscala.jquery.jQuery)

  override def init[S <: Session](website: Website[S]) = {
    website.register("/js/jquery-1.8.2.js", "jquery-1.8.2.min.js")
  }

  override def load[S <: Session](webpage: Webpage[S]) = {
    webpage.head.contents += new tag.Script(mimeType = "text/javascript", src = "/js/jquery-1.8.2.js")
  }

}

