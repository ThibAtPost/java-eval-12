package lu.post.eval.infra.mirror;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lu.post.eval.domain.model.HeadersBO;
import lu.post.eval.domain.service.IHTTMirrorClient;
import lu.post.eval.domain.transformers.ToHeadersBO;
import lu.post.gen.v6.httpbin.HttpMethodsApi;
import lu.post.gen.v6.httpbin.RequestInspectionApi;
import lu.post.gen.v6.httpbin.invoker.ApiClient;
import lu.post.gen.v6.httpbin.model.GetIPResponse;
import reactor.core.publisher.Mono;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class  HTTPMirrorUsingHTTPBin implements IHTTMirrorClient {

    private final HttpMethodsApi httpMethodsApi;
    private final RequestInspectionApi requestInspectionApi;

    
    

    @Override
    public List<HeadersBO> mirrorMyGetHeaders() {
        return httpMethodsApi.getGet().toFuture()
                .thenApply(getResponse -> ToHeadersBO.of(getResponse.getHeaders())).join();
    }

    public String getOutgoingIp() {
        // Utilise la méthode ipGet() de RequestInspectionApi pour obtenir l'IP sortante
        try {
            GetIPResponse response = requestInspectionApi.ipGet().block();
            return response.getOrigin();
        } catch (Exception e) {
            // Gestion des erreurs
            return "Erreur lors de la récupération de l'IP";
        }
    }

    public HTTPMirrorUsingHTTPBin(Mono<ResponseEntity<GetIPResponse>> mono) {
    }
}
