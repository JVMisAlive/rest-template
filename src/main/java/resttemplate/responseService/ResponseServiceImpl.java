package resttemplate.responseService;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import resttemplate.model.User;

@Service
public class ResponseServiceImpl implements ResponseService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final HttpHeaders httpHeaders = new HttpHeaders();

    private final String responseURL = "http://91.241.64.178:7081/api/users";
    private final User user = new User(3L, "James", "Brown", (byte) 28);

    @Override
    public void getAll() {
        ResponseEntity<String> response = restTemplate.getForEntity(responseURL, String.class);
        httpHeaders.set("Cookie", response.getHeaders().get("Set-Cookie").get(0));
    }

    @Override
    public ResponseEntity<String> addUser() {
        HttpEntity<User> requestBodyPost = new HttpEntity<>(user, httpHeaders);
        return restTemplate.postForEntity(responseURL, requestBodyPost, String.class);
    }

    @Override
    public ResponseEntity<String> editUser() {
        user.setName("Thomas");
        user.setLastName("Shelby");
        HttpEntity<User> requestBodyPut = new HttpEntity<>(user, httpHeaders);
        return restTemplate
                .exchange(responseURL, HttpMethod.PUT, requestBodyPut, String.class);
    }

    @Override
    public ResponseEntity<String> deleteUser() {
        HttpEntity<User> requestBodyDelete = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange(responseURL + "/" + user.getId(),
                HttpMethod.DELETE, requestBodyDelete, String.class);
    }

    @Override
    public void getResult() {
        getAll();
        System.out.println("<------------------------->");
        System.out.println("RESULT: "
                + addUser().getBody()
                + editUser().getBody()
                + deleteUser().getBody());
    }

}
