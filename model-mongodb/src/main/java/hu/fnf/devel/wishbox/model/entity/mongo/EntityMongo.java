
package hu.fnf.devel.wishbox.model.entity.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class EntityMongo {
    @Id
    @Indexed(unique = true)
    protected String id;

    public String getId() {
        return id;
    }

    protected void setId(String id) {
        this.id = id;
    }
}
