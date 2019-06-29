package codeitin.co.in.codeitin.DAO;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Spring {
    @Id
    private String topic;
    private String store;

    public Spring() {
    }

    public Spring(String store) {
        this.store = store;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "About{" +
                "id='" + topic+ '\'' +
                ",store='" +store +
                '}';
    }
}
