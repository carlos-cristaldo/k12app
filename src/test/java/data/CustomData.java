package data;

import org.testng.annotations.DataProvider;

import static utilities.Utils.getUsersMap;

public class CustomData {

    public static final String DP_NAME = "Data User";

    @DataProvider(name = DP_NAME)
    public Object[][] getData(){
        final var usersMap = getUsersMap();
        final var n = usersMap.size();
        final var object = new Object[n][];
        int i = 0;
        for (String s : usersMap.keySet()){
            object[i] = new Object[]{usersMap.get(s)};
            i++;
        }

//        for (int i = 0; i < n; i++) {
//            object[i] = new Object[]{usersMap.get(i)};
//        }
        return object;
    }
}
