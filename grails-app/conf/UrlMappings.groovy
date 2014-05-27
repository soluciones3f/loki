class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller:"Home")
        "/default"(view:"/defaultIndex")
        "500"(view:'/error')
	}
}
