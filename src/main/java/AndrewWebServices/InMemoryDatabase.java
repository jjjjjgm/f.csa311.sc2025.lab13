package AndrewWebServices;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDatabase extends Database {
    private Map<String, Integer> accounts = new HashMap<>();
    
    public InMemoryDatabase() {
        accounts.put("Scotty", 17214);
    }
    
    @Override
    public int getPassword(String accountName) {
        return accounts.getOrDefault(accountName, 0);
    }
    
    public void addAccount(String accountName, int password) {
        accounts.put(accountName, password);
    }
}