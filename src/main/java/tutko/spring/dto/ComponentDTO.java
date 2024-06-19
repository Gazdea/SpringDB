package tutko.spring.dto;

public class ComponentDTO {
    private int componentId;
    private String name;
    private String description;

    public ComponentDTO() {
    }

    public int getComponentId() {
        return componentId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ComponentDTO setComponentId(int componentId) {
        this.componentId = componentId;
        return this;
    }

    public ComponentDTO setName(String name) {
        this.name = name;
        return this;
    }

    public ComponentDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
