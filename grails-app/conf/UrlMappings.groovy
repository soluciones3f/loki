class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        // Url de las llamadas REST
        "/api/$controller/$action?/$id?(.${format})?"{
            namespace = "api"
        }

        "/"(controller:"Home")
        "/default"(view:"/defaultIndex")
        "500"(view:'/error')
	}
}
