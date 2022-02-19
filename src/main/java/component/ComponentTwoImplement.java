package component;

public class ComponentTwoImplement implements ComponentDependency{

    @Override
    public void saludar() {
        System.out.println("Hola mundo desde mi componente 2");
    }
}
