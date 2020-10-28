package resttemplate.responseService;

import org.springframework.http.ResponseEntity;

public interface ResponseService {
    void getAll();

    ResponseEntity<String> addUser();

    ResponseEntity<String> editUser();

    ResponseEntity<String> deleteUser();

    void getResult();
}
