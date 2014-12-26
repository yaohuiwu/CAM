package org.cam.core.mapping;

/**
 * The Field of an entity.
 */
public class EntityField {

    private String name;
    private String type;

    public EntityField() {
    }

    public EntityField(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EntityField field = (EntityField) o;

        if (name != null ? !name.equals(field.name) : field.name != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Field{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
