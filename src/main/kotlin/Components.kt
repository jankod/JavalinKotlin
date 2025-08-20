package hr.pbf

import kotlinx.html.FlowContent
import kotlinx.html.a
import kotlinx.html.classes


fun FlowContent.myButton(text: String, href: String, style: String = "primary") {
    a(href) {
        classes = setOf("btn", "btn-$style")
        +text
    }
}
