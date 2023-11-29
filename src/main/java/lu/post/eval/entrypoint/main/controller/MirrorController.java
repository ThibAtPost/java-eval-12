package lu.post.eval.entrypoint.main.controller;

import lombok.RequiredArgsConstructor;
import lu.post.eval.domain.model.MyIpResponse;
import lu.post.eval.domain.service.HTTPMirrorCaller;
import lu.post.eval.entrypoint.main.transformer.ToHeaderOA;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/java-eval-api")
public class MirrorController  {

    private final HTTPMirrorCaller httpMirrorCaller;

//    @Override
//    public ResponseEntity<List<HeaderOA>> mirrorOutgoingHeaders(
//    ) {
//        return new ResponseEntity<>(ToHeaderOA.of(httpMirrorCaller.callGet()), HttpStatus.OK);
//    }


    @GetMapping("/my-ip")
    public ResponseEntity<MyIpResponse> getMyIp() {
        String outgoingIp = httpMirrorCaller.getOutgoingIp();
        return new ResponseEntity<>(new MyIpResponse(outgoingIp), HttpStatus.OK);
    }
}
