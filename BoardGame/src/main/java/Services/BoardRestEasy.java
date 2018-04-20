package Services;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class BoardRestEasy extends Application {
    private Set<Object> singletons = new HashSet<Object>();

    public BoardRestEasy() {
        singletons.add(new BoardServicesImpl());
    }


    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}