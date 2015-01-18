package com.growingliberty.hello

import org.hyperscala.html.tag
import org.hyperscala.module._
import org.hyperscala.web.{Webpage, Website}
import org.powerscala.Version

object jQuery182 extends Module {

  import com.outr.net.http.session.Session

  def name = "jQuery182"
  def version = Version(1,8,2)

  override def init[S <: Session](website: Website[S]) = {
    website.register("/js/jquery-1.8.2.js", "jquery-1.8.2.min.js")
  }

  override def load[S <: Session](webpage: Webpage[S]) = {
    webpage.head.contents += new tag.Script(mimeType = "text/javascript", src = "/js/jquery-1.8.2.js")
  }
}

