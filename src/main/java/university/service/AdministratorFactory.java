package university.service;

import university.domain.*;

public class AdministratorFactory {

    public static Administrator createAdministrator(
            String id,
            String name,
            String email,
            String password,
            int accessLevel) {

        return new Administrator(id, name, email, password, accessLevel);
    }
}
