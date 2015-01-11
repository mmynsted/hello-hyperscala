package com.growingliberty.hello

import org.hyperscala.web.Webpage
import org.hyperscala.html._

class HelloPage extends Webpage(HelloSite) {
  body.contents += new tag.H1(content = "Hello, World!")
}


