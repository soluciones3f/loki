package soluciones3f.loki.core

import soluciones3f.loki.*

class ProjectController {
    static scaffold = Project

    // overrides scaffolded, do not limit results
    def index() {
        respond Project.list(params)
    }
}
