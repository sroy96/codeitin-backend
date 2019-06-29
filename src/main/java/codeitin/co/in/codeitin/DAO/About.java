package codeitin.co.in.codeitin.DAO;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class About {
    @Id
    private String id;
    private String content;

    public About() {
    }

    public About(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "About{" +
                "id='" + id + '\'' +
                ",about='" +content +
                '}';
    }
}
