class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

        "/project/list"(controller: 'project', parseRequest: true){
            action = [GET:'list']
        }

        "/project/create"(controller: 'project', parseRequest: true){
            action = [POST: 'save']
        }

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
