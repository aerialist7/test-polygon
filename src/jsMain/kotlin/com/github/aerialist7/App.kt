package com.github.aerialist7

import js.objects.jso
import react.*
import react.dom.client.createRoot
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.h1
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.nav
import react.dom.html.ReactHTML.ul
import react.router.Outlet
import react.router.RouterProvider
import react.router.dom.Link
import react.router.dom.createBrowserRouter
import remix.run.router.Router
import web.dom.document

fun main() {
    createRoot(document.getElementById("root")!!)
        .render(App.create())
}

private val App = FC<Props> {
    StrictMode {
        RouterProvider {
            router = Router
        }
    }
}

private val Home = FC {
    h1 { +"Home" }
}

private val Images = FC {
    button {
        +"Image List"
    }
}

private val Nav = FC {
    nav {
        ul {
            li {
                Link {
                    to = "/"
                    unstable_viewTransition = true

                    +"Home"
                }
                ul {
                    li {
                        +"The / route has no loader is should be an immediate/synchronous transition"
                    }
                }
            }
            li {
                Link {
                    to = "/images"
                    unstable_viewTransition = true

                    +"Image Gallery Example"
                }
            }
        }
    }
}

private val Main = FC {
    Fragment {
        Nav()
        Outlet()
    }
}

private val Router: Router = createBrowserRouter(
    routes = arrayOf(
        jso {
            path = "/"
            Component = Main
            children = arrayOf(
                jso {
                    index = true
                    Component = Home
                },
                jso {
                    path = "images"
                    Component = Images
                }
            )
        },
    ),
)
