package com.growingliberty.hello

import org.hyperscala.web.Webpage
import org.hyperscala.html._

class HelloPage extends Webpage(HelloSite) {
  require(jQuery182)
  title := "Hello world page"
  body.contents += new tag.H1(content = "Hello, ")
  body.contents += new tag.H2(content = "World!")
}


