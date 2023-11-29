package lu.post.eval.entrypoint.main.controller;

import lu.post.gen.eval.application.controllers.InfoControllerApi;
import lu.post.gen.v6.httpbin.model.GetIPResponse;
import reactor.core.publisher.Mono;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController implements InfoControllerApi {

    @Override
    public ResponseEntity<Void> ping() {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public Mono<ResponseEntity<GetIPResponse>> requestInspectionApi() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'requestInspectionApi'");
    }
}
