package hr.pbf

import io.javalin.Javalin

fun main() {
    val app = Javalin.create() { config ->
        config.useVirtualThreads = true
        // config.bundledPlugins.enableDevLogging()
    }
        .get("/") { ctx -> ctx.result("Hello World sad sadds a") }
        .get("/hello") { ctx -> ctx.result("Hello from Javalin!") }
        .get("/home") { ctx -> ctx.html(homePage(ctx)) }
        .start(7070)

}
