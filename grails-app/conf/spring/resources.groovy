// Place your Spring DSL code here
import org.hexagonal.persistence.ProjectGormRepository
import org.hexagonal.converters.JsonService

beans = {
    projectRepository(ProjectGormRepository){}
    jsonService(JsonService){}
}
