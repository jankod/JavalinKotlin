package hr.pbf

import kotlinx.html.BODY
import kotlinx.html.HEAD
import kotlinx.html.a
import kotlinx.html.body
import kotlinx.html.div
import kotlinx.html.head
import kotlinx.html.html
import kotlinx.html.lang
import kotlinx.html.link
import kotlinx.html.main
import kotlinx.html.meta
import kotlinx.html.nav
import kotlinx.html.script
import kotlinx.html.stream.createHTML
import kotlinx.html.title

fun layoutPage(
    pageTitle: String,
    headBlock: HEAD.() -> Unit = {},
    contentBlock: BODY.() -> Unit
): String = createHTML().html {
    lang = "en"
    head {
        meta { charset = "utf-8" }
        meta { name = "viewport"; content = "width=device-width, initial-scale=1" }
        title { +pageTitle }
        // Global CSS/JS (npr. Bootstrap)
        link(
            rel = "stylesheet",
            href = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        )
        headBlock() // 👈 stranica može dodati svoj <head> sadržaj
    }
    body {
        // zajednički layout (nav, footer…)
        nav(classes = "navbar navbar-expand-lg navbar-light bg-light") {
            div(classes = "container-fluid") {
                a(classes = "navbar-brand", href = "/") { +"MyApp" }
            }
        }
        main(classes = "container my-4") {
            this@body.contentBlock() // 👈 sadržaj konkretne stranice
        }
        script(src = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js") {}
    }
}
