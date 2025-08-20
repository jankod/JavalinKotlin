package hr.pbf

import io.javalin.http.Context
import kotlinx.html.*
import kotlinx.html.stream.createHTML


fun homePage(ctx: Context): String = layoutPage(
    pageTitle = "Home",
    headBlock = {
        meta { name = "description"; content = "Početna stranica mog sitea" }
    }
) {
    val nsto = "< > scape"

    h1 { +"Welcome to the Home Page" }
    p { +"IP je ${ctx.ip()}" }
    p { +"Escape $nsto" }
    myButton("Docs", "/docs")
}
