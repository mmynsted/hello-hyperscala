package com.growingliberty.hello

import org.hyperscala.html._
import org.hyperscala.web.Webpage
import org.powerscala.property.Property

import org.hyperscala.ui.binder._
import org.hyperscala.ui.dynamic.{DynamicContent, DynamicString}
import org.hyperscala.realtime.RealtimeEvent

class DynamicContentExample extends Webpage(HelloSite) {
  title := "Dynamic Content Example"
  body.contents += new tag.P { contents +=
    "Content can be extracted and manipulated before hyperscala delivers a response.  "
  }
  body.contents += new SimpleDynamicForm

  class SimpleDynamicForm extends DynamicContent("DynamicContentExample") {

    /* Load dynamic.html to dynamicString
     * Implementing the dynamicString method from DynamicContent trait
     * with a lazy val because we need not load this more than once.
     */
    lazy val dynamicString = DynamicString.url("dynamic.html", getClass.getClassLoader.getResource("dynamic.html"))

    //Person
    case class Person(name: String, age: Int)

    //Provide a default value for the Person property
    val person = Property[Person](default = Some(Person("John Doe", 123)))

    //Listen for changes
    person.change.on {
      //Lets write to the console when we see the person property change.
      case evt => println("Person changed from %s to %s".format(evt.oldValue, evt.newValue))
    }

    //bind form inputs by id to fields in person
    val nameInput = bind[tag.Input, String]("i1", person, "name")
    val ageInput  = bind[tag.Input, Int]("i2", person, "age")

    //Listen for button clicks on button with id "b1"
    val button = load[tag.Button]("b1")
    button.clickEvent := RealtimeEvent()
    button.clickEvent.on {
      //Replace person with a one with new values on button click.
      case evt => person := Person("Test User", 987)
    }

    /* Manipulate the button so it reads "Do Something"
     * It originally looked like this <button id="b1">Submit</button>
     */
    button.contents.replaceWith("Do Something")
  }
}
