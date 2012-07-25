// Place your Spring DSL code here
import org.hexagonal.persistent.ProjectGormRepository

beans = {
    projectRepository(ProjectGormRepository){}
}
